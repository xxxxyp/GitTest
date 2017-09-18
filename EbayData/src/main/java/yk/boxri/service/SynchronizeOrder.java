package yk.boxri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yk.boxri.pojo.ShopToken;


@Service
public class SynchronizeOrder {

	@Autowired
	private LoadSynchronizeShop loadSynchronizeShop;
	@Autowired
	private AcquireEbayOrderAll acquireEbayOrder;
	
	public void synchOrder(){
		List<ShopToken> shopList=loadSynchronizeShop.loadSynchronizeShop();//需要同步店铺
		if(shopList ==null)
		{
			return;
		}else if(shopList.size()==0){
			return;
		}else{
			for(int i=0;i<shopList.size();i++){
				acquireEbayOrder.AllEntrance(shopList.get(i));//获取全量
			}
		}
	}
}
