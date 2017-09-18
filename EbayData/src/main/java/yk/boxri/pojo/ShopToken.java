package yk.boxri.pojo;

/**
 * 店铺信息
 * @author Administrator
 *
 */
public class ShopToken {
	private int shopId;
	private int userId;
	private String token;
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
