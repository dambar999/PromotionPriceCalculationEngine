package com.commerce.offer;

import com.commerce.calculationenginee.Item;

public class B2for45 implements SingleOfferI {
    @Override
    public double calculatePrice(Item item)
    {
        double totalPrice;
        int totQuantity= item.getQuantity();
        if(totQuantity>=2){
            int totalOffer=totQuantity/2;
            int remainingQuantity=totQuantity%2;
            totalPrice=totalOffer*45+item.getProduct().getUnitPrice()*remainingQuantity;

        }
        else{
            totalPrice=totQuantity*item.getProduct().getUnitPrice();
        }
        return totalPrice;
    }
}
