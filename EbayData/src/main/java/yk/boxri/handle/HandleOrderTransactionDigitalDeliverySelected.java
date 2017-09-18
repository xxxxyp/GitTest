package yk.boxri.handle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionDigitalDeliverySelectedMapper;
import yk.boxri.pojo.OrderTransactionDigitalDeliverySelected;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.DigitalDeliverySelectedType;
import com.ebay.soap.eBLBaseComponents.OrderType;

@Component("HandleOrderTransactionDigitalDeliverySelected")
public class HandleOrderTransactionDigitalDeliverySelected {

	public  List<OrderTransactionDigitalDeliverySelected> returnOrderTransactionDigitalDeliverySelected(
			OrderType o, ShopToken shop) {

		List<OrderTransactionDigitalDeliverySelected> orderTransactionDigitalDeliverySelectedList = new ArrayList<OrderTransactionDigitalDeliverySelected>();

		if (o.getTransactionArray() != null) {

			for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {

				OrderTransactionDigitalDeliverySelected orderTransactionDigitalDeliverySelected = null;

				if (o.getTransactionArray().getTransaction(i)
						.getDigitalDeliverySelected() != null) {

					orderTransactionDigitalDeliverySelected = new OrderTransactionDigitalDeliverySelected();

					DigitalDeliverySelectedType digitalDeliverySelectedType = o
							.getTransactionArray().getTransaction(i)
							.getDigitalDeliverySelected();

					orderTransactionDigitalDeliverySelected.transaction_id = o
							.getTransactionArray().getTransaction(i)
							.getTransactionID();

					orderTransactionDigitalDeliverySelected.order_id = o
							.getOrderID();

					orderTransactionDigitalDeliverySelected.user_id = shop
							.getUserId();

					orderTransactionDigitalDeliverySelected.shop_id = shop
							.getShopId();

					if (orderTransactionDigitalDeliverySelected.delivery_method != null) {

						orderTransactionDigitalDeliverySelected.delivery_method = digitalDeliverySelectedType
								.getDeliveryMethod();
					}

					if (digitalDeliverySelectedType.getDeliveryStatus() != null) {

						orderTransactionDigitalDeliverySelected.delivery_status_email = digitalDeliverySelectedType
								.getDeliveryStatus().getEmail();
					}

					if (digitalDeliverySelectedType.getDeliveryDetails() != null) {

						if (digitalDeliverySelectedType.getDeliveryDetails()
								.getRecipient() != null) {

							orderTransactionDigitalDeliverySelected.recipient_email = digitalDeliverySelectedType
									.getDeliveryDetails().getRecipient()
									.getEmail();

							orderTransactionDigitalDeliverySelected.recipient_name = digitalDeliverySelectedType
									.getDeliveryDetails().getRecipient()
									.getName();
						}

						if (digitalDeliverySelectedType.getDeliveryDetails()
								.getSender() != null) {

							orderTransactionDigitalDeliverySelected.sender_email = digitalDeliverySelectedType
									.getDeliveryDetails().getSender()
									.getEmail();

							orderTransactionDigitalDeliverySelected.sender_name = digitalDeliverySelectedType
									.getDeliveryDetails().getSender().getName();
						}

					}

					orderTransactionDigitalDeliverySelectedList
							.add(orderTransactionDigitalDeliverySelected);
				}
			}
		}

		return orderTransactionDigitalDeliverySelectedList;
	}

	/*public void batchInsertorderTransactionDigitalDeliverySelected(
			OrderType[] oList, Shops shop) {
		List<OrderTransactionDigitalDeliverySelected> list = new ArrayList<OrderTransactionDigitalDeliverySelected>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionDigitalDeliverySelected> orderTransactionDigitalDeliverySelectedList = HandleOrderTransactionDigitalDeliverySelected
						.returnOrderTransactionDigitalDeliverySelected(o, shop);
				for (int j = 0; j < orderTransactionDigitalDeliverySelectedList
						.size(); j++) {
					list.add(orderTransactionDigitalDeliverySelectedList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionDigitalDeliverySelectedMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionDigitalDeliverySelected(
			OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionDigitalDeliverySelected> orderTransactionDigitalDeliverySelectedList = HandleOrderTransactionDigitalDeliverySelected
						.returnOrderTransactionDigitalDeliverySelected(o, shop);
				for (int j = 0; j < orderTransactionDigitalDeliverySelectedList
						.size(); j++) {
					OrderTransactionDigitalDeliverySelected orderTransactionDigitalDeliverySelected = orderTransactionDigitalDeliverySelectedList
							.get(j);
					orderTransactionDigitalDeliverySelectedMapper
							.insert(orderTransactionDigitalDeliverySelected);
				}
			}

		}
	}*/
}
