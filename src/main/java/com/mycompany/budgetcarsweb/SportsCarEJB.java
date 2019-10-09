/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.budgetcarsweb;

import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @Assessment3: WebProject The Budget Cars
 * @author Jose Luis & Sarita Giri
 * @StudentNumbers: 12045670 & 12045743
 * @Description:  SportsCar EJB that connect the Database, persist and delete data and query the data.
 */
@Stateless
public class SportsCarEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //entity manager of the persistence
    @PersistenceContext(unitName = "BudgetCarsPU")
    private EntityManager entityManager;
    
    // Retrieve all the sports car from the database
    public List<SportsCar> findAllSportsCars() {
        TypedQuery<SportsCar> query = entityManager.createNamedQuery("findAllSportsCar", SportsCar.class); //NAmed query to get all sports car
        return query.getResultList(); // return the list of the query
    }
    
    // Retrieve a sports car by the id
    public SportsCar findSportsCarByID (Long id) {
        TypedQuery<SportsCar> query = entityManager.createNamedQuery("findSportsCarById", SportsCar.class); //NamedQuery of a sportscar by id
        query.setParameter("sId", id); // set the id
        // Max one result
        query.setMaxResults(1); // just get one record
        return query.getResultList().get(0);   // return a sportscar element
    }
    
    // Persist a sportsCar on the database
    public SportsCar createSportsCar(SportsCar sportsCar) {
        entityManager.persist(sportsCar);
        return sportsCar;
    }
    
    // Remove a sportsCar
    @Remove
    public void deleteSportsCar(SportsCar sportsCar) {
        entityManager.remove(entityManager.merge(sportsCar));
    }
}
