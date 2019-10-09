/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.budgetcarsweb;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * @Assessment3: WebProject The Budget Cars
 * @author Jose Luis & Sarita Giri
 * @StudentNumbers: 12045670 & 12045743
 * @Description:  Controller of the web site that link the JSF pages with the EJBs on the project.
 */
@Named(value = "budgetCarsController")
@RequestScoped
public class BudgetCarsController {
    
    /**
     * Creates a new instance of BudgetCarsController
     */
    public BudgetCarsController() {
    }
    // ------ Customer Variables  ------
    @EJB
    private CustomerEJB customerEJB;
    private Customer customer = new Customer();
    private List<Customer> customerList = new ArrayList<>();
    private Customer customerSearch = new Customer();           // Customer to search in the index.xhtml
    private List<Car> carListByCustomer = new ArrayList<>();    // Liat with the cars purchased by a car
    // -----------------------------------
    
    // ------ Car Variable -------------
    @EJB
    private CarEJB carEJB;
    private Car car = new Car();
    private List<Car> carList = new ArrayList<>();
    
    // ----------------------------------
    
    // ------ FamilyCar Variable -------------
    @EJB
    private FamilyCarEJB familyCarEJB;
    private FamilyCar familyCar = new FamilyCar();
    private List<FamilyCar> familyCarList = new ArrayList<>();
    // ----------------------------------
    
    // ------ SportsCar Variable -------------
    @EJB
    private SportsCarEJB sportsCarEJB;
    private SportsCar sportsCar = new SportsCar();
    private List<SportsCar> sportsCarList = new ArrayList<>();
    // ----------------------------------
    
    // ------ Sale Variable -------------
    @EJB
    private SaleEJB saleEJB;
    private Sale sale = new Sale();
    private List<Sale> saleList = new ArrayList<>();
    private List<Car> availableCarList = new ArrayList<>(); // List to display in the createSale.xhtml
    // ----------------------------------
    
    // ***********************************
    // ------ Customer Methods -----------
    // ***********************************
    
    // Method to create a customer
    public String doCreateCustomer(){
        //Send the custoer to customerEJB to persist the record
        customer = customerEJB.createCustomer(customer);
        return "customers.xhtml"; // Go back to the customers.xhtml page
    }
    
    // Method to send the customer to the delete page
    public String goDeleteCustomer (Customer customer) {
        // set the customer select to shoe in the deleteCustomer.xhtml
        setCustomer(customer);
        return "deleteCustomer.xhtml"; // Move to the deleteCustomer.xhtml page
    }
    
    // Method to delete the customer on the page
    public String doDeleteCustomer(){
        // Create a new customer object from the id on the deleteCustomer.xhtml page thrpugh the customerEJB method to find in the database
        Customer customerDelete = customerEJB.findCustomerByID(customer.getId());
        // method from the customerEJB to delete the customerDelete object
        customerEJB.deleteCustomer(customerDelete);
        return "customers.xhtml"; //return to the customers page
    }
    
    // Search purchased cars by a customer on index.xhtml
    public String searchCarsByCustomer () {
        // Update the car list of the customer by using the method in customerEJB with the id of the customer to search
        carListByCustomer = customerEJB.getAllCarsByCustomer(customerSearch.getId());
        return "carsByCustomer.xhtml"; // move to the page to display the list of car of the customer
    }
    
    // Get and set method of the general customer variable
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    // Get and Set methods of the customer list
    public List<Customer> getCustomerList() {
        customerList = customerEJB.findAllCustomers(); // Update list with the method on customerEJB to find all customers
        return customerList;
    }
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
    // Get and set method of the searched customer variable
    public Customer getCustomerSearch() {
        return customerSearch;
    }
    public void setCustomerSearch(Customer customerSearch) {
        this.customerSearch = customerSearch;
    }
    
    // GEt and set method of the cars purchased by a customer
    public List<Car> getCarListByCustomer() {
        return carListByCustomer;
    }
    public void setCarListByCustomer(List<Car> carListByCustomer) {
        this.carListByCustomer = carListByCustomer;
    }
    
    //MEthod to the a customer by the id
    public Customer getCustomerById (Long id) {
        Customer customerId = customerEJB.findCustomerByID(id); // Use the customerEJB to find a customer by id
        return customerId;
    }
    // *****************************
    // -----------------------------
    // *****************************
    
    // *****************************
    // ----- Car Methods -----------
    // *****************************
    
    // MEthod to create a car
    public String doCreateCar(){
        // create the car in the carEJB 
        car = carEJB.createCar(car);
        return "cars.xhtml"; // return to the cars.xhtml page
    }
    
    // Method to move the car to the delete page
    public String goDeleteCar (Car car) {
        setCar(car); // set the new car in the object to retrieve after
        return "deleteCar.xhtml"; // Move to the delete car page
    }
    
    // Method to delete the car
    public String doDeleteCar(){
        // Car obejct to used to delete the car and getting by the carEJB method to find by id
        Car carDelete = carEJB.findCarByID(car.getId());
        // delete car through the carEJB to delete car
        carEJB.deleteCar(carDelete);
        return "cars.xhtml"; // go to the cars page
    }  
    // Get and set methods of the general car variable
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    // Get and set variables of the list of car in the database
    public List<Car> getCarList() {
        carList = carEJB.findAllCars(); // Update the list of cars
        return carList;
    }
    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
    // **********************************
    // ----------------------------------
    // **********************************
    
    // **********************************
    //  ------- FamilyCar Methods -------
    // **********************************
    
