
package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionBuyerMapper;
import yk.boxri.pojo.OrderTransactionBuyer;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.UserType;

@Component("HandleOrderTransactionBuyer")
public class HandleOrderTransactionBuyer {
	public  List<OrderTransactionBuyer> returnOrderTransactionBuyer(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {
		
		List<OrderTransactionBuyer> orderTransactionBuyerList = new ArrayList<OrderTransactionBuyer>();
		
		ObjectMapper mapper = new ObjectMapper();// jackson
		
		if (o.getTransactionArray() != null) {
			
			for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {
				
				OrderTransactionBuyer orderTransactionBuyer = null;
				
				if (o.getTransactionArray().getTransaction(i).getBuyer() != null) {
					
					orderTransactionBuyer = new OrderTransactionBuyer();
					
					UserType transactionArrayType = o.getTransactionArray()
							.getTransaction(i).getBuyer();
					
					orderTransactionBuyer.transaction_id = o
							.getTransactionArray().getTransaction(i)
							.getTransactionID();
					
					orderTransactionBuyer.order_id = o.getOrderID();
					
					orderTransactionBuyer.user_id = shop.getUserId();
					
					orderTransactionBuyer.shop_id = shop.getShopId();
					
					if (transactionArrayType.getBuyerInfo() != null) {
						
						if (transactionArrayType.getBuyerInfo()
								.getBuyerTaxIdentifier() != null) {
							
							orderTransactionBuyer.buyer_tax_identifier = mapper
									.writeValueAsString(transactionArrayType
											.getBuyerInfo()
											.getBuyerTaxIdentifier());
							
							
						}
					}
					
					if (transactionArrayType.getEmail() != null) {
						
						orderTransactionBuyer.email = transactionArrayType
								.getEmail();
					}
					
					if (transactionArrayType.getStaticAlias() != null) {
						
						orderTransactionBuyer.static_alias = transactionArrayType
								.getStaticAlias();
					}
					
					if (transactionArrayType.getUserFirstName() != null) {
						
						orderTransactionBuyer.user_first_name = transactionArrayType
								.getUserFirstName();
					}
					
					if (transactionArrayType.getUserLastName() != null) {
						
						orderTransactionBuyer.user_last_name = transactionArrayType
								.getUserLastName();
					}
					
				}
				
				orderTransactionBuyerList.add(orderTransactionBuyer);
			}
		}
		
		return orderTransactionBuyerList;
		
	}
	
	/*public void batchInsertOrderTransactionBuyer(OrderType[] oList, Shops shop) {
		List<OrderTransactionBuyer> list = new ArrayList<OrderTransactionBuyer>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionBuyer> orderTransactionBuyerList = HandleOrderTransactionBuyer
						.returnOrderTransactionBuyer(o, shop);
				for (int j = 0; j < orderTransactionBuyerList.size(); j++) {
					list.add(orderTransactionBuyerList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionBuyerMapper.insertBatch(list);
			}
		}
	}

	public void insertOrderTransactionBuyer(OrderType[] oList, Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionBuyer> orderTransactionBuyerList = HandleOrderTransactionBuyer
						.returnOrderTransactionBuyer(o, shop);
				for (int j = 0; j < orderTransactionBuyerList.size(); j++) {
					OrderTransactionBuyer OrderTransactionBuyer = orderTransactionBuyerList
							.get(j);
					orderTransactionBuyerMapper.insert(OrderTransactionBuyer);
				}
			}

		}
	}*/
}