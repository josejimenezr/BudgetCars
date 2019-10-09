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
 * @Description:  FamilyCar EJB that connect the Database, persist and delete data and query the data.
 */
@Stateless
public class FamilyCarEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //entity manager of the persistence
    @PersistenceContext(unitName = "BudgetCarsPU")
    private EntityManager entityManager;
    
    // Retrieve all the family car from the database
    public List<FamilyCar> findAllFamilyCars() {
        TypedQuery<FamilyCar> query = entityManager.createNamedQuery("findAllFamilyCar", FamilyCar.class); //Named query to get all family car
        return query.getResultList(); // return the list of the query
    }
    
    // Retrieve a family car by the id    
    public FamilyCar findFamilyCarByID (Long id) {
        TypedQuery<FamilyCar> query = entityManager.createNamedQuery("findFamilyCarById", FamilyCar.class); //NamedQuery of a familyCar by id
        query.setParameter("fId", id); // set the id
        // Max one result
        query.setMaxResults(1); // just get one record
        return query.getResultList().get(0);  // return a familyCar element
    }
    
    // Persist a familyCar on the database
    public FamilyCar createFamilyCar(FamilyCar familyCar) {
        entityManager.persist(familyCar);
        return familyCar;
    }
    
    // Remove a familyCar
    @Remove
    public void deleteFamilyCar(FamilyCar familyCar) {
        entityManager.remove(entityManager.merge(familyCar));
    }
}
