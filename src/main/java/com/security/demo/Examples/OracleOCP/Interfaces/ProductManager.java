package com.security.demo.Examples.OracleOCP.Interfaces;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;
import com.security.demo.Examples.OracleOCP.Product;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProductManager {

    private Map<AbstractProduct, List<Review>> pmHashMap=new HashMap<>();


    //This part utilize a review we use hashmap for products and reviews
    //ProductManager cares only one product object but we need to change this
//    private AbstractProduct product;
//    //private Review review;
//    private Review [] reviews=new Review[5];

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
        System.out.println("gelen son tüketim tarihi: "+bestBefore.toString());
        AbstractProduct product=new Food(id,name,price,begeni,bestBefore);
        pmHashMap.putIfAbsent(product,new ArrayList<>());
        return product;
    }

    public AbstractProduct createProduct(int id, String name, BigDecimal price, Begeni begeni){
        AbstractProduct product=new Drink(id,name,price,begeni);
        pmHashMap.putIfAbsent(product,new ArrayList<>());
        return product;
    }

    //review product
    public AbstractProduct reviewProduct(int id,Begeni begeni,String comment){
        return reviewProduct(findProduct(id),begeni,comment);
    }

    public AbstractProduct reviewProduct(AbstractProduct product, Begeni rating, String comment){
        //this line of code designed for reviews[] array
        //        if(reviews[reviews.length-1]!=null){
//            reviews= Arrays.copyOf(reviews,reviews.length*2);
//        }
        //this.review=new Review(rating,comment);

//        int i=0, sum=0;
//        boolean reviewed=false;
//
//        while(i< reviews.length && !reviewed) {
//            if (reviews[i] == null) {
//                reviews[i] = new Review(rating, comment);
//                reviewed = true;
//            }
//
//            sum += reviews[i].getRating().ordinal();
//            i++;
//
//        }
//        this.product.applyRating(Rateable.convertRating(Math.round((float)sum/i)));

        List<Review> reviews=pmHashMap.get(product);
        pmHashMap.remove(product,reviews);
        reviews.add(new Review(rating,comment));

        int sum=0;
        for(Review review:reviews){
            sum+=review.getRating().ordinal();
        }

        product=product.applyRating(Rateable.convertRating(Math.round((float)sum/reviews.size())));

        pmHashMap.put(product,reviews);
        return product;
    }

    public AbstractProduct findProduct(int id){
        AbstractProduct product=null;
        for(Map.Entry<AbstractProduct,List<Review>> entry:pmHashMap.entrySet()){
            if(entry.getKey().getId()==id){
                product=entry.getKey();
            }
        }
        return product;
    }

    public void printProduct(int id) throws UnsupportedEncodingException {
        printProduct(findProduct(id));
    }
    public void printProduct(AbstractProduct product) throws UnsupportedEncodingException {
        String formattedPrice=moneyFormat.format(product.getPrice());
        //System.out.println(product.getBestBefore());
        String formattedDate=dateTimeFormatter.format(product.getBestBefore());

        System.out.println(MessageFormat.format(this.resources.getString("product")
                                                ,product.getName()
                                                ,formattedPrice
                                                ,product.getRating()
                                                ,formattedDate));

        List<Review> reviews=pmHashMap.get(product);
        Collections.sort(reviews);
        for(Review review:reviews){
            if(review==null){
                break;
            }
                System.out.println(MessageFormat.format(this.resources.getString("review"),review.getRating(),review.getComments()));
            }
        if(reviews.size()==0){
            String val=resources.getString("no.reviews");
            String deger=new String(val.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(deger);
        }


    }


}
