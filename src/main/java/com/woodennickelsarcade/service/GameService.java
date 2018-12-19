package com.woodennickelsarcade.service;

import com.woodennickelsarcade.datastore.Game;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class GameService {
    @PersistenceContext
    private EntityManager em;
    
    public List<Game> getGames() {
        TypedQuery<Game> q = em.createNamedQuery("Games.findAll", Game.class);
        return q.getResultList();
    }
    public List<Game> getGamesByAgeRating(String age) {
        TypedQuery<Game> q = em.createNamedQuery("Games.findAll", Game.class);
        List<Game> reservations = new ArrayList<>();
        if (age.equals("M")){
            reservations = q.getResultList();
        }else if( age.equals("E10")){
             q = em.createNamedQuery("Games.findByAgerating", Game.class);
             q.setParameter("agerating", "E10");
             reservations = q.getResultList();
             q = em.createNamedQuery("Games.findByAgerating", Game.class);
             q.setParameter("agerating", "E");
             reservations.addAll(q.getResultList());
        }else{
            q = em.createNamedQuery("Games.findByAgerating", Game.class);
            q.setParameter("agerating", "E");
            reservations.addAll(q.getResultList());
        }
        if (reservations.isEmpty()) {
            return null;
        }
        return reservations;        
    }
    public void persist(Game game) {
        em.persist(game);
    }
}
