package yk.boxri.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import yk.boxri.pojo.OrderInfo;

public interface OrderInfoMapper {
	
    int deleteByPrimaryKey(String order_id);

    int insert(OrderInfo record);

    OrderInfo selectByPrimaryKey(String order_id);

    List<OrderInfo> selectAll();

    int updateByPrimaryKey(OrderInfo record);
    
    void insertBatch(List<OrderInfo> recordLst);
    
    void mergerBatch(List<OrderInfo> recordLst);
    
    List<String> dynamicSelectId(List<String> isExistsList);
    
    List<OrderInfo> dynamicSelect(List<String> updateOrderList); 
}