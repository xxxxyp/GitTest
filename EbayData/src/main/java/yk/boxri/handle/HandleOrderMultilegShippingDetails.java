
package yk.boxri.handle;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderMultilegShippingDetailsMapper;
import yk.boxri.pojo.OrderMultilegShippingDetails;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.AddressType;
import com.ebay.soap.eBLBaseComponents.MultiLegShipmentType;
import com.ebay.soap.eBLBaseComponents.MultiLegShippingServiceType;
import com.ebay.soap.eBLBaseComponents.OrderType;

@Component("HandleOrderMultilegShippingDetails")
public class HandleOrderMultilegShippingDetails {
	
	public OrderMultilegShippingDetails returnOrderMultilegShippingDetails(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();// jackson
		
		OrderMultilegShippingDetails orderMultilegShippingDetails = null;
		
		if (o.getMultiLegShippingDetails() != null) {
			
			if (o.getMultiLegShippingDetails()
					.getSellerShipmentToLogisticsProvider() != null) {
				
				orderMultilegShippingDetails = new OrderMultilegShippingDetails();
				
				MultiLegShipmentType multiLegShipmentType = o
						.getMultiLegShippingDetails()
						.getSellerShipmentToLogisticsProvider();
				
				orderMultilegShippingDetails.order_id = o.getOrderID();
				
				orderMultilegShippingDetails.user_id = shop.getUserId();
				
				orderMultilegShippingDetails.shop_id = shop.getShopId();
				
				if (multiLegShipmentType.getShippingServiceDetails() != null) {
					
					MultiLegShippingServiceType multiLegShippingServiceType = multiLegShipmentType
							.getShippingServiceDetails();
					
					if (multiLegShippingServiceType.getShippingService() != null) {
						
						orderMultilegShippingDetails.shipping_service = multiLegShippingServiceType
								.getShippingService();
					}
					
					if (multiLegShippingServiceType.getTotalShippingCost() != null) {
						
						orderMultilegShippingDetails.total_shipping_cost = multiLegShippingServiceType
								.getTotalShippingCost().getValue();
						
						orderMultilegShippingDetails.total_shipping_cost_currency_id = multiLegShippingServiceType
								.getTotalShippingCost().getCurrencyID()
								.toString();
					}
					
					if (multiLegShipmentType.getShippingTimeMax() != null) {
						
						orderMultilegShippingDetails.shipping_time_max = multiLegShipmentType
								.getShippingTimeMax();
					}
					if (multiLegShipmentType.getShippingTimeMin() != null) {
						
						orderMultilegShippingDetails.shipping_time_min = multiLegShipmentType
								.getShippingTimeMin();
					}
				}
				
				if (multiLegShipmentType.getShipToAddress() != null) {
					
					AddressType addressType = multiLegShipmentType
							.getShipToAddress();// ���ӿɶ���
					
					if (addressType.getAddressAttribute() != null) {
						
						orderMultilegShippingDetails.address_attribute_value = mapper
								.writeValueAsString(addressType
										.getAddressAttribute());
						
						
						if (addressType.getAddressID() != null) {
							
							orderMultilegShippingDetails.address_id = addressType
									.getAddressID();
						}
						
						if (addressType.getAddressOwner() != null) {
							
							orderMultilegShippingDetails.address_owner = addressType
									.getAddressOwner().toString();
						}
						if (addressType.getAddressUsage() != null) {
							
							orderMultilegShippingDetails.address_usage = addressType
									.getAddressUsage().toString();
						}
						
						if (addressType.getCityName() != null) {
							
							orderMultilegShippingDetails.city_name = addressType
									.getCityName();
						}
						
						if (addressType.getCounty() != null) {
							
							orderMultilegShippingDetails.country = addressType
									.getCounty();
						}
						
						if (addressType.getCountryName() != null) {
							orderMultilegShippingDetails.country_name = addressType
									.getCountryName();
						}
						
						if (addressType.getExternalAddressID() != null) {
							
							orderMultilegShippingDetails.external_address_id = addressType
									.getExternalAddressID();
						}
						
						if (addressType.getName() != null) {
							
							orderMultilegShippingDetails.name = addressType
									.getName();
						}
						
						if (addressType.getPhone() != null) {
							
							orderMultilegShippingDetails.phone = addressType
									.getPhone();
						}
						
						if (addressType.getPostalCode() != null) {
							
							orderMultilegShippingDetails.postal_code = addressType
									.getPostalCode();
						}
						
						if (addressType.getReferenceID() != null) {
							
							orderMultilegShippingDetails.reference_id = addressType
									.getReferenceID();
						}
						
						if (addressType.getStateOrProvince() != null) {
							
							orderMultilegShippingDetails.state_or_province = addressType
									.getStateOrProvince();
						}
						
						if (addressType.getStreet1() != null) {
							
							orderMultilegShippingDetails.street1 = addressType
									.getStreet1();
						}
						
						if (addressType.getStreet2() != null) {
							
							orderMultilegShippingDetails.street2 = addressType
									.getStreet2();
						}
						
					}
				}
			}
			return orderMultilegShippingDetails;
		}
		return orderMultilegShippingDetails;
	}
}