package yk.boxri.handle;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderInfoMapper;
import yk.boxri.pojo.OrderInfo;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.CheckoutStatusType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PickupMethodSelectedType;

@Component("HandleOrderInfo")
public class HandleOrderInfo {

	public  OrderInfo returnOrderInfo(OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();// jackson

		OrderInfo orderInfo = new OrderInfo();

		orderInfo.order_id = o.getOrderID();

		orderInfo.user_id = shop.getUserId();

		orderInfo.shop_id = shop.getShopId();

		if (o.getBuyerUserID() != null) {

			orderInfo.buyer_user_id = o.getBuyerUserID();
		}

		if (o.getOrderStatus() != null) {

			orderInfo.order_status = o.getOrderStatus().toString();
		}

		if (o.getPaidTime() != null) {

			orderInfo.paid_time = o.getPaidTime().getTime();
		}

		if (o.getPaymentHoldStatus() != null) {

			orderInfo.payment_hold_status = o.getPaymentHoldStatus().toString();
		}

		if (o.getPaymentMethods() != null) {
				orderInfo.payment_methods = mapper.writeValueAsString(o
						.getPaymentMethods());
		}

		try {

			if (o.getBuyerTaxIdentifier() != null) {

				orderInfo.buyer_tax_identifier = mapper.writeValueAsString(o
						.getBuyerTaxIdentifier());
			}

			if (o.getBuyerPackageEnclosures() != null) {

				orderInfo.buyer_package_enclosures = mapper
						.writeValueAsString(o.getBuyerPackageEnclosures());
			}

		} catch (JsonGenerationException e) {
			e.printStackTrace();

		} catch (JsonMappingException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
		if (o.getCreatedTime() != null) {

			orderInfo.createing_time = o.getCreatedTime().getTime();
		}

		if (o.getExtendedOrderID() != null) {

			orderInfo.extended_order_id = o.getExtendedOrderID();
		}

		if (o.getCreatingUserRole() != null) {

			orderInfo.creating_user_role = o.getCreatingUserRole().toString();
		}

		if (o.getCheckoutStatus() != null) {

			CheckoutStatusType checkoutStatusType = o.getCheckoutStatus();

			if (checkoutStatusType.getEBayPaymentStatus() != null) {

				orderInfo.checkout_status_ebay_payment_status = checkoutStatusType
						.getEBayPaymentStatus().toString();
			}

			if (checkoutStatusType.isIntegratedMerchantCreditCardEnabled() != null) {

				orderInfo.checkout_status_integrated_merchant_credit_card_enabled = checkoutStatusType
						.isIntegratedMerchantCreditCardEnabled();
			}

			if (checkoutStatusType.getLastModifiedTime() != null) {

				orderInfo.checkout_status_last_modified_time = checkoutStatusType
						.getLastModifiedTime().getTime();
			}

			if (checkoutStatusType.getPaymentInstrument() != null) {

				orderInfo.checkout_status_payment_instrument = checkoutStatusType
						.getPaymentInstrument().toString();
			}

			if (checkoutStatusType.getPaymentMethod() != null) {

				orderInfo.checkout_status_payment_methods = checkoutStatusType
						.getPaymentMethod().toString();
			}

			if (checkoutStatusType.getStatus() != null) {

				orderInfo.checkout_status_status = checkoutStatusType
						.getStatus().toString();
			}

		}

		if (o.getPickupMethodSelected() != null) {

			PickupMethodSelectedType pickupMethodSelectedType = o
					.getPickupMethodSelected();

			if (pickupMethodSelectedType.getMerchantPickupCode() != null) {

				orderInfo.pickup_method_selected_merchant_pickup_code = pickupMethodSelectedType
						.getMerchantPickupCode();
			}

			if (pickupMethodSelectedType.getPickupFulfillmentTime() != null) {

				orderInfo.pickup_method_selected_pickup_fulfillment_time = pickupMethodSelectedType
						.getPickupFulfillmentTime().getTime();
			}

			if (pickupMethodSelectedType.getPickupLocationUUID() != null) {

				orderInfo.pickup_method_selected_pickup_location_UUID = pickupMethodSelectedType
						.getPickupLocationUUID();
			}

			if (pickupMethodSelectedType.getPickupMethod() != null) {

				orderInfo.pickup_method_selected_pickup_method = pickupMethodSelectedType
						.getPickupMethod();
			}

			if (pickupMethodSelectedType.getPickupStatus() != null) {

				orderInfo.pickup_method_selected_pickup_status = pickupMethodSelectedType
						.getPickupStatus().toString();
			}

			if (pickupMethodSelectedType.getPickupStoreID() != null) {

				orderInfo.pickup_method_selected_pickup_store_id = pickupMethodSelectedType
						.getPickupStoreID();
			}
		}

		if (o.getSellerEmail() != null) {

			orderInfo.seller_email = o.getSellerEmail();
		}

		if (o.getSellerUserID() != null) {

			orderInfo.seller_user_id = o.getSellerUserID();
		}

		if (o.getShippedTime() != null) {

			orderInfo.shipped_time = o.getShippedTime().getTime();
		}

		if (o.getSubtotal() != null) {

			orderInfo.subtotal = o.getSubtotal().getValue();

			orderInfo.subtoal_currency_id = o.getSubtotal().getCurrencyID()
					.toString();
		}

		if (o.getEIASToken() != null) {

			orderInfo.EIAS_token = o.getEIASToken();
		}

		if (o.getSellerEIASToken() != null) {

			orderInfo.order_seller_EIAS_token = o.getSellerEIASToken();
		}

		if (o.getShippingConvenienceCharge() != null) {

			orderInfo.shipping_convenience_charge = o
					.getShippingConvenienceCharge().getValue();

			orderInfo.shipping_convenience_charge_currency_id = o
					.getShippingConvenienceCharge().getCurrencyID().toString();
		}

		if (o.isIsMultiLegShipping() != null) {

			orderInfo.is_multiLeg_shipping = o.isIsMultiLegShipping();
		}

		if (o.getLogisticsPlanType() != null) {

			orderInfo.logistics_plan_type = o.getLogisticsPlanType();
		}

		if (o.isIntegratedMerchantCreditCardEnabled() != null) {

			orderInfo.integrated_merchant_credit_card_enabled = o
					.isIntegratedMerchantCreditCardEnabled();
		}

		if (o.getAdjustmentAmount() != null) {

			orderInfo.adjustment_amount = o.getAdjustmentAmount().getValue();

			orderInfo.adjustment_amount_currency_id = o.getAdjustmentAmount()
					.getCurrencyID().toString();

		}

		if (o.getAmountPaid() != null) {

			orderInfo.amount_paid = o.getAmountPaid().getValue();

			orderInfo.amount_paid_currency_id = o.getAmountPaid()
					.getCurrencyID().toString();

		}

		if (o.getAmountSaved() != null) {

			orderInfo.amount_saved = o.getAmountSaved().getValue();

			orderInfo.amount_saved_currency_id = o.getAmountSaved()
					.getCurrencyID().toString();

		}

		if (o.getBuyerCheckoutMessage() != null) {

			orderInfo.buyer_checkout_message = o.getBuyerCheckoutMessage();
		}

		if (o.getCancelStatus() != null) {

			orderInfo.cancel_status = o.getCancelStatus().toString();
		}

		if (o.getCancelReason() != null) {

			orderInfo.cancel_reason = o.getCancelReason();
		}

		if (o.getCancelReasonDetails() != null) {

			orderInfo.cancal_reason_details = o.getCancelReasonDetails();
		}

		if (o.isContainseBayPlusTransaction() != null) {

			orderInfo.containseBay_plus_transaction = o
					.isContainseBayPlusTransaction();
		}

		return orderInfo;
	}

	/*public void batchInsert(OrderType[] oList, Shops shop) {
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				OrderInfo orderInfo = HandleOrderInfo.returnOrderInfo(o, shop);
				if (orderInfo != null) {
					list.add(orderInfo);
				}
			}
			if (list.size() != 0) {
				orderInfoMapper.insertBatch(list);
			}
		}
	}

	public void insert(OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				OrderInfo orderInfo = HandleOrderInfo.returnOrderInfo(o, shop);
				orderInfoMapper.insert(orderInfo);
			}

		}
	}*/

}