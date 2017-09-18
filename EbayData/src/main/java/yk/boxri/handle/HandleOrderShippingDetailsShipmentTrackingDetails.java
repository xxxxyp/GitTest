package yk.boxri.handle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderShippingDetailsShipmentTrackingDetailsMapper;
import yk.boxri.pojo.OrderShippingDetailsShipmentTrackingDetails;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.ShipmentTrackingDetailsType;

@Component("HandleOrderShippingDetailsShipmentTrackingDetails")
public class HandleOrderShippingDetailsShipmentTrackingDetails {

	public  List<OrderShippingDetailsShipmentTrackingDetails> returnOrderShippingDetailsShipmentTrackingDetails(
			OrderType o, ShopToken shop) {

		List<OrderShippingDetailsShipmentTrackingDetails> orderShippingDetailsShipmentTrackingDetailsList = new ArrayList<OrderShippingDetailsShipmentTrackingDetails>();

		if (o.getShippingDetails() != null) {

			if (o.getShippingDetails().getShipmentTrackingDetails() != null) {

				for (int i = 0; i < o.getShippingDetails()
						.getShipmentTrackingDetailsLength(); i++) {

					ShipmentTrackingDetailsType shipmentTrackingDetailsType = o
							.getShippingDetails().getShipmentTrackingDetails()[i];

					OrderShippingDetailsShipmentTrackingDetails orderShippingDetailsShipmentTrackingDetails = new OrderShippingDetailsShipmentTrackingDetails();

					orderShippingDetailsShipmentTrackingDetails.order_id = o
							.getOrderID();

					orderShippingDetailsShipmentTrackingDetails.user_id = shop
							.getUserId();

					orderShippingDetailsShipmentTrackingDetails.shop_id = shop
							.getShopId();

					if (shipmentTrackingDetailsType.getShipmentTrackingNumber() != null) {

						orderShippingDetailsShipmentTrackingDetails.shipment_tracking_number = shipmentTrackingDetailsType
								.getShipmentTrackingNumber();
					}

					if (shipmentTrackingDetailsType.getShippingCarrierUsed() != null) {

						orderShippingDetailsShipmentTrackingDetails.shipping_carrier_used = shipmentTrackingDetailsType
								.getShippingCarrierUsed();
					}

					orderShippingDetailsShipmentTrackingDetailsList
							.add(orderShippingDetailsShipmentTrackingDetails);
				}
			}
		}

		return orderShippingDetailsShipmentTrackingDetailsList;
	}
}
