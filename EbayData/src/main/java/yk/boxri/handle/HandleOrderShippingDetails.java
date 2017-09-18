package yk.boxri.handle;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderShippingDetailsMapper;
import yk.boxri.pojo.OrderShippingDetails;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.CalculatedShippingRateType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.SalesTaxType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;

@Component("HandleOrderShippingDetails")
public class HandleOrderShippingDetails {

	public  OrderShippingDetails returnOrderShippingDetails(OrderType o,
			ShopToken shop) {

		OrderShippingDetails orderShippingDetails = null;

		if (o.getShippingDetails() != null) {

			orderShippingDetails = new OrderShippingDetails();

			ShippingDetailsType shippingDetailsType = o.getShippingDetails();

			orderShippingDetails.order_id = o.getOrderID();

			orderShippingDetails.user_id = shop.getUserId();
 
			orderShippingDetails.shop_id = shop.getShopId();

			if (o.getShippingDetails().isInsuranceWanted() != null) {

				orderShippingDetails.insurance_wanted = o.getShippingDetails()
						.isInsuranceWanted();
			}

			if (o.getShippingDetails().getCalculatedShippingRate() != null) {

				CalculatedShippingRateType calculatedShippingRateType = o
						.getShippingDetails().getCalculatedShippingRate();

				if (calculatedShippingRateType
						.getInternationalPackagingHandlingCosts() != null) {

					AmountType amountType = calculatedShippingRateType
							.getInternationalPackagingHandlingCosts();

					orderShippingDetails.international_packaging_handling_costs = amountType
							.getValue();

					orderShippingDetails.international_packaging_handling_costs_currency_id = amountType
							.getCurrencyID().toString();
				}

				if (calculatedShippingRateType.getOriginatingPostalCode() != null) {

					orderShippingDetails.originating_postal_code = calculatedShippingRateType
							.getOriginatingPostalCode();
				}

				if (calculatedShippingRateType
						.getInternationalPackagingHandlingCosts() != null) {

					AmountType amountType_handling = calculatedShippingRateType
							.getInternationalPackagingHandlingCosts();

					orderShippingDetails.packaging_handling_costs = amountType_handling
							.getValue();

					orderShippingDetails.packaging_handling_costs_currency_id = amountType_handling
							.getCurrencyID().toString();
				}

				if (calculatedShippingRateType.isShippingIrregular() != null) {

					orderShippingDetails.shipping_irregular = calculatedShippingRateType
							.isShippingIrregular();
				}

				if (shippingDetailsType.getCODCost() != null) {

					orderShippingDetails.COD_cost = shippingDetailsType
							.getCODCost().getValue();

					orderShippingDetails.COD_cost_currency_id = shippingDetailsType
							.getCODCost().getCurrencyID().toString();
				}

				if (shippingDetailsType.getSalesTax() != null) {

					SalesTaxType salesTaxType = shippingDetailsType
							.getSalesTax();

					if (salesTaxType.getSalesTaxAmount() != null) {

						orderShippingDetails.sales_tax_amount = salesTaxType
								.getSalesTaxAmount().getValue();

						orderShippingDetails.sales_tax_amount_currency_id = salesTaxType
								.getSalesTaxAmount().getCurrencyID().toString();
					}
					if (salesTaxType.getSalesTaxPercent() != null) {

						orderShippingDetails.sales_tax_percent = salesTaxType
								.getSalesTaxPercent();
					}

					if (salesTaxType.getSalesTaxState() != null) {

						orderShippingDetails.sales_tax_state = salesTaxType
								.getSalesTaxState();
					}

					if (salesTaxType.isShippingIncludedInTax() != null) {

						orderShippingDetails.shipping_included_in_tax = salesTaxType
								.isShippingIncludedInTax();
					}

				}

				if (shippingDetailsType.getSellingManagerSalesRecordNumber() != null) {

					orderShippingDetails.selling_manager_sales_record_number = shippingDetailsType
							.getSellingManagerSalesRecordNumber();

				}
			}

		}

		return orderShippingDetails;
	}

	/*public void batchInsert(OrderType[] oList, Shops shop) {
		List<OrderShippingDetails> list = new ArrayList<OrderShippingDetails>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				OrderShippingDetails orderShippingDetails = HandleOrderShippingDetails
						.returnOrderShippingDetails(o, shop);
				if (orderShippingDetails != null) {
					list.add(orderShippingDetails);
				}
			}
			if (list.size() != 0) {
				orderShippingDetailsMapper.insertBatch(list);
			}
		}
	}

	public void insert(OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				OrderShippingDetails orderShippingDetails = HandleOrderShippingDetails
						.returnOrderShippingDetails(o, shop);
				orderShippingDetailsMapper.insert(orderShippingDetails);
			}

		}
	}*/
}
