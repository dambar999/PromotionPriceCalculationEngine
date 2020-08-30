package com.commerce.calculationenginee;

public class Item {
    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    private Product product;
    private int quantity;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProductId(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void updateQuantity(){}
}
