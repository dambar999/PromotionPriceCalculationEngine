package com.commerce.calculationenginee;

public class Product {
    public Product(String productId, String productName, String productDescribtion, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productDescribtion = productDescribtion;
        this.unitPrice = unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescribtion() {
        return productDescribtion;
    }

    public void setProductDescribtion(String productDescribtion) {
        this.productDescribtion = productDescribtion;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    private String productId;
    private String productName;
    private String productDescribtion;
    private double  unitPrice;
}
