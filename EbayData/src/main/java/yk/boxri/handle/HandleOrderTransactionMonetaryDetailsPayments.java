package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionMonetaryDetailsPaymentsMapper;
import yk.boxri.pojo.OrderTransactionMonetaryDetailsPayments;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PaymentInformationType;
import com.ebay.soap.eBLBaseComponents.PaymentTransactionType;

@Component("HandleOrderTransactionMonetaryDetailsPayments")
public class HandleOrderTransactionMonetaryDetailsPayments {

	public  List<OrderTransactionMonetaryDetailsPayments> returnOrderTransactionMonetaryDetailsPayments(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {

		List<OrderTransactionMonetaryDetailsPayments> orderTransactionMonetaryDetailsPaymentsList = new ArrayList<OrderTransactionMonetaryDetailsPayments>();

		ObjectMapper mapper = new ObjectMapper();// jackson

		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {

			if (o.getTransactionArray().getTransaction(i).getMonetaryDetails() != null) {

				if (o.getTransactionArray().getTransaction(i)
						.getMonetaryDetails().getPayments() != null) {

					PaymentInformationType paymentInformationType = o
							.getTransactionArray().getTransaction(i)
							.getMonetaryDetails().getPayments();

					for (int y = 0; y < paymentInformationType
							.getPaymentLength(); y++) {

						PaymentTransactionType paymentTransactionType = paymentInformationType
								.getPayment()[y];

						OrderTransactionMonetaryDetailsPayments orderTransactionMonetaryDetailsPayments = new OrderTransactionMonetaryDetailsPayments();

						orderTransactionMonetaryDetailsPayments.order_id = o
								.getOrderID();

						orderTransactionMonetaryDetailsPayments.user_id = shop
								.getUserId();

						orderTransactionMonetaryDetailsPayments.shop_id = shop
								.getShopId();

						if (paymentTransactionType.getFeeOrCreditAmount() != null) {

							orderTransactionMonetaryDetailsPayments.fee_or_credit_amount = paymentTransactionType
									.getFeeOrCreditAmount().getValue();

							orderTransactionMonetaryDetailsPayments.fee_or_credit_amount_currency_id = paymentTransactionType
									.getFeeOrCreditAmount().getCurrencyID()
									.toString();
						}

						if (paymentTransactionType.getPayee() != null) {

							orderTransactionMonetaryDetailsPayments.payee = paymentTransactionType
									.getPayee().getValue();

							orderTransactionMonetaryDetailsPayments.payee_attribute_type = paymentTransactionType
									.getPayee().getType().toString();
						}

						if (paymentTransactionType.getPayer() != null) {

							orderTransactionMonetaryDetailsPayments.payer = paymentTransactionType
									.getPayer().getValue();

							orderTransactionMonetaryDetailsPayments.payer = paymentTransactionType
									.getPayer().getType().toString();
						}

						if (paymentTransactionType.getPaymentAmount() != null) {

							orderTransactionMonetaryDetailsPayments.payment_amount = paymentTransactionType
									.getPaymentAmount().getValue();

							orderTransactionMonetaryDetailsPayments.payment_amount_currency_id = paymentTransactionType
									.getPaymentAmount().getCurrencyID()
									.toString();
						}

							if (paymentTransactionType.getPaymentReferenceID() != null) {

								orderTransactionMonetaryDetailsPayments.payment_reference_id_values = mapper
										.writeValueAsString(paymentTransactionType
												.getPaymentReferenceID());
							}


						if (paymentTransactionType.getPaymentStatus() != null) {

							orderTransactionMonetaryDetailsPayments.payment_status = paymentTransactionType
									.getPaymentStatus().toString();
						}

						if (paymentTransactionType.getPaymentTime() != null) {

							orderTransactionMonetaryDetailsPayments.payment_time = paymentTransactionType
									.getPaymentTime().getTime();
						}

						if (paymentTransactionType.getReferenceID() != null) {

							orderTransactionMonetaryDetailsPayments.reference_id = paymentTransactionType
									.getReferenceID().getValue();

							orderTransactionMonetaryDetailsPayments.reference_id_attribute_type = paymentTransactionType
									.getReferenceID().getType().toString();
						}

						orderTransactionMonetaryDetailsPaymentsList
								.add(orderTransactionMonetaryDetailsPayments);
					}
				}
			}

		}
		return orderTransactionMonetaryDetailsPaymentsList;
	}

	/*public void batchInsertorderTransactionMonetaryDetailsPayments(
			OrderType[] oList, Shops shop) {
		List<OrderTransactionMonetaryDetailsPayments> list = new ArrayList<OrderTransactionMonetaryDetailsPayments>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionMonetaryDetailsPayments> orderTransactionMonetaryDetailsPaymentsList = HandleOrderTransactionMonetaryDetailsPayments
						.returnOrderTransactionMonetaryDetailsPayments(o, shop);
				for (int j = 0; j < orderTransactionMonetaryDetailsPaymentsList
						.size(); j++) {
					list.add(orderTransactionMonetaryDetailsPaymentsList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionMonetaryDetailsPaymentsMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionMonetaryDetailsPayments(
			OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionMonetaryDetailsPayments> orderTransactionMonetaryDetailsPaymentsList = HandleOrderTransactionMonetaryDetailsPayments
						.returnOrderTransactionMonetaryDetailsPayments(o, shop);
				for (int j = 0; j < orderTransactionMonetaryDetailsPaymentsList
						.size(); j++) {
					OrderTransactionMonetaryDetailsPayments orderTransactionMonetaryDetailsPayments = orderTransactionMonetaryDetailsPaymentsList
							.get(j);
					orderTransactionMonetaryDetailsPaymentsMapper
							.insert(orderTransactionMonetaryDetailsPayments);
				}
			}

		}
	}*/
}
