package com.security.demo.Examples.OracleOCP.Interfaces;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;
import com.security.demo.Examples.OracleOCP.Rating;

public class Review implements Comparable<Review>{
    private Begeni rating;
    private String comments;


    public Review(Begeni rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }

    public Begeni getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    @Override
    public String  toString() {
        return "Review{" +
                "rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }

    @Override
    public int compareTo(Review o) {
        if(this.getRating().ordinal()>o.getRating().ordinal()){
            return -1;
        }else if(this.getRating().ordinal()<o.getRating().ordinal()){
            return 1;
        }else{
            return 0;
        }

        //return this.getRating().ordinal()-o.getRating().ordinal();
    }
}
