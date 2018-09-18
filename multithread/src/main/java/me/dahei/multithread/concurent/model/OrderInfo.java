package me.dahei.multithread.concurent.model;

/**
 * created by yubosu
 * 2018年09月18日下午3:27
 */
public class OrderInfo {
    private String customerInfo;
    private String discountInfo;
    private String foodListInfo;
    private String tenantInfo;
    private String otherInfo;

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public String getDiscountInfo() {
        return discountInfo;
    }

    public void setDiscountInfo(String discountInfo) {
        this.discountInfo = discountInfo;
    }

    public String getFoodListInfo() {
        return foodListInfo;
    }

    public void setFoodListInfo(String foodListInfo) {
        this.foodListInfo = foodListInfo;
    }

    public String getTenantInfo() {
        return tenantInfo;
    }

    public void setTenantInfo(String tenantInfo) {
        this.tenantInfo = tenantInfo;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}
