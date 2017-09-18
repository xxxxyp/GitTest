package yk.boxri.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Component;

import yk.boxri.dao.OrderCancelDetailsMapper;
import yk.boxri.dao.OrderInfoMapper;
import yk.boxri.dao.OrderMonetaryDetailsPaymentsMapper;
import yk.boxri.dao.OrderMonetaryDetailsRefundsMapper;
import yk.boxri.dao.OrderMultilegShippingDetailsMapper;
import yk.boxri.dao.OrderPaymentHoldDetailsMapper;
import yk.boxri.dao.OrderPickupDetailsMapper;
import yk.boxri.dao.OrderRefundArrayMapper;
import yk.boxri.dao.OrderShippingAddressMapper;
import yk.boxri.dao.OrderShippingDetailsIntlShippingServiceOptionMapper;
import yk.boxri.dao.OrderShippingDetailsMapper;
import yk.boxri.dao.OrderShippingDetailsShipmentTrackingDetailsMapper;
import yk.boxri.dao.OrderShippingDetailsShippingServiceOptionsMapper;
import yk.boxri.dao.OrderShippingServiceSelectedMapper;
import yk.boxri.dao.OrderTransactionBuyerMapper;
import yk.boxri.dao.OrderTransactionDigitalDeliverySelectedMapper;
import yk.boxri.dao.OrderTransactionExternalTransactionMapper;
import yk.boxri.dao.OrderTransactionItemMapper;
import yk.boxri.dao.OrderTransactionMapper;
import yk.boxri.dao.OrderTransactionMonetaryDetailsPaymentsMapper;
import yk.boxri.dao.OrderTransactionMonetaryDetailsRefundsMapper;
import yk.boxri.dao.OrderTransactionMultilegShippingDetailsMapper;
import yk.boxri.dao.OrderTransactionPaymentHoldDetailsMapper;
import yk.boxri.dao.OrderTransactionRefundArrayMapper;
import yk.boxri.dao.OrderTransactionSellerDiscountMapper;
import yk.boxri.dao.OrderTransactionShippingDetailsIntlShippingServiceOptionMapper;
import yk.boxri.dao.OrderTransactionShippingDetailsMapper;
import yk.boxri.dao.OrderTransactionShippingDetailsShipmentTrackingDetailsMapper;
import yk.boxri.dao.OrderTransactionShippingDetailsShippingServiceOptionsMapper;
import yk.boxri.dao.OrderTransactionShippingServiceSelectedMapper;
import yk.boxri.dao.OrderTransactionTaxesMapper;
import yk.boxri.dao.OrderTransactionVariationMapper;
import yk.boxri.handle.HandleOrderCancelDetails;
import yk.boxri.handle.HandleOrderInfo;
import yk.boxri.handle.HandleOrderMonetaryDetails;
import yk.boxri.handle.HandleOrderMultilegShippingDetails;
import yk.boxri.handle.HandleOrderPaymentHoldDetails;
import yk.boxri.handle.HandleOrderPickupDetails;
import yk.boxri.handle.HandleOrderRefundArray;
import yk.boxri.handle.HandleOrderShippingAddress;
import yk.boxri.handle.HandleOrderShippingDetails;
import yk.boxri.handle.HandleOrderShippingDetailsIntlShippingServiceOption;
import yk.boxri.handle.HandleOrderShippingDetailsShipmentTrackingDetails;
import yk.boxri.handle.HandleOrderShippingDetailsShippingServiceOptions;
import yk.boxri.handle.HandleOrderShippingServiceSelected;
import yk.boxri.handle.HandleOrderTransaction;
import yk.boxri.handle.HandleOrderTransactionBuyer;
import yk.boxri.handle.HandleOrderTransactionDigitalDeliverySelected;
import yk.boxri.handle.HandleOrderTransactionExternalTransaction;
import yk.boxri.handle.HandleOrderTransactionItem;
import yk.boxri.handle.HandleOrderTransactionMonetaryDetailsPayments;
import yk.boxri.handle.HandleOrderTransactionMonetaryDetailsRefunds;
import yk.boxri.handle.HandleOrderTransactionMultilegShippingDetails;
import yk.boxri.handle.HandleOrderTransactionPaymentHoldDetails;
import yk.boxri.handle.HandleOrderTransactionRefundArray;
import yk.boxri.handle.HandleOrderTransactionSellerDiscount;
import yk.boxri.handle.HandleOrderTransactionShippingDetails;
import yk.boxri.handle.HandleOrderTransactionShippingDetailsIntlShippingServiceOption;
import yk.boxri.handle.HandleOrderTransactionShippingDetailsShipmentTrackingDetails;
import yk.boxri.handle.HandleOrderTransactionShippingDetailsShippingServiceOptions;
import yk.boxri.handle.HandleOrderTransactionShippingServiceSelected;
import yk.boxri.handle.HandleOrderTransactionTaxes;
import yk.boxri.handle.HandleOrderTransactionVariation;
import yk.boxri.pojo.OrderCancelDetails;
import yk.boxri.pojo.OrderInfo;
import yk.boxri.pojo.OrderMonetaryDetailsPayments;
import yk.boxri.pojo.OrderMonetaryDetailsRefunds;
import yk.boxri.pojo.OrderMultilegShippingDetails;
import yk.boxri.pojo.OrderPaymentHoldDetails;
import yk.boxri.pojo.OrderPickupDetails;
import yk.boxri.pojo.OrderRefundArray;
import yk.boxri.pojo.OrderShippingAddress;
import yk.boxri.pojo.OrderShippingDetails;
import yk.boxri.pojo.OrderShippingDetailsIntlShippingServiceOption;
import yk.boxri.pojo.OrderShippingDetailsShipmentTrackingDetails;
import yk.boxri.pojo.OrderShippingDetailsShippingServiceOptions;
import yk.boxri.pojo.OrderShippingServiceSelected;
import yk.boxri.pojo.OrderTransaction;
import yk.boxri.pojo.OrderTransactionBuyer;
import yk.boxri.pojo.OrderTransactionDigitalDeliverySelected;
import yk.boxri.pojo.OrderTransactionExternalTransaction;
import yk.boxri.pojo.OrderTransactionItem;
import yk.boxri.pojo.OrderTransactionMonetaryDetailsPayments;
import yk.boxri.pojo.OrderTransactionMonetaryDetailsRefunds;
import yk.boxri.pojo.OrderTransactionMultilegShippingDetails;
import yk.boxri.pojo.OrderTransactionPaymentHoldDetails;
import yk.boxri.pojo.OrderTransactionRefundArray;
import yk.boxri.pojo.OrderTransactionSellerDiscount;
import yk.boxri.pojo.OrderTransactionShippingDetails;
import yk.boxri.pojo.OrderTransactionShippingDetailsIntlShippingServiceOption;
import yk.boxri.pojo.OrderTransactionShippingDetailsShipmentTrackingDetails;
import yk.boxri.pojo.OrderTransactionShippingDetailsShippingServiceOptions;
import yk.boxri.pojo.OrderTransactionShippingServiceSelected;
import yk.boxri.pojo.OrderTransactionTaxes;
import yk.boxri.pojo.OrderTransactionVariation;
import yk.boxri.pojo.ShopToken;
import yk.boxri.utils.CompareListObject;

import com.ebay.soap.eBLBaseComponents.OrderType;

@Component("BatchUpdateOrder")
public class BatchUpdateOrder {
	@Resource
	private OrderCancelDetailsMapper orderCancelDetailsMapper;
	@Resource
	private HandleOrderCancelDetails handleOrderCancelDetails;
	@Resource
	private OrderInfoMapper orderInfoMapper;
	@Resource
	private HandleOrderInfo handleOrderInfo;
	@Resource
	private OrderMonetaryDetailsPaymentsMapper orderMonetaryDetailsPaymentsMapper;
	@Resource
	private OrderMonetaryDetailsRefundsMapper orderMonetaryDetailsRefundsMapper;
	@Resource
	private HandleOrderMonetaryDetails handleOrderMonetaryDetails;
	@Resource
	private OrderMultilegShippingDetailsMapper orderMultilegShippingDetailsMapper;
	@Resource
	private HandleOrderMultilegShippingDetails handleOrderMultilegShippingDetails;
	@Resource
	private OrderPaymentHoldDetailsMapper orderPaymentHoldDetailsMapper;
	@Resource
	private HandleOrderPaymentHoldDetails handleOrderPaymentHoldDetails;
	@Resource
	private OrderPickupDetailsMapper orderPickupDetailsMapper;
	@Resource
	private HandleOrderPickupDetails handleOrderPickupDetails;
	@Resource
	private OrderRefundArrayMapper orderRefundArrayMapper;
	@Resource
	private HandleOrderRefundArray handleOrderRefundArray;
	@Resource
	private OrderShippingAddressMapper orderShippingAddressMapper;
	@Resource
	private HandleOrderShippingAddress handleOrderShippingAddress;
	@Resource
	private OrderShippingDetailsMapper orderShippingDetailsMapper;
	@Resource
	private HandleOrderShippingDetails handleOrderShippingDetails;
	@Resource
	private OrderShippingDetailsIntlShippingServiceOptionMapper orderShippingDetailsIntlShippingServiceOptionMapper;
	@Resource
	private HandleOrderShippingDetailsIntlShippingServiceOption handleOrderShippingDetailsIntlShippingServiceOption;
	@Resource
	private OrderShippingDetailsShipmentTrackingDetailsMapper orderShippingDetailsShipmentTrackingDetailsMapper;
	@Resource
	private HandleOrderShippingDetailsShipmentTrackingDetails handleOrderShippingDetailsShipmentTrackingDetails;
	@Resource
	private OrderShippingDetailsShippingServiceOptionsMapper orderShippingDetailsShippingServiceOptionsMapper;
	@Resource
	private HandleOrderShippingDetailsShippingServiceOptions handleOrderShippingDetailsShippingServiceOptions;
	@Resource
	private OrderShippingServiceSelectedMapper orderShippingServiceSelectedMapper;
	@Resource
	private HandleOrderShippingServiceSelected handleOrderShippingServiceSelected;
	@Resource
	private OrderTransactionMapper orderTransactionMapper;
	@Resource
	private HandleOrderTransaction handleOrderTransaction;
	@Resource
	private OrderTransactionBuyerMapper orderTransactionBuyerMapper;
	@Resource
	private HandleOrderTransactionBuyer handleOrderTransactionBuyer;
	@Resource
	private OrderTransactionDigitalDeliverySelectedMapper orderTransactionDigitalDeliverySelectedMapper;
	@Resource
	private HandleOrderTransactionDigitalDeliverySelected handleOrderTransactionDigitalDeliverySelected;
	@Resource
	private OrderTransactionExternalTransactionMapper orderTransactionExternalTransactionMapper;
	@Resource
	private HandleOrderTransactionExternalTransaction handleOrderTransactionExternalTransaction;
	@Resource
	private OrderTransactionItemMapper orderTransactionItemMapper;
	@Resource
	private HandleOrderTransactionItem handleOrderTransactionItem;
	@Resource
	private OrderTransactionMonetaryDetailsPaymentsMapper orderTransactionMonetaryDetailsPaymentsMapper;
	@Resource
	private HandleOrderTransactionMonetaryDetailsPayments handleOrderTransactionMonetaryDetailsPayments;
	@Resource
	private OrderTransactionMonetaryDetailsRefundsMapper orderTransactionMonetaryDetailsRefundsMapper;
	@Resource
	private HandleOrderTransactionMonetaryDetailsRefunds handleOrderTransactionMonetaryDetailsRefunds;
	@Resource
	private OrderTransactionMultilegShippingDetailsMapper orderTransactionMultilegShippingDetailsMapper;
	@Resource
	private HandleOrderTransactionMultilegShippingDetails handleOrderTransactionMultilegShippingDetails;
	@Resource
	private OrderTransactionPaymentHoldDetailsMapper orderTransactionPaymentHoldDetailsMapper;
	@Resource
	private HandleOrderTransactionPaymentHoldDetails handleOrderTransactionPaymentHoldDetails;
	@Resource
	private OrderTransactionRefundArrayMapper orderTransactionRefundArrayMapper;
	@Resource
	private HandleOrderTransactionRefundArray handleOrderTransactionRefundArray;
	@Resource
	private OrderTransactionSellerDiscountMapper orderTransactionSellerDiscountMapper;
	@Resource
	private HandleOrderTransactionSellerDiscount handleOrderTransactionSellerDiscount;
	@Resource
	private OrderTransactionShippingDetailsMapper orderTransactionShippingDetailsMapper;
	@Resource
	private HandleOrderTransactionShippingDetails handleOrderTransactionShippingDetails;
	@Resource
	private OrderTransactionShippingDetailsIntlShippingServiceOptionMapper orderTransactionShippingDetailsIntlShippingServiceOptionMapper;
	@Resource
	private HandleOrderTransactionShippingDetailsIntlShippingServiceOption handleOrderTransactionShippingDetailsIntlShippingServiceOption;
	@Resource
	private OrderTransactionShippingDetailsShipmentTrackingDetailsMapper orderTransactionShippingDetailsShipmentTrackingDetailsMapper;
	@Resource
	private HandleOrderTransactionShippingDetailsShipmentTrackingDetails handleOrderTransactionShippingDetailsShipmentTrackingDetails;
	@Resource
	private OrderTransactionShippingDetailsShippingServiceOptionsMapper orderTransactionShippingDetailsShippingServiceOptionsMapper;
	@Resource
	private HandleOrderTransactionShippingDetailsShippingServiceOptions handleOrderTransactionShippingDetailsShippingServiceOptions;
	@Resource
	private OrderTransactionShippingServiceSelectedMapper orderTransactionShippingServiceSelectedMapper;
	@Resource
	private HandleOrderTransactionShippingServiceSelected handleOrderTransactionShippingServiceSelected;
	@Resource
	private OrderTransactionTaxesMapper orderTransactionTaxesMapper;
	@Resource
	private HandleOrderTransactionTaxes handleOrderTransactionTaxes;
	@Resource
	private OrderTransactionVariationMapper orderTransactionVariationMapper;
	@Resource
	private HandleOrderTransactionVariation handleOrderTransactionVariation;
	
	@SuppressWarnings("unchecked")
	public void batchUpdateOrder(List<OrderType> waitUpdateList, ShopToken shop) throws IllegalArgumentException, IllegalAccessException, JsonGenerationException, JsonMappingException, IOException {
		if(waitUpdateList.size()!=0){
			List<OrderCancelDetails> insertOrderCancelDetails = new ArrayList<OrderCancelDetails>();
			List<OrderInfo> insertOrderInfo = new ArrayList<OrderInfo>();
			List<OrderMonetaryDetailsPayments> insertOrderMonetaryDetailsPayments = 
					new ArrayList<OrderMonetaryDetailsPayments>();
			List<OrderMonetaryDetailsRefunds> insertOrderMonetaryDetailsRefunds =
					new ArrayList<OrderMonetaryDetailsRefunds>();
			List<OrderMultilegShippingDetails> insertOrderMultilegShippingDetails =
					new ArrayList<OrderMultilegShippingDetails>();
			List<OrderPaymentHoldDetails> insertOrderPaymentHoldDetails =
					new ArrayList<OrderPaymentHoldDetails>();
			List<OrderPickupDetails> insertOrderPickupDetails =
					new ArrayList<OrderPickupDetails>();
			List<OrderRefundArray> insertOrderRefundArray =
					new ArrayList<OrderRefundArray>();
			List<OrderShippingAddress> insertOrderShippingAddress = 
					new ArrayList<OrderShippingAddress>();
			List<OrderShippingDetails> insertOrderShippingDetails = 
					new ArrayList<OrderShippingDetails>();
			List<OrderShippingDetailsIntlShippingServiceOption> insertOrderShippingDetailsIntlShippingServiceOption = 
					new ArrayList<OrderShippingDetailsIntlShippingServiceOption>();
			List<OrderShippingDetailsShipmentTrackingDetails> insertOrderShippingDetailsShipmentTrackingDetails = 
					new ArrayList<OrderShippingDetailsShipmentTrackingDetails>();
			List<OrderShippingDetailsShippingServiceOptions> insertOrderShippingDetailsShippingServiceOptions = 
					new ArrayList<OrderShippingDetailsShippingServiceOptions>();
			List<OrderTransactionItem> insertOrderTransactionItem = 
					new ArrayList<OrderTransactionItem>();
			List<OrderShippingServiceSelected> insertOrderShippingServiceSelected = 
					new ArrayList<OrderShippingServiceSelected>();
			List<OrderTransaction> insertOrderTransaction = 
					new ArrayList<OrderTransaction>();
			List<OrderTransactionBuyer> insertOrderTransactionBuyer = 
					new ArrayList<OrderTransactionBuyer>();
			List<OrderTransactionDigitalDeliverySelected> insertOrderTransactionDigitalDeliverySelected = 
					new ArrayList<OrderTransactionDigitalDeliverySelected>();
			List<OrderTransactionMonetaryDetailsPayments> insertOrderTransactionMonetaryDetailsPayments = 
					new ArrayList<OrderTransactionMonetaryDetailsPayments>();
			List<OrderTransactionExternalTransaction> insertOrderTransactionExternalTransaction = 
					new ArrayList<OrderTransactionExternalTransaction>();
			List<OrderTransactionMonetaryDetailsRefunds> insertOrderTransactionMonetaryDetailsRefunds = 
					new ArrayList<OrderTransactionMonetaryDetailsRefunds>();
			List<OrderTransactionMultilegShippingDetails> insertOrderTransactionMultilegShippingDetails = 
					new ArrayList<OrderTransactionMultilegShippingDetails>();
			List<OrderTransactionPaymentHoldDetails> insertOrderTransactionPaymentHoldDetails = 
					new ArrayList<OrderTransactionPaymentHoldDetails>();
			List<OrderTransactionRefundArray> insertOrderTransactionRefundArray = 
					new ArrayList<OrderTransactionRefundArray>();
			List<OrderTransactionSellerDiscount> insertOrderTransactionSellerDiscount =
					new ArrayList<OrderTransactionSellerDiscount>();
			List<OrderTransactionShippingDetails> insertOrderTransactionShippingDetails =
					new ArrayList<OrderTransactionShippingDetails>();
			List<OrderTransactionShippingDetailsIntlShippingServiceOption> insertOrderTransactionShippingDetailsIntlShippingServiceOption = 
					new ArrayList<OrderTransactionShippingDetailsIntlShippingServiceOption>();
			List<OrderTransactionShippingDetailsShipmentTrackingDetails> insertOrderTransactionShippingDetailsShipmentTrackingDetails = 
					new ArrayList<OrderTransactionShippingDetailsShipmentTrackingDetails>();
			List<OrderTransactionShippingDetailsShippingServiceOptions> insertOrderTransactionShippingDetailsShippingServiceOptions =
					new ArrayList<OrderTransactionShippingDetailsShippingServiceOptions>();
			List<OrderTransactionShippingServiceSelected> insertOrderTransactionShippingServiceSelected = 
					new ArrayList<OrderTransactionShippingServiceSelected>();
			List<OrderTransactionTaxes> insertOrderTransactionTaxes =
					new ArrayList<OrderTransactionTaxes>();
			List<OrderTransactionVariation> insertOrderTransactionVariation = 
					new ArrayList<OrderTransactionVariation>();
			
			
			List<String> updateOrderList =new ArrayList<String>();
			
			/*updateOrderList.add("252939801542-2055270114015");
			List<OrderTransactionTaxes> list=orderTransactionTaxesMapper.dynamicSelect(updateOrderList);
			System.out.println(list.get(0).order_id);
			insertOrderTransactionTaxes=(List<OrderTransactionTaxes>) compareListObject.compareListObject(insertOrderTransactionTaxes, list);*/
			CompareListObject compareListObject=new CompareListObject();
			 
			
			
			for(int i=0;i<waitUpdateList.size();i++){
			 
				OrderType o =waitUpdateList.get(i);
				updateOrderList.add(waitUpdateList.get(i).getOrderID());
				
				List<OrderCancelDetails> orderCancelDetailsList =
						handleOrderCancelDetails.returnOrderCancelDetails(o, shop);
				for (int j = 0; j < orderCancelDetailsList.size(); j++) {
					
					insertOrderCancelDetails.add(orderCancelDetailsList.get(j));
				}
				
				OrderInfo orderInfo = handleOrderInfo.returnOrderInfo(o, shop);
				if (orderInfo != null) {
					insertOrderInfo.add(orderInfo);
				}
				List<OrderMonetaryDetailsPayments> orderMonetaryDetailsPaymentsList =//ɾ��orderInfo��¼���²�ִ��Update
						handleOrderMonetaryDetails.returnOrderMonetaryDetailsPayments(o, shop);
				for (int j = 0; j < orderMonetaryDetailsPaymentsList.size(); j++) {
					insertOrderMonetaryDetailsPayments.add(orderMonetaryDetailsPaymentsList.get(j));
				}
				
				List<OrderMonetaryDetailsRefunds> OrderMonetaryDetailsRefundsList =
						handleOrderMonetaryDetails.returnOrderMonetaryDetailsRefunds(o, shop);
				for (int j = 0; j < OrderMonetaryDetailsRefundsList.size(); j++) {
					insertOrderMonetaryDetailsRefunds.add(OrderMonetaryDetailsRefundsList.get(j));
				}
				
				OrderMultilegShippingDetails orderMultilegShippingDetails =
						handleOrderMultilegShippingDetails.returnOrderMultilegShippingDetails(o, shop);
				if (orderMultilegShippingDetails != null) {
					insertOrderMultilegShippingDetails.add(orderMultilegShippingDetails);
				}

				OrderPaymentHoldDetails orderPaymentHoldDetails =
						handleOrderPaymentHoldDetails.returnOrderPaymentHoldDetails(o, shop);
				if (orderPaymentHoldDetails != null) {
					insertOrderPaymentHoldDetails.add(orderPaymentHoldDetails);
				}
				
				List<OrderPickupDetails> orderPickupDetailsList = handleOrderPickupDetails.returnOrderPickupDetails(o, shop);

				for (int j = 0; j < orderPickupDetailsList.size(); j++) {
					insertOrderPickupDetails.add(orderPickupDetailsList.get(j));
				}
				
				List<OrderRefundArray> orderRefundArrayList = 
						handleOrderRefundArray.returnOrderRefundArray(o, shop);
				for (int j = 0; j < orderRefundArrayList.size(); j++) {
					insertOrderRefundArray.add(orderRefundArrayList.get(j));
				}
				
				OrderShippingAddress orderShippingAddress = handleOrderShippingAddress.returnOrderShippingAddress(o, shop);
				if (orderShippingAddress != null) {
					insertOrderShippingAddress.add(orderShippingAddress);
				}
				
				OrderShippingDetails orderShippingDetails = 
						handleOrderShippingDetails.returnOrderShippingDetails(o, shop);
				if (orderShippingDetails != null) {
					insertOrderShippingDetails.add(orderShippingDetails);
				}

				List<OrderShippingDetailsIntlShippingServiceOption> orderShippingDetailsIntlShippingServiceOptionList =
						handleOrderShippingDetailsIntlShippingServiceOption.returnOrderShippingDetailsIntlShippingServiceOption(o,
								shop);
				for (int j = 0; j < orderShippingDetailsIntlShippingServiceOptionList.size(); j++) {
					insertOrderShippingDetailsIntlShippingServiceOption.add(orderShippingDetailsIntlShippingServiceOptionList.get(j));
				}

				List<OrderShippingDetailsShipmentTrackingDetails> orderShippingDetailsShipmentTrackingDetailsList =
						handleOrderShippingDetailsShipmentTrackingDetails.returnOrderShippingDetailsShipmentTrackingDetails(o,shop);
				for (int j = 0; j < orderShippingDetailsShipmentTrackingDetailsList.size(); j++) {
					insertOrderShippingDetailsShipmentTrackingDetails.add(orderShippingDetailsShipmentTrackingDetailsList.get(j));
				}
				
				List<OrderShippingDetailsShippingServiceOptions> orderShippingDetailsShippingServiceOptionsList =
						handleOrderShippingDetailsShippingServiceOptions.returnOrderShippingDetailsShippingServiceOptions(o,shop);
				for (int j = 0; j < orderShippingDetailsShippingServiceOptionsList.size(); j++) {
					insertOrderShippingDetailsShippingServiceOptions.add(orderShippingDetailsShippingServiceOptionsList.get(j));
				}

				OrderShippingServiceSelected orderShippingServiceSelected = 
						handleOrderShippingServiceSelected.returnOrderShippingServiceSelected(o, shop);
				if (orderShippingServiceSelected != null) {
					insertOrderShippingServiceSelected.add(orderShippingServiceSelected);
				}

				List<OrderTransaction> orderTransactionList = 
						handleOrderTransaction.returnOrderTransaction(o, shop);
				for (int j = 0; j < orderTransactionList.size(); j++) {
					insertOrderTransaction.add(orderTransactionList.get(j));
				}

				List<OrderTransactionBuyer> orderTransactionBuyerList = handleOrderTransactionBuyer.returnOrderTransactionBuyer(o, shop);
				for (int j = 0; j < orderTransactionBuyerList.size(); j++) {
					insertOrderTransactionBuyer.add(orderTransactionBuyerList.get(j));
				}

				List<OrderTransactionDigitalDeliverySelected> orderTransactionDigitalDeliverySelectedList = 
						handleOrderTransactionDigitalDeliverySelected.returnOrderTransactionDigitalDeliverySelected(o, shop);
				for (int j = 0; j < orderTransactionDigitalDeliverySelectedList.size(); j++) {
					insertOrderTransactionDigitalDeliverySelected.add(orderTransactionDigitalDeliverySelectedList.get(j));
				}

				List<OrderTransactionExternalTransaction> orderTransactionExternalTransactionList = 
						handleOrderTransactionExternalTransaction.returnOrderTransactionExternalTransaction(o, shop);
				for (int j = 0; j < orderTransactionExternalTransactionList.size(); j++) {
					insertOrderTransactionExternalTransaction.add(orderTransactionExternalTransactionList.get(j));
				}
				
				List<OrderTransactionItem> orderTransactionItemList = 
						handleOrderTransactionItem.returnOrderTransactionItem(o, shop);
				for (int j = 0; j < orderTransactionItemList.size(); j++) {
					insertOrderTransactionItem.add(orderTransactionItemList.get(j));
				}

				List<OrderTransactionMonetaryDetailsPayments> orderTransactionMonetaryDetailsPaymentsList = 
						handleOrderTransactionMonetaryDetailsPayments.returnOrderTransactionMonetaryDetailsPayments(o, shop);
				for (int j = 0; j < orderTransactionMonetaryDetailsPaymentsList.size(); j++) {
					insertOrderTransactionMonetaryDetailsPayments.add(orderTransactionMonetaryDetailsPaymentsList.get(j));
				}

				List<OrderTransactionMonetaryDetailsRefunds> orderTransactionMonetaryDetailsRefundsList =
						handleOrderTransactionMonetaryDetailsRefunds.returnOrderTransactionMonetaryDetailsRefunds(o, shop);
				for (int j = 0; j < orderTransactionMonetaryDetailsRefundsList.size(); j++) {
					insertOrderTransactionMonetaryDetailsRefunds.add(orderTransactionMonetaryDetailsRefundsList.get(j));
				}

				List<OrderTransactionMultilegShippingDetails> orderTransactionMultilegShippingDetailsList = 
						handleOrderTransactionMultilegShippingDetails.returnOrderTransactionMultilegShippingDetails(o, shop);
				for (int j = 0; j < orderTransactionMultilegShippingDetailsList.size(); j++) {
					insertOrderTransactionMultilegShippingDetails.add(orderTransactionMultilegShippingDetailsList.get(j));
				}

				List<OrderTransactionPaymentHoldDetails> orderTransactionPaymentHoldDetailsList = 
						handleOrderTransactionPaymentHoldDetails.returnOrderTransactionPaymentHoldDetails(o, shop);
				for (int j = 0; j < orderTransactionPaymentHoldDetailsList.size(); j++) {
					insertOrderTransactionPaymentHoldDetails.add(orderTransactionPaymentHoldDetailsList.get(j));
				}

				List<OrderTransactionRefundArray> orderTransactionRefundArrayList = 
						handleOrderTransactionRefundArray.returnOrderTransactionRefundArray(o, shop);
				for (int j = 0; j < orderTransactionRefundArrayList.size(); j++) {
					insertOrderTransactionRefundArray.add(orderTransactionRefundArrayList.get(j));
				}

				List<OrderTransactionSellerDiscount> orderTransactionSellerDiscountList = 
						handleOrderTransactionSellerDiscount.returnOrderTransactionSellerDiscount(o, shop);
				for (int j = 0; j < orderTransactionSellerDiscountList.size(); j++) {
					insertOrderTransactionSellerDiscount.add(orderTransactionSellerDiscountList.get(j));
				}

				List<OrderTransactionShippingDetails> orderTransactionShippingDetailsList = 
						handleOrderTransactionShippingDetails.returnOrderTransactionShippingDetails(o, shop);
				for (int j = 0; j < orderTransactionShippingDetailsList.size(); j++) {
					insertOrderTransactionShippingDetails.add(orderTransactionShippingDetailsList.get(j));
				}

				List<OrderTransactionShippingDetailsIntlShippingServiceOption> orderTransactionShippingDetailsIntlShippingServiceOptionList = 
						handleOrderTransactionShippingDetailsIntlShippingServiceOption.returnOrderTransactionShippingDetailsIntlShippingServiceOption(o, shop);
				for (int j = 0; j < orderTransactionShippingDetailsIntlShippingServiceOptionList.size(); j++) {
					insertOrderTransactionShippingDetailsIntlShippingServiceOption.add(orderTransactionShippingDetailsIntlShippingServiceOptionList.get(j));
				}

				List<OrderTransactionShippingDetailsShipmentTrackingDetails> orderTransactionShippingDetailsShipmentTrackingDetailsList = 
						handleOrderTransactionShippingDetailsShipmentTrackingDetails.returnOrderTransactionShippingDetailsShipmentTrackingDetails(o, shop);
				for (int j = 0; j < orderTransactionShippingDetailsShipmentTrackingDetailsList.size(); j++) {
					insertOrderTransactionShippingDetailsShipmentTrackingDetails.add(orderTransactionShippingDetailsShipmentTrackingDetailsList.get(j));
				}

				List<OrderTransactionShippingDetailsShippingServiceOptions> orderTransactionShippingDetailsShippingServiceOptionsList =
						handleOrderTransactionShippingDetailsShippingServiceOptions.returnOrderTransactionShippingDetailsShippingServiceOptions(o, shop);
				for (int j = 0; j < orderTransactionShippingDetailsShippingServiceOptionsList.size(); j++) {
					insertOrderTransactionShippingDetailsShippingServiceOptions.add(orderTransactionShippingDetailsShippingServiceOptionsList.get(j));
				}

				List<OrderTransactionShippingServiceSelected> orderTransactionShippingServiceSelectedList = 
						handleOrderTransactionShippingServiceSelected.returnOrderTransactionShippingServiceSelected(o, shop);
				for (int j = 0; j < orderTransactionShippingServiceSelectedList.size(); j++) {
					insertOrderTransactionShippingServiceSelected.add(orderTransactionShippingServiceSelectedList.get(j));
				}

				List<OrderTransactionTaxes> orderTransactionTaxesList = 
						handleOrderTransactionTaxes.returnOrderTransactionTaxes(o, shop);
				for (int j = 0; j < orderTransactionTaxesList.size(); j++) {
					insertOrderTransactionTaxes.add(orderTransactionTaxesList.get(j));
				}

				List<OrderTransactionVariation> orderTransactionVariationList =
						handleOrderTransactionVariation.returnOrderTransactionVariation(o, shop);
				for (int j = 0; j < orderTransactionVariationList.size(); j++) {
					insertOrderTransactionVariation.add(orderTransactionVariationList.get(j));
				}
				
			}
			//List<OrderCancelDetails> existOrderCancelDetailsList=orderCancelDetailsMapper.dynamicSelect(updateOrderList);
			//insertOrderCancelDetails=(List<OrderCancelDetails>) compareListObject.compareListObject(insertOrderCancelDetails,existOrderCancelDetailsList);
			if (insertOrderCancelDetails.size() != 0) {
				orderCancelDetailsMapper.deletewithUpdate(insertOrderCancelDetails);
				orderCancelDetailsMapper.insertBatch(insertOrderCancelDetails);
			}
			List<OrderInfo> existOrderInfoLists=orderInfoMapper.dynamicSelect(updateOrderList);
			insertOrderInfo=(List<OrderInfo>) compareListObject.compareListObject(insertOrderInfo,existOrderInfoLists);
			if (insertOrderInfo.size() != 0) {
				orderInfoMapper.mergerBatch(insertOrderInfo);
			}
			
			
			//List<OrderMonetaryDetailsPayments> existOrderMonetaryDetailsPaymentsList=orderMonetaryDetailsPaymentsMapper.dynamicSelect(updateOrderList);
			//insertOrderMonetaryDetailsPayments=(List<OrderMonetaryDetailsPayments>)compareListObject.compareListObject(insertOrderMonetaryDetailsPayments,existOrderMonetaryDetailsPaymentsList);
			if (insertOrderMonetaryDetailsPayments.size() != 0) {
				orderMonetaryDetailsPaymentsMapper.deletewithUpdate(insertOrderMonetaryDetailsPayments);
				orderMonetaryDetailsPaymentsMapper.insertBatch(insertOrderMonetaryDetailsPayments);
			}
			
			//List<OrderMonetaryDetailsRefunds> exisOrderMonetaryDetailsRefundsList=orderMonetaryDetailsRefundsMapper.dynamicSelect(updateOrderList);
			//insertOrderMonetaryDetailsRefunds=(List<OrderMonetaryDetailsRefunds>) compareListObject.compareListObject(insertOrderMonetaryDetailsRefunds,exisOrderMonetaryDetailsRefundsList);
			if (insertOrderMonetaryDetailsRefunds.size() != 0) {
				orderMonetaryDetailsRefundsMapper.deletewithUpdate(insertOrderMonetaryDetailsRefunds);
				orderMonetaryDetailsRefundsMapper.insertBatch(insertOrderMonetaryDetailsRefunds);
			}
			
			List<OrderMultilegShippingDetails> existOrderMultilegShippingDetailsList=orderMultilegShippingDetailsMapper.dynamicSelect(updateOrderList);
			insertOrderMultilegShippingDetails=(List<OrderMultilegShippingDetails>) compareListObject.compareListObject(insertOrderMultilegShippingDetails,existOrderMultilegShippingDetailsList);
			if (insertOrderMultilegShippingDetails.size() != 0) {
				orderMultilegShippingDetailsMapper.mergerBatch(insertOrderMultilegShippingDetails);
			}
			
			List<OrderPaymentHoldDetails> existOrderPaymentHoldDetailsList=orderPaymentHoldDetailsMapper.dynamicSelect(updateOrderList);
			insertOrderPaymentHoldDetails=(List<OrderPaymentHoldDetails>)compareListObject.compareListObject(insertOrderPaymentHoldDetails,existOrderPaymentHoldDetailsList);
			if (insertOrderPaymentHoldDetails.size() != 0) {
				orderPaymentHoldDetailsMapper.mergerBatch(insertOrderPaymentHoldDetails);
			}
			
			//List<OrderPickupDetails> existOrderPickupDetailsList=orderPickupDetailsMapper.dynamicSelect(updateOrderList);
			//insertOrderPickupDetails=(List<OrderPickupDetails>) compareListObject.compareListObject(insertOrderPickupDetails,existOrderPickupDetailsList);
			if (insertOrderPickupDetails.size() != 0) {
				orderPickupDetailsMapper.deletewithUpdate(insertOrderPickupDetails);
				orderPickupDetailsMapper.insertBatch(insertOrderPickupDetails);
			}
			
			List<OrderRefundArray> existOrderRefundArrayList=orderRefundArrayMapper.dynamicSelect(updateOrderList);
			insertOrderRefundArray=(List<OrderRefundArray>)compareListObject.compareListObject(insertOrderRefundArray,existOrderRefundArrayList);
			if (insertOrderRefundArray.size() != 0) {
				orderRefundArrayMapper.mergerBatch(insertOrderRefundArray);
			}
			
			List<OrderShippingAddress> existOrderShippingAddressList=orderShippingAddressMapper.dynamicSelect(updateOrderList);
			insertOrderShippingAddress=(List<OrderShippingAddress>)compareListObject.compareListObject(insertOrderShippingAddress,existOrderShippingAddressList);
			if (insertOrderShippingAddress.size() != 0) {
				orderShippingAddressMapper.mergerBatch(insertOrderShippingAddress);
			}
			
			List<OrderShippingDetails> existOrderShippingDetailsList=orderShippingDetailsMapper.dynamicSelect(updateOrderList);
			insertOrderShippingDetails=(List<OrderShippingDetails>)compareListObject.compareListObject(insertOrderShippingDetails,existOrderShippingDetailsList);
			if (insertOrderShippingDetails.size() != 0) {
				orderShippingDetailsMapper.mergerBatch(insertOrderShippingDetails);
			}
			
			//List<OrderShippingDetailsIntlShippingServiceOption> existOrderShippingDetailsIntlShippingServiceOptionList=
				//	orderShippingDetailsIntlShippingServiceOptionMapper.dynamicSelect(updateOrderList);
			//insertOrderShippingDetailsIntlShippingServiceOption=(List<OrderShippingDetailsIntlShippingServiceOption>) 
				//	compareListObject.compareListObject(insertOrderShippingDetailsIntlShippingServiceOption,existOrderShippingDetailsIntlShippingServiceOptionList);
			if (insertOrderShippingDetailsIntlShippingServiceOption.size() != 0) {
				orderShippingDetailsIntlShippingServiceOptionMapper.deletewithUpdate(insertOrderShippingDetailsIntlShippingServiceOption);
				orderShippingDetailsIntlShippingServiceOptionMapper.insertBatch(insertOrderShippingDetailsIntlShippingServiceOption);
			}
			
			//List<OrderShippingDetailsShipmentTrackingDetails> existOrderShippingDetailsShipmentTrackingDetailsList=orderShippingDetailsShipmentTrackingDetailsMapper.dynamicSelect(updateOrderList);
			//insertOrderShippingDetailsShipmentTrackingDetails=(List<OrderShippingDetailsShipmentTrackingDetails>) 
				//	compareListObject.compareListObject(insertOrderShippingDetailsShipmentTrackingDetails,existOrderShippingDetailsShipmentTrackingDetailsList);
			if (insertOrderShippingDetailsShipmentTrackingDetails.size() != 0) {
				orderShippingDetailsShipmentTrackingDetailsMapper.deletewithUpdate(insertOrderShippingDetailsShipmentTrackingDetails);
				orderShippingDetailsShipmentTrackingDetailsMapper.insertBatch(insertOrderShippingDetailsShipmentTrackingDetails);
			}
			
			//List<OrderShippingDetailsShippingServiceOptions> existOrderShippingDetailsShippingServiceOptionsList=orderShippingDetailsShippingServiceOptionsMapper.dynamicSelect(updateOrderList);
			//insertOrderShippingDetailsShippingServiceOptions=(List<OrderShippingDetailsShippingServiceOptions>) compareListObject.compareListObject(insertOrderShippingDetailsShippingServiceOptions,existOrderShippingDetailsShippingServiceOptionsList);
			if (insertOrderShippingDetailsShippingServiceOptions.size() != 0) {
				orderShippingDetailsShippingServiceOptionsMapper.deletewithUpdate(insertOrderShippingDetailsShippingServiceOptions);
				orderShippingDetailsShippingServiceOptionsMapper.insertBatch(insertOrderShippingDetailsShippingServiceOptions);
			}
			
			List<OrderShippingServiceSelected> existOrderShippingServiceSelectedList=orderShippingServiceSelectedMapper.dynamicSelect(updateOrderList);
			insertOrderShippingServiceSelected=(List<OrderShippingServiceSelected>) compareListObject.compareListObject(insertOrderShippingServiceSelected,existOrderShippingServiceSelectedList);
			if (insertOrderShippingServiceSelected.size() != 0) {
				orderShippingServiceSelectedMapper.mergerBatch(insertOrderShippingServiceSelected);
			}
			
			List<OrderTransaction> existOrderTransactionList=orderTransactionMapper.dynamicSelect(updateOrderList);
			insertOrderTransaction=(List<OrderTransaction>) compareListObject.compareListObject(insertOrderTransaction,existOrderTransactionList);
			if (insertOrderTransaction.size() != 0) {
				orderTransactionMapper.mergerBatch(insertOrderTransaction);
			}
			
			List<OrderTransactionBuyer> existOrderTransactionBuyerList=orderTransactionBuyerMapper.dynamicSelect(updateOrderList);
			insertOrderTransactionBuyer=(List<OrderTransactionBuyer>)compareListObject.compareListObject(insertOrderTransactionBuyer,existOrderTransactionBuyerList);
			if (insertOrderTransactionBuyer.size() != 0) {
				orderTransactionBuyerMapper.mergerBatch(insertOrderTransactionBuyer);
			}
			
			List<OrderTransactionDigitalDeliverySelected> existOrderTransactionDigitalDeliverySelectedList=orderTransactionDigitalDeliverySelectedMapper.dynamicSelect(updateOrderList);
			insertOrderTransactionDigitalDeliverySelected=(List<OrderTransactionDigitalDeliverySelected>) 
					compareListObject.compareListObject(insertOrderTransactionDigitalDeliverySelected,existOrderTransactionDigitalDeliverySelectedList);
			if (insertOrderTransactionDigitalDeliverySelected.size() != 0) {
				orderTransactionDigitalDeliverySelectedMapper.mergerBatch(insertOrderTransactionDigitalDeliverySelected);
			}
			
			//List<OrderTransactionExternalTransaction> existOrderTransactionExternalTransactionList=
					//orderTransactionExternalTransactionMapper.dynamicSelect(updateOrderList);
			//insertOrderTransactionExternalTransaction=(List<OrderTransactionExternalTransaction>) 
					//compareListObject.compareListObject(insertOrderTransactionExternalTransaction,existOrderTransactionExternalTransactionList);
			if (insertOrderTransactionExternalTransaction.size() != 0) {
				orderTransactionExternalTransactionMapper.deletewithUpdate(insertOrderTransactionExternalTransaction);
				orderTransactionExternalTransactionMapper.insertBatch(insertOrderTransactionExternalTransaction);
			}
			
			List<OrderTransactionItem> existOrderTransactionItemList=orderTransactionItemMapper.dynamicSelect(updateOrderList);
			insertOrderTransactionItem=(List<OrderTransactionItem>) 
					compareListObject.compareListObject(insertOrderTransactionItem,existOrderTransactionItemList);
			if (insertOrderTransactionItem.size() != 0) {
				orderTransactionItemMapper.mergerBatch(insertOrderTransactionItem);
			}
			
			//List<OrderTransactionMonetaryDetailsPayments> existOrderTransactionMonetaryDetailsPaymentsList=
					//orderTransactionMonetaryDetailsPaymentsMapper.dynamicSelect(updateOrderList);
			//insertOrderTransactionMonetaryDetailsPayments=(List<OrderTransactionMonetaryDetailsPayments>) 
					//compareListObject.compareListObject(insertOrderTransactionMonetaryDetailsPayments,existOrderTransactionMonetaryDetailsPaymentsList);
			if (insertOrderTransactionMonetaryDetailsPayments.size() != 0) {
				orderTransactionMonetaryDetailsPaymentsMapper.deletewithUpdate(insertOrderTransactionMonetaryDetailsPayments);
				orderTransactionMonetaryDetailsPaymentsMapper.insertBatch(insertOrderTransactionMonetaryDetailsPayments);
			}
			
			//List<OrderTransactionMonetaryDetailsRefunds> existOrderTransactionMonetaryDetailsRefundsList=
					//orderTransactionMonetaryDetailsRefundsMapper.dynamicSelect(updateOrderList);
			//insertOrderTransactionMonetaryDetailsRefunds=(List<OrderTransactionMonetaryDetailsRefunds>) 
					//compareListObject.compareListObject(insertOrderTransactionMonetaryDetailsRefunds,existOrderTransactionMonetaryDetailsRefundsList);
			if (insertOrderTransactionMonetaryDetailsRefunds.size() != 0) {
				orderTransactionMonetaryDetailsRefundsMapper.deletewithUpdate(insertOrderTransactionMonetaryDetailsRefunds);
				orderTransactionMonetaryDetailsRefundsMapper.insertBatch(insertOrderTransactionMonetaryDetailsRefunds);
			}
			
			List<OrderTransactionMultilegShippingDetails> existOrderTransactionMultilegShippingDetailsList=
					orderTransactionMultilegShippingDetailsMapper.dynamicSelect(updateOrderList);
			insertOrderTransactionMultilegShippingDetails=(List<OrderTransactionMultilegShippingDetails>) compareListObject.compareListObject(insertOrderTransactionMultilegShippingDetails,existOrderTransactionMultilegShippingDetailsList);
			if (insertOrderTransactionMultilegShippingDetails.size() != 0) {
				orderTransactionMultilegShippingDetailsMapper.mergerBatch(insertOrderTransactionMultilegShippingDetails);
			}
			
			List<OrderTransactionPaymentHoldDetails> existOrderTransactionPaymentHoldDetailsList=
					orderTransactionPaymentHoldDetailsMapper.dynamicSelect(updateOrderList);
			insertOrderTransactionPaymentHoldDetails=(List<OrderTransactionPaymentHoldDetails>) 
					compareListObject.compareListObject(insertOrderTransactionPaymentHoldDetails,existOrderTransactionPaymentHoldDetailsList);
			if (insertOrderTransactionPaymentHoldDetails.size() != 0) {
				orderTransactionPaymentHoldDetailsMapper.mergerBatch(insertOrderTransactionPaymentHoldDetails);
			}
			
			List<OrderTransactionRefundArray> existOrderTransactionRefundArraylist=orderTransactionRefundArrayMapper.dynamicSelect(updateOrderList);
			insertOrderTransactionRefundArray=(List<OrderTransactionRefundArray>) 
					compareListObject.compareListObject(insertOrderTransactionRefundArray,existOrderTransactionRefundArraylist);
			if (insertOrderTransactionRefundArray.size() != 0) {
				orderTransactionRefundArrayMapper.mergerBatch(insertOrderTransactionRefundArray);
			}
			
			//List<OrderTransactionSellerDiscount> existOrderTransactionSellerDiscountList=orderTransactionSellerDiscountMapper.dynamicSelect(updateOrderList);
			//insertOrderTransactionSellerDiscount=(List<OrderTransactionSellerDiscount>) compareListObject.compareListObject(insertOrderTransactionSellerDiscount,existOrderTransactionSellerDiscountList);
			if (insertOrderTransactionSellerDiscount.size() != 0) {
				orderTransactionSellerDiscountMapper.deletewithUpdate(insertOrderTransactionSellerDiscount);
				orderTransactionSellerDiscountMapper.insertBatch(insertOrderTransactionSellerDiscount);
			}
			
			List<OrderTransactionShippingDetails> existOrderTransactionShippingDetails=
					orderTransactionShippingDetailsMapper.dynamicSelect(updateOrderList);
			insertOrderTransactionShippingDetails=(List<OrderTransactionShippingDetails>) 
					compareListObject.compareListObject(insertOrderTransactionShippingDetails,existOrderTransactionShippingDetails);
			if (insertOrderTransactionShippingDetails.size() != 0) {
				orderTransactionShippingDetailsMapper.mergerBatch(insertOrderTransactionShippingDetails);
			}
			
			//List<OrderTransactionShippingDetailsIntlShippingServiceOption> existOrderTransactionShippingDetailsIntlShippingServiceOptionList=
					//orderTransactionShippingDetailsIntlShippingServiceOptionMapper.dynamicSelect(updateOrderList);
			//insertOrderTransactionShippingDetailsIntlShippingServiceOption=(List<OrderTransactionShippingDetailsIntlShippingServiceOption>) 
					//compareListObject.compareListObject(insertOrderTransactionShippingDetailsIntlShippingServiceOption,existOrderTransactionShippingDetailsIntlShippingServiceOptionList);
			if (insertOrderTransactionShippingDetailsIntlShippingServiceOption.size() != 0) {
				orderTransactionShippingDetailsIntlShippingServiceOptionMapper.deletewithUpdate(insertOrderTransactionShippingDetailsIntlShippingServiceOption);
				orderTransactionShippingDetailsIntlShippingServiceOptionMapper.insertBatch(insertOrderTransactionShippingDetailsIntlShippingServiceOption);
			}
			
			//List<OrderTransactionShippingDetailsShipmentTrackingDetails> existOrderTransactionShippingDetailsShipmentTrackingDetailsList=
					//orderTransactionShippingDetailsShipmentTrackingDetailsMapper.dynamicSelect(updateOrderList);
			//insertOrderTransactionShippingDetailsShipmentTrackingDetails=(List<OrderTransactionShippingDetailsShipmentTrackingDetails>) 
					//compareListObject.compareListObject(insertOrderTransactionShippingDetailsShipmentTrackingDetails,existOrderTransactionShippingDetailsShipmentTrackingDetailsList);
			if (insertOrderTransactionShippingDetailsShipmentTrackingDetails.size() != 0) {
				orderTransactionShippingDetailsShipmentTrackingDetailsMapper.deletewithUpdate(insertOrderTransactionShippingDetailsShipmentTrackingDetails);
				orderTransactionShippingDetailsShipmentTrackingDetailsMapper.insertBatch(insertOrderTransactionShippingDetailsShipmentTrackingDetails);
			}
			
			//List<OrderTransactionShippingDetailsShippingServiceOptions> existOrderTransactionShippingDetailsShippingServiceOptionsList=
					//orderTransactionShippingDetailsShippingServiceOptionsMapper.dynamicSelect(updateOrderList);
			//insertOrderTransactionShippingDetailsShippingServiceOptions=(List<OrderTransactionShippingDetailsShippingServiceOptions>) 
					//compareListObject.compareListObject(insertOrderTransactionShippingDetailsShippingServiceOptions,existOrderTransactionShippingDetailsShippingServiceOptionsList);
			if (insertOrderTransactionShippingDetailsShippingServiceOptions.size() != 0) {
				orderTransactionShippingDetailsShippingServiceOptionsMapper.deletewithUpdate(insertOrderTransactionShippingDetailsShippingServiceOptions);
				orderTransactionShippingDetailsShippingServiceOptionsMapper.insertBatch(insertOrderTransactionShippingDetailsShippingServiceOptions);
			}
			
			List<OrderTransactionShippingServiceSelected> existOrderTransactionShippingServiceSelectedList=
					orderTransactionShippingServiceSelectedMapper.dynamicSelect(updateOrderList);
			insertOrderTransactionShippingServiceSelected=(List<OrderTransactionShippingServiceSelected>) 
					compareListObject.compareListObject(insertOrderTransactionShippingServiceSelected,existOrderTransactionShippingServiceSelectedList);
			if (insertOrderTransactionShippingServiceSelected.size() != 0) {
				orderTransactionShippingServiceSelectedMapper.mergerBatch(insertOrderTransactionShippingServiceSelected);
			}
			
			//List<OrderTransactionTaxes> existOrderTransactionTaxesList=orderTransactionTaxesMapper.dynamicSelect(updateOrderList);
			//insertOrderTransactionTaxes=(List<OrderTransactionTaxes>) compareListObject.compareListObject(insertOrderTransactionTaxes,existOrderTransactionTaxesList);
			if (insertOrderTransactionTaxes.size() != 0) {
				orderTransactionTaxesMapper.deletewithUpdate(insertOrderTransactionTaxes);
				orderTransactionTaxesMapper.insertBatch(insertOrderTransactionTaxes);
			}
			
			//List<OrderTransactionVariation> existOrderTransactionVariationList=orderTransactionVariationMapper.dynamicSelect(updateOrderList);
			//insertOrderTransactionVariation=(List<OrderTransactionVariation>) 
					//compareListObject.compareListObject(insertOrderTransactionVariation,existOrderTransactionVariationList);
			if (insertOrderTransactionVariation.size() != 0) {
				orderTransactionVariationMapper.deletewithUpdate(insertOrderTransactionVariation);
				orderTransactionVariationMapper.insertBatch(insertOrderTransactionVariation);
			}
			System.out.println(System.currentTimeMillis());
		}
	}
	
}
