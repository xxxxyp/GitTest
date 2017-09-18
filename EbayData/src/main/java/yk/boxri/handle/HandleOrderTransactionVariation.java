package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionVariationMapper;
import yk.boxri.pojo.OrderTransactionVariation;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.VariationType;

@Component("HandleOrderTransactionVariation")
public class HandleOrderTransactionVariation {

	public  List<OrderTransactionVariation> returnOrderTransactionVariation(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		
		List<OrderTransactionVariation> orderTransactionVariationList = new ArrayList<OrderTransactionVariation>();

		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {

			OrderTransactionVariation orderTransactionVariation = null;

			if (o.getTransactionArray().getTransaction()[i].getVariation() != null) {

				orderTransactionVariation = new OrderTransactionVariation();

				VariationType variationType = o.getTransactionArray()
						.getTransaction()[i].getVariation();

				orderTransactionVariation.transaction_id = o
						.getTransactionArray().getTransaction()[i]
						.getTransactionID();

				orderTransactionVariation.order_id = o.getOrderID();

				orderTransactionVariation.user_id = shop.getUserId();

				orderTransactionVariation.shop_id = shop.getShopId();

				if (variationType.getSKU() != null) {

					orderTransactionVariation.SKU = variationType.getSKU();
				}

				if (variationType.getPrivateNotes() != null) {

					orderTransactionVariation.variation_specifics = mapper.writeValueAsString(
							variationType.getVariationSpecifics());
				}

				if (variationType.getVariationTitle() != null) {

					orderTransactionVariation.variation_title = variationType
							.getVariationTitle();
				}

				if (variationType.getVariationViewItemURL() != null) {

					orderTransactionVariation.variation_view_item_URL = variationType
							.getVariationViewItemURL();
				}

				orderTransactionVariationList.add(orderTransactionVariation);
			}
		}

		return orderTransactionVariationList;
	}

	/*public void batchInsertorderTransactionVariation(OrderType[] oList,
			Shops shop) {
		List<OrderTransactionVariation> list = new ArrayList<OrderTransactionVariation>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionVariation> orderTransactionVariationList = HandleOrderTransactionVariation
						.returnOrderTransactionVariation(o, shop);
				for (int j = 0; j < orderTransactionVariationList.size(); j++) {
					list.add(orderTransactionVariationList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionVariationMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionVariation(OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionVariation> orderTransactionVariationList = HandleOrderTransactionVariation
						.returnOrderTransactionVariation(o, shop);
				for (int j = 0; j < orderTransactionVariationList.size(); j++) {
					OrderTransactionVariation orderTransactionVariation = orderTransactionVariationList
							.get(j);
					orderTransactionVariationMapper
							.insert(orderTransactionVariation);
				}
			}

		}
	}*/
}
