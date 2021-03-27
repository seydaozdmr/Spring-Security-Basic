package com.security.demo.Examples.OracleOCP.Interfaces;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductManager {

    private AbstractProduct product;
    private Review review;

    private Locale locale;
    private ResourceBundle resources;
    private DateTimeFormatter dateTimeFormatter;
    private NumberFormat moneyFormat;

    public  ProductManager(){
        this.locale=new Locale("tr","TR");
        this.resources=ResourceBundle.getBundle("resources",locale);
        this.dateTimeFormatter=DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",locale);
        this.moneyFormat=NumberFormat.getCurrencyInstance(locale);
    }



    public AbstractProduct createProduct(int id, String name, BigDecimal price, Begeni begeni, LocalDate bestBefore){
        this.product=new Food(id,name,price,begeni,bestBefore);
        return product;
    }

    public AbstractProduct createProduct(int id, String name, BigDecimal price, Begeni begeni){
        this.product=new Drink(id,name,price,begeni);
        return product;
    }

    public AbstractProduct reviewProduct(AbstractProduct product, Begeni rating, String comment){
        this.review=new Review(rating,comment);
        this.product.applyRating(rating);
        return this.product;
    }

    public void printProduct(){
        String formattedPrice=moneyFormat.format(this.product.getPrice());
        String formattedDate=dateTimeFormatter.format(this.product.getBestBefore());

        System.out.println(MessageFormat.format(this.resources.getString("product")
                                                ,this.product.getName()
                                                ,formattedPrice
                                                ,this.review.getRating()
                                                ,formattedDate));
        if(this.review!=null){
            System.out.println(MessageFormat.format(this.resources.getString("review"),this.review.getRating(),this.review.getComments()));
        }else{
            System.out.println(MessageFormat.format(resources.getString("no.reviews"),""));
        }


    }
}
