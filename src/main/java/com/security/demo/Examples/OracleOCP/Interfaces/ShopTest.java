package com.security.demo.Examples.OracleOCP.Interfaces;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;
import com.security.demo.Examples.OracleOCP.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class ShopTest {

    public static void main(String[] args) {
        Drink drink=new Drink(5);

        drink.measure();
        drink.consume(10);
        drink.prepare();

        Testable.d();
        Liquid.d();

        //we are calling this e method from AbstractProduct not from Liquid
        drink.e();

        Liquid liquid=(Liquid) drink;

        System.out.println("we use only liquid's methods : "+liquid.measure()+" measure() methods.");

        //equals() method inherited from Object
        System.out.println(liquid.equals(drink));
        drink= (Drink) drink.applyRating(3);
        System.out.println(drink.getRating());

        ProductManager productManager=new ProductManager();
//        Review review=new Review();
        productManager.createProduct(101,"tea",BigDecimal.valueOf(21.23),Begeni.FOUR_STAR);
        productManager.reviewProduct((Drink)drink,Begeni.FIVE_STAR,"Güzel bir ürün");


        productManager.printProduct();

        AbstractProduct food= productManager.createProduct(102,"Kek",BigDecimal.valueOf(23.11),Begeni.FIVE_STAR, LocalDate.of(2021,05,05));
        productManager.reviewProduct(food,Begeni.FOUR_STAR,"güzel");
        productManager.printProduct();


//        AbstractProduct[] products={new AbstractProduct(101,"çay", BigDecimal.valueOf(10.10), Begeni.FOUR_STAR),
//                                     new AbstractProduct(101,"kahve",BigDecimal.valueOf(20.20),Begeni.FIVE_STAR),
//                                     new AbstractProduct(102,"kola",BigDecimal.valueOf(16.16),Begeni.THREE_STAR)};

//        Arrays.sort(products);
//        for(AbstractProduct p:products){
//            System.out.println(p);
//        }
//
//        Arrays.sort(products, new Comparator<AbstractProduct>() {
//            @Override
//            public int compare(AbstractProduct o1, AbstractProduct o2) {
//                if(o1.getPrice().doubleValue()>o2.getPrice().doubleValue()){
//                    return 1;
//                }else if(o1.getPrice().doubleValue()<o2.getPrice().doubleValue()){
//                    return -1;
//                }else{
//                    return 0;
//                }
//            }
//        });
//
//        System.out.println("after sorted by price***");
//        for(AbstractProduct p:products){
//            System.out.println(p);
//        }

    }
}
