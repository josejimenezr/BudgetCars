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
 * @Description:  Customer EJB that connect the Database, persist and delete data and query the data.
 */
@Stateless
public class CustomerEJB {

    @EJB
    private SaleEJB saleEJB;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //entity manager of the persistence
    @PersistenceContext(unitName = "BudgetCarsPU")
    private EntityManager entityManager;
    
    // Retrieve all the customer 
    public List<Customer> findAllCustomers() {
        TypedQuery<Customer> query = entityManager.createNamedQuery("findAllCustomer", Customer.class); // NAmedQuery to retrieve all customer
        return query.getResultList(); // return the list
    }
    
    // retrieve a customer by id
    public Customer findCustomerByID (Long id) {
        TypedQuery<Customer> query = entityManager.createNamedQuery("findCustomerId", Customer.class); // NAmedQuery to retrieve a customer by id
        query.setParameter("cId", id); // set the id
        // Max one result
        query.setMaxResults(1); // get only one record
        return query.getResultList().get(0); // return customer
    }
    
    // Persist a customer
    public Customer createCustomer(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }
    
    // Remove a customer
    @Remove
    public void deleteCustomer(Customer customer) {
        entityManager.remove(entityManager.merge(customer));
    }
    // MEthod before remove customer
    @PreRemove
    public void deleteCustomerSale(Customer customer) {
        // if the customer has sales, also delete those
        if (customer.getSales()!= null){
            List<Sale> sales = customer.getSales(); // get the sales
            for (Sale element : sales) {
                saleEJB.createSale(element); //delete all the sale in the for loop
            }
        }
    }
    
    // Query to get all car by customer
    public List<Car> getAllCarsByCustomer (Long id) {
        // Create a query that returna  list of all the cars that a customer id has purchased
        List<Car> cars = entityManager.createQuery("select distinct c from Car c inner join c.sale s inner join s.customer cu where cu.id = :customerId").setParameter("customerId", id).getResultList();;
        return cars;
    }
    
    
}
