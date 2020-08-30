package com.commerce.offer;

import com.commerce.calculationenginee.Item;

public class CDfor30 implements  MultipleSKUOfferI {

    @Override
    public double calculatePrice(Item item1, Item item2 )
    {
        double totalPrice;
        int item1Quantity= item1.getQuantity();
        int item2Quantity= item2.getQuantity();
    // int smaller =item1.getQuantity()>item2.getQuantity()?   item2.getQuantity():item1.getQuantity();
      if(item2Quantity==item1Quantity){
          totalPrice=item2Quantity*30;
     }
      else if(item2Quantity>item1Quantity){
          totalPrice= item1Quantity*30+(item2Quantity-item1Quantity)*item2.getProduct().getUnitPrice();
      }
      else{
          totalPrice= item2Quantity*30+(item1Quantity-item2Quantity)*item1.getProduct().getUnitPrice();
      }

   return totalPrice;

    }
}
