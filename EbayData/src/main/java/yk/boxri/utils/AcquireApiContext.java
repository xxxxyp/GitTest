package yk.boxri.utils;

import yk.boxri.pojo.ShopToken;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
/**
 * 获取apicontext工具类
 * @author Administrator
 *
 */
public class AcquireApiContext {

	public static ApiContext getApiContext(ShopToken shop){
		ApiContext apiContext = new ApiContext();
	      ApiCredential cred = apiContext.getApiCredential();
	      cred.seteBayToken(shop.getToken());
	      String url = "https://api.ebay.com/wsapi";
		  apiContext.setApiServerUrl(url);
		  return apiContext;
	}
}
