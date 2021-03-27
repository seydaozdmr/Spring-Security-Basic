package com.security.demo.Examples.OracleOCP.Interfaces;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;
import com.security.demo.Examples.OracleOCP.Rating;

public class Review {
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
}
