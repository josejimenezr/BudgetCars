/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.budgetcarsweb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @Assessment3: WebProject The Budget Cars
 * @author Jose Luis & Sarita Giri
 * @StudentNumbers: 12045670 & 12045743
 * Description: Sale class that link the car class and the customer class
 */
@Entity
// Set of Named Queries on the class
@NamedQueries({
    // Query that return all sales in the table in order by id
    @NamedQuery(name = "findAllSale", query = "select s from Sale s order by s.id"),
    // Query that return a single record by the id
    @NamedQuery(name = "findSaleById", query = "select s from Sale s where s.id = :sId"),
})
public class Sale implements Serializable {

    // Four field of the class
    
    private static final long serialVersionUID = 1L;
    // It is created the Id variables with auto generation for long integers
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // this variable has the TIMESTRAMP to use an stadarised time
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfSale;
    // Many to one relationship with customer, it will appear in the table
    @ManyToOne
    private Customer customer;
    // One to many relationship of sale, it will appear in the car table
    @OneToMany(targetEntity = Car.class, mappedBy = "sale", cascade = {CascadeType.REMOVE} ,fetch=FetchType.EAGER )
    private List<Car> cars;
    
    /*
    //Default Constructor
    public Sale() {
        dateOfSale = new Date();
        customer = new Customer();
        cars = new ArrayList<>();
    }
    
    //Parametrised constructor
    public Sale(Date dateOfSale, Customer customer, List<Car> cars) {
        this.dateOfSale = dateOfSale;
        this.customer = customer;
        this.cars = cars;
    }*/

    /* Methods*/
    
    // ----- Get Methods ----
    
    public Long getId() {
        return id;
    }
    public Date getDateOfSale() {
        return dateOfSale;
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<Car> getCars() {
        return cars;
    }
    
    // ----- Set Methods ----

    public void setId(Long id) {
        this.id = id;
    }
    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setCars(List<Car> cars){
        this.cars = cars;
    }
    
    // The "toString" method to print it our in the screen

    @Override
    public String toString() {
        return "[ id=" + id + ", Date=" + String.format("The date: %1$td/%1$tm/%1$tY", dateOfSale ) + ", CustomerID= " + customer.getId() + " ]";
    }
    
}
