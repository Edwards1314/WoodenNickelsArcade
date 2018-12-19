package com.woodennickelsarcade.service;

import com.woodennickelsarcade.datastore.Pay;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class PayService {
    @PersistenceContext
    private EntityManager em;
    
    public List<Pay> getPayments() {
        TypedQuery<Pay> q = em.createNamedQuery("Pay.findAll", Pay.class);
        return q.getResultList();
        
    }
    public void persist(Pay pay) {
        em.persist(pay);
    }
}
