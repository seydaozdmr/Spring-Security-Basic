package com.security.demo.Examples.OracleOCP.Exercise_1;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NewShop101 {

    public static void main(String[] args) {
        //Abstract sınıfı anonymous class yapısı ile somut hale getiriyoruz.
         AbstractProduct p1=new AbstractProduct() {
             @Override
             public int getId() {
                 return 101;
             }

             @Override
             public String getName() {
                 return "Çay";
             }

             @Override
             public BigDecimal getPrice() {
                 return BigDecimal.valueOf(19.22);
             }

             @Override
             public AbstractProduct applyRating(Begeni rating) {
                 return null;
             }


         };

        System.out.println(p1.getName());

        AbstractProduct p2=new Drink(102,"Kahve",BigDecimal.valueOf(15.25),Begeni.FIVE_STAR);
        AbstractProduct p3=new Food(103,"Kek",BigDecimal.valueOf(40.0),Begeni.FOUR_STAR, LocalDate.now().plusDays(3));

        System.out.println(p3.getId()+" "+p3.getName()+" "+p3.getPrice()+" "+p3.getRating().printBegeni());
        System.out.println(p2.toString());
        System.out.println(p3);

        AbstractProduct p4=new Drink(104,"Çikolata",BigDecimal.valueOf(2.99),Begeni.FIVE_STAR);
        AbstractProduct p5= new Food(104 ,"Çikolata",BigDecimal.valueOf(2.99),Begeni.FIVE_STAR,LocalDate.now().plusDays(3));
        System.out.println(p4.equals(p5));
        AbstractProduct p6=p4.applyRating(Begeni.ONE_STAR);

        System.out.println(p3.getDiscount());
        System.out.println(p2.getDiscount());
        System.out.println(p6);

        if(p5 instanceof Food){
            System.out.println(((Food) p5).getBestBefore());
        }

        System.out.println(p4.getBestBefore());

        ProductManager pm=new ProductManager();
        AbstractProduct pnew=pm.createProduct(110,"Elma",BigDecimal.valueOf(4.3),Begeni.FIVE_STAR,LocalDate.now().plusDays(5));
        System.out.println(pnew);
    }
}
