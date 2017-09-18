package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionMapper;
import yk.boxri.pojo.OrderTransaction;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PickupMethodSelectedType;
import com.ebay.soap.eBLBaseComponents.TransactionType;

@Component("HandleOrderTransaction")
public class HandleOrderTransaction {

	public  List<OrderTransaction> returnOrderTransaction(OrderType o,
			ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {

		List<OrderTransaction> orderTransactionList = new ArrayList<OrderTransaction>();

		ObjectMapper mapper = new ObjectMapper();// jackson

		if (o.getTransactionArray() != null) {

			for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {

				OrderTransaction orderTransaction = new OrderTransaction();

				TransactionType transactionArrayType = o.getTransactionArray()
						.getTransaction()[i];

				orderTransaction.order_id = o.getOrderID();

				orderTransaction.user_id = shop.getUserId();

				orderTransaction.shop_id = shop.getShopId();

				if (transactionArrayType.getTransactionID() != null) {

					orderTransaction.transaction_id = transactionArrayType
							.getTransactionID();
				}

				if (transactionArrayType.getActualHandlingCost() != null) {

					orderTransaction.actual_handling_cost = transactionArrayType
							.getActualHandlingCost().getValue();

					orderTransaction.actual_handling_cost_currency_id = transactionArrayType
							.getActualHandlingCost().getCurrencyID().toString();
				}

				if (transactionArrayType.getActualShippingCost() != null) {

					orderTransaction.actual_shipping_cost = transactionArrayType
							.getActualShippingCost().getValue();

					orderTransaction.actual_shipping_cost_currency_id = transactionArrayType
							.getActualShippingCost().getCurrencyID().toString();
				}

					if (transactionArrayType.getBuyerPackageEnclosures() != null) {

						orderTransaction.buyer_package_enclosures = mapper
								.writeValueAsString(transactionArrayType
										.getBuyerPackageEnclosures());
					}

					if (transactionArrayType
							.getListingCheckoutRedirectPreference() != null) {

						orderTransaction.listing_checkout_redirect_preference = mapper
								.writeValueAsString(transactionArrayType
										.getListingCheckoutRedirectPreference());
					}
				
				if (transactionArrayType.getCreatedDate() != null) {

					orderTransaction.created_date = transactionArrayType
							.getCreatedDate().getTime();
				}
				if (transactionArrayType.getExtendedOrderID() != null) {

					orderTransaction.extended_order_id = transactionArrayType
							.getExtendedOrderID();
				}

				if (transactionArrayType.getFinalValueFee() != null) {

					orderTransaction.final_value_fee = transactionArrayType
							.getFinalValueFee().getValue();

					orderTransaction.final_value_fee_currency_id = transactionArrayType
							.getFinalValueFee().getCurrencyID().toString();
				}

				if (transactionArrayType.isGift() != null) {

					orderTransaction.gift = transactionArrayType.isGift();
				}

				if (transactionArrayType.getGiftSummary() != null) {

					orderTransaction.gift_summary_message = transactionArrayType
							.getGiftSummary().getMessage();
				}

				if (transactionArrayType.isGuaranteedShipping() != null) {

					orderTransaction.guaranteed_shipping = transactionArrayType
							.isGuaranteedShipping();
				}

				if (transactionArrayType.getInventoryReservationID() != null) {

					orderTransaction.inventory_reservation_id = transactionArrayType
							.getInventoryReservationID();
				}

				if (transactionArrayType.getInvoiceSentTime() != null) {

					orderTransaction.invoice_sent_time = transactionArrayType
							.getInvoiceSentTime().getTime();
				}

				if (transactionArrayType.getLogisticsPlanType() != null) {

					orderTransaction.logistics_plan_type = transactionArrayType
							.getLogisticsPlanType();
				}

				if (transactionArrayType.getOrderLineItemID() != null) {

					orderTransaction.order_line_item_id = transactionArrayType
							.getOrderLineItemID();
				}

				if (transactionArrayType.getUnpaidItem() != null) {

					orderTransaction.order_transaction_unpaid_item_status = transactionArrayType
							.getUnpaidItem().getStatus().toString();

					orderTransaction.order_transaction_unpaid_item_type = transactionArrayType
							.getUnpaidItem().getType().toString();

				}

				if (transactionArrayType.getPaidTime() != null) {

					orderTransaction.paid_time = transactionArrayType
							.getPaidTime().getTime();
				}

				if (transactionArrayType.getPickupMethodSelected() != null) {

					PickupMethodSelectedType pickupMethodSelectedType = transactionArrayType
							.getPickupMethodSelected();

					if (pickupMethodSelectedType.getMerchantPickupCode() != null) {

						orderTransaction.pickup_method_selected_merchant_pickup_code = pickupMethodSelectedType
								.getMerchantPickupCode();
					}

					if (pickupMethodSelectedType.getPickupFulfillmentTime() != null) {

						orderTransaction.pickup_method_selected_pickup_fulfillment_time = pickupMethodSelectedType
								.getPickupFulfillmentTime().getTime();
					}

					if (pickupMethodSelectedType.getPickupLocationUUID() != null) {

						orderTransaction.pickup_method_selected_pickup_location_UUID = pickupMethodSelectedType
								.getPickupLocationUUID();
					}

					if (pickupMethodSelectedType.getPickupMethod() != null) {

						orderTransaction.pickup_method_selected_pickup_method = pickupMethodSelectedType
								.getPickupMethod();
					}

					if (pickupMethodSelectedType.getPickupStatus() != null) {

						orderTransaction.pickup_method_selected_pickup_status = pickupMethodSelectedType
								.getPickupStatus().toString();
					}

					if (pickupMethodSelectedType.getPickupStoreID() != null) {

						orderTransaction.pickup_method_selected_pickup_store_id = pickupMethodSelectedType
								.getPickupStoreID();
					}

				}

				if (transactionArrayType.getQuantityPurchased() != null) {

					orderTransaction.quantity_purchased = transactionArrayType
							.getQuantityPurchased();
				}

				if (transactionArrayType.getShippedTime() != null) {

					orderTransaction.shipped_time = transactionArrayType
							.getShippedTime().getTime();
				}

				if (transactionArrayType.getShippingConvenienceCharge() != null) {

					orderTransaction.shipping_convenience_charge = transactionArrayType
							.getShippingConvenienceCharge().getValue();

					orderTransaction.shipping_convenience_charge_currency_id = transactionArrayType
							.getShippingConvenienceCharge().getCurrencyID()
							.toString();
				}

				if (transactionArrayType.getStatus() != null) {

					if (transactionArrayType.getStatus().getDigitalStatus() != null) {

						orderTransaction.status_digital_status = transactionArrayType
								.getStatus().getDigitalStatus().toString();
					}

					if (transactionArrayType.getStatus().getInquiryStatus() != null) {

						orderTransaction.status_inquiry_status = transactionArrayType
								.getStatus().getInquiryStatus().toString();
					}

					if (transactionArrayType.getStatus()
							.isIntegratedMerchantCreditCardEnabled() != null) {

						orderTransaction.status_integrated_merchant_credit_card_enabled = transactionArrayType
								.getStatus()
								.isIntegratedMerchantCreditCardEnabled();
					}

					if (transactionArrayType.getStatus().getPaymentHoldStatus() != null) {

						orderTransaction.status_payment_hold_status = transactionArrayType
								.getStatus().getPaymentHoldStatus().toString();
					}

					if (transactionArrayType.getStatus().getPaymentInstrument() != null) {

						orderTransaction.status_payment_instrument = transactionArrayType
								.getStatus().getPaymentInstrument().toString();
					}

					if (transactionArrayType.getStatus().getReturnStatus() != null) {

						orderTransaction.status_return_status = transactionArrayType
								.getStatus().getReturnStatus().toString();
					}

				}

				if (transactionArrayType.getTransactionPrice() != null) {

					orderTransaction.transaction_price = transactionArrayType
							.getTransactionPrice().getValue();

					orderTransaction.transaction_price_currency_id = transactionArrayType
							.getTransactionPrice().getCurrencyID().toString();

				}

				if (transactionArrayType.getTransactionSiteID() != null) {

					orderTransaction.transaction_site_id = transactionArrayType
							.getTransactionSiteID().toString();
				}

				if (transactionArrayType.getUnpaidItem() != null) {

					if (transactionArrayType.getUnpaidItem().getStatus() != null) {

						orderTransaction.unpaid_item_status = transactionArrayType
								.getUnpaidItem().getStatus().toString();
					}

					if (transactionArrayType.getUnpaidItem().getType() != null) {
						orderTransaction.unpaiditem_type = transactionArrayType
								.getUnpaidItem().getType().toString();
					}
				}

				orderTransactionList.add(orderTransaction);
			}

		}
		return orderTransactionList;
	}

	/*public void batchInsertorderTransaction(OrderType[] oList, Shops shop) {
		List<OrderTransaction> list = new ArrayList<OrderTransaction>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransaction> orderTransactionList = HandleOrderTransaction
						.returnOrderTransaction(o, shop);
				for (int j = 0; j < orderTransactionList.size(); j++) {
					list.add(orderTransactionList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransaction(OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransaction> orderTransactionList = HandleOrderTransaction
						.returnOrderTransaction(o, shop);
				for (int j = 0; j < orderTransactionList.size(); j++) {
					OrderTransaction orderTransaction = orderTransactionList
							.get(j);
					orderTransactionMapper.insert(orderTransaction);
				}
			}

		}
	}*/
}
