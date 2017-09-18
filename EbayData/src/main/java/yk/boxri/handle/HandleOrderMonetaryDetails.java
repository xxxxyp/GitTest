
package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderMonetaryDetailsPaymentsMapper;
import yk.boxri.dao.OrderMonetaryDetailsRefundsMapper;
import yk.boxri.pojo.OrderMonetaryDetailsPayments;
import yk.boxri.pojo.OrderMonetaryDetailsRefunds;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PaymentTransactionType;
import com.ebay.soap.eBLBaseComponents.RefundTransactionInfoType;

@Component("HandleOrderMonetaryDetails")
public class HandleOrderMonetaryDetails {
	
	public  List<OrderMonetaryDetailsPayments> returnOrderMonetaryDetailsPayments(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();// jackson
		
		List<OrderMonetaryDetailsPayments> orderMonetaryDetailsPaymentsList = new ArrayList<OrderMonetaryDetailsPayments>();
		
		if (o.getMonetaryDetails() != null) {
			
			if (o.getMonetaryDetails().getPayments() != null) {
				
				if (o.getMonetaryDetails().getPayments().getPaymentLength() != 0) {
					
					for (int i = 0; i < o.getMonetaryDetails().getPayments()
							.getPaymentLength(); i++) {
						
						OrderMonetaryDetailsPayments orderMonetaryDetailsPayments = new OrderMonetaryDetailsPayments();
						
						PaymentTransactionType paymentTransactionType = o
								.getMonetaryDetails().getPayments()
								.getPayment()[i];
						
						orderMonetaryDetailsPayments.order_id = o.getOrderID();
						
						orderMonetaryDetailsPayments.user_id = shop
								.getUserId();
						
						
						orderMonetaryDetailsPayments.shop_id = shop
								.getShopId();
						
						if (paymentTransactionType.getFeeOrCreditAmount() != null) {
							
							orderMonetaryDetailsPayments.fee_or_credit_amount = paymentTransactionType
									.getFeeOrCreditAmount().getValue();
							
							orderMonetaryDetailsPayments.fee_or_credit_amount_currency_id = paymentTransactionType
									.getFeeOrCreditAmount().getCurrencyID()
									.toString();
						}
						
						if (paymentTransactionType.getPayee() != null) {
							
							orderMonetaryDetailsPayments.payee = paymentTransactionType
									.getPayee().getValue();
							
							orderMonetaryDetailsPayments.payee_attribute_type = paymentTransactionType
									.getPayee().getType().toString();
						}
						
						if (paymentTransactionType.getPayer() != null) {
							
							orderMonetaryDetailsPayments.payer = paymentTransactionType
									.getPayer().getValue();
							
							orderMonetaryDetailsPayments.payer_attribute_type = paymentTransactionType
									.getPayer().getType().toString();
						}
						
						if (paymentTransactionType.getPaymentAmount() != null) {
							
							orderMonetaryDetailsPayments.payment_amount = paymentTransactionType
									.getPaymentAmount().getValue();
							
							orderMonetaryDetailsPayments.payment_amount_currency_id = paymentTransactionType
									.getPaymentAmount().getCurrencyID()
									.toString();
							
						}
						
						if (paymentTransactionType.getPaymentReferenceID() != null) {
							
							orderMonetaryDetailsPayments.payment_reference_id_values = mapper
									.writeValueAsString(paymentTransactionType
											.getPaymentReferenceID());
						}
						
						if (paymentTransactionType.getPaymentStatus() != null) {
							
							orderMonetaryDetailsPayments.payment_status = paymentTransactionType
									.getPaymentStatus().toString();
						}
						
						if (paymentTransactionType.getPaymentTime() != null) {
							
							orderMonetaryDetailsPayments.payment_time = paymentTransactionType
									.getPaymentTime().getTime();
						}
						
						if (paymentTransactionType.getReferenceID() != null) {
							
							orderMonetaryDetailsPayments.reference_id = paymentTransactionType
									.getReferenceID().getValue();
							
							orderMonetaryDetailsPayments.reference_id_attribute_type = paymentTransactionType
									.getReferenceID().getType().toString();
						}
						
						orderMonetaryDetailsPaymentsList
						.add(orderMonetaryDetailsPayments);
					}
				}
			}
		}
		
		return orderMonetaryDetailsPaymentsList;
	}
	
	
	
