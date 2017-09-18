package yk.boxri.handle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionRefundArrayMapper;
import yk.boxri.pojo.OrderTransactionRefundArray;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.RefundType;

@Component("HandleOrderTransactionRefundArray")
public class HandleOrderTransactionRefundArray {

	public  List<OrderTransactionRefundArray> returnOrderTransactionRefundArray(
			OrderType o, ShopToken shop) {

		List<OrderTransactionRefundArray> orderTransactionRefundArrayList = new ArrayList<OrderTransactionRefundArray>();

		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {

			if (o.getTransactionArray().getTransaction(i).getRefundArray() != null) {

				if (o.getTransactionArray().getTransaction(i).getRefundArray()
						.getRefund() != null) {

					RefundType[] refundType = o.getTransactionArray()
							.getTransaction(i).getRefundArray().getRefund();

					for (int y = 0; y < refundType.length; y++) {

						OrderTransactionRefundArray orderTransactionRefundArray = new OrderTransactionRefundArray();

						orderTransactionRefundArray.transaction_id = o
								.getTransactionArray().getTransaction()[i]
								.getTransactionID();

						orderTransactionRefundArray.order_id = o.getOrderID();

						orderTransactionRefundArray.user_id = shop.getUserId();

						orderTransactionRefundArray.shop_id = shop.getShopId();

						if (refundType[y].getRefundAmount() != null) {

							orderTransactionRefundArray.refund_amount = refundType[y]
									.getRefundAmount().getValue();

							orderTransactionRefundArray.refund_amount_currency_id = refundType[y]
									.getRefundAmount().getCurrencyID()
									.toString();
						}

						if (refundType[y].getRefundFromSeller() != null) {

							orderTransactionRefundArray.refund_from_seller = refundType[y]
									.getRefundFromSeller().getValue();

							orderTransactionRefundArray.refund_from_seller_currency_id = refundType[y]
									.getRefundFromSeller().getCurrencyID()
									.toString();
						}

						if (refundType[y].getRefundID() != null) {

							orderTransactionRefundArray.refund_id = refundType[y]
									.getRefundID();
						}

						if (refundType[y].getRefundTime() != null) {

							orderTransactionRefundArray.refund_time = refundType[y]
									.getRefundTime().getTime();
						}

						if (refundType[y].getTotalRefundToBuyer() != null) {

							orderTransactionRefundArray.total_refund_to_buyer = refundType[y]
									.getTotalRefundToBuyer().getValue();

							orderTransactionRefundArray.total_refund_to_buyer_currency_id = refundType[y]
									.getTotalRefundToBuyer().getCurrencyID()
									.toString();
						}
						orderTransactionRefundArrayList
								.add(orderTransactionRefundArray);
					}
				}
			}
		}

		return orderTransactionRefundArrayList;
	}

	/*public void batchInsertorderTransactionRefundArray(OrderType[] oList,
			Shops shop) {
		List<OrderTransactionRefundArray> list = new ArrayList<OrderTransactionRefundArray>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionRefundArray> orderTransactionRefundArrayList = HandleOrderTransactionRefundArray
						.returnOrderTransactionRefundArray(o, shop);
				for (int j = 0; j < orderTransactionRefundArrayList.size(); j++) {
					list.add(orderTransactionRefundArrayList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionRefundArrayMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionRefundArray(OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionRefundArray> orderTransactionRefundArrayList = HandleOrderTransactionRefundArray
						.returnOrderTransactionRefundArray(o, shop);
				for (int j = 0; j < orderTransactionRefundArrayList.size(); j++) {
					OrderTransactionRefundArray orderTransactionRefundArray = orderTransactionRefundArrayList
							.get(j);
					orderTransactionRefundArrayMapper
							.insert(orderTransactionRefundArray);
				}
			}

		}
	}*/
}