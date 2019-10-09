/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.budgetcarsweb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * @Assessment3: WebProject The Budget Cars
 * @author Jose Luis & Sarita Giri
 * @StudentNumbers: 12045670 & 12045743
 * Description: Customer class that holds all information of the clients of the store
 */
@Entity
// Set of Named Queries on the class
@NamedQueries({
    // Query that return all customers in the table in order by id
    @NamedQuery(name = "findAllCustomer", query = "select c from Customer c order by c.id"),
    // Query the customer by id
    @NamedQuery(name= "findCustomerId", query = "select c from Customer c where c.id = :cId"),
})
public class Customer implements Serializable {

    // Ten field of the class
    
    private static final long serialVersionUID = 1L;
    // It is created the Id variables with auto generation for long integers
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String suburb;
    private String stateName;
    private String postcode;
    private String emailAddress;
    private String mobilePhoneNumber;
    // One to many relationship of sale, it will appear in the sale table
    @OneToMany(targetEntity = Sale.class, mappedBy = "customer", cascade = { CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<Sale> sales;

    /*//Default Constructor
    public Customer() {
        firstName = "";
        lastName = "";
        streetAddress = "";
        suburb = "";
        stateName = "";
        postcode = "";
        emailAddress = "";
        mobilePhoneNumber = "";
    }*/
    
    /*//Parametrised constructor
    public Customer(String firstName, String lastName, String streetAddress, String suburb, String stateName, String postcode, String emailAddress, String mobilePhoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.suburb = suburb;
        this.stateName = stateName;
        this.postcode = postcode;
        this.emailAddress = emailAddress;
        this.mobilePhoneNumber = mobilePhoneNumber;
    }*/
    
    /* Methods*/
    
    // ----- Get Methods ----
    
    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getStreetAddress(){
        return streetAddress;
    }
    public String getSuburb() {
        return suburb;
    }
    public String getStateName() {
        return stateName;
    }
    public String getPostcode() {
        return postcode;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }
    public List<Sale> getSales() {
        return sales;
    }
    
    // ----- Set Methods ----
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
    }
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public void setSales (List<Sale> sales) {
        this.sales = sales;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    // The "toString" method to print it our in the screen

    @Override
    public String toString() {
        return id + "-/-" + firstName + "-/-" + lastName + "-/-" + streetAddress + "-/-" + suburb + "-/-" + stateName + "-/-" + postcode + "-/-" + emailAddress + "-/-" + mobilePhoneNumber;
    }
    
    
    
    
}