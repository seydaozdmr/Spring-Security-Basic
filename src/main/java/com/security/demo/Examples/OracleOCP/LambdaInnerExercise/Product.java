package com.security.demo.Examples.OracleOCP.LambdaInnerExercise;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;
import com.security.demo.Examples.OracleOCP.Interfaces.Rateable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

//abstract sınıf bir interface'i implemente ettiğinde o interface'in metotlarını implemente etmek zorunda değildir
//çünkü sınıfın kendisi abstract. fakat bu sınıfı başka bir sınıf extend ederse interface'e ait olan metotları da
//somutlaştırmak zorunda.
public abstract class Product implements Comparable<Product>, Rateable<Product> {

    public static final BigDecimal DISCOUNT_RATE=BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Begeni rating;
    private LocalDate bestBefore;
    private BigDecimal discount;

    Product(){
        this(0,"no name",BigDecimal.ZERO);
    }

    Product(int id, String name, BigDecimal price, Begeni begeni){
        this.id=id;
        this.name=name;
        this.price=price;
        this.rating=begeni;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDiscount(BigDecimal discount){
        this.discount=this.price.multiply(discount);
    }

    Product(int id, String name, BigDecimal price){
        this(id,name,price,Begeni.NOT_EVALUATE);
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Begeni getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        if(o instanceof Product){
            Product that = (Product) o;
            return id == that.id; //&& name.equals(that.name);
        }
        return false;

    }

    //every extend classes must override this method
    //public abstract AbstractProduct applyRating(Begeni rating);


    public LocalDate getBestBefore() {
        return LocalDate.now();
    }

    public BigDecimal getDiscount(){
        return this.price.subtract(this.price.multiply(DISCOUNT_RATE)).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", bestBefore=" + bestBefore +
                ", discount =" + discount +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if(this.rating.ordinal()<o.getRating().ordinal()){
            return 1;
        }else if(this.rating.ordinal()>o.getRating().ordinal()){
            return -1;
        }else {
            return 0;
        }
    }
}
