
package yk.boxri.handle;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderShippingAddressMapper;
import yk.boxri.pojo.OrderShippingAddress;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.AddressType;
import com.ebay.soap.eBLBaseComponents.OrderType;

@Component("HandleOrderShippingAddress")
public class HandleOrderShippingAddress {
	
	public  OrderShippingAddress returnOrderShippingAddress(OrderType o,
			ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();// jackson
		
		OrderShippingAddress orderShippingAddress = null;
		
		if (o.getShippingAddress() != null) {
			
			orderShippingAddress = new OrderShippingAddress();
			
			AddressType addressType = o.getShippingAddress();
			
			orderShippingAddress.order_id = o.getOrderID();
			
			orderShippingAddress.user_id = shop.getUserId();
			
			orderShippingAddress.shop_id = shop.getShopId();
			
			if (addressType.getAddressID() != null) {
				
				orderShippingAddress.address_id = addressType.getAddressID();
			}
			
			
			if (addressType.getAddressAttribute() != null) {
				
				orderShippingAddress.address_attribute_values = mapper
						.writeValueAsString(addressType
								.getAddressAttribute());
			}
			
			
			if (addressType.getAddressOwner() != null) {
				
				orderShippingAddress.address_owner = addressType
						.getAddressOwner().toString();
			}
			
			if (addressType.getAddressUsage() != null) {
				
				orderShippingAddress.address_usage = addressType
						.getAddressUsage().toString();
			}
			
			if (addressType.getCityName() != null) {
				
				orderShippingAddress.city_name = addressType.getCityName();
			}
			
			if (addressType.getCounty() != null) {
				
				orderShippingAddress.country = addressType.getCounty();
			}
			
			if (addressType.getCountryName() != null) {
				
				orderShippingAddress.country_name = addressType
						.getCountryName();
			}
			
			if (addressType.getExternalAddressID() != null) {
				
				orderShippingAddress.external_address_id = addressType
						.getExternalAddressID();
			}
			
			if (addressType.getName() != null) {
				
				orderShippingAddress.name = addressType.getName();
			}
			
			if (addressType.getPhone() != null) {
				
				orderShippingAddress.phone = addressType.getPhone();
			}
			
			if (addressType.getPostalCode() != null) {
				
				orderShippingAddress.postal_code = addressType.getPostalCode();
			}
			
			if (addressType.getStateOrProvince() != null) {
				
				orderShippingAddress.state_or_province = addressType
						.getStateOrProvince();
			}
			
			if (addressType.getStreet1() != null) {
				orderShippingAddress.street1 = addressType.getStreet1();
			}
			
			if (addressType.getStreet2() != null) {
				orderShippingAddress.street2 = addressType.getStreet2();
			}
		}
		
		return orderShippingAddress;
		
	}
	
	/*public void batchInsert(OrderType[] oList, Shops shop) {
		List<OrderShippingAddress> list = new ArrayList<OrderShippingAddress>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				OrderShippingAddress orderShippingAddress = HandleOrderShippingAddress
						.returnOrderShippingAddress(o, shop);
				if (orderShippingAddress != null) {
					list.add(orderShippingAddress);
				}
			}
			if (list.size() != 0) {
				orderShippingAddressMapper.insertBatch(list);
			}
		}
	}

	public void insert(OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				OrderShippingAddress orderShippingAddress = HandleOrderShippingAddress
						.returnOrderShippingAddress(o, shop);
				orderShippingAddressMapper.insert(orderShippingAddress);
			}

		}
	}*/
}