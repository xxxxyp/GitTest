package yk.boxri.handle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionShippingDetailsShipmentTrackingDetailsMapper;
import yk.boxri.pojo.OrderTransactionShippingDetailsShipmentTrackingDetails;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.ShipmentTrackingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;

@Component("HandleOrderTransactionShippingDetailsShipmentTrackingDetails")
public class HandleOrderTransactionShippingDetailsShipmentTrackingDetails {

	public  List<OrderTransactionShippingDetailsShipmentTrackingDetails> returnOrderTransactionShippingDetailsShipmentTrackingDetails(
			OrderType o, ShopToken shop) {

		List<OrderTransactionShippingDetailsShipmentTrackingDetails> orderTransactionShippingDetailsShipmentTrackingDetailsList = new ArrayList<OrderTransactionShippingDetailsShipmentTrackingDetails>();

		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {

			if (o.getTransactionArray().getTransaction(i).getShippingDetails() != null) {

				ShippingDetailsType shippingDetailsType = o
						.getTransactionArray().getTransaction(i)
						.getShippingDetails();

				OrderTransactionShippingDetailsShipmentTrackingDetails orderTransactionShippingDetailsShipmentTrackingDetails = null;

				for (int y = 0; y < shippingDetailsType
						.getShipmentTrackingDetailsLength(); y++) {// ddd

					orderTransactionShippingDetailsShipmentTrackingDetails = new OrderTransactionShippingDetailsShipmentTrackingDetails();

					ShipmentTrackingDetailsType ShipmentTrackingDetailsType = shippingDetailsType
							.getShipmentTrackingDetails()[y];

					orderTransactionShippingDetailsShipmentTrackingDetails.transaction_id = o
							.getTransactionArray().getTransaction()[i]
							.getTransactionID();

					orderTransactionShippingDetailsShipmentTrackingDetails.order_id = o
							.getOrderID();

					orderTransactionShippingDetailsShipmentTrackingDetails.user_id = shop
							.getUserId();

					orderTransactionShippingDetailsShipmentTrackingDetails.shop_id = shop
							.getShopId();

					if (ShipmentTrackingDetailsType.getShipmentTrackingNumber() != null) {

						orderTransactionShippingDetailsShipmentTrackingDetails.shipment_tracking_number = ShipmentTrackingDetailsType
								.getShipmentTrackingNumber();
					}

					if (ShipmentTrackingDetailsType.getShippingCarrierUsed() != null) {

						orderTransactionShippingDetailsShipmentTrackingDetails.shipping_carrier_used = ShipmentTrackingDetailsType
								.getShippingCarrierUsed();
					}

					orderTransactionShippingDetailsShipmentTrackingDetailsList
							.add(orderTransactionShippingDetailsShipmentTrackingDetails);
				}
			}
		}

		return orderTransactionShippingDetailsShipmentTrackingDetailsList;
	}

	/*public void batchInsertorderTransactionShippingDetailsShipmentTrackingDetails(
			OrderType[] oList, Shops shop) {
		List<OrderTransactionShippingDetailsShipmentTrackingDetails> list = new ArrayList<OrderTransactionShippingDetailsShipmentTrackingDetails>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionShippingDetailsShipmentTrackingDetails> orderTransactionShippingDetailsShipmentTrackingDetailsList = HandleOrderTransactionShippingDetailsShipmentTrackingDetails
						.returnOrderTransactionShippingDetailsShipmentTrackingDetails(
								o, shop);
				for (int j = 0; j < orderTransactionShippingDetailsShipmentTrackingDetailsList
						.size(); j++) {
					list.add(orderTransactionShippingDetailsShipmentTrackingDetailsList
							.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionShippingDetailsShipmentTrackingDetailsMapper
						.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionShippingDetailsShipmentTrackingDetails(
			OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionShippingDetailsShipmentTrackingDetails> orderTransactionShippingDetailsShipmentTrackingDetailsList = HandleOrderTransactionShippingDetailsShipmentTrackingDetails
						.returnOrderTransactionShippingDetailsShipmentTrackingDetails(
								o, shop);
				for (int j = 0; j < orderTransactionShippingDetailsShipmentTrackingDetailsList
						.size(); j++) {
					OrderTransactionShippingDetailsShipmentTrackingDetails orderTransactionShippingDetailsShipmentTrackingDetails = orderTransactionShippingDetailsShipmentTrackingDetailsList
							.get(j);
					orderTransactionShippingDetailsShipmentTrackingDetailsMapper
							.insert(orderTransactionShippingDetailsShipmentTrackingDetails);
				}
			}

		}
	}*/
}