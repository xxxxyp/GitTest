
package yk.boxri.handle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderTransactionPaymentHoldDetailsMapper;
import yk.boxri.pojo.OrderTransactionPaymentHoldDetails;
import yk.boxri.pojo.ShopToken;

import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PaymentHoldDetailType;

@Component("HandleOrderTransactionPaymentHoldDetails")
public class HandleOrderTransactionPaymentHoldDetails {
	
	public  List<OrderTransactionPaymentHoldDetails> returnOrderTransactionPaymentHoldDetails(
			OrderType o, ShopToken shop) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();// jackson
		
		List<OrderTransactionPaymentHoldDetails> orderTransactionPaymentHoldDetailsList = new ArrayList<OrderTransactionPaymentHoldDetails>();
		
		for (int i = 0; i < o.getTransactionArray().getTransactionLength(); i++) {
			
			OrderTransactionPaymentHoldDetails orderTransactionPaymentHoldDetails = null;
			
			if (o.getTransactionArray().getTransaction(i)
					.getPaymentHoldDetails() != null) {
				
				orderTransactionPaymentHoldDetails = new OrderTransactionPaymentHoldDetails();
				
				PaymentHoldDetailType paymentHoldDetailType = o
						.getTransactionArray().getTransaction(i)
						.getPaymentHoldDetails();
				
				orderTransactionPaymentHoldDetails.transaction_id = o
						.getTransactionArray().getTransaction()[i]
								.getTransactionID();
				
				orderTransactionPaymentHoldDetails.order_id = o.getOrderID();
				
				orderTransactionPaymentHoldDetails.user_id = shop.getUserId();
				
				orderTransactionPaymentHoldDetails.shop_id = shop.getShopId();
				
				if (paymentHoldDetailType.getExpectedReleaseDate() != null) {
					
					orderTransactionPaymentHoldDetails.expected_release_date = paymentHoldDetailType
							.getExpectedReleaseDate().getTime();
				}
				
				if (paymentHoldDetailType.getNumOfReqSellerActions() != null) {
					
					orderTransactionPaymentHoldDetails.num_of_req_seller_actions = paymentHoldDetailType
							.getNumOfReqSellerActions();
				}
				
				if (paymentHoldDetailType.getPaymentHoldReason() != null) {
					
					orderTransactionPaymentHoldDetails.payment_hold_reason = paymentHoldDetailType
							.getPaymentHoldReason().toString();
				}
				
				if (paymentHoldDetailType.getRequiredSellerActionArray() != null) {
					orderTransactionPaymentHoldDetails.required_seller_action_values = mapper
							.writeValueAsString(paymentHoldDetailType
									.getRequiredSellerActionArray());
				}
				
				orderTransactionPaymentHoldDetailsList
				.add(orderTransactionPaymentHoldDetails);
			}
			
		}
		
		return orderTransactionPaymentHoldDetailsList;
	}
	
	/*public void batchInsertorderTransactionPaymentHoldDetails(
			OrderType[] oList, Shops shop) {
		List<OrderTransactionPaymentHoldDetails> list = new ArrayList<OrderTransactionPaymentHoldDetails>();
		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionPaymentHoldDetails> orderTransactionPaymentHoldDetailsList = HandleOrderTransactionPaymentHoldDetails
						.returnOrderTransactionPaymentHoldDetails(o, shop);
				for (int j = 0; j < orderTransactionPaymentHoldDetailsList
						.size(); j++) {
					list.add(orderTransactionPaymentHoldDetailsList.get(j));
				}
			}
			if (list.size() != 0) {
				orderTransactionPaymentHoldDetailsMapper.insertBatch(list);
			}
		}
	}

	public void insertorderTransactionPaymentHoldDetails(OrderType[] oList,
			Shops shop) {

		if (oList != null) {
			for (int i = 0; i < oList.length; i++) {// �������ض���
				OrderType o = oList[i];
				List<OrderTransactionPaymentHoldDetails> orderTransactionPaymentHoldDetailsList = HandleOrderTransactionPaymentHoldDetails
						.returnOrderTransactionPaymentHoldDetails(o, shop);
				for (int j = 0; j < orderTransactionPaymentHoldDetailsList
						.size(); j++) {
					OrderTransactionPaymentHoldDetails orderTransactionPaymentHoldDetails = orderTransactionPaymentHoldDetailsList
							.get(j);
					orderTransactionPaymentHoldDetailsMapper
							.insert(orderTransactionPaymentHoldDetails);
				}
			}

		}
	}*/
}