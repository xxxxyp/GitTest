package yk.boxri.pojo;

import java.io.Serializable;

public class OrderPickupDetails implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_pickup_details.order_id
     *
     * @mbggenerated
     */
    public String order_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_pickup_details.order_pickup_details_id
     *
     * @mbggenerated
     */
    public Integer order_pickup_details_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_pickup_details.user_id
     *
     * @mbggenerated
     */
    public Integer user_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_pickup_details.shop_id
     *
     * @mbggenerated
     */
    public Integer shop_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_pickup_details.pickup_method
     *
     * @mbggenerated
     */
    public String pickup_method;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_pickup_details.pickup_priority
     *
     * @mbggenerated
     */
    public Integer pickup_priority;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_pickup_details
     *
     * @mbggenerated
     */
    public static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_pickup_details.order_id
     *
     * @return the value of order_pickup_details.order_id
     *
     * @mbggenerated
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_pickup_details.order_id
     *
     * @param order_id the value for order_pickup_details.order_id
     *
     * @mbggenerated
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id == null ? null : order_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_pickup_details.order_pickup_details_id
     *
     * @return the value of order_pickup_details.order_pickup_details_id
     *
     * @mbggenerated
     */
    public Integer getOrder_pickup_details_id() {
        return order_pickup_details_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_pickup_details.order_pickup_details_id
     *
     * @param order_pickup_details_id the value for order_pickup_details.order_pickup_details_id
     *
     * @mbggenerated
     */
    public void setOrder_pickup_details_id(Integer order_pickup_details_id) {
        this.order_pickup_details_id = order_pickup_details_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_pickup_details.user_id
     *
     * @return the value of order_pickup_details.user_id
     *
     * @mbggenerated
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_pickup_details.user_id
     *
     * @param user_id the value for order_pickup_details.user_id
     *
     * @mbggenerated
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_pickup_details.shop_id
     *
     * @return the value of order_pickup_details.shop_id
     *
     * @mbggenerated
     */
    public Integer getShop_id() {
        return shop_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_pickup_details.shop_id
     *
     * @param shop_id the value for order_pickup_details.shop_id
     *
     * @mbggenerated
     */
    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_pickup_details.pickup_method
     *
     * @return the value of order_pickup_details.pickup_method
     *
     * @mbggenerated
     */
    public String getPickup_method() {
        return pickup_method;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_pickup_details.pickup_method
     *
     * @param pickup_method the value for order_pickup_details.pickup_method
     *
     * @mbggenerated
     */
    public void setPickup_method(String pickup_method) {
        this.pickup_method = pickup_method == null ? null : pickup_method.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_pickup_details.pickup_priority
     *
     * @return the value of order_pickup_details.pickup_priority
     *
     * @mbggenerated
     */
    public Integer getPickup_priority() {
        return pickup_priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_pickup_details.pickup_priority
     *
     * @param pickup_priority the value for order_pickup_details.pickup_priority
     *
     * @mbggenerated
     */
    public void setPickup_priority(Integer pickup_priority) {
        this.pickup_priority = pickup_priority;
    }
}