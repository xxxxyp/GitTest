package yk.boxri.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import yk.boxri.pojo.OrderTransactionShippingServiceSelected;



public interface OrderTransactionShippingServiceSelectedMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_shipping_service_selected
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String transaction_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_shipping_service_selected
     *
     * @mbggenerated
     */
    int insert(OrderTransactionShippingServiceSelected record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_shipping_service_selected
     *
     * @mbggenerated
     */
    OrderTransactionShippingServiceSelected selectByPrimaryKey(String transaction_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_shipping_service_selected
     *
     * @mbggenerated
     */
    List<OrderTransactionShippingServiceSelected> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_shipping_service_selected
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderTransactionShippingServiceSelected record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_shipping_service_selected
     *
     * @mbggenerated
     */
    void insertBatch(List<OrderTransactionShippingServiceSelected> recordLst);
    
    
    
    void mergerBatch(List<OrderTransactionShippingServiceSelected> recordLst);

    
    
    List<OrderTransactionShippingServiceSelected> dynamicSelect(List<String> updateOrderList);
}