
package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionMultilegShippingDetailsMapper;
import yk.boxri.pojo.OrderTransactionMultilegShippingDetails;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.AddressType;
import com.ebay.soap.eBLBaseComponents.MultiLegShipmentType;
import com.ebay.soap.eBLBaseComponents.MultiLegShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.MultiLegShippingServiceType;
import com.ebay.soap.eBLBaseComponents.OrderType;

@Component("HandleOrderTransactionMultilegShippingDetails")
public class HandleOrderTransactionMultilegShippingDetails {
	
	public  List<OrderTransactionMultilegShippingDetails> returnOrderTransactionMultilegShippingDetails(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();// jackson
		
		List<OrderTransactionMultilegShippingDetails> orderTransactionMultilegShippingDetailsList = new ArrayList<OrderTransactionMultilegShippingDetails>();
		
		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {
			
			OrderTransactionMultilegShippingDetails orderTransactionMultilegShippingDetails = new OrderTransactionMultilegShippingDetails();
			
			if (o.getTransactionArray().getTransaction(i)
					.getMultiLegShippingDetails() != null) {
				
				MultiLegShippingDetailsType multiLegShippingDetailsType = o
						.getTransactionArray().getTransaction(i)
						.getMultiLegShippingDetails();
				
				orderTransactionMultilegShippingDetails.transaction_id = o
						.getTransactionArray().getTransaction()[i]
								.getTransactionID();
				
				orderTransactionMultilegShippingDetails.order_id = o
						.getOrderID();
				
				orderTransactionMultilegShippingDetails.user_id = shop
						.getUserId();
				
				orderTransactionMultilegShippingDetails.shop_id = shop
						.getShopId();
				
				if (multiLegShippingDetailsType
						.getLogisticsProviderShipmentToBuyer() != null) {
					
					if (multiLegShippingDetailsType
							.getLogisticsProviderShipmentToBuyer()
							.getShipToAddress() != null) {
						
						AddressType addressType = multiLegShippingDetailsType
								.getLogisticsProviderShipmentToBuyer()
								.getShipToAddress();
						
						if (addressType.getAddressID() != null) {
							
							orderTransactionMultilegShippingDetails.address_id = addressType
									.getAddressID();
						}
						
						if (addressType.getAddressOwner() != null) {
							
							orderTransactionMultilegShippingDetails.address_owner = addressType
									.getAddressOwner().toString();
						}
						
						if (addressType.getAddressUsage() != null) {
							
							orderTransactionMultilegShippingDetails.address_usage = addressType
									.getAddressUsage().toString();
						}
						
						if (addressType.getCityName() != null) {
							
							orderTransactionMultilegShippingDetails.city_name = addressType
									.getCityName();
						}
						
						if (addressType.getCounty() != null) {
							
							orderTransactionMultilegShippingDetails.country = addressType
									.getCounty();
						}
						
						if (addressType.getCountryName() != null) {
							
							orderTransactionMultilegShippingDetails.country_name = addressType
									.getCountryName();
						}
						
						if (addressType.getExternalAddressID() != null) {
							
							orderTransactionMultilegShippingDetails.external_address_id = addressType
									.getExternalAddressID();
						}
						
						if (addressType.getName() != null) {
							
							orderTransactionMultilegShippingDetails.name = addressType
									.getName();
						}
						
						if (addressType.getPhone() != null) {
							
							orderTransactionMultilegShippingDetails.phone = addressType
									.getPhone();
						}
						
						if (addressType.getPostalCode() != null) {
							
							orderTransactionMultilegShippingDetails.postal_code = addressType
									.getPostalCode();
						}
						
						if (addressType.getReferenceID() != null) {
							
							orderTransactionMultilegShippingDetails.reference_id = addressType
									.getReferenceID();
						}
						
						if (addressType.getStateOrProvince() != null) {
							
							orderTransactionMultilegShippingDetails.state_or_province = addressType
									.getStateOrProvince();
						}
						
						if (addressType.getStreet1() != null) {
							
							orderTransactionMultilegShippingDetails.street1 = addressType
									.getStreet1();
						}
						
						if (addressType.getStreet2() != null) {
							
							orderTransactionMultilegShippingDetails.street2 = addressType
									.getStreet2();
						}
						
						if (multiLegShippingDetailsType
								.getLogisticsProviderShipmentToBuyer() != null) {
							MultiLegShipmentType multiLegShipmentType = multiLegShippingDetailsType
									.getLogisticsProviderShipmentToBuyer();
							
							if (multiLegShipmentType != null) {
								
								orderTransactionMultilegShippingDetails.shipping_service = multiLegShipmentType
										.getShippingServiceDetails()
										.getShippingService();
							}
							
							if (multiLegShipmentType.getShippingTimeMax() != null) {
								
								orderTransactionMultilegShippingDetails.shipping_time_max = multiLegShipmentType
										.getShippingTimeMax();
							}
							
							if (multiLegShipmentType.getShippingTimeMin() != null) {
								
								orderTransactionMultilegShippingDetails.shipping_time_min = multiLegShipmentType
										.getShippingTimeMin();
							}
							
							if (multiLegShippingDetailsType
									.getLogisticsProviderShipmentToBuyer()
									.getShippingServiceDetails() != null) {
								
								MultiLegShippingServiceType multiLegShippingServiceType = multiLegShippingDetailsType
										.getLogisticsProviderShipmentToBuyer()
										.getShippingServiceDetails();
								if (multiLegShippingServiceType
										.getTotalShippingCost() != null) {
									
									orderTransactionMultilegShippingDetails.total_shipping_cost = multiLegShippingServiceType
											.getTotalShippingCost().getValue();
									
									orderTransactionMultilegShippingDetails.total_shipping_cost_currency_id = multiLegShippingServiceType
											.getTotalShippingCost()
											.getCurrencyID().toString();
								}
								
								if (addressType.getAddressAttribute() != null) {
									
									orderTransactionMultilegShippingDetails.address_attribute_value = mapper
											.writeValueAsString(addressType
													.getAddressAttribute());
								}
								
							}
							
						}
						
						orderTransactionMultilegShippingDetailsList
						.add(orderTransactionMultilegShippingDetails);
					}
				}
			}
		}
		
		return orderTransactionMultilegShippingDetailsList;
	}
	
	/*public void batchInsertorderTransactionMultilegShippingDetails(
			OrderType[] oList, Shops shop) {
		List<OrderTransactionMultilegShippingDetails> list = new ArrayList<OrderTransactionMultilegShippingDetails>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionMultilegShippingDetails> orderTransactionMultilegShippingDetailsList = HandleOrderTransactionMultilegShippingDetails
						.returnOrderTransactionMultilegShippingDetails(o, shop);
				for (int j = 0; j < orderTransactionMultilegShippingDetailsList
						.size(); j++) {
					list.add(orderTransactionMultilegShippingDetailsList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionMultilegShippingDetailsMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionMultilegShippingDetails(
			OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionMultilegShippingDetails> orderTransactionMultilegShippingDetailsList = HandleOrderTransactionMultilegShippingDetails
						.returnOrderTransactionMultilegShippingDetails(o, shop);
				for (int j = 0; j < orderTransactionMultilegShippingDetailsList
						.size(); j++) {
					OrderTransactionMultilegShippingDetails orderTransactionMultilegShippingDetails = orderTransactionMultilegShippingDetailsList
							.get(j);
					orderTransactionMultilegShippingDetailsMapper
							.insert(orderTransactionMultilegShippingDetails);
				}
			}

		}
	}*/
}