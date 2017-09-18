package yk.boxri.handle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderPickupDetailsMapper;
import yk.boxri.pojo.OrderPickupDetails;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PickupOptionsType;

@Component("HandleOrderPickupDetails")
public class HandleOrderPickupDetails {

	public  List<OrderPickupDetails> returnOrderPickupDetails(
			OrderType o, ShopToken shop) {

		List<OrderPickupDetails> orderPickupDetailsList = new ArrayList<OrderPickupDetails>();

		if (o.getPickupDetails() != null) {

			for (int i = 0; i < o.getPickupDetails().getPickupOptionsLength(); i++) {

				PickupOptionsType pickupOptionsType = o.getPickupDetails()
						.getPickupOptions()[i];

				OrderPickupDetails orderPickupDetails = new OrderPickupDetails();

				orderPickupDetails.order_id = o.getOrderID();

				orderPickupDetails.user_id = shop.getUserId();

				orderPickupDetails.shop_id = shop.getShopId();

				if (pickupOptionsType.getPickupMethod() != null) {

					orderPickupDetails.pickup_method = pickupOptionsType
							.getPickupMethod();
				}

				if (pickupOptionsType.getPickupPriority() != null) {

					orderPickupDetails.pickup_priority = pickupOptionsType
							.getPickupPriority();

				}

				orderPickupDetailsList.add(orderPickupDetails);
			}
		}

		return orderPickupDetailsList;
	}
}