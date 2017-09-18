package yk.boxri.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import yk.boxri.pojo.OrderMultilegShippingDetails;


public interface OrderMultilegShippingDetailsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_multileg_shipping_details
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String order_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_multileg_shipping_details
     *
     * @mbggenerated
     */
    int insert(OrderMultilegShippingDetails record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_multileg_shipping_details
     *
     * @mbggenerated
     */
    OrderMultilegShippingDetails selectByPrimaryKey(String order_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_multileg_shipping_details
     *
     * @mbggenerated
     */
    List<OrderMultilegShippingDetails> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_multileg_shipping_details
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderMultilegShippingDetails record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_multileg_shipping_details
     *
     * @mbggenerated
     */
    void insertBatch(List<OrderMultilegShippingDetails> recordLst);
    
    
    void mergerBatch(List<OrderMultilegShippingDetails> recordLst);
    
    
    List<OrderMultilegShippingDetails> dynamicSelect(List<String> updateOrderList);
}