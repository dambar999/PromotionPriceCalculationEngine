package com.commerce.offer;

import com.commerce.calculationenginee.Item;

public class A3for130 implements SingleOfferI {

    @Override
    public double calculatePrice(Item item)
    {
     double totalPrice;
       int totQuantity= item.getQuantity();
       if(totQuantity>=3){
           int totalOffer=totQuantity/3;
           int remainingQuantity=totQuantity%3;
            totalPrice=totalOffer*130+item.getProduct().getUnitPrice()*remainingQuantity;

       }
       else{
           totalPrice=totQuantity*item.getProduct().getUnitPrice();
       }
       return totalPrice;
    }
}
