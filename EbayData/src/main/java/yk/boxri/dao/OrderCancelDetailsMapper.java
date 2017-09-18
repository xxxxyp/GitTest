package yk.boxri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yk.boxri.pojo.OrderCancelDetails;


public interface OrderCancelDetailsMapper {
	
    int deleteByPrimaryKey(@Param("order_id") String order_id, @Param("order_cancel_details_id") Integer order_cancel_details_id);
    
    int deletewithUpdate(List<OrderCancelDetails> recordLst);
    
    int insert(OrderCancelDetails record);
    
    OrderCancelDetails selectByPrimaryKey(@Param("order_id") String order_id, @Param("order_cancel_details_id") Integer order_cancel_details_id);
    
    List<OrderCancelDetails> selectAll();
    
    int updateByPrimaryKey(OrderCancelDetails record);
    
    void insertBatch(List<OrderCancelDetails> recordLst);
    
    List<OrderCancelDetails> dynamicSelect(List<String> updateOrderList);
}