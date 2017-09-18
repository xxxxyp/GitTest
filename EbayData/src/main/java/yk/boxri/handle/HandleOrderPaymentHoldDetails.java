package yk.boxri.handle;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderPaymentHoldDetailsMapper;
import yk.boxri.pojo.OrderPaymentHoldDetails;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PaymentHoldDetailType;

@Component("HandleOrderPaymentHoldDetails")
public class HandleOrderPaymentHoldDetails {

	public  OrderPaymentHoldDetails returnOrderPaymentHoldDetails(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();// jackson

		OrderPaymentHoldDetails orderPaymentHoldDetails = null;

		if (o.getPaymentHoldDetails() != null) {

			orderPaymentHoldDetails = new OrderPaymentHoldDetails();

			PaymentHoldDetailType paymentHoldDetailType = o
					.getPaymentHoldDetails();

			orderPaymentHoldDetails.order_id = o.getOrderID();

			orderPaymentHoldDetails.user_id = shop.getUserId();

			orderPaymentHoldDetails.shop_id = shop.getShopId();

			if (paymentHoldDetailType.getExpectedReleaseDate() != null) {

				orderPaymentHoldDetails.expected_release_date = paymentHoldDetailType
						.getExpectedReleaseDate().getTime();
			}


				if (paymentHoldDetailType.getRequiredSellerActionArray() != null) {

					orderPaymentHoldDetails.required_seller_action_values = mapper
							.writeValueAsString(paymentHoldDetailType
									.getRequiredSellerActionArray());
				}


			if (paymentHoldDetailType.getNumOfReqSellerActions() != null) {

				orderPaymentHoldDetails.num_of_req_seller_actions = paymentHoldDetailType
						.getNumOfReqSellerActions();
			}

			if (paymentHoldDetailType.getPaymentHoldReason() != null) {

				orderPaymentHoldDetails.payment_hold_reason = paymentHoldDetailType
						.getPaymentHoldReason().toString();
			}

		}
		return orderPaymentHoldDetails;
	}
}
