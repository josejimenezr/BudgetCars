/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.budgetcarsweb;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
/**
 * @Assessment3: WebProject The Budget Cars
 * @author Jose Luis & Sarita Giri
 * @StudentNumbers: 12045670 & 12045743
 * Description: Subclass of Cars superclass named SportCar that have specific characteristics for sports cars
 */
@Entity
// Set of Named Queries on the class
@NamedQueries({
    // Query that return all cars in the table
    @NamedQuery(name = "findAllSportsCar", query = "select s from SportsCar s order by s.id"),
    // Query that return an specific record by the id
    @NamedQuery(name = "findSportsCarById", query = "select s from SportsCar s where s.id = :sId")
})
@DiscriminatorValue("SportsCar") //Value of this table on the discrimination column on car
public class SportsCar extends Car implements Serializable {

    private static final long serialVersionUID = 1L;
    /* Not requiered for this child
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/
   
    // Four fields for this class
    private Float height;
    private Float weight;
    private Boolean hasTurbochanger;
    private Float secondsTo100KM;
    
    /*//Default Constructor
    public SportsCar() {
        super();
        height = 0.0f;
        weight = 0.0f;
        hasTurbochanger = false;
        secondsTo100KM = 0.0f;
    }
    
    //Parametrised constructor
    public SportsCar(String make, String model, Integer yearOfManufacture, String registrationNumber, Transmission transmission, Integer numberOfSeats, String colour, Float price, Float height, Float weight, Boolean hasTurbochanger, Float secondsTo100KM) {
        super(make, model, yearOfManufacture, registrationNumber, transmission, numberOfSeats, colour, price);
        this.height = height;
        this.weight = weight;
        this.hasTurbochanger = hasTurbochanger;
        this.secondsTo100KM = secondsTo100KM;
    }*/
    
    /* Methods*/
    
    // ----- Get Methods ----
    public Float getHeight(){
        return height;
    }
    public Float getWeight(){
        return weight;
    }
    public Boolean getHasTurbochanger() {
        return hasTurbochanger;
    }
    public Float getSecondsTo100KM() {
        return secondsTo100KM;
    }
    
    // ----- Set Methods ----
    
    public void setHeight(Float height) {
        this.height = height;
    }
    public void setWeight(Float weight) {
        this.weight = weight;
    }
    public void setHasTurbochanger(Boolean hasTurbochanger) {
        this.hasTurbochanger = hasTurbochanger;
    }
    public void setSecondsTo100KM(Float secondsTo100KM) {
        this.secondsTo100KM = secondsTo100KM;
    }
    
    // The "toString" method to print it our in the screen
    /*
    @Override
    public String toString() {
        return super.toString() + "-/-" +String.format("%.2f", height) + "-/-" + String.format("%.2f", weight) + "-/-" + hasTurbochanger + "-/-" +String.format("%.1f",secondsTo100KM);
    }*/
    
}
