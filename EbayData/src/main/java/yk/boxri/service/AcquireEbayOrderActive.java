package yk.boxri.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yk.boxri.Execeptions.exceptionHandle;
import yk.boxri.dao.OrderInfoMapper;
import yk.boxri.pojo.ShopToken;
import yk.boxri.utils.AcquireApiContext;
import yk.boxri.utils.HandleTwoList;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetOrdersCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.OrderStatusCodeType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PaginationType;

@Service
public class AcquireEbayOrderActive {

	public int Runcount;
	
	@Autowired
	private static OrderInfoMapper orderInfoMapper;
	@Autowired
	private static BatchInsertOrder batchInsertOrder;
	@Autowired
	private static BatchUpdateOrder batchUpdateOrder;
	public  void ActiveEntrance(ShopToken shop)	{
		//设置获取的时间段，从当前时间段开始获取
		Date enddate = new Date();
		enddate.setSeconds(0);
		enddate.setTime(enddate.getTime()-enddate.getTime()%1000); //清除毫秒
		Date begindate=new Date(enddate.getTime() - 20*60*1000);// 减去20分钟
		
		System.out.println("Loading Data: Shop_id="+shop.getShopId()+" Time Period "+begindate+"- "+enddate);
		if(startExcute(shop,begindate,enddate,0) == true)
		{
			System.out.println("Load Data complete.");
		}
		else
		{
			System.err.println("UnhandleError,Skip Load Data for Shop_id="+shop.getShopId()+" Time Period "+begindate+"- "+enddate);
		}
		return;
	}
	//开始执行
	public  boolean startExcute(final ShopToken shop,final Date begindate,final Date enddate,final int Retrycount)
	{
		OrderType[] oList = null;
		final ExecutorService exec = Executors.newFixedThreadPool(1);
		Callable<OrderType[]> call = new Callable<OrderType[]>() {  
			public OrderType[] call() throws Exception {
				return getActiveEbayData(shop,begindate,enddate);
			}
		};
		try {  
			Future<OrderType[]> future = exec.submit(call);  
			oList = future.get(1000*90, TimeUnit.MILLISECONDS); //任务处理超时时间设为 90 秒 
		}
		catch (Exception e) 
		{
			if(Retrycount+1 >=3)
			{
				System.out.println("load EbayData out of retry time. Shop_id is : "+shop.getShopId()+" Time Period "+begindate+"- "+enddate
						+"Error Message is "+e.toString());
				return false;
			}
			String logmsg = " Shop_id="+shop.getShopId() +" Time Period is "+begindate+"- "+enddate;
			if(exceptionHandle.ExceptionHandle(e, logmsg).equals(exceptionHandle.TimeoutException)
					||exceptionHandle.ExceptionHandle(e, logmsg).equals(exceptionHandle.sdkException))
			{
				startExcute(shop,begindate,enddate,Retrycount+1);
			}
		}
		try
		{
			List<String> isExistsList=new ArrayList<String>();
			if(oList==null || oList.length == 0)
			{
				return true;
			}
			else{
				for(int i=0;i<oList.length;i++){
					isExistsList.add(oList[i].getOrderID());
				}
			}
			if(isExistsList.size()== 0)return true;
			loadDatatoDB(oList,shop,isExistsList);
		}
		catch(Exception e)
		{
			String logmsg = " Shop_id="+shop.getShopId() +" Time Period is "+begindate+"- "+enddate;
			exceptionHandle.ExceptionHandle(e,logmsg);
			return false;
		}
		// 关闭线程池  
		exec.shutdown();
		return true;
	}

	//加载到数据库
	public static void loadDatatoDB(OrderType[] oList,ShopToken shop,List<String> isExistsList) throws JsonGenerationException, JsonMappingException, IOException, IllegalArgumentException, IllegalAccessException
	{
		List<String> existsList=orderInfoMapper.dynamicSelectId(isExistsList);
		HandleTwoList searchTwoList=new HandleTwoList();
		List<String> diffList=searchTwoList.searchDiffList(isExistsList, existsList);
		List<OrderType> waitInsertList=new ArrayList<OrderType>();
		List<OrderType> waitUpdateList=new ArrayList<OrderType>();
		for(int i=0;i<oList.length;i++){
			if(diffList.contains(oList[i].getOrderID())){
				waitInsertList.add(oList[i]);
			}else{
				waitUpdateList.add(oList[i]);
			}
		}
		if(waitInsertList.size()!=0){
			batchInsertOrder.batchInsertOrder(waitInsertList, shop);  
		}
		if(waitUpdateList.size()!=0){
			batchUpdateOrder.batchUpdateOrder(waitUpdateList, shop);  
		}
		batchInsertOrder.batchInsertOrder(waitInsertList, shop);
	}

	public  OrderType[] getActiveEbayData(ShopToken shop,Date begindate,Date enddate) throws Exception	{

		OrderType[] oList = null;
		PaginationType pageType = null;
		int pageNum = 1;   //Ebay官方默认第一页
		
		Calendar beginTime=Calendar.getInstance();
		beginTime.setTime(begindate);
		Calendar endTime=Calendar.getInstance();
		endTime.setTime(enddate);
		
		ApiContext apiContext = AcquireApiContext.getApiContext(shop);
		
		GetOrdersCall getCall = new GetOrdersCall(apiContext);
		
		getCall.setModTimeFrom(beginTime);
		getCall.setModTimeTo(endTime);
		
		// RETURN_ALL，获取信息的详细等级,暂时默认为ALL
		DetailLevelCodeType[] dt = new DetailLevelCodeType[]{DetailLevelCodeType.RETURN_ALL};
		getCall.setDetailLevel(dt);
		
		//OrderStatusCodeType，获取订单状态(All,IN_PROCESS,COMPLETED,CANCEL_PENDING,CANCELLED)目前业务需求只需要使用'ALL'这个参数
		OrderStatusCodeType oType = OrderStatusCodeType.ALL;
		getCall.setOrderStatus(oType);			
		
		do {
			pageType = new PaginationType();
			pageType.setEntriesPerPage(100);//每页N订单
			pageType.setPageNumber(pageNum);//取每pageNum页
			getCall.setPagination(pageType);     
			oList = getCall.getOrders();
//			log.info(getCall.getRequestXml());
//			log.info(getCall.getResponseXml());
			pageNum++;
		}
		while (getCall.getReturnedHasMoreOrders());

		return oList;
	}
}
