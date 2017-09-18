package yk.boxri.handle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionExternalTransactionMapper;
import yk.boxri.pojo.OrderTransactionExternalTransaction;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.ExternalTransactionType;
import com.ebay.soap.eBLBaseComponents.OrderType;

@Component("HandleOrderTransactionExternalTransaction")
public class HandleOrderTransactionExternalTransaction {

	public  List<OrderTransactionExternalTransaction> returnOrderTransactionExternalTransaction(
			OrderType o, ShopToken shop) {

		List<OrderTransactionExternalTransaction> orderTransactionExternalTransactionList = new ArrayList<OrderTransactionExternalTransaction>();

		if (o.getTransactionArray() != null) {

			for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {

				if (o.getTransactionArray().getTransaction(i)
						.getExternalTransaction() != null) {

					ExternalTransactionType[] externalTransactionType = o
							.getTransactionArray().getTransaction(i)
							.getExternalTransaction();

					if (externalTransactionType.length != 0) {
						for (int y = 0; y < externalTransactionType.length; y++) {

							OrderTransactionExternalTransaction orderTransactionExternalTransaction = new OrderTransactionExternalTransaction();

							orderTransactionExternalTransaction.transaction_id = o
									.getTransactionArray().getTransaction(i)
									.getTransactionID();

							orderTransactionExternalTransaction.order_id = o
									.getOrderID();

							orderTransactionExternalTransaction.user_id = shop
									.getUserId();

							orderTransactionExternalTransaction.shop_id = shop
									.getShopId();

							if (externalTransactionType[y]
									.getExternalTransactionID() != null) {

								orderTransactionExternalTransaction.external_transaction_id = externalTransactionType[y]
										.getExternalTransactionID();
							}

							if (externalTransactionType[y]
									.getExternalTransactionStatus() != null) {

								orderTransactionExternalTransaction.external_transaction_status = externalTransactionType[y]
										.getExternalTransactionStatus()
										.toString();
							}

							if (externalTransactionType[y]
									.getExternalTransactionTime() != null) {

								orderTransactionExternalTransaction.external_transaction_time = externalTransactionType[y]
										.getExternalTransactionTime().getTime();
							}

							if (externalTransactionType[y]
									.getFeeOrCreditAmount() != null) {

								orderTransactionExternalTransaction.fee_or_credit_amount = externalTransactionType[y]
										.getFeeOrCreditAmount().getValue();

								orderTransactionExternalTransaction.fee_or_credit_amount_currency_id = externalTransactionType[y]
										.getFeeOrCreditAmount().getCurrencyID()
										.toString();
							}

							if (externalTransactionType[y]
									.getPaymentOrRefundAmount() != null) {

								orderTransactionExternalTransaction.payment_or_refund_amount = externalTransactionType[y]
										.getPaymentOrRefundAmount().getValue();

								orderTransactionExternalTransaction.payment_or_refund_amount_currency_id = externalTransactionType[y]
										.getPaymentOrRefundAmount()
										.getCurrencyID().toString();
							}

							orderTransactionExternalTransactionList
									.add(orderTransactionExternalTransaction);
						}
					}

				}
			}
		}

		return orderTransactionExternalTransactionList;
	}

	/*public void batchInsertorderTransactionExternalTransaction(
			OrderType[] oList, Shops shop) {
		List<OrderTransactionExternalTransaction> list = new ArrayList<OrderTransactionExternalTransaction>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionExternalTransaction> orderTransactionExternalTransactionList = HandleOrderTransactionExternalTransaction
						.returnOrderTransactionExternalTransaction(o, shop);
				for (int j = 0; j < orderTransactionExternalTransactionList
						.size(); j++) {
					list.add(orderTransactionExternalTransactionList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionExternalTransactionMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionExternalTransaction(OrderType[] oList,
			Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionExternalTransaction> orderTransactionExternalTransactionList = HandleOrderTransactionExternalTransaction
						.returnOrderTransactionExternalTransaction(o, shop);
				for (int j = 0; j < orderTransactionExternalTransactionList
						.size(); j++) {
					OrderTransactionExternalTransaction orderTransactionExternalTransaction = orderTransactionExternalTransactionList
							.get(j);
					orderTransactionExternalTransactionMapper
							.insert(orderTransactionExternalTransaction);
				}
			}

		}
	}*/
}