	public  List<OrderMonetaryDetailsRefunds> returnOrderMonetaryDetailsRefunds(
			OrderType o, ShopToken shop) {
		
		List<OrderMonetaryDetailsRefunds> orderMonetaryDetailsRefundsList = new ArrayList<OrderMonetaryDetailsRefunds>();
		
		if (o.getMonetaryDetails() != null) {
			
			if (o.getMonetaryDetails().getRefunds() != null) {
				
				for (int i = 0; i < o.getMonetaryDetails().getRefunds()
						.getRefundLength(); i++) {
					
					OrderMonetaryDetailsRefunds orderMonetaryDetailsRefunds = new OrderMonetaryDetailsRefunds();
					
					RefundTransactionInfoType refundTransactionInfoType = o
							.getMonetaryDetails().getRefunds().getRefund()[i];
					
					orderMonetaryDetailsRefunds.order_id = o.getOrderID();
					
					orderMonetaryDetailsRefunds.user_id = shop.getUserId();
					
					orderMonetaryDetailsRefunds.shop_id = shop.getShopId();
					
					if (refundTransactionInfoType.getFeeOrCreditAmount() != null) {
						
						orderMonetaryDetailsRefunds.refund_fee_or_credit_amount = refundTransactionInfoType
								.getFeeOrCreditAmount().getValue();
						
						orderMonetaryDetailsRefunds.refund_fee_or_credit_amount_currency_id = refundTransactionInfoType
								.getFeeOrCreditAmount().getCurrencyID()
								.toString();
					}
					
					if (refundTransactionInfoType.getReferenceID() != null) {
						
						orderMonetaryDetailsRefunds.refund_reference_id = refundTransactionInfoType
								.getReferenceID().getValue();
						
						orderMonetaryDetailsRefunds.refund_reference_id_attribute_type = refundTransactionInfoType
								.getReferenceID().getType().toString();
					}
					
					if (refundTransactionInfoType.getRefundAmount() != null) {
						
						orderMonetaryDetailsRefunds.refund_refund_amount = refundTransactionInfoType
								.getRefundAmount().getValue();
						
						orderMonetaryDetailsRefunds.refund_amount_currency_id = refundTransactionInfoType
								.getRefundAmount().getCurrencyID().toString();
						
					}
					
					if (refundTransactionInfoType.getRefundStatus() != null) {
						
						orderMonetaryDetailsRefunds.refund_refund_status = refundTransactionInfoType
								.getRefundStatus().toString();
					}
					
					if (refundTransactionInfoType.getRefundTime() != null) {
						
						orderMonetaryDetailsRefunds.refund_refund_time = refundTransactionInfoType
								.getRefundTime().getTime();
					}
					
					if (refundTransactionInfoType.getRefundTo() != null) {
						
						orderMonetaryDetailsRefunds.refund_refund_to = refundTransactionInfoType
								.getRefundTo().getValue();
					}
					
					if (refundTransactionInfoType.getRefundType() != null) {
						
						orderMonetaryDetailsRefunds.refund_refund_to_attribute_type = refundTransactionInfoType
								.getRefundTo().getType().toString();
						
					}
					
					if (refundTransactionInfoType.getRefundType() != null) {
						
						orderMonetaryDetailsRefunds.refund_refund_type = refundTransactionInfoType
								.getRefundType().toString();
					}
					
					orderMonetaryDetailsRefundsList
					.add(orderMonetaryDetailsRefunds);
					
				}
			}
		}
		
		return orderMonetaryDetailsRefundsList;
		
	}
}