
package yk.boxri.handle;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderShippingServiceSelectedMapper;
import yk.boxri.pojo.OrderShippingServiceSelected;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;

@Component("HandleOrderShippingServiceSelected")
public class HandleOrderShippingServiceSelected {
	
	public  OrderShippingServiceSelected returnOrderShippingServiceSelected(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();// jackson
		
		OrderShippingServiceSelected orderShippingServiceSelected = null;
		
		if (o.getShippingServiceSelected() != null) {
			
			orderShippingServiceSelected = new OrderShippingServiceSelected();
			
			ShippingServiceOptionsType ShippingServiceSelected = o
					.getShippingServiceSelected();
			
			orderShippingServiceSelected.order_id = o.getOrderID();
			
			orderShippingServiceSelected.user_id = shop.getUserId();
			
			orderShippingServiceSelected.shop_id = shop.getShopId();
			
			if (ShippingServiceSelected.isExpeditedService() != null) {
				
				orderShippingServiceSelected.expedited_service = ShippingServiceSelected
						.isExpeditedService();
			}
			
			if (ShippingServiceSelected.getImportCharge() != null) {
				
				orderShippingServiceSelected.import_charge = ShippingServiceSelected
						.getImportCharge().getValue();
				
				orderShippingServiceSelected.import_charge_currency_id = ShippingServiceSelected
						.getImportCharge().getCurrencyID().toString();
			}
			
			if (ShippingServiceSelected.getLogisticPlanType() != null) {
				
				orderShippingServiceSelected.logistic_plan_type = ShippingServiceSelected
						.getLogisticPlanType();
			}
			
			if (ShippingServiceSelected.getShippingInsuranceCost() != null) {
				
				orderShippingServiceSelected.shipping_insurance_cost = ShippingServiceSelected
						.getShippingInsuranceCost().getValue();
				
				orderShippingServiceSelected.shipping_insurance_cost_currency_id = ShippingServiceSelected
						.getShippingInsuranceCost().getCurrencyID().toString();
			}
			
			if (ShippingServiceSelected.getShippingPackageInfo() != null) {
				
				orderShippingServiceSelected.shipping_package_info = mapper
						.writeValueAsString(ShippingServiceSelected
								.getShippingPackageInfo());
			}
			
			if (ShippingServiceSelected.getShippingService() != null) {
				
				orderShippingServiceSelected.shipping_service = ShippingServiceSelected
						.getShippingService();
			}
			
			if (ShippingServiceSelected.getShippingServiceAdditionalCost() != null) {
				
				orderShippingServiceSelected.shipping_service_additional_cost = ShippingServiceSelected
						.getShippingServiceAdditionalCost().getValue();
				
				orderShippingServiceSelected.shipping_service_additional_cost_currency_id = ShippingServiceSelected
						.getShippingServiceAdditionalCost().getCurrencyID()
						.toString();
			}
			
			if (ShippingServiceSelected.getShippingServicePriority() != null) {
				
				orderShippingServiceSelected.shipping_service_priority = ShippingServiceSelected
						.getShippingServicePriority();
			}
			
		}
		
		return orderShippingServiceSelected;
	}
	
	/*public void batchInsert(OrderType[] oList, Shops shop) {
		List<OrderShippingServiceSelected> list = new ArrayList<OrderShippingServiceSelected>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				OrderShippingServiceSelected orderShippingServiceSelected = HandleOrderShippingServiceSelected
						.returnOrderShippingServiceSelected(o, shop);
				if (orderShippingServiceSelected != null) {
					list.add(orderShippingServiceSelected);
				}
			}
			if (list.size() != 0) {
				orderShippingServiceSelectedMapper.insertBatch(list);
			}
		}
	}

	public void insert(OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				OrderShippingServiceSelected orderShippingServiceSelected = HandleOrderShippingServiceSelected
						.returnOrderShippingServiceSelected(o, shop);
				orderShippingServiceSelectedMapper
						.insert(orderShippingServiceSelected);
			}

		}
	}*/
}