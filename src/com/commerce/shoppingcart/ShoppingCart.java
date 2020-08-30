package com.commerce.shoppingcart;

import com.commerce.calculationenginee.Item;
import com.commerce.calculationenginee.Product;
import com.commerce.offer.A3for130;
import com.commerce.offer.B2for45;
import com.commerce.offer.CDfor30;
import com.commerce.offer.DiscountType;
import com.commerce.offer.MultipleSKUOfferI;
import com.commerce.offer.Promotion;
import com.commerce.offer.SingleOfferI;
import com.sun.tools.javac.jvm.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
   static  HashMap<DiscountType,SingleOfferI>offerMaping=new HashMap<>();
    static  HashMap<DiscountType,MultipleSKUOfferI>offerMapingMultiple=new HashMap<>();

    static List<Item> items=new ArrayList<>();
    public void addItems(Item item){}
    public void removeItem(Item item){}
    public void  updateQuantityItem(Item item ,int quantity){}
    public List<Item> getItems(){return  items;}

     static double totalPrice;

    public   static void checkout(Promotion promotion){
        List<Item> itemsCopy= items;

        //apply promotion on single sku and add to totalprice on cart
        for(int i=0;i<items.size();i++){
            String ProductId=items.get(i).getProduct().getProductName();
                if (promotion.getCurrentPromotion().containsKey(ProductId)){
                        SingleOfferI singleOfferI= offerMaping.get(promotion.getCurrentPromotion().get(ProductId));

                    totalPrice=totalPrice+singleOfferI.calculatePrice(items.get(i));
                }
           // itemsCopy.remove(i);
        }
        String  key;

        //apply promotion on multiple sku
        //
        for (Map.Entry<String, DiscountType> entry : promotion.getCurrentPromotion().entrySet())
        {
            Item itemFirst=null;
            Item itemSec=null;
            key=entry.getKey();
             if (key.contains("-")){
                 MultipleSKUOfferI multipleSKUOfferI = offerMapingMultiple.get(promotion.getCurrentPromotion().get(key));
                 if(itemsCopy.size()>3){
                     String spl[]= key.split("-");
                     //here items can be search by splitting key
                     for(int i=0;i<itemsCopy.size();i++){
                         if(itemsCopy.get(i).getProduct().getProductName().equals(spl[0])){
                             itemFirst=itemsCopy.get(i);
                         }else if(itemsCopy.get(i).getProduct().getProductName().equals(spl[1])){
                             itemSec= itemsCopy.get(i);
                         }
                     }
                     totalPrice = totalPrice + multipleSKUOfferI.calculatePrice(itemFirst, itemSec);

                 }else{
                     totalPrice=totalPrice+itemsCopy.get(2).getProduct().getUnitPrice()*itemsCopy.get(2).getQuantity();
                 }

              }



        }

        }



    public static void main(String []args){

        offerMaping.put(DiscountType.A3for130,new A3for130());
        offerMaping.put(DiscountType.B2for45,new B2for45());
        offerMapingMultiple.put(DiscountType.CDfor30, new CDfor30());

        Product A= new Product("1","A","Apple",50);
        Product B= new Product("2","B","Banana",30);
        Product C= new Product("3","C","Carrot",20);
        Product D= new Product("4","D","Dates",15);

        //Example

//        Item item1= new Item(A,1);
//        Item item2= new Item(B,1);
//        Item item3= new Item(C,1);
//        output : 100

        Item item1= new Item(A,5);
        Item item2= new Item(B,5);
        Item item3= new Item(C,1);
//        output : 370


//        Item item1= new Item(A,3);
//        Item item2= new Item(B,5);
//        Item item3= new Item(C,1);
//        Item item4= new Item(D,1);
        //output :280

        items.add(item1);
        items.add(item2);
        items.add(item3);
       // items.add(item4);
        System.out.println(items.size());

        double fianlPrice;
        Promotion promotion =new Promotion();
        promotion.setCurrentPromotion();
         checkout(promotion);
         System.out.println("final Price "+totalPrice);








    }
}
