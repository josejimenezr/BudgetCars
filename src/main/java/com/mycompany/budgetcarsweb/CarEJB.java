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
 * @Description:  Car EJB that connect the Database, persist and delete data and query the data.
 */
@Stateless
public class CarEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //entity manager of the persistence
    @PersistenceContext(unitName = "BudgetCarsPU")
    private EntityManager entityManager;
    
    // Method that return all the cars
    public List<Car> findAllCars() {
        TypedQuery<Car> query = entityManager.createNamedQuery("findAllCar", Car.class); // NamedQuery all the cars
        return query.getResultList(); // REturn a list
    }
    
    // Methods to retrieve a car by the id
    public Car findCarByID (Long id) {
        TypedQuery<Car> query = entityManager.createNamedQuery("findCarById", Car.class); // NamedQuery a car by id
        query.setParameter("cId", id); // set the id
        // Max one result
        query.setMaxResults(1); // only get one
        return query.getResultList().get(0);  // Retrieve a car
    }
    
    //  Method to persist a car on the database
    public Car createCar(Car car) {
        entityManager.persist(car);
        return car;
    }
    
    // Remove method of the car
    @Remove
    public void deleteCar(Car car) {
        entityManager.remove(entityManager.merge(car));
    }
}
