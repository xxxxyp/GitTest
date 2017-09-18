
package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderShippingDetailsShippingServiceOptionsMapper;
import yk.boxri.pojo.OrderShippingDetailsShippingServiceOptions;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;

@Component("HandleOrderShippingDetailsShippingServiceOptions")
public class HandleOrderShippingDetailsShippingServiceOptions {
	
	public  List<OrderShippingDetailsShippingServiceOptions> returnOrderShippingDetailsShippingServiceOptions(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {
		List<OrderShippingDetailsShippingServiceOptions> orderShippingDetailsShippingServiceOptionsList = new ArrayList<OrderShippingDetailsShippingServiceOptions>();
		
		ObjectMapper mapper = new ObjectMapper();// jackson
		
		if (o.getShippingDetails() != null) {
			
			if (o.getShippingDetails().getShippingServiceOptions() != null) {
				
				for (int i = 0; i < o.getShippingDetails()
						.getShippingServiceOptionsLength(); i++) {
					
					ShippingServiceOptionsType shippingServiceOptionsType = o
							.getShippingDetails().getShippingServiceOptions()[i];
					
					OrderShippingDetailsShippingServiceOptions orderShippingDetailsShippingServiceOptions = new OrderShippingDetailsShippingServiceOptions();
					
					orderShippingDetailsShippingServiceOptions.order_id = o
							.getOrderID();
					
					orderShippingDetailsShippingServiceOptions.user_id = shop
							.getUserId();
					
					orderShippingDetailsShippingServiceOptions.shop_id = shop
							.getShopId();
					
					if (shippingServiceOptionsType.isExpeditedService() != null) {
						
						orderShippingDetailsShippingServiceOptions.expedited_service = shippingServiceOptionsType
								.isExpeditedService();
					}
					
					if (shippingServiceOptionsType.getImportCharge() != null) {
						
						orderShippingDetailsShippingServiceOptions.options_import_charge = shippingServiceOptionsType
								.getImportCharge().getValue();
						
						orderShippingDetailsShippingServiceOptions.options_import_charge_currency_id = shippingServiceOptionsType
								.getImportCharge().getCurrencyID().toString();
					}
					
					if (shippingServiceOptionsType.getLogisticPlanType() != null) {
						
						orderShippingDetailsShippingServiceOptions.logistic_plan_type = shippingServiceOptionsType
								.getLogisticPlanType();
					}
					
					if (shippingServiceOptionsType.getShippingInsuranceCost() != null) {
						
						orderShippingDetailsShippingServiceOptions.options_shipping_insurance_cost = shippingServiceOptionsType
								.getShippingInsuranceCost().getValue();
						
						orderShippingDetailsShippingServiceOptions.options_import_charge_currency_id = shippingServiceOptionsType
								.getShippingInsuranceCost().getCurrencyID()
								.toString();
					}
					
					if (shippingServiceOptionsType.getShippingPackageInfo() != null) {
						orderShippingDetailsShippingServiceOptions.shipping_package_info = mapper
								.writeValueAsString(shippingServiceOptionsType
										.getShippingPackageInfo());
					}
					if (shippingServiceOptionsType.getShippingService() != null) {
						
						orderShippingDetailsShippingServiceOptions.option_shipping_service = shippingServiceOptionsType
								.getShippingService();
					}
					
					if (shippingServiceOptionsType
							.getShippingServiceAdditionalCost() != null) {
						
						orderShippingDetailsShippingServiceOptions.option_shipping_service_additional_cost = shippingServiceOptionsType
								.getShippingServiceAdditionalCost().getValue();
						
						orderShippingDetailsShippingServiceOptions.option_shipping_service_additional_cost_currency_id = shippingServiceOptionsType
								.getShippingServiceAdditionalCost()
								.getCurrencyID().toString();
					}
					
					if (shippingServiceOptionsType.getShippingServiceCost() != null) {
						
						orderShippingDetailsShippingServiceOptions.option_shipping_service_cost = shippingServiceOptionsType
								.getShippingServiceCost().getValue();
						
						orderShippingDetailsShippingServiceOptions.option_shipping_service_cost_currency_id = shippingServiceOptionsType
								.getShippingServiceCost().getCurrencyID()
								.toString();
					}
					
					if (shippingServiceOptionsType.getShippingServicePriority() != null) {
						orderShippingDetailsShippingServiceOptions.option_shipping_service_priority = shippingServiceOptionsType
								.getShippingServicePriority();
					}
					orderShippingDetailsShippingServiceOptionsList
					.add(orderShippingDetailsShippingServiceOptions);
				}
			}
		}
		
		return orderShippingDetailsShippingServiceOptionsList;
	}
	
	/*public void batchInsertorderShippingDetailsShippingServiceOptions(
			OrderType[] oList, Shops shop) {
		List<OrderShippingDetailsShippingServiceOptions> list = new ArrayList<OrderShippingDetailsShippingServiceOptions>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderShippingDetailsShippingServiceOptions> orderShippingDetailsShippingServiceOptionsList = HandleOrderShippingDetailsShippingServiceOptions
						.returnOrderShippingDetailsShippingServiceOptions(o,
								shop);
				for (int j = 0; j < orderShippingDetailsShippingServiceOptionsList
						.size(); j++) {
					list.add(orderShippingDetailsShippingServiceOptionsList
							.get(j));
				}
			}
			if (list.size() != 0) {
				orderShippingDetailsShippingServiceOptionsMapper
						.insertBatch(list);
			}
		}
	}

	public void insertorderShippingDetailsShippingServiceOptions(
			OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderShippingDetailsShippingServiceOptions> orderShippingDetailsShippingServiceOptionsList = HandleOrderShippingDetailsShippingServiceOptions
						.returnOrderShippingDetailsShippingServiceOptions(o,
								shop);
				for (int j = 0; j < orderShippingDetailsShippingServiceOptionsList
						.size(); j++) {
					OrderShippingDetailsShippingServiceOptions orderShippingDetailsShippingServiceOptions = orderShippingDetailsShippingServiceOptionsList
							.get(j);
					orderShippingDetailsShippingServiceOptionsMapper
							.insert(orderShippingDetailsShippingServiceOptions);
				}
			}

		}
	}*/
}