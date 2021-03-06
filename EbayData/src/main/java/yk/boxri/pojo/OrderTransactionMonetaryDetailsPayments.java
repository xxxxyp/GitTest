package yk.boxri.pojo;

import java.io.Serializable;
import java.util.Date;

public class OrderTransactionMonetaryDetailsPayments implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.transaction_id
     *
     * @mbggenerated
     */
    public String transaction_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.transaction_monetary_details_payment_id
     *
     * @mbggenerated
     */
    public Integer transaction_monetary_details_payment_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.order_id
     *
     * @mbggenerated
     */
    public String order_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.user_id
     *
     * @mbggenerated
     */
    public Integer user_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.shop_id
     *
     * @mbggenerated
     */
    public Integer shop_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.fee_or_credit_amount
     *
     * @mbggenerated
     */
    public Double fee_or_credit_amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.fee_or_credit_amount_currency_id
     *
     * @mbggenerated
     */
    public String fee_or_credit_amount_currency_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.payee
     *
     * @mbggenerated
     */
    public String payee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.payee_attribute_type
     *
     * @mbggenerated
     */
    public String payee_attribute_type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.payer
     *
     * @mbggenerated
     */
    public String payer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.payer_attribute_type
     *
     * @mbggenerated
     */
    public String payer_attribute_type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.payment_amount
     *
     * @mbggenerated
     */
    public Double payment_amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.payment_amount_currency_id
     *
     * @mbggenerated
     */
    public String payment_amount_currency_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.payment_reference_id_values
     *
     * @mbggenerated
     */
    public String payment_reference_id_values;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.payment_status
     *
     * @mbggenerated
     */
    public String payment_status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.payment_time
     *
     * @mbggenerated
     */
    public Date payment_time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.reference_id
     *
     * @mbggenerated
     */
    public String reference_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_transaction_monetary_details_payments.reference_id_attribute_type
     *
     * @mbggenerated
     */
    public String reference_id_attribute_type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_transaction_monetary_details_payments
     *
     * @mbggenerated
     */
    public static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.transaction_id
     *
     * @return the value of order_transaction_monetary_details_payments.transaction_id
     *
     * @mbggenerated
     */
    public String getTransaction_id() {
        return transaction_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.transaction_id
     *
     * @param transaction_id the value for order_transaction_monetary_details_payments.transaction_id
     *
     * @mbggenerated
     */
    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id == null ? null : transaction_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.transaction_monetary_details_payment_id
     *
     * @return the value of order_transaction_monetary_details_payments.transaction_monetary_details_payment_id
     *
     * @mbggenerated
     */
    public Integer getTransaction_monetary_details_payment_id() {
        return transaction_monetary_details_payment_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.transaction_monetary_details_payment_id
     *
     * @param transaction_monetary_details_payment_id the value for order_transaction_monetary_details_payments.transaction_monetary_details_payment_id
     *
     * @mbggenerated
     */
    public void setTransaction_monetary_details_payment_id(Integer transaction_monetary_details_payment_id) {
        this.transaction_monetary_details_payment_id = transaction_monetary_details_payment_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.order_id
     *
     * @return the value of order_transaction_monetary_details_payments.order_id
     *
     * @mbggenerated
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.order_id
     *
     * @param order_id the value for order_transaction_monetary_details_payments.order_id
     *
     * @mbggenerated
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id == null ? null : order_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.user_id
     *
     * @return the value of order_transaction_monetary_details_payments.user_id
     *
     * @mbggenerated
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.user_id
     *
     * @param user_id the value for order_transaction_monetary_details_payments.user_id
     *
     * @mbggenerated
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.shop_id
     *
     * @return the value of order_transaction_monetary_details_payments.shop_id
     *
     * @mbggenerated
     */
    public Integer getShop_id() {
        return shop_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.shop_id
     *
     * @param shop_id the value for order_transaction_monetary_details_payments.shop_id
     *
     * @mbggenerated
     */
    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.fee_or_credit_amount
     *
     * @return the value of order_transaction_monetary_details_payments.fee_or_credit_amount
     *
     * @mbggenerated
     */
    public Double getFee_or_credit_amount() {
        return fee_or_credit_amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.fee_or_credit_amount
     *
     * @param fee_or_credit_amount the value for order_transaction_monetary_details_payments.fee_or_credit_amount
     *
     * @mbggenerated
     */
    public void setFee_or_credit_amount(Double fee_or_credit_amount) {
        this.fee_or_credit_amount = fee_or_credit_amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.fee_or_credit_amount_currency_id
     *
     * @return the value of order_transaction_monetary_details_payments.fee_or_credit_amount_currency_id
     *
     * @mbggenerated
     */
    public String getFee_or_credit_amount_currency_id() {
        return fee_or_credit_amount_currency_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.fee_or_credit_amount_currency_id
     *
     * @param fee_or_credit_amount_currency_id the value for order_transaction_monetary_details_payments.fee_or_credit_amount_currency_id
     *
     * @mbggenerated
     */
    public void setFee_or_credit_amount_currency_id(String fee_or_credit_amount_currency_id) {
        this.fee_or_credit_amount_currency_id = fee_or_credit_amount_currency_id == null ? null : fee_or_credit_amount_currency_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.payee
     *
     * @return the value of order_transaction_monetary_details_payments.payee
     *
     * @mbggenerated
     */
    public String getPayee() {
        return payee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.payee
     *
     * @param payee the value for order_transaction_monetary_details_payments.payee
     *
     * @mbggenerated
     */
    public void setPayee(String payee) {
        this.payee = payee == null ? null : payee.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.payee_attribute_type
     *
     * @return the value of order_transaction_monetary_details_payments.payee_attribute_type
     *
     * @mbggenerated
     */
    public String getPayee_attribute_type() {
        return payee_attribute_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.payee_attribute_type
     *
     * @param payee_attribute_type the value for order_transaction_monetary_details_payments.payee_attribute_type
     *
     * @mbggenerated
     */
    public void setPayee_attribute_type(String payee_attribute_type) {
        this.payee_attribute_type = payee_attribute_type == null ? null : payee_attribute_type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.payer
     *
     * @return the value of order_transaction_monetary_details_payments.payer
     *
     * @mbggenerated
     */
    public String getPayer() {
        return payer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.payer
     *
     * @param payer the value for order_transaction_monetary_details_payments.payer
     *
     * @mbggenerated
     */
    public void setPayer(String payer) {
        this.payer = payer == null ? null : payer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.payer_attribute_type
     *
     * @return the value of order_transaction_monetary_details_payments.payer_attribute_type
     *
     * @mbggenerated
     */
    public String getPayer_attribute_type() {
        return payer_attribute_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.payer_attribute_type
     *
     * @param payer_attribute_type the value for order_transaction_monetary_details_payments.payer_attribute_type
     *
     * @mbggenerated
     */
    public void setPayer_attribute_type(String payer_attribute_type) {
        this.payer_attribute_type = payer_attribute_type == null ? null : payer_attribute_type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.payment_amount
     *
     * @return the value of order_transaction_monetary_details_payments.payment_amount
     *
     * @mbggenerated
     */
    public Double getPayment_amount() {
        return payment_amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.payment_amount
     *
     * @param payment_amount the value for order_transaction_monetary_details_payments.payment_amount
     *
     * @mbggenerated
     */
    public void setPayment_amount(Double payment_amount) {
        this.payment_amount = payment_amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.payment_amount_currency_id
     *
     * @return the value of order_transaction_monetary_details_payments.payment_amount_currency_id
     *
     * @mbggenerated
     */
    public String getPayment_amount_currency_id() {
        return payment_amount_currency_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.payment_amount_currency_id
     *
     * @param payment_amount_currency_id the value for order_transaction_monetary_details_payments.payment_amount_currency_id
     *
     * @mbggenerated
     */
    public void setPayment_amount_currency_id(String payment_amount_currency_id) {
        this.payment_amount_currency_id = payment_amount_currency_id == null ? null : payment_amount_currency_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.payment_reference_id_values
     *
     * @return the value of order_transaction_monetary_details_payments.payment_reference_id_values
     *
     * @mbggenerated
     */
    public String getPayment_reference_id_values() {
        return payment_reference_id_values;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.payment_reference_id_values
     *
     * @param payment_reference_id_values the value for order_transaction_monetary_details_payments.payment_reference_id_values
     *
     * @mbggenerated
     */
    public void setPayment_reference_id_values(String payment_reference_id_values) {
        this.payment_reference_id_values = payment_reference_id_values == null ? null : payment_reference_id_values.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.payment_status
     *
     * @return the value of order_transaction_monetary_details_payments.payment_status
     *
     * @mbggenerated
     */
    public String getPayment_status() {
        return payment_status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.payment_status
     *
     * @param payment_status the value for order_transaction_monetary_details_payments.payment_status
     *
     * @mbggenerated
     */
    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status == null ? null : payment_status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.payment_time
     *
     * @return the value of order_transaction_monetary_details_payments.payment_time
     *
     * @mbggenerated
     */
    public Date getPayment_time() {
        return payment_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.payment_time
     *
     * @param payment_time the value for order_transaction_monetary_details_payments.payment_time
     *
     * @mbggenerated
     */
    public void setPayment_time(Date payment_time) {
        this.payment_time = payment_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.reference_id
     *
     * @return the value of order_transaction_monetary_details_payments.reference_id
     *
     * @mbggenerated
     */
    public String getReference_id() {
        return reference_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.reference_id
     *
     * @param reference_id the value for order_transaction_monetary_details_payments.reference_id
     *
     * @mbggenerated
     */
    public void setReference_id(String reference_id) {
        this.reference_id = reference_id == null ? null : reference_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_transaction_monetary_details_payments.reference_id_attribute_type
     *
     * @return the value of order_transaction_monetary_details_payments.reference_id_attribute_type
     *
     * @mbggenerated
     */
    public String getReference_id_attribute_type() {
        return reference_id_attribute_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_transaction_monetary_details_payments.reference_id_attribute_type
     *
     * @param reference_id_attribute_type the value for order_transaction_monetary_details_payments.reference_id_attribute_type
     *
     * @mbggenerated
     */
    public void setReference_id_attribute_type(String reference_id_attribute_type) {
        this.reference_id_attribute_type = reference_id_attribute_type == null ? null : reference_id_attribute_type.trim();
    }
}