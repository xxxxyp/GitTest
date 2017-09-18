package yk.boxri.handle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionMonetaryDetailsRefundsMapper;
import yk.boxri.pojo.OrderTransactionMonetaryDetailsRefunds;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.RefundInformationType;
import com.ebay.soap.eBLBaseComponents.RefundTransactionInfoType;

@Component("HandleOrderTransactionMonetaryDetailsRefunds")
public class HandleOrderTransactionMonetaryDetailsRefunds {

	public  List<OrderTransactionMonetaryDetailsRefunds> returnOrderTransactionMonetaryDetailsRefunds(
			OrderType o, ShopToken shop) {

		List<OrderTransactionMonetaryDetailsRefunds> orderTransactionMonetaryDetailsRefundsList = new ArrayList<OrderTransactionMonetaryDetailsRefunds>();

		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {

			if (o.getTransactionArray().getTransaction(i).getMonetaryDetails() != null) {

				if (o.getTransactionArray().getTransaction(i)
						.getMonetaryDetails().getRefunds() != null) {

					RefundInformationType refundInformationType = o
							.getTransactionArray().getTransaction(i)
							.getMonetaryDetails().getRefunds();

					for (int y = 0; y < refundInformationType.getRefundLength(); y++) {

						OrderTransactionMonetaryDetailsRefunds orderTransactionMonetaryDetailsRefunds = new OrderTransactionMonetaryDetailsRefunds();

						orderTransactionMonetaryDetailsRefunds.order_id = o
								.getOrderID();

						orderTransactionMonetaryDetailsRefunds.transaction_id = o
								.getTransactionArray().getTransaction()[i]
								.getTransactionID();

						orderTransactionMonetaryDetailsRefunds.user_id = shop
								.getUserId();

						orderTransactionMonetaryDetailsRefunds.shop_id = shop
								.getShopId();

						RefundTransactionInfoType refundTransactionInfoType = refundInformationType
								.getRefund()[y];

						if (refundTransactionInfoType.getRefundAmount() != null) {

							orderTransactionMonetaryDetailsRefunds.refund_refund_amount = refundTransactionInfoType
									.getRefundAmount().getValue();

							orderTransactionMonetaryDetailsRefunds.refund_amount_currency_id = refundTransactionInfoType
									.getRefundAmount().getCurrencyID()
									.toString();
						}

						if (refundTransactionInfoType.getFeeOrCreditAmount() != null) {

							orderTransactionMonetaryDetailsRefunds.refund_fee_or_credit_amount = refundTransactionInfoType
									.getFeeOrCreditAmount().getValue();

							orderTransactionMonetaryDetailsRefunds.refund_fee_or_credit_amount_currency_id = refundTransactionInfoType
									.getFeeOrCreditAmount().getCurrencyID()
									.toString();
						}

						if (refundTransactionInfoType.getReferenceID() != null) {

							orderTransactionMonetaryDetailsRefunds.refund_reference_id = refundTransactionInfoType
									.getReferenceID().getValue();

							orderTransactionMonetaryDetailsRefunds.refund_reference_id_attribute_type = refundTransactionInfoType
									.getReferenceID().getType().toString();
						}

						if (refundTransactionInfoType.getRefundStatus() != null) {

							orderTransactionMonetaryDetailsRefunds.refund_refund_status = refundTransactionInfoType
									.getRefundStatus().toString();
						}

						if (refundTransactionInfoType.getRefundTime() != null) {

							orderTransactionMonetaryDetailsRefunds.refund_refund_time = refundTransactionInfoType
									.getRefundTime().getTime();
						}

						if (refundTransactionInfoType.getRefundTo() != null) {

							orderTransactionMonetaryDetailsRefunds.refund_refund_to = refundTransactionInfoType
									.getRefundTo().getValue();

							orderTransactionMonetaryDetailsRefunds.refund_refund_to_attribute_type = refundTransactionInfoType
									.getRefundTo().getType().toString();
						}

						if (refundTransactionInfoType.getRefundType() != null) {

							orderTransactionMonetaryDetailsRefunds.refund_refund_type = refundTransactionInfoType
									.getRefundType().toString();
						}

						orderTransactionMonetaryDetailsRefundsList
								.add(orderTransactionMonetaryDetailsRefunds);
					}
				}
			}
		}

		return orderTransactionMonetaryDetailsRefundsList;
	}

	/*public void batchInsertorderTransactionMonetaryDetailsRefunds(
			OrderType[] oList, Shops shop) {
		List<OrderTransactionMonetaryDetailsRefunds> list = new ArrayList<OrderTransactionMonetaryDetailsRefunds>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionMonetaryDetailsRefunds> orderTransactionMonetaryDetailsRefundsList = HandleOrderTransactionMonetaryDetailsRefunds
						.returnOrderTransactionMonetaryDetailsRefunds(o, shop);
				for (int j = 0; j < orderTransactionMonetaryDetailsRefundsList
						.size(); j++) {
					list.add(orderTransactionMonetaryDetailsRefundsList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionMonetaryDetailsRefundsMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionMonetaryDetailsRefunds(OrderType[] oList,
			Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionMonetaryDetailsRefunds> orderTransactionMonetaryDetailsRefundsList = HandleOrderTransactionMonetaryDetailsRefunds
						.returnOrderTransactionMonetaryDetailsRefunds(o, shop);
				for (int j = 0; j < orderTransactionMonetaryDetailsRefundsList
						.size(); j++) {
					OrderTransactionMonetaryDetailsRefunds orderTransactionMonetaryDetailsRefunds = orderTransactionMonetaryDetailsRefundsList
							.get(j);
					orderTransactionMonetaryDetailsRefundsMapper
							.insert(orderTransactionMonetaryDetailsRefunds);
				}
			}

		}
	}*/
}
