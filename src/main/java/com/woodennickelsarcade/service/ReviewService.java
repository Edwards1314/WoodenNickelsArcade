package com.woodennickelsarcade.service;

import com.woodennickelsarcade.datastore.Review;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ReviewService {
    @PersistenceContext
    private EntityManager em;
    
    public List<Review> getReviews() {
        TypedQuery<Review> q = em.createNamedQuery("Review.findAll", Review.class);
        return q.getResultList();
        
    }
    
    public void persist(Review review) {
        em.persist(review);
    }
}
