
package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionSellerDiscountMapper;
import yk.boxri.pojo.OrderTransactionSellerDiscount;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.SellerDiscountsType;

@Component("HandleOrderTransactionSellerDiscount")
public class HandleOrderTransactionSellerDiscount {
	
	public  List<OrderTransactionSellerDiscount> returnOrderTransactionSellerDiscount(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {
		
		List<OrderTransactionSellerDiscount> orderTransactionSellerDiscountList = new ArrayList<OrderTransactionSellerDiscount>();
		
		ObjectMapper mapper = new ObjectMapper();// jackson
		
		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {
			
			OrderTransactionSellerDiscount orderTransactionSellerDiscount = null;
			
			if (o.getTransactionArray().getTransaction(i).getSellerDiscounts() != null) {
				
				orderTransactionSellerDiscount = new OrderTransactionSellerDiscount();
				
				SellerDiscountsType sellerDiscountsType = o
						.getTransactionArray().getTransaction(i)
						.getSellerDiscounts();
				
				orderTransactionSellerDiscount.transaction_id = o
						.getTransactionArray().getTransaction()[i]
								.getTransactionID();
				
				orderTransactionSellerDiscount.order_id = o.getOrderID();
				
				orderTransactionSellerDiscount.user_id = shop.getUserId();
				
				orderTransactionSellerDiscount.shop_id = shop.getShopId();
				
				if (sellerDiscountsType.getOriginalItemPrice() != null) {
					
					orderTransactionSellerDiscount.original_item_price = sellerDiscountsType
							.getOriginalItemPrice().getValue();
					
					orderTransactionSellerDiscount.original_item_price_currency_id = sellerDiscountsType
							.getOriginalItemPrice().getCurrencyID().toString();
				}
				
				if (sellerDiscountsType.getOriginalItemShippingCost() != null) {
					
					orderTransactionSellerDiscount.original_item_shipping_cost = sellerDiscountsType
							.getOriginalItemShippingCost().getValue();
					
					orderTransactionSellerDiscount.original_item_shipping_currency_id = sellerDiscountsType
							.getOriginalItemShippingCost().getCurrencyID()
							.toString();
				}
				
				if (sellerDiscountsType.getOriginalShippingService() != null) {
					
					orderTransactionSellerDiscount.original_shipping_service = sellerDiscountsType
							.getOriginalShippingService();
				}
				
				if (sellerDiscountsType.getSellerDiscount() != null) {
					
					orderTransactionSellerDiscount.seller_discount = mapper
							.writeValueAsString(sellerDiscountsType
									.getSellerDiscount());
				}
				
				orderTransactionSellerDiscountList
				.add(orderTransactionSellerDiscount);
			}
		}
		
		return orderTransactionSellerDiscountList;
	}
	
	/*public void batchInsertorderTransactionSellerDiscount(OrderType[] oList,
			Shops shop) {
		List<OrderTransactionSellerDiscount> list = new ArrayList<OrderTransactionSellerDiscount>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionSellerDiscount> orderTransactionSellerDiscountList = HandleOrderTransactionSellerDiscount
						.returnOrderTransactionSellerDiscount(o, shop);
				for (int j = 0; j < orderTransactionSellerDiscountList.size(); j++) {
					list.add(orderTransactionSellerDiscountList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionSellerDiscountMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionSellerDiscount(OrderType[] oList,
			Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionSellerDiscount> orderTransactionSellerDiscountList = HandleOrderTransactionSellerDiscount
						.returnOrderTransactionSellerDiscount(o, shop);
				for (int j = 0; j < orderTransactionSellerDiscountList.size(); j++) {
					OrderTransactionSellerDiscount orderTransactionSellerDiscount = orderTransactionSellerDiscountList
							.get(j);
					orderTransactionSellerDiscountMapper
							.insert(orderTransactionSellerDiscount);
				}
			}

		}
	}*/
}