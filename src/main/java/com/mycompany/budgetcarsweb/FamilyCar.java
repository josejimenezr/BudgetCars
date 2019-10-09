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
 * Description: Subclass of Cars superclass named FamilyCar that have specific characteristics for cars that have special use for families
 */
@Entity
// Set of Named Queries on the class
@NamedQueries ({
    // Query that return all cars in the table
    @NamedQuery(name = "findAllFamilyCar", query = "select f from FamilyCar f"),
    // Query that return an specific record by the id
    @NamedQuery(name = "findFamilyCarById", query = "select f from FamilyCar f where f.id = :fId")
})
@DiscriminatorValue("FamilyCar") //Value of this table on the discrimination column on car
public class FamilyCar extends Car implements Serializable {

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
   
    // Three fields for this class
    private Boolean hasChildSafetyLocks;
    private Float volumeBoot;
    private Boolean hasBackAirbags;
    
    /*//Default Constructor
    public FamilyCar() {
        super();
        hasChildSafetyLocks = false;
        volumeBoot = 0.0f;
        hasBackAirbags = false;
    }
    
    //Parametrised constructor
    public FamilyCar(String make, String model, Integer yearOfManufacture, String registrationNumber, Transmission transmission, Integer numberOfSeats, String colour, Float price, Boolean hasChildSafetyLocks, Float volumeBoot, Boolean hasBackAirbags) {
        super(make, model, yearOfManufacture, registrationNumber, transmission, numberOfSeats, colour, price);
        this.hasChildSafetyLocks = hasChildSafetyLocks;
        this.volumeBoot = volumeBoot;
        this.hasBackAirbags = hasBackAirbags;
    }*/
    
    /* Methods*/
    
    // ----- Get Methods ----
    
    public Boolean getHasChildSafetyLocks(){
        return hasChildSafetyLocks;
    }
    public Float getVolumeBoot(){
        return volumeBoot;
    }
    public Boolean getHasBackAirbags() {
        return hasBackAirbags;
    }
    
    // ----- Set Methods ----
    
    public void setHasChildSafetyLocks(Boolean hasChildSafetyLocks) {
        this.hasChildSafetyLocks = hasChildSafetyLocks;
    }
    public void setVolumeBoot(Float volumeBoot) {
        this.volumeBoot = volumeBoot;
    }
    public void setHasBackAirbags(Boolean hasBackAirbags) {
        this.hasBackAirbags = hasBackAirbags;
    }
    
    // The "toString" method to print it our in the screen
    /*
    @Override
    public String toString() {
        return super.toString() + "-/-" + hasChildSafetyLocks + "-/-" + String.format("%.2f", volumeBoot) + "-/-" + hasBackAirbags;
    }*/
    
}
