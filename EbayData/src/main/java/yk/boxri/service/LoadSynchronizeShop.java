package yk.boxri.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;





import yk.boxri.dao.LoadSynchronizeShopMapper;
import yk.boxri.pojo.ShopToken;
/**
 * 需要更新的店铺
 * @author Administrator
 */
@Service
public class LoadSynchronizeShop {

	@Value("${SERVICE_ID}")
	private Integer service_id;
	@Value("${SYNCHRONIZE_MOLD}")
	private String sync_mold;
	@Autowired
	private LoadSynchronizeShopMapper loadSynchronizeShopMapper;//从数据库获取需要同步的店铺 
	
	public List<ShopToken> loadSynchronizeShop(){
		
		 Map<String,Object> params=new HashMap<String, Object>();
		 params.put("service_id", service_id);
		 params.put("sync_mold", sync_mold);
		 List<ShopToken> shopList=loadSynchronizeShopMapper.loadSynchronizeShop(params);
		return shopList;
	}
}
