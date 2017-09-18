package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionTaxesMapper;
import yk.boxri.pojo.OrderTransactionTaxes;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.TaxDetailsType;
import com.ebay.soap.eBLBaseComponents.TaxesType;

@Component("HandleOrderTransactionTaxes")
public class HandleOrderTransactionTaxes {

	public  List<OrderTransactionTaxes> returnOrderTransactionTaxes(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();// jackson

		List<OrderTransactionTaxes> orderTransactionTaxesList = new ArrayList<OrderTransactionTaxes>();

		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {

			if (o.getTransactionArray().getTransaction()[i].getTaxes() != null) {

				TaxesType taxesType = o.getTransactionArray().getTransaction()[i]
						.getTaxes();

				for (int y = 0; y < taxesType.getTaxDetailsLength(); y++) {

					OrderTransactionTaxes orderTransactionTaxes = new OrderTransactionTaxes();

					TaxDetailsType taxDetailsType = taxesType.getTaxDetails()[y];

					orderTransactionTaxes.transaction_id = o
							.getTransactionArray().getTransaction()[i]
							.getTransactionID();

					orderTransactionTaxes.order_id = o.getOrderID();

					orderTransactionTaxes.user_id = shop.getUserId();

					orderTransactionTaxes.shop_id = shop.getShopId();

					if (taxDetailsType.getImposition() != null) {

						orderTransactionTaxes.imposition = taxDetailsType
								.getImposition().toString();
					}

					if (taxDetailsType.getTaxAmount() != null) {

						orderTransactionTaxes.tax_amount = taxDetailsType
								.getTaxAmount().getValue();

						orderTransactionTaxes.tax_amount_currency_id = taxDetailsType
								.getTaxAmount().getCurrencyID().toString();
					}

					if (taxDetailsType.getTaxCode() != null) {

						orderTransactionTaxes.tax_code = taxDetailsType
								.getTaxCode();
					}

					if (taxDetailsType.getTaxDescription() != null) {

						orderTransactionTaxes.tax_description = taxDetailsType
								.getTaxDescription().toString();
					}

						if (taxesType.getTaxDetails() != null) {

							orderTransactionTaxes.tax_details = mapper
									.writeValueAsString(taxesType
											.getTaxDetails());
						}

					if (taxDetailsType.getTaxOnHandlingAmount() != null) {

						orderTransactionTaxes.tax_on_handling_amount = taxDetailsType
								.getTaxOnHandlingAmount().getValue();

						orderTransactionTaxes.tax_on_handling_amount_currency_id = taxDetailsType
								.getTaxOnHandlingAmount().getCurrencyID()
								.toString();
					}

					if (taxDetailsType.getTaxOnShippingAmount() != null) {

						orderTransactionTaxes.tax_on_shipping_amount = taxDetailsType
								.getTaxOnShippingAmount().getValue();

						orderTransactionTaxes.tax_on_shipping_amount_currency_id = taxDetailsType
								.getTaxOnShippingAmount().getCurrencyID()
								.toString();
					}

					if (taxDetailsType.getTaxOnSubtotalAmount() != null) {

						orderTransactionTaxes.tax_on_subtotal_amount = taxDetailsType
								.getTaxOnSubtotalAmount().getValue();

						orderTransactionTaxes.tax_on_subtotal_amount_currency_id = taxDetailsType
								.getTaxOnSubtotalAmount().getCurrencyID()
								.toString();
					}

					if (taxesType.getTotalTaxAmount() != null) {

						orderTransactionTaxes.total_tax_amount = taxesType
								.getTotalTaxAmount().getValue();

						orderTransactionTaxes.total_tax_amount_currency_id = taxesType
								.getTotalTaxAmount().getCurrencyID().toString();
					}

					orderTransactionTaxesList.add(orderTransactionTaxes);
				}
			}
		}

		return orderTransactionTaxesList;

	}

	/*public void batchInsertorderTransactionTaxes(OrderType[] oList, Shops shop) {
		List<OrderTransactionTaxes> list = new ArrayList<OrderTransactionTaxes>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionTaxes> orderTransactionTaxesList = HandleOrderTransactionTaxes
						.returnOrderTransactionTaxes(o, shop);
				for (int j = 0; j < orderTransactionTaxesList.size(); j++) {
					list.add(orderTransactionTaxesList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionTaxesMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionTaxes(OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionTaxes> orderTransactionTaxesList = HandleOrderTransactionTaxes
						.returnOrderTransactionTaxes(o, shop);
				for (int j = 0; j < orderTransactionTaxesList.size(); j++) {
					OrderTransactionTaxes orderTransactionTaxes = orderTransactionTaxesList
							.get(j);
					orderTransactionTaxesMapper.insert(orderTransactionTaxes);
				}
			}

		}
	}*/
}