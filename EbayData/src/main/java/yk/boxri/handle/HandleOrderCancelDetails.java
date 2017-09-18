package yk.boxri.handle;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

import yk.boxri.pojo.OrderCancelDetails;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.CancelDetailType;
import com.ebay.soap.eBLBaseComponents.OrderType;

@Component("HandleOrderCancelDetails")
public class HandleOrderCancelDetails {

	public  List<OrderCancelDetails> returnOrderCancelDetails(
			OrderType o, ShopToken shop) {

		List<OrderCancelDetails> orderCancelDetailsList = new ArrayList<OrderCancelDetails>();

		for (int i = 0; i < o.getCancelDetailLength(); i++) {

			OrderCancelDetails orderCancelDetails = new OrderCancelDetails();

			CancelDetailType cancelDetailType = o.getCancelDetail()[i];

			orderCancelDetails.order_id = o.getOrderID();

			orderCancelDetails.user_id = shop.getUserId();

			orderCancelDetails.shop_id = shop.getShopId();

			if (cancelDetailType.getCancelCompleteDate() != null) {

				orderCancelDetails.cancel_complete_date = cancelDetailType
						.getCancelCompleteDate().getTime();
			}

			if (cancelDetailType.getCancelIntiationDate() != null) {

				orderCancelDetails.cancel_intiation_date = cancelDetailType
						.getCancelIntiationDate().getTime();
			}

			if (cancelDetailType.getCancelIntiator() != null) {

				orderCancelDetails.cancel_intiator = cancelDetailType
						.getCancelIntiator();
			}

			if (cancelDetailType.getCancelReason() != null) {

				orderCancelDetails.cancel_reason = cancelDetailType
						.getCancelReason();
			}

			if (cancelDetailType.getCancelReasonDetails() != null) {

				orderCancelDetails.cancel_reason_details = cancelDetailType
						.getCancelReasonDetails();
			}

			orderCancelDetailsList.add(orderCancelDetails);
		}

		return orderCancelDetailsList;

	}
}
