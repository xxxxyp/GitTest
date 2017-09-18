package yk.boxri.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import yk.boxri.pojo.ShopToken;



public interface LoadSynchronizeShopMapper {
	List<ShopToken> loadSynchronizeShop(Map<String,Object> params); 
}
