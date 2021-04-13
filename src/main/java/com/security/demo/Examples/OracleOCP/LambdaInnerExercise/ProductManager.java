package com.security.demo.Examples.OracleOCP.LambdaInnerExercise;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;
import com.security.demo.Examples.OracleOCP.Interfaces.*;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductManager {

    private Map<Product, List<Review>> pmHashMap=new HashMap<>();

    private static Map<String,ResourceFormatter> formatters= new HashMap<>();

    private ResourceFormatter formatter;

    //static final değişkenler hemen initialize edilmeli
    static final double constantprice = 0;
    static final int p;
    static {
        p=9;
    }

    public Map<Product, List<Review>> getPmHashMap() {
        return pmHashMap;
    }

    //This part utilize a review we use hashmap for products and reviews
    //ProductManager cares only one product object but we need to change this
//    private AbstractProduct product;
//    //private Review review;
//    private Review [] reviews=new Review[5];

    public ProductManager(Locale locale){
        this(locale.toLanguageTag());
    }

    public ProductManager(String languageTag){
        this();
        changeLocale(languageTag);
    }

    public  ProductManager(){
        formatters.put("en-GB",new ResourceFormatter(Locale.UK));
        formatters.put("en-US",new ResourceFormatter(Locale.US));
        formatters.put("fr-FR",new ResourceFormatter(Locale.FRANCE));
        formatters.put("tr-TR",new ResourceFormatter(new Locale("tr","TR")));
    }




    public Product createProduct(int id, String name, BigDecimal price, Begeni begeni, LocalDate bestBefore){
        System.out.println("gelen son tüketim tarihi: "+bestBefore.toString());
        Product product=new Food(id,name,price,begeni,bestBefore);
        pmHashMap.putIfAbsent(product,new ArrayList<>());
        return product;
    }

    public Product createProduct(int id, String name, BigDecimal price, Begeni begeni){
        Product product=new Drink(id,name,price,begeni);
        pmHashMap.putIfAbsent(product,new ArrayList<>());
        return product;
    }

    //changeLocale

    public void changeLocale(String languageTag){
        formatter=formatters.getOrDefault(languageTag,formatters.get("tr-TR"));
    }

    //which locales supported
    public static Set<String> getSupportedLocales(){
        return formatters.keySet();
    }

    //review product
    public Product reviewProduct(int id,Begeni begeni,String comment){
        return reviewProduct(findProduct(id),begeni,comment);
    }

    public Product reviewProduct(Product product, Begeni rating, String comment){
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

        product=product.applyRating(Rateable
                .convertRating((int)Math.round(
                        reviews.stream()
                                .mapToInt(r->r.getRating().ordinal())
                                .average()
                                .orElse(0))));

//        int sum=0;
//        for(Review review:reviews){
//            sum+=review.getRating().ordinal();
//        }
//
//        product=product.applyRating(Rateable.convertRating(Math.round((float)sum/reviews.size())));

        pmHashMap.put(product,reviews);
        return product;
    }

    public Product findProduct(int id){
//        Product product=null;
//        for(Map.Entry<Product,List<Review>> entry:pmHashMap.entrySet()){
//            if(entry.getKey().getId()==id){
//                product=entry.getKey();
//            }
//        }
//        return product;

        return pmHashMap.keySet().stream().filter(p->p.getId()==id).findFirst().orElseGet(()->null);
    }

    public void printProduct(int id) throws UnsupportedEncodingException {
        printProduct(findProduct(id));
    }

    public void printProduct(Product product) throws UnsupportedEncodingException {

        System.out.println(formatter.formatPruduct(product));

        List<Review> reviews=pmHashMap.get(product);
        Collections.sort(reviews);

        StringBuilder txt=new StringBuilder();
        if(reviews.isEmpty()){
            System.out.println(formatter.getText("no.review"));
        }else{
            //collect sonuç olarak çıktı verisi veriyor bunu bir yerde kullanmak gerekiyor...
            txt.append(reviews.stream().map(p->formatter.formatReview(p)+"\n").collect(Collectors.joining()));
            //foreach işlemi onaylıyor
            //reviews.stream().forEach(review -> System.out.println(formatter.formatReview(review)));
            //reviews.stream().forEach(r->txt.append(formatter.formatReview(r)+"\n"));
        }

        System.out.println("yeni :"+txt);
//        for(Review review:reviews){
//            if(review==null){
//                break;
//            }
//            System.out.println(formatter.formatReview(review));
//        }
//        if(reviews.size()==0){
//            String val=formatter.getText("no.reviews");
//            String deger=new String(val.getBytes("ISO-8859-1"), "UTF-8");
//            System.out.println(deger);
//        }
    }

    public Map<String,String> getDiscounts(){
        return pmHashMap.keySet().stream()
                .collect(Collectors.groupingBy(product->product.getRating().printBegeni()
                        ,Collectors.collectingAndThen(
                                Collectors.summingDouble(
                                        product->product.getDiscount().doubleValue()
                                ),discount->formatter.moneyFormat.format(discount)
                        )));
    }

    //String s=formatter.moneyFormat.format(34.34);

    public void printProducts(Predicate<Product> filter,Comparator<Product> sorter){
//        List<Product> productList=new ArrayList<>(pmHashMap.keySet());
//        productList.sort(sorter);
//        productList.forEach(System.out::println);

        StringBuilder txt=new StringBuilder();
        //pmHashMap.keySet().stream().sorted().forEach(p->txt.append(p.getName()));
        pmHashMap.keySet()
                .stream()
                .sorted()
                .filter(filter)
                .forEach(p->txt.append(formatter.formatPruduct(p)+"\n"));
        //System.out.println("yeni txt:"+pmHashMap.keySet().stream().sorted().map(p-> formatter.formatPruduct(p)+"\n").collect(Collectors.joining()));
        System.out.println(txt);
    }

    private static class ResourceFormatter{
        //Bu sınıf resources.properties'da bulunan mesaj özelliklerine göre verileri formatlayarak ekrana yazdırmaya çalışıyor.
        private Locale locale;
        private ResourceBundle resources;
        private DateTimeFormatter dateTimeFormatter;
        private NumberFormat moneyFormat;

        private ResourceFormatter(Locale locale){
            this.locale=locale;
            this.resources=ResourceBundle.getBundle("resources",locale);
            this.dateTimeFormatter=DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",locale);
            this.moneyFormat=NumberFormat.getCurrencyInstance(locale);
        }

        private String formatPruduct(Product product){

            return MessageFormat.format(this.resources.getString("product")
                    ,product.getName(),moneyFormat.format(product.getPrice())
                    ,product.getRating().printBegeni()
                    ,dateTimeFormatter.format(product.getBestBefore()));
        }

        private String formatReview(Review review){
            return MessageFormat.format(this.resources.getString("review")
                    ,review.getRating(),review.getComments());
        }

        private String getText(String key){
            return resources.getString(key);
        }

    }


}