    // Method to persiste the family car on the database
    public String doCreateFamilyCar(){
        //Use the familyCarEJB  method to create the family car
        familyCar = familyCarEJB.createFamilyCar(familyCar);
        return "familyCars.xhtml"; // go back t the familtCars.xhtml page
    }
    
    // Method to move to the delete family car by carrying the object
    public String goDeleteFamilyCar (FamilyCar familyCar) {
        // set the family car object to retrieve on the page
        setFamilyCar(familyCar);
        return "deleteFamilyCar.xhtml"; // Move to the delete familyCar.xhtml page
    }
    
    // Method to delete the family car on the database
    public String doDeleteFamilyCar(){
        // Create a new object from the familyCarEJB method to find familyCar id
        FamilyCar familyCarDelete = familyCarEJB.findFamilyCarByID(familyCar.getId());
        familyCarEJB.deleteFamilyCar(familyCarDelete); // Delete family car by the method on familyCarEJB
        return "familyCars.xhtml"; // return to the familyCars.xhtml
    }
    
    // Get and set method of the familyCAr variable
    public FamilyCar getFamilyCar() {
        return familyCar;
    }
    public void setFamilyCar(FamilyCar familyCar) {
        this.familyCar = familyCar;
    }

    // Get and set method of the familyCarList varible
    public List<FamilyCar> getFamilyCarList() {
        familyCarList = familyCarEJB.findAllFamilyCars(); //Retrieve all car from the method on the familyCarEJB 
        return familyCarList;
    }
    public void setFamilyCarList(List<FamilyCar> familyCarList) {
        this.familyCarList = familyCarList;
    }
    // ************************************
    // ------------------------------------
    // ************************************

    // ************************************
    // ----------- SportsCar Methods ------
    // ************************************
    
    // Method to create a new sports car on the database
    public String doCreateSportsCar(){
        // It is used the method on the sportsCarEJB to persist the sportCar variable
        sportsCar = sportsCarEJB.createSportsCar(sportsCar);
        return "sportsCars.xhtml"; // Return to the sportsCar.xhtml page
    }
    
    // Method to move the object select to the delete page of sports car
    public String goDeleteSportsCar (SportsCar sportsCar) {
        setSportsCar(sportsCar); // Set the sports car on the variable
        return "deleteSportsCar.xhtml"; // move to the deleteSportsCar.xhtml page
    }
    
    // Method to delete the sportscar on the database
    public String doDeleteSportsCar(){
        // Create a SportsCar object from the id of the object retrived using the sportsCarEJB method
        SportsCar sportsCarDelete = sportsCarEJB.findSportsCarByID(sportsCar.getId());
        sportsCarEJB.deleteSportsCar(sportsCarDelete); // delete the object from the database by the sportsCarEJB method
        return "sportsCars.xhtml"; // return to the sportsCars.xhtml page
    } 
    
    // Get and set of the sportsCar variable
    public SportsCar getSportsCar() {
        return sportsCar;
    }
    public void setSportsCar(SportsCar sportsCar) {
        this.sportsCar = sportsCar;
    }
    
    // Get and Set methods of the sportsCarList variables
    public List<SportsCar> getSportsCarList() {
        sportsCarList = sportsCarEJB.findAllSportsCars(); // Retrieve all sports car from the database by the sportsCarEJB
        return sportsCarList;
    }
    public void setSportsCarList(List<SportsCar> sportsCarList) {
        this.sportsCarList = sportsCarList;
    }
    // ********************************
    // --------------------------------
    // ********************************

    // ********************************
    //  -------- Sale Methods 
    // ********************************
  
    // Method to create a new sale in the database
    public String doCreateSale(){
        // Set the current 
        sale.setDateOfSale(new Date());
        // create the sale obecjt from the saleEJB
        sale = saleEJB.createSale(sale);
        // for loop over the cars in the sale to update the cars
        for (Car carElement : sale.getCars()) {
            // Update the cars to assign the sale in the car by the saleEJB
            Integer success = saleEJB.updateCar(carElement, sale);
        }
        return "sales.xhtml"; // return to the sales.xhtml page
    }
    
    // Method to move the sale to the delete page
    public String goDeleteSale (Sale sale) {
        setSale(sale); // set the object to retrieve in the delete page
        return "deleteSale.xhtml"; // go to the delete page
    }
    
    // Method to delete the sale
    public String doDeleteSale(){
        // new SAle object to delete by finding the id of the obejct retrieved osn the database through the saleEJB
        Sale saleDelete = saleEJB.findSaleByID(sale.getId());
        saleEJB.deleteSale(saleDelete); // delete the object by the saleEJB
        return "sales.xhtml"; // return to the sales.xhtml page
    } 
    
    // Get and set methods of the sale obejct
    public Sale getSale() {
        return sale;
    }
    public void setSale(Sale sale) {
        this.sale = sale;
    }

    // Get and set method of the saleList
    public List<Sale> getSaleList() {
        saleList = saleEJB.findAllSales(); // Update the saleList with all the sale from the database
        return saleList;
    }
    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }
    
    // Get and set method of the available carslist 
    public List<Car> getAvailableCarList() {
        availableCarList = saleEJB.getAvailableCars(); // update the list with the cars that have not been sold by wuery through the saleEJB
        return availableCarList;
    }
    public void setAvailableCarList(List<Car> availableCarList) {
        this.availableCarList = availableCarList;
    }
    // ************************************
    // ------------------------------------   
    // ************************************
}