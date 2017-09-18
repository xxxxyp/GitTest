
package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionShippingDetailsMapper;
import yk.boxri.pojo.OrderTransactionShippingDetails;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.CalculatedShippingRateType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.SalesTaxType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;

@Component("HandleOrderTransactionShippingDetails")
public class HandleOrderTransactionShippingDetails {
	
	public  List<OrderTransactionShippingDetails> returnOrderTransactionShippingDetails(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();// jackson
		
		List<OrderTransactionShippingDetails> orderTransactionShippingDetailsList = new ArrayList<OrderTransactionShippingDetails>();
		
		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {
			
			OrderTransactionShippingDetails orderTransactionShippingDetails = new OrderTransactionShippingDetails();
			
			if (o.getTransactionArray().getTransaction(i).getShippingDetails() != null) {
				
				ShippingDetailsType shippingDetailsType = o
						.getTransactionArray().getTransaction(i)
						.getShippingDetails();
				
				orderTransactionShippingDetails.transaction_id = o
						.getTransactionArray().getTransaction()[i]
								.getTransactionID();
				
				orderTransactionShippingDetails.order_id = o.getOrderID();
				
				orderTransactionShippingDetails.user_id = shop.getUserId();
				
				orderTransactionShippingDetails.shop_id = shop.getShopId();
				
				if (shippingDetailsType.getCODCost() != null) {
					
					orderTransactionShippingDetails.COD_cost = shippingDetailsType
							.getCODCost().getValue();
					
					orderTransactionShippingDetails.COD_cost_currency_id = shippingDetailsType
							.getCODCost().getCurrencyID().toString();
				}
				
				if (shippingDetailsType.isInsuranceWanted() != null) {
					
					orderTransactionShippingDetails.insurance_wanted = shippingDetailsType
							.isInsuranceWanted();
				}
				
				if (shippingDetailsType.getSellingManagerSalesRecordNumber() != null) {
					
					orderTransactionShippingDetails.selling_manager_sales_record_number = shippingDetailsType
							.getSellingManagerSalesRecordNumber();
				}
				
				if (shippingDetailsType.getCalculatedShippingRate() != null) {
					
					CalculatedShippingRateType calculatedShippingRateType = shippingDetailsType
							.getCalculatedShippingRate();
					
					if (calculatedShippingRateType
							.getInternationalPackagingHandlingCosts() != null) {
						
						orderTransactionShippingDetails.international_packaging_handling_costs_currency_id = calculatedShippingRateType
								.getInternationalPackagingHandlingCosts()
								.getCurrencyID().toString();
						
						orderTransactionShippingDetails.international_packaging_handling_costs = calculatedShippingRateType
								.getInternationalPackagingHandlingCosts()
								.getValue();
						
					}
					
					if (calculatedShippingRateType.getOriginatingPostalCode() != null) {
						
						orderTransactionShippingDetails.originating_postal_code = calculatedShippingRateType
								.getOriginatingPostalCode();
					}
					
					if (calculatedShippingRateType.getPackagingHandlingCosts() != null) {
						
						orderTransactionShippingDetails.packaging_handling_costs = calculatedShippingRateType
								.getPackagingHandlingCosts().getValue();
						
						orderTransactionShippingDetails.packaging_handling_costs_currency_id = calculatedShippingRateType
								.getPackagingHandlingCosts().getCurrencyID()
								.toString();
					}
					
					if (calculatedShippingRateType.isShippingIrregular() != null) {
						
						orderTransactionShippingDetails.shipping_irregular = calculatedShippingRateType
								.isShippingIrregular();
					}
				}
				
				if (shippingDetailsType.getSalesTax() != null) {
					
					SalesTaxType salesTaxType = shippingDetailsType
							.getSalesTax();
					
					if (salesTaxType.getSalesTaxAmount() != null) {
						
						orderTransactionShippingDetails.sales_tax_amount = salesTaxType
								.getSalesTaxAmount().getValue();
						
						orderTransactionShippingDetails.sales_tax_amount_currency_id = salesTaxType
								.getSalesTaxAmount().getCurrencyID().toString();
					}
					
					if (salesTaxType.getSalesTaxPercent() != null) {
						
						orderTransactionShippingDetails.sales_tax_percent = salesTaxType
								.getSalesTaxPercent();
					}
					
					if (salesTaxType.getSalesTaxState() != null) {
						
						orderTransactionShippingDetails.sales_tax_state = salesTaxType
								.getSalesTaxState();
					}
					
					if (salesTaxType.isShippingIncludedInTax() != null) {
						
						orderTransactionShippingDetails.shipping_included_in_tax = salesTaxType
								.isShippingIncludedInTax();
					}
					
				}
				
				if (shippingDetailsType.getTaxTable() != null) {
					
					if (shippingDetailsType.getTaxTable()
							.getTaxJurisdiction() != null) {
						
						orderTransactionShippingDetails.tax_jurisdiction = mapper
								.writeValueAsString(shippingDetailsType
										.getTaxTable().getTaxJurisdiction());
					}
					
				}
				orderTransactionShippingDetailsList
				.add(orderTransactionShippingDetails);
			}
		}
		
		return orderTransactionShippingDetailsList;
	}
	
	/*public void batchInsertorderTransactionShippingDetails(OrderType[] oList,
			Shops shop) {
		List<OrderTransactionShippingDetails> list = new ArrayList<OrderTransactionShippingDetails>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionShippingDetails> orderTransactionShippingDetailsList = HandleOrderTransactionShippingDetails
						.returnOrderTransactionShippingDetails(o, shop);
				for (int j = 0; j < orderTransactionShippingDetailsList.size(); j++) {
					list.add(orderTransactionShippingDetailsList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionShippingDetailsMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionShippingDetails(OrderType[] oList,
			Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionShippingDetails> orderTransactionShippingDetailsList =

				HandleOrderTransactionShippingDetails
						.returnOrderTransactionShippingDetails(o, shop);
				for (int j = 0; j < orderTransactionShippingDetailsList.size(); j++) {

					OrderTransactionShippingDetails orderTransactionShippingDetails = orderTransactionShippingDetailsList
							.get(j);
					orderTransactionShippingDetailsMapper
							.insert(orderTransactionShippingDetails);
				}
			}

		}
	}*/
}