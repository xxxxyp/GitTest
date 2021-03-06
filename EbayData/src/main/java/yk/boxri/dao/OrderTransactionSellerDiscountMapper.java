package yk.boxri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yk.boxri.pojo.OrderTransactionSellerDiscount;



public interface OrderTransactionSellerDiscountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_seller_discount
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(@Param("transaction_id") String transaction_id, @Param("transaction_seller_discount_id") Integer transaction_seller_discount_id);

    
    int deletewithUpdate(List<OrderTransactionSellerDiscount> recordLst);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_seller_discount
     *
     * @mbggenerated
     */
    int insert(OrderTransactionSellerDiscount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_seller_discount
     *
     * @mbggenerated
     */
    OrderTransactionSellerDiscount selectByPrimaryKey(@Param("transaction_id") String transaction_id, @Param("transaction_seller_discount_id") Integer transaction_seller_discount_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_seller_discount
     *
     * @mbggenerated
     */
    List<OrderTransactionSellerDiscount> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_seller_discount
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderTransactionSellerDiscount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_seller_discount
     *
     * @mbggenerated
     */
    void insertBatch(List<OrderTransactionSellerDiscount> recordLst);
    
    
    List<OrderTransactionSellerDiscount> dynamicSelect(List<String> updateOrderList);
}