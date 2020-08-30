package com.commerce.offer;

import com.commerce.calculationenginee.Product;

import java.util.HashMap;

public class Promotion {

    HashMap<String, DiscountType> currentPromotion;

    public HashMap<String, DiscountType> getCurrentPromotion() {
        return currentPromotion;
    }

    public void setCurrentPromotion() {
        this.currentPromotion = new HashMap<>();
        currentPromotion.put("A", DiscountType.A3for130);
        currentPromotion.put("B", DiscountType.B2for45);
        currentPromotion.put("C-D", DiscountType.CDfor30);
    }









}
