
package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionItemMapper;
import yk.boxri.pojo.OrderTransactionItem;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.OrderType;

@Component("HandleOrderTransactionItem")
public class HandleOrderTransactionItem {
	public  List<OrderTransactionItem> returnOrderTransactionItem(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();// jackson
		
		List<OrderTransactionItem> orderTransactionItemList = new ArrayList<OrderTransactionItem>();
		
		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {
			
			OrderTransactionItem orderTransactionItem = null;
			
			if (o.getTransactionArray().getTransaction(i).getItem() != null) {
				
				orderTransactionItem = new OrderTransactionItem();
				
				ItemType itemType = o.getTransactionArray().getTransaction(i)
						.getItem();
				
				orderTransactionItem.transaction_id = o.getTransactionArray()
						.getTransaction(i).getTransactionID();
				
				orderTransactionItem.order_id = o.getOrderID();
				
				orderTransactionItem.user_id = shop.getUserId();
				
				orderTransactionItem.shop_id = shop.getShopId();
				
				if (itemType != null) {
					
					orderTransactionItem.item_id = itemType.getItemID();
				}
				
				if (itemType.isIntegratedMerchantCreditCardEnabled() != null) {
					
					orderTransactionItem.integrated_merchant_credit_card_enabled = itemType
							.isIntegratedMerchantCreditCardEnabled();
				}
				
				if (itemType.getAttributeArray() != null) {
					
					orderTransactionItem.attribute_array = mapper
							.writeValueAsString(itemType
									.getAttributeArray());
				}
				
				
				if (itemType.getPrivateNotes() != null) {
					
					orderTransactionItem.private_notes = itemType
							.getPrivateNotes();
				}
				
				if (itemType.getSellerInventoryID() != null) {
					
					orderTransactionItem.seller_inventory_id = itemType
							.getSellerInventoryID();
				}
				
				if (itemType.getSite() != null) {
					
					orderTransactionItem.site = itemType.getSite().toString();
				}
				
				if (itemType.getSKU() != null) {
					
					orderTransactionItem.SKU = itemType.getSKU();
				}
				
				if (itemType.getTitle() != null) {
					
					orderTransactionItem.title = itemType.getTitle();
				}
				
				orderTransactionItemList.add(orderTransactionItem);
				
			}
		}
		
		return orderTransactionItemList;
	}
	
	/*public void batchInsertorderTransactionItem(OrderType[] oList, Shops shop) {
		List<OrderTransactionItem> list = new ArrayList<OrderTransactionItem>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionItem> orderTransactionItemList = HandleOrderTransactionItem
						.returnOrderTransactionItem(o, shop);
				for (int j = 0; j < orderTransactionItemList.size(); j++) {
					list.add(orderTransactionItemList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionItemMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionItem(OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionItem> orderTransactionItemList = HandleOrderTransactionItem
						.returnOrderTransactionItem(o, shop);
				for (int j = 0; j < orderTransactionItemList.size(); j++) {
					OrderTransactionItem orderTransactionItem = orderTransactionItemList
							.get(j);
					orderTransactionItemMapper.insert(orderTransactionItem);
				}
			}

		}
	}*/
}