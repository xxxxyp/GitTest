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
import com.ebay.soap.eBLBaseComponents.OrderIDArrayType;
import com.ebay.soap.eBLBaseComponents.OrderStatusCodeType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.TradingRoleCodeType;


/**
 * 获取订单
 * @author Administrator
 */
@Service
public class AcquireEbayOrderAll {

	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private BatchInsertOrder batchInsertOrder;
	@Autowired
	private BatchUpdateOrder batchUpdateOrder;
	
	public void AllEntrance(ShopToken shop) {
		//设置获取的时间段，从当前时间段开始获取
		Calendar startTime = Calendar.getInstance();
		startTime.setTime(new Date());
		startTime.add(Calendar.MONTH, -6);
		Calendar endTime = Calendar.getInstance();
		endTime.setTime(new Date());
		endTime.add(Calendar.MINUTE, -10);
		
		System.out.println("Loading Data: Shop_id="+shop.getShopId()+" Time Period "+startTime.getTime()+"- "+endTime.getTime());
		if(startExcute(shop,startTime,endTime,null,0) == true){
			System.out.println("Load Data complete.");
		}
		else{
			System.out.println("UnhandleError,Skip Load Data for Shop_id="+shop.getShopId()+" Time Period "+startTime.getTime()+"- "+endTime.getTime());
		}
		return;	
	}
	//返回
	public boolean startExcute(final ShopToken shop,final Calendar beginTime,final Calendar endTime,
			final OrderIDArrayType orderIdArray,final int Retrycount) {
		OrderType orderType[]=null;
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
		Callable<OrderType[]> call = new Callable<OrderType[]>() {  
			public OrderType[] call() throws Exception {
				return getALLEbayData(shop,beginTime,endTime,orderIdArray);
			}
		};
		try {  
			Future<OrderType[]> future = fixedThreadPool.submit(call);  
			orderType = future.get(1000*90, TimeUnit.MILLISECONDS); //任务处理超时时间设为 90 秒 
			
		}catch (Exception e){
		
			if(Retrycount+1 >=3){
				System.err.println("load Data out of retry time. Shop_id is : "+shop.getShopId()+" Time Period "+beginTime.getTime()+"- "+endTime.getTime()
						+"Error Message is "+e.toString());
				return false;
			}
			String logmsg = " Shop_id="+shop.getShopId() +" Time Period is "+beginTime.getTime()+"- "+endTime.getTime();
			if(exceptionHandle.ExceptionHandle(e, logmsg).equals(exceptionHandle.TimeoutException)
					||exceptionHandle.ExceptionHandle(e, logmsg).equals(exceptionHandle.sdkException))
			{
				startExcute(shop,beginTime,endTime,orderIdArray,Retrycount+1);
			}
		}
		/*try
		{
			List<String> isExistsList=new ArrayList<String>();
			if(orderType==null || orderType.length == 0)
			{
				return true;
			}
			else{
				for(int i=0;i<orderType.length;i++){
					isExistsList.add(orderType[i].getOrderID());
				}
			}
			if(isExistsList.size()== 0)return true;
			loadDatatoDB(orderType,shop,isExistsList);
		}
		catch(Exception e)
		{
			String logmsg = " Shop_id="+shop.getShopId() +" Time Period is "+beginTime.getTime()+"- "+endTime.getTime();
			exceptionHandle.ExceptionHandle(e,logmsg);
			return false;
		}*/
		
		// 关闭线程池  
		fixedThreadPool.shutdown();
		return true;
	}

		
	 //获取所有订单
	public OrderType[] getALLEbayData(ShopToken shop,Calendar beginTime,Calendar endTime,OrderIDArrayType orderIdArray) throws Exception {
		OrderType[] oList = null;
		PaginationType pageType = null;
		int pageNum = 1;   //Ebay官方默认第一页
		
		ApiContext apiContext = AcquireApiContext.getApiContext(shop);
		
		GetOrdersCall getCall = new GetOrdersCall(apiContext);
		if(orderIdArray!=null&&orderIdArray.getOrderID().length!=0){
			getCall.setOrderIDArray(orderIdArray);
		}
		getCall.setCreateTimeFrom(beginTime);
		getCall.setCreateTimeTo(endTime);
		
		// RETURN_ALL，获取信息的详细等级,暂时默认为ALL
		DetailLevelCodeType[] dt = new DetailLevelCodeType[]{DetailLevelCodeType.RETURN_ALL};
		getCall.setDetailLevel(dt);
		getCall.setOrderRole(TradingRoleCodeType.SELLER);//获取卖家的订单
		
		//OrderStatusCodeType，获取订单状态(All,IN_PROCESS,COMPLETED,CANCEL_PENDING,CANCELLED)目前业务需求只需要使用'ALL'这个参数
		OrderStatusCodeType oType = OrderStatusCodeType.ALL;
		getCall.setOrderStatus(oType);
		do {
			pageType = new PaginationType();
			pageType.setEntriesPerPage(100);//每页N订单
			pageType.setPageNumber(pageNum);//取每pageNum页
			getCall.setPagination(pageType);                                       
			oList = getCall.getOrders();
			System.out.println(getCall.getResponseXml());
			pageNum++;
		}
		while (getCall.getReturnedHasMoreOrders());
		System.out.println("API："+oList[0].getShippingAddress().getCounty());
		return oList;
	}

	//加载到数据库
	public  void loadDatatoDB(OrderType[] oList,ShopToken shop,List<String> isExistsList) throws JsonGenerationException, JsonMappingException, IllegalArgumentException, IllegalAccessException, IOException{

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
	}
	
	
}
