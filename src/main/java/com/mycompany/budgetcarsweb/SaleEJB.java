/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.budgetcarsweb;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PreRemove;
import javax.persistence.TypedQuery;

/**
 * @Assessment3: WebProject The Budget Cars
 * @author Jose Luis & Sarita Giri
 * @StudentNumbers: 12045670 & 12045743
 * @Description:  Sale EJB that connect the Database, persist and delete data and query the data.
 */
@Stateless
public class SaleEJB {
    
    @EJB
    private CarEJB carEJB;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //entity manager of the persistence
    @PersistenceContext(unitName = "BudgetCarsPU")
    private EntityManager entityManager;
    
    // Retrieve all sales from the datasase
    public List<Sale> findAllSales() {
        TypedQuery<Sale> query = entityManager.createNamedQuery("findAllSale", Sale.class); //NamedQuery to retrieve all sales
        return query.getResultList(); //return the list
    }
    
    // find a sale by id
    public Sale findSaleByID (Long id) {
        TypedQuery<Sale> query = entityManager.createNamedQuery("findSaleById", Sale.class); //NamedQuery to retrieve a sale by id
        query.setParameter("sId", id); //set an id
        // Max one result
        query.setMaxResults(1); // Only get one record
        return query.getResultList().get(0);   // return the sale
    }
    
    // Create the sale
    public Sale createSale(Sale sale) {
        entityManager.persist(sale);
        return sale;
    }
    
    // Remove a sale
    @Remove
    public void deleteSale(Sale sale) {
        entityManager.remove(entityManager.merge(sale));
    }
    
    // BEfore remove a sale
    @PreRemove
    public void deleteSaleCars(Sale sale) {
        // find all the cars in the sale to delete too
        if (sale.getCars()!= null){
            List<Car> cars = sale.getCars(); // get cars
            for (Car element : cars) {
                carEJB.deleteCar(element); //delete cars in teh for loop
            }
        }
    }
    
    // Update the sale in the cars
    public Integer updateCar (Car car, Sale sale) {
        // Query to update the car table with the sale
        Integer rows = entityManager.createQuery("update Car c set c.sale = :cSale where c.id = :cId").setParameter("cSale", sale).setParameter("cId", car.getId()).executeUpdate();
        return rows;
    }
    
    // Get all cars that haave not been sale
    public List<Car> getAvailableCars () {
        // get all cars that do not have sales
        List<Car> cars = entityManager.createQuery("select c from Car c where c.sale is null").getResultList();
        return cars;
    }
}
