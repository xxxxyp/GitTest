package yk.boxri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yk.boxri.pojo.OrderTransaction;



public interface OrderTransactionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(@Param("order_id") String order_id, @Param("transaction_id") String transaction_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction
     *
     * @mbggenerated
     */
    int insert(OrderTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction
     *
     * @mbggenerated
     */
    OrderTransaction selectByPrimaryKey(@Param("order_id") String order_id, @Param("transaction_id") String transaction_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction
     *
     * @mbggenerated
     */
    List<OrderTransaction> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction
     *
     * @mbggenerated
     */
    void insertBatch(List<OrderTransaction> recordLst);
    
    
    void mergerBatch(List<OrderTransaction> recordLst);

    
    List<OrderTransaction> dynamicSelect(List<String> updateOrderList);

}