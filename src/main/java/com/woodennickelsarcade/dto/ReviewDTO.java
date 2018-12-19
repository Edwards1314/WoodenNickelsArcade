package com.woodennickelsarcade.dto;

import com.woodennickelsarcade.datastore.Review;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReviewDTO {
    private String name;
    private int id;
    private String review;
    private int rating;

    public ReviewDTO() {
    }
    public ReviewDTO(String name, String review, String rating) {
        name = name;
        review = review;
        rating = rating;
    }
    public ReviewDTO(Review r) {
        id = r.getReviewId();
        name = r.getCustomerName();
        review = r.getReview();
        rating = r.getRating();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
