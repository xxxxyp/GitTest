package yk.boxri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yk.boxri.pojo.OrderTransactionRefundArray;



public interface OrderTransactionRefundArrayMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_refund_array
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(@Param("transaction_id") String transaction_id, @Param("transaction_refund_id") Integer transaction_refund_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_refund_array
     *
     * @mbggenerated
     */
    int insert(OrderTransactionRefundArray record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_refund_array
     *
     * @mbggenerated
     */
    OrderTransactionRefundArray selectByPrimaryKey(@Param("transaction_id") String transaction_id, @Param("transaction_refund_id") Integer transaction_refund_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_refund_array
     *
     * @mbggenerated
     */
    List<OrderTransactionRefundArray> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_refund_array
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderTransactionRefundArray record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_refund_array
     *
     * @mbggenerated
     */
    void insertBatch(List<OrderTransactionRefundArray> recordLst);
    
    
    
    void mergerBatch(List<OrderTransactionRefundArray> recordLst);

    
    
    List<OrderTransactionRefundArray> dynamicSelect(List<String> updateOrderList);
}