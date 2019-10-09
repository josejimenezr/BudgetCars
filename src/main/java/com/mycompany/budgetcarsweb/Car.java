/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.budgetcarsweb;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @Assessment3: WebProject The Budget Cars
 * @author Jose Luis & Sarita Giri
 * @StudentNumbers: 12045670 & 12045743
 * @Description: Superclass Car for all cars available in The Budget Cars store
 */
@Entity
// Set of Named Queries on the class
@NamedQueries({
    // Query that return all cars in the table in order by id
    @NamedQuery(name = "findAllCar", query = "select c from Car c order by c.id"),
    // Query to find an specific car by id
    @NamedQuery(name = "findCarById", query = "select c from Car c where c.id = :cId"),
})
// Inheritance attribute to ther children. Parent and children will have their own tables
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="type") //Name of the discriminator column
@DiscriminatorValue("car") // VAlue of this table on the discripminator variable
public class Car implements Serializable {

    // Ten field of the class
    
    private static final long serialVersionUID = 1L;
    // It is created the Id variables with auto generation for long integers
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String make;
    private String model;
    private Integer yearOfManufacture;
    private String registrationNumber;
    private String transmission;
    private Integer numberOfSeats;
    private String colour;
    private Float price;
    // Many to one relationship with the sale class
    @ManyToOne
    private Sale sale;
    
    /*//Default Constructor
    public Car() {
        make = "";
        model = "";
        yearOfManufacture = 0;
        registrationNumber = "";
        transmission = Transmission.AUTOMATIC;
        numberOfSeats = 0;
        colour = "";
        price = 0.0f;
    }*/
    
    /*//Parametrised constructor
    public Car(String make, String model, Integer yearOfManufacture, String registrationNumber, Transmission transmission, Integer numberOfSeats, String colour, Float price) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.registrationNumber = registrationNumber;
        this.transmission = transmission;
        this.numberOfSeats = numberOfSeats;
        this.colour = colour;
        this.price = price;
    }*/

    /* Methods*/
    
    // ----- Get Methods ----
    
    public Long getId() {
        return id;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public String getTransmission() {
        return transmission;
    }
    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }
    public String getColour() {
        return colour;
    }
    public Float getPrice() {
        return price;
    }
    public Sale getSale() {
        return sale;
    }
    
    // ----- Set Methods ----

    public void setId(Long id) {
        this.id = id;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public void setSale(Sale sale) {
        this.sale = sale;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    // The "toString" method to print it our in the screen
    
    /*@Override
    public String toString() {
        return id + "-/-" + make + "-/-" + model + "-/-" + yearOfManufacture + "-/-" + registrationNumber + "-/-" + transmission + "-/-" + numberOfSeats + "-/-" + colour + "-/-" + String.format("%.2f", price);
    }*/

    
    
}
