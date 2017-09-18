package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionShippingServiceSelectedMapper;
import yk.boxri.pojo.OrderTransactionShippingServiceSelected;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;

@Component("HandleOrderTransactionShippingServiceSelected")
public class HandleOrderTransactionShippingServiceSelected {

	public  List<OrderTransactionShippingServiceSelected> returnOrderTransactionShippingServiceSelected(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();// jackson

		List<OrderTransactionShippingServiceSelected> orderTransactionShippingServiceSelectedList = new ArrayList<OrderTransactionShippingServiceSelected>();

		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {

			OrderTransactionShippingServiceSelected orderTransactionShippingServiceSelected = null;

			if (o.getTransactionArray().getTransaction()[i]
					.getShippingServiceSelected() != null) {

				orderTransactionShippingServiceSelected = new OrderTransactionShippingServiceSelected();

				ShippingServiceOptionsType shippingServiceOptionsType = o
						.getTransactionArray().getTransaction()[i]
						.getShippingServiceSelected();

				orderTransactionShippingServiceSelected.transaction_id = o
						.getTransactionArray().getTransaction()[i]
						.getTransactionID();

				orderTransactionShippingServiceSelected.order_id = o
						.getOrderID();

				orderTransactionShippingServiceSelected.user_id = shop
						.getUserId();

				orderTransactionShippingServiceSelected.shop_id = shop
						.getShopId();

				if (shippingServiceOptionsType.isExpeditedService() != null) {

					orderTransactionShippingServiceSelected.expedited_service = shippingServiceOptionsType
							.isExpeditedService();
				}

				if (shippingServiceOptionsType.getImportCharge() != null) {

					orderTransactionShippingServiceSelected.import_charge = shippingServiceOptionsType
							.getImportCharge().getValue();

					orderTransactionShippingServiceSelected.import_charge_currency_id = shippingServiceOptionsType
							.getImportCharge().getCurrencyID().toString();
				}

				if (shippingServiceOptionsType.getLogisticPlanType() != null) {

					orderTransactionShippingServiceSelected.logistic_plan_type = shippingServiceOptionsType
							.getLogisticPlanType();
				}

				if (shippingServiceOptionsType.getShippingInsuranceCost() != null) {

					orderTransactionShippingServiceSelected.shipping_insurance_cost = shippingServiceOptionsType
							.getShippingInsuranceCost().getValue();

					orderTransactionShippingServiceSelected.shipping_insurance_cost_currency_id = shippingServiceOptionsType
							.getShippingInsuranceCost().getCurrencyID()
							.toString();
				}
					if (shippingServiceOptionsType.getShippingPackageInfo() != null) {

						orderTransactionShippingServiceSelected.shipping_package_info = mapper
								.writeValueAsString(shippingServiceOptionsType
										.getShippingPackageInfo());
					}

				if (shippingServiceOptionsType.getShippingService() != null) {

					orderTransactionShippingServiceSelected.shipping_service = shippingServiceOptionsType
							.getShippingService();
				}

				if (shippingServiceOptionsType
						.getShippingServiceAdditionalCost() != null) {

					orderTransactionShippingServiceSelected.shipping_service_additional_cost = shippingServiceOptionsType
							.getShippingServiceAdditionalCost().getValue();

					orderTransactionShippingServiceSelected.shipping_service_additional_cost_currency_id = shippingServiceOptionsType
							.getShippingServiceAdditionalCost().getCurrencyID()
							.toString();
				}

				if (shippingServiceOptionsType.getShippingServiceCost() != null) {

					orderTransactionShippingServiceSelected.shipping_service_cost = shippingServiceOptionsType
							.getShippingServiceCost().getValue();

					orderTransactionShippingServiceSelected.shipping_service_cost_currency_id = shippingServiceOptionsType
							.getShippingServiceCost().getCurrencyID()
							.toString();
				}

				if (shippingServiceOptionsType.getShippingServicePriority() != null) {

					orderTransactionShippingServiceSelected.shipping_service_priority = shippingServiceOptionsType
							.getShippingServicePriority();
				}

				orderTransactionShippingServiceSelectedList
						.add(orderTransactionShippingServiceSelected);
			}
		}

		return orderTransactionShippingServiceSelectedList;
	}

	/*public void batchInsertorderTransactionShippingServiceSelected(
			OrderType[] oList, Shops shop) {
		List<OrderTransactionShippingServiceSelected> list = new ArrayList<OrderTransactionShippingServiceSelected>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionShippingServiceSelected> orderTransactionShippingServiceSelectedList = HandleOrderTransactionShippingServiceSelected
						.returnOrderTransactionShippingServiceSelected(o, shop);
				for (int j = 0; j < orderTransactionShippingServiceSelectedList
						.size(); j++) {
					list.add(orderTransactionShippingServiceSelectedList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionShippingServiceSelectedMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionShippingServiceSelected(
			OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionShippingServiceSelected> orderTransactionShippingServiceSelectedList = HandleOrderTransactionShippingServiceSelected
						.returnOrderTransactionShippingServiceSelected(o, shop);
				for (int j = 0; j < orderTransactionShippingServiceSelectedList
						.size(); j++) {
					OrderTransactionShippingServiceSelected orderTransactionShippingServiceSelected = orderTransactionShippingServiceSelectedList
							.get(j);
					orderTransactionShippingServiceSelectedMapper
							.insert(orderTransactionShippingServiceSelected);
				}
			}

		}
	}*/
}
