package yk.boxri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yk.boxri.pojo.OrderTransactionExternalTransaction;



public interface OrderTransactionExternalTransactionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_external_transaction
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(@Param("transaction_id") String transaction_id, @Param("transaction_external_transaction_id") Integer transaction_external_transaction_id);

    
    int deletewithUpdate(List<OrderTransactionExternalTransaction> recordLst);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_external_transaction
     *
     * @mbggenerated
     */
    int insert(OrderTransactionExternalTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_external_transaction
     *
     * @mbggenerated
     */
    OrderTransactionExternalTransaction selectByPrimaryKey(@Param("transaction_id") String transaction_id, @Param("transaction_external_transaction_id") Integer transaction_external_transaction_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_external_transaction
     *
     * @mbggenerated
     */
    List<OrderTransactionExternalTransaction> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_external_transaction
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderTransactionExternalTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_transaction_external_transaction
     *
     * @mbggenerated
     */
    void insertBatch(List<OrderTransactionExternalTransaction> recordLst);
    
    
    List<OrderTransactionExternalTransaction> dynamicSelect(List<String> updateOrderList);

}