package yk.boxri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yk.boxri.pojo.OrderTransactionMonetaryDetailsPayments;



public interface OrderTransactionMonetaryDetailsPaymentsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_monetary_details_payments
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(@Param("transaction_id") String transaction_id, @Param("transaction_monetary_details_payment_id") Integer transaction_monetary_details_payment_id);

    
    int deletewithUpdate(List<OrderTransactionMonetaryDetailsPayments> recordLst);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_monetary_details_payments
     *
     * @mbggenerated
     */
    int insert(OrderTransactionMonetaryDetailsPayments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_monetary_details_payments
     *
     * @mbggenerated
     */
    OrderTransactionMonetaryDetailsPayments selectByPrimaryKey(@Param("transaction_id") String transaction_id, @Param("transaction_monetary_details_payment_id") Integer transaction_monetary_details_payment_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_monetary_details_payments
     *
     * @mbggenerated
     */
    List<OrderTransactionMonetaryDetailsPayments> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_monetary_details_payments
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderTransactionMonetaryDetailsPayments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_monetary_details_payments
     *
     * @mbggenerated
     */
    void insertBatch(List<OrderTransactionMonetaryDetailsPayments> recordLst);
    
    
    List<OrderTransactionMonetaryDetailsPayments> dynamicSelect(List<String> updateOrderList);
}