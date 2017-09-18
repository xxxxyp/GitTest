package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderShippingDetailsIntlShippingServiceOptionMapper;
import yk.boxri.pojo.OrderShippingDetailsIntlShippingServiceOption;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.InternationalShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.OrderType;

@Component("HandleOrderShippingDetailsIntlShippingServiceOption")
public class HandleOrderShippingDetailsIntlShippingServiceOption {

	public  List<OrderShippingDetailsIntlShippingServiceOption> returnOrderShippingDetailsIntlShippingServiceOption(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {

		List<OrderShippingDetailsIntlShippingServiceOption> orderShippingDetailsIntlShippingServiceOptionList = new ArrayList<OrderShippingDetailsIntlShippingServiceOption>();

		ObjectMapper mapper = new ObjectMapper();// jackson

		if (o.getShippingDetails() != null) {

			if (o.getShippingDetails().getInternationalShippingServiceOption() != null) {

				for (int i = 0; i < o.getShippingDetails()
						.getInternationalShippingServiceOptionLength(); i++) {

					InternationalShippingServiceOptionsType internationalShippingServiceOptionsType = o
							.getShippingDetails()
							.getInternationalShippingServiceOption()[i];

					OrderShippingDetailsIntlShippingServiceOption orderShippingDetailsIntlShippingServiceOption = new OrderShippingDetailsIntlShippingServiceOption();

					orderShippingDetailsIntlShippingServiceOption.order_id = o
							.getOrderID();

					orderShippingDetailsIntlShippingServiceOption.user_id = shop
							.getUserId();

					orderShippingDetailsIntlShippingServiceOption.shop_id = shop
							.getShopId();

					if (internationalShippingServiceOptionsType
							.getImportCharge() != null) {

						orderShippingDetailsIntlShippingServiceOption.import_charge = internationalShippingServiceOptionsType
								.getImportCharge().getValue();

						orderShippingDetailsIntlShippingServiceOption.import_charge_currency_id = internationalShippingServiceOptionsType
								.getImportCharge().getCurrencyID().toString();
					}

					if (internationalShippingServiceOptionsType
							.getShippingInsuranceCost() != null) {

						orderShippingDetailsIntlShippingServiceOption.shipping_insurance_cost = internationalShippingServiceOptionsType
								.getShippingInsuranceCost().getValue();

						orderShippingDetailsIntlShippingServiceOption.shipping_insurance_cost_currency_id = internationalShippingServiceOptionsType
								.getShippingInsuranceCost().getCurrencyID()
								.toString();
					}

					if (internationalShippingServiceOptionsType
							.getShippingService() != null) {

						orderShippingDetailsIntlShippingServiceOption.shipping_service = internationalShippingServiceOptionsType
								.getShippingService();
					}

					if (internationalShippingServiceOptionsType
							.getShippingServiceAdditionalCost() != null) {

						orderShippingDetailsIntlShippingServiceOption.shipping_service_additional_cost = internationalShippingServiceOptionsType
								.getShippingServiceAdditionalCost().getValue();

						orderShippingDetailsIntlShippingServiceOption.shipping_service_additional_cost_currency_id = internationalShippingServiceOptionsType
								.getShippingServiceAdditionalCost()
								.getCurrencyID().toString();
					}

					if (internationalShippingServiceOptionsType
							.getShippingServiceCost() != null) {

						orderShippingDetailsIntlShippingServiceOption.shipping_service_cost = internationalShippingServiceOptionsType
								.getShippingServiceCost().getValue();

						orderShippingDetailsIntlShippingServiceOption.shipping_service__cost_currency_id = internationalShippingServiceOptionsType
								.getShippingServiceCost().getCurrencyID()
								.toString();
					}
					if (internationalShippingServiceOptionsType
							.getShippingServicePriority() != null) {

						orderShippingDetailsIntlShippingServiceOption.shipping_service_priority = internationalShippingServiceOptionsType
								.getShippingServicePriority();
					}

						if (internationalShippingServiceOptionsType
								.getShipToLocation() != null) {
							orderShippingDetailsIntlShippingServiceOption.ship_to_location_values = mapper
									.writeValueAsString(internationalShippingServiceOptionsType
											.getShipToLocation());
						}

					orderShippingDetailsIntlShippingServiceOptionList
							.add(orderShippingDetailsIntlShippingServiceOption);
				}

			}
		}

		return orderShippingDetailsIntlShippingServiceOptionList;
	}
}
