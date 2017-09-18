package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionShippingDetailsIntlShippingServiceOptionMapper;
import yk.boxri.pojo.OrderTransactionShippingDetailsIntlShippingServiceOption;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.InternationalShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;

@Component("HandleOrderTransactionShippingDetailsIntlShippingServiceOption")
public class HandleOrderTransactionShippingDetailsIntlShippingServiceOption {

	public  List<OrderTransactionShippingDetailsIntlShippingServiceOption> returnOrderTransactionShippingDetailsIntlShippingServiceOption(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();// jackson

		List<OrderTransactionShippingDetailsIntlShippingServiceOption> orderTransactionShippingDetailsIntlShippingServiceOptionList = new ArrayList<OrderTransactionShippingDetailsIntlShippingServiceOption>();

		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {

			if (o.getTransactionArray().getTransaction(i).getShippingDetails() != null) {

				ShippingDetailsType shippingDetailsType = o
						.getTransactionArray().getTransaction(i)
						.getShippingDetails();

				for (int y = 0; y < shippingDetailsType
						.getInternationalShippingServiceOptionLength(); y++) {

					OrderTransactionShippingDetailsIntlShippingServiceOption orderTransactionShippingDetailsIntlShippingServiceOption = new OrderTransactionShippingDetailsIntlShippingServiceOption();

					InternationalShippingServiceOptionsType internationalShippingServiceOptionsType = shippingDetailsType
							.getInternationalShippingServiceOption()[y];

					orderTransactionShippingDetailsIntlShippingServiceOption.transaction_id = o
							.getTransactionArray().getTransaction()[i]
							.getTransactionID();

					orderTransactionShippingDetailsIntlShippingServiceOption.order_id = o
							.getOrderID();

					orderTransactionShippingDetailsIntlShippingServiceOption.user_id = shop
							.getUserId();

					orderTransactionShippingDetailsIntlShippingServiceOption.shop_id = shop
							.getShopId();

					if (internationalShippingServiceOptionsType
							.getImportCharge() != null) {

						orderTransactionShippingDetailsIntlShippingServiceOption.import_charge = internationalShippingServiceOptionsType
								.getImportCharge().getValue();

						orderTransactionShippingDetailsIntlShippingServiceOption.import_charge_currency_id = internationalShippingServiceOptionsType
								.getImportCharge().getCurrencyID().toString();
					}

					if (internationalShippingServiceOptionsType
							.getShippingInsuranceCost() != null) {

						orderTransactionShippingDetailsIntlShippingServiceOption.shipping_insurance_cost = internationalShippingServiceOptionsType
								.getShippingInsuranceCost().getValue();

						orderTransactionShippingDetailsIntlShippingServiceOption.shipping_insurance_cost_currency_id = internationalShippingServiceOptionsType
								.getShippingInsuranceCost().getCurrencyID()
								.toString();
					}

					if (internationalShippingServiceOptionsType
							.getShippingService() != null) {

						orderTransactionShippingDetailsIntlShippingServiceOption.shipping_service = internationalShippingServiceOptionsType
								.getShippingService();
					}

					if (internationalShippingServiceOptionsType
							.getShippingServiceCost() != null) {

						orderTransactionShippingDetailsIntlShippingServiceOption.shipping_service__cost_currency_id = internationalShippingServiceOptionsType
								.getShippingServiceCost().getCurrencyID()
								.toString();

						orderTransactionShippingDetailsIntlShippingServiceOption.shipping_service_cost = internationalShippingServiceOptionsType
								.getShippingServiceCost().getValue();
					}

					if (internationalShippingServiceOptionsType
							.getShippingServiceAdditionalCost() != null) {

						orderTransactionShippingDetailsIntlShippingServiceOption.shipping_service_additional_cost = internationalShippingServiceOptionsType
								.getShippingServiceAdditionalCost().getValue();

						orderTransactionShippingDetailsIntlShippingServiceOption.shipping_service_additional_cost_currency_id = internationalShippingServiceOptionsType
								.getShippingServiceAdditionalCost()
								.getCurrencyID().toString();
					}

					if (internationalShippingServiceOptionsType
							.getShippingServicePriority() != null) {

						orderTransactionShippingDetailsIntlShippingServiceOption.shipping_service_priority = internationalShippingServiceOptionsType
								.getShippingServicePriority();
					}

						if (internationalShippingServiceOptionsType
								.getShipToLocation() != null) {

							orderTransactionShippingDetailsIntlShippingServiceOption.ship_to_location_values = mapper
									.writeValueAsString(internationalShippingServiceOptionsType
											.getShipToLocation());
						}

					orderTransactionShippingDetailsIntlShippingServiceOptionList
							.add(orderTransactionShippingDetailsIntlShippingServiceOption);
				}
			}
		}

		return orderTransactionShippingDetailsIntlShippingServiceOptionList;
	}

	/*public void batchInsertorderTransactionShippingDetailsIntlShippingServiceOption(
			OrderType[] oList, Shops shop) {
		List<OrderTransactionShippingDetailsIntlShippingServiceOption> list = new ArrayList<OrderTransactionShippingDetailsIntlShippingServiceOption>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionShippingDetailsIntlShippingServiceOption> orderTransactionShippingDetailsIntlShippingServiceOptionList = HandleOrderTransactionShippingDetailsIntlShippingServiceOption
						.returnOrderTransactionShippingDetailsIntlShippingServiceOption(
								o, shop);
				for (int j = 0; j < orderTransactionShippingDetailsIntlShippingServiceOptionList
						.size(); j++) {
					list.add(orderTransactionShippingDetailsIntlShippingServiceOptionList
							.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionShippingDetailsIntlShippingServiceOptionMapper
						.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionShippingDetailsIntlShippingServiceOption(
			OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionShippingDetailsIntlShippingServiceOption> orderTransactionShippingDetailsIntlShippingServiceOptionList = HandleOrderTransactionShippingDetailsIntlShippingServiceOption
						.returnOrderTransactionShippingDetailsIntlShippingServiceOption(
								o, shop);
				for (int j = 0; j < orderTransactionShippingDetailsIntlShippingServiceOptionList
						.size(); j++) {
					OrderTransactionShippingDetailsIntlShippingServiceOption orderTransactionShippingDetailsIntlShippingServiceOption = orderTransactionShippingDetailsIntlShippingServiceOptionList
							.get(j);
					orderTransactionShippingDetailsIntlShippingServiceOptionMapper
							.insert(orderTransactionShippingDetailsIntlShippingServiceOption);
				}
			}

		}
	}*/
}