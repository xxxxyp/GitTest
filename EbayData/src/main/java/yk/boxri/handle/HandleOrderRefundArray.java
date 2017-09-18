package yk.boxri.handle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderRefundArrayMapper;
import yk.boxri.pojo.OrderRefundArray;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.RefundType;

@Component("HandleOrderRefundArray")
public class HandleOrderRefundArray {

	public  List<OrderRefundArray> returnOrderRefundArray(OrderType o,
			ShopToken shop) {

		List<OrderRefundArray> orderRefundArrayList = new ArrayList<OrderRefundArray>();

		if (o.getRefundArray() != null) {

			for (int i = 0; i < o.getRefundArray().getRefundLength(); i++) {

				RefundType refundType = o.getRefundArray().getRefund()[i];

				OrderRefundArray orderRefundArray = new OrderRefundArray();

				orderRefundArray.order_id = o.getOrderID();

				orderRefundArray.user_id = shop.getUserId();

				orderRefundArray.shop_id = shop.getShopId();

				if (refundType.getRefundID() != null) {

					orderRefundArray.refund_id = refundType.getRefundID();
				}

				if (refundType.getRefundAmount() != null) {

					orderRefundArray.refund_amount = refundType
							.getRefundAmount().getValue();

					orderRefundArray.refund_amount_currency_id = refundType
							.getRefundAmount().getCurrencyID().toString();
				}

				if (refundType.getRefundFromSeller() != null) {

					orderRefundArray.refund_from_seller = refundType
							.getRefundFromSeller().getValue();

					orderRefundArray.refund_from_seller_currency_id = refundType
							.getRefundFromSeller().getCurrencyID().toString();

				}

				if (refundType.getRefundID() != null) {

					orderRefundArray.refund_id = refundType.getRefundID();
				}

				if (refundType.getRefundTime() != null) {

					orderRefundArray.refund_time = refundType.getRefundTime()
							.getTime();
				}

				if (refundType.getTotalRefundToBuyer() != null) {

					orderRefundArray.total_refund_to_buyer = refundType
							.getTotalRefundToBuyer().getValue();

					orderRefundArray.total_refund_to_buyer_currency_id = refundType
							.getTotalRefundToBuyer().getCurrencyID().toString();
				}

				orderRefundArrayList.add(orderRefundArray);
			}
		}
		return orderRefundArrayList;
	}

	/*public void batchInsertOrderRefundArray(OrderType[] oList, Shops shop) {
		List<OrderRefundArray> list = new ArrayList<OrderRefundArray>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderRefundArray> orderRefundArrayList = HandleOrderRefundArray
						.returnOrderRefundArray(o, shop);
				for (int j = 0; j < orderRefundArrayList.size(); j++) {
					list.add(orderRefundArrayList.get(j));
				}
			}
			if (list.size() != 0) {
				orderRefundArrayMapper.insertBatch(list);
			}
		}
	}

	public void insertOrderRefundArray(OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderRefundArray> orderRefundArrayList = HandleOrderRefundArray
						.returnOrderRefundArray(o, shop);
				for (int j = 0; j < orderRefundArrayList.size(); j++) {
					OrderRefundArray orderRefundArray = orderRefundArrayList
							.get(j);
					orderRefundArrayMapper.insert(orderRefundArray);
				}
			}

		}
	}*/
}
