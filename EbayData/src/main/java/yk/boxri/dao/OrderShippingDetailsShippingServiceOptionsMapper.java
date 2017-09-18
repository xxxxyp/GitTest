package yk.boxri.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yk.boxri.pojo.OrderShippingDetailsShippingServiceOptions;



public interface OrderShippingDetailsShippingServiceOptionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping_details_shipping_service_options
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(@Param("order_id") String order_id, @Param("order_shipping_details_shipping_service_options_id") Integer order_shipping_details_shipping_service_options_id);

    int deletewithUpdate(List<OrderShippingDetailsShippingServiceOptions> recordLst);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping_details_shipping_service_options
     *
     * @mbggenerated
     */
    int insert(OrderShippingDetailsShippingServiceOptions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping_details_shipping_service_options
     *
     * @mbggenerated
     */
    OrderShippingDetailsShippingServiceOptions selectByPrimaryKey(@Param("order_id") String order_id, @Param("order_shipping_details_shipping_service_options_id") Integer order_shipping_details_shipping_service_options_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping_details_shipping_service_options
     *
     * @mbggenerated
     */
    List<OrderShippingDetailsShippingServiceOptions> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping_details_shipping_service_options
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderShippingDetailsShippingServiceOptions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping_details_shipping_service_options
     *
     * @mbggenerated
     */
    void insertBatch(List<OrderShippingDetailsShippingServiceOptions> recordLst);
    
    List<OrderShippingDetailsShippingServiceOptions> dynamicSelect(List<String> updateOrderList);

}