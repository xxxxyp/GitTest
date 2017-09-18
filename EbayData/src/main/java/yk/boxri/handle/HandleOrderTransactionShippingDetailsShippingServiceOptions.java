package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionShippingDetailsShippingServiceOptionsMapper;
import yk.boxri.pojo.OrderTransactionShippingDetailsShippingServiceOptions;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;

@Component("HandleOrderTransactionShippingDetailsShippingServiceOptions")
public class HandleOrderTransactionShippingDetailsShippingServiceOptions {

	public  List<OrderTransactionShippingDetailsShippingServiceOptions> returnOrderTransactionShippingDetailsShippingServiceOptions(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {

		List<OrderTransactionShippingDetailsShippingServiceOptions> orderTransactionShippingDetailsShippingServiceOptionsList = new ArrayList<OrderTransactionShippingDetailsShippingServiceOptions>();

		ObjectMapper mapper = new ObjectMapper();// jackson

		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {

			if (o.getTransactionArray().getTransaction(i).getShippingDetails() != null) {

				ShippingDetailsType shippingDetailsType = o
						.getTransactionArray().getTransaction(i)
						.getShippingDetails();

				for (int y = 0; y < shippingDetailsType
						.getShippingServiceOptionsLength(); y++) {

					OrderTransactionShippingDetailsShippingServiceOptions orderTransactionShippingDetailsShippingServiceOptions = new OrderTransactionShippingDetailsShippingServiceOptions();

					ShippingServiceOptionsType shippingServiceOptionsType = shippingDetailsType
							.getShippingServiceOptions()[y];

					orderTransactionShippingDetailsShippingServiceOptions.transaction_id = o
							.getTransactionArray().getTransaction()[i]
							.getTransactionID();

					orderTransactionShippingDetailsShippingServiceOptions.order_id = o
							.getOrderID();

					orderTransactionShippingDetailsShippingServiceOptions.user_id = shop
							.getUserId();

					orderTransactionShippingDetailsShippingServiceOptions.shop_id = shop
							.getShopId();

					if (shippingServiceOptionsType.isExpeditedService() != null) {

						orderTransactionShippingDetailsShippingServiceOptions.expedited_service = shippingServiceOptionsType
								.isExpeditedService();
					}

					if (shippingServiceOptionsType.getLogisticPlanType() != null) {

						orderTransactionShippingDetailsShippingServiceOptions.logistic_plan_type = shippingServiceOptionsType
								.getLogisticPlanType();
					}

					if (shippingServiceOptionsType.getShippingService() != null) {

						orderTransactionShippingDetailsShippingServiceOptions.option_shipping_service = shippingServiceOptionsType
								.getShippingService();
					}

					if (shippingServiceOptionsType
							.getShippingServiceAdditionalCost() != null) {

						orderTransactionShippingDetailsShippingServiceOptions.option_shipping_service_additional_cost = shippingServiceOptionsType
								.getShippingServiceAdditionalCost().getValue();

						orderTransactionShippingDetailsShippingServiceOptions.option_shipping_service_additional_cost_currency_id = shippingServiceOptionsType
								.getShippingServiceAdditionalCost()
								.getCurrencyID().toString();
					}

					if (shippingServiceOptionsType.getShippingServiceCost() != null) {

						orderTransactionShippingDetailsShippingServiceOptions.option_shipping_service_cost = shippingServiceOptionsType
								.getShippingServiceCost().getValue();

						orderTransactionShippingDetailsShippingServiceOptions.option_shipping_service_cost_currency_id = shippingServiceOptionsType
								.getShippingServiceCost().getCurrencyID()
								.toString();
					}

					if (shippingServiceOptionsType.getShippingServicePriority() != null) {

						orderTransactionShippingDetailsShippingServiceOptions.option_shipping_service_priority = shippingServiceOptionsType
								.getShippingServicePriority();
					}

					if (shippingServiceOptionsType.getImportCharge() != null) {

						orderTransactionShippingDetailsShippingServiceOptions.options_import_charge = shippingServiceOptionsType
								.getImportCharge().getValue();

						orderTransactionShippingDetailsShippingServiceOptions.options_import_charge_currency_id = shippingServiceOptionsType
								.getImportCharge().getCurrencyID().toString();
					}

					if (shippingServiceOptionsType.getShippingInsuranceCost() != null) {

						orderTransactionShippingDetailsShippingServiceOptions.options_shipping_insurance_cost = shippingServiceOptionsType
								.getShippingInsuranceCost().getValue();

						orderTransactionShippingDetailsShippingServiceOptions.options_shipping_insurance_cost_currency_id = shippingServiceOptionsType
								.getShippingInsuranceCost().getCurrencyID()
								.toString();
					}


						if (shippingServiceOptionsType.getShippingPackageInfo() != null) {

							orderTransactionShippingDetailsShippingServiceOptions.shipping_package_info = mapper
									.writeValueAsString(shippingServiceOptionsType
											.getShippingPackageInfo());
						}


					orderTransactionShippingDetailsShippingServiceOptionsList
							.add(orderTransactionShippingDetailsShippingServiceOptions);
				}
			}
		}

		return orderTransactionShippingDetailsShippingServiceOptionsList;
	}

	/*public void batchInsertorderTransactionShippingDetailsShippingServiceOptions(
			OrderType[] oList, Shops shop) {
		List<OrderTransactionShippingDetailsShippingServiceOptions> list = new ArrayList<OrderTransactionShippingDetailsShippingServiceOptions>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionShippingDetailsShippingServiceOptions> orderTransactionShippingDetailsShippingServiceOptionsList = HandleOrderTransactionShippingDetailsShippingServiceOptions
						.returnOrderTransactionShippingDetailsShippingServiceOptions(
								o, shop);
				for (int j = 0; j < orderTransactionShippingDetailsShippingServiceOptionsList
						.size(); j++) {
					list.add(orderTransactionShippingDetailsShippingServiceOptionsList
							.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionShippingDetailsShippingServiceOptionsMapper
						.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionShippingDetailsShippingServiceOptions(
			OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionShippingDetailsShippingServiceOptions> orderTransactionShippingDetailsShippingServiceOptionsList = HandleOrderTransactionShippingDetailsShippingServiceOptions
						.returnOrderTransactionShippingDetailsShippingServiceOptions(
								o, shop);
				for (int j = 0; j < orderTransactionShippingDetailsShippingServiceOptionsList
						.size(); j++) {
					OrderTransactionShippingDetailsShippingServiceOptions orderTransactionShippingDetailsShippingServiceOptions = orderTransactionShippingDetailsShippingServiceOptionsList
							.get(j);
					orderTransactionShippingDetailsShippingServiceOptionsMapper
							.insert(orderTransactionShippingDetailsShippingServiceOptions);
				}
			}

		}
	}*/
}