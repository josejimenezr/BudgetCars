/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.budgetcarsweb;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @Assessment3: WebProject The Budget Cars
 * @author Jose Luis & Sarita Giri
 * @StudentNumbers: 12045670 & 12045743
 * @Description:  class that implement Converter interface that allows to converter car object to string
 */
@FacesConverter("carConverter")
public class CarConverter implements Converter {
    /*
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                return carEJB.findCarByID(Long.parseLong(value));
            } catch(NumberFormatException e) {
                return null;
            }
        }
        else {
            return null;
        }
    }*/

    /*@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Car) object).getId());
        }
        else {
            return null;
        }
    }  */  
//}
    // convert from String to Car
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        String[] stringArray = value.split("-/-");
        if (stringArray.length > 0) {
            Car car = new Car();
            car.setId(Long.parseLong(stringArray[0]));
            car.setMake(stringArray[1]);
            car.setModel(stringArray[2]);
            car.setYearOfManufacture(Integer.parseInt(stringArray[3]));
            car.setRegistrationNumber(stringArray[4]);
            car.setTransmission(stringArray[5]);
            car.setNumberOfSeats(Integer.parseInt(stringArray[6]));
            car.setColour(stringArray[7]);
            car.setPrice(Float.parseFloat(stringArray[8]));
            if (stringArray.length == 12) {
                FamilyCar familyCar = (FamilyCar)car;
                familyCar.setHasChildSafetyLocks(Boolean.parseBoolean(stringArray[9]));
                familyCar.setVolumeBoot(Float.parseFloat(stringArray[10]));
                familyCar.setHasBackAirbags(Boolean.parseBoolean(stringArray[11]));
                return familyCar;
            }
            else if (stringArray.length == 13) {
                SportsCar sportsCar = (SportsCar)car;
                sportsCar.setHeight(Float.parseFloat(stringArray[9]));
                sportsCar.setWeight(Float.parseFloat(stringArray[10]));
                sportsCar.setHasTurbochanger(Boolean.parseBoolean(stringArray[11]));
                sportsCar.setSecondsTo100KM(Float.parseFloat(stringArray[12]));
            }
            return car;
        }
        return null;
    }
    // Converter form a object to a String
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        if (object instanceof Car) {
            Car car = (Car)object;
            String result;
            result = car.getId().toString() +"-/-";
            result += car.getMake() +"-/-";
            result += car.getModel() +"-/-";
            result += car.getYearOfManufacture().toString() +"-/-";
            result += car.getRegistrationNumber() +"-/-";
            result += car.getTransmission() +"-/-";
            result += car.getNumberOfSeats().toString() +"-/-";
            result += car.getColour() +"-/-";
            result += String.format("%.2f", car.getPrice());
            if (object instanceof FamilyCar){
                FamilyCar familyCar = (FamilyCar)car;
                result += "-/-";
                result += familyCar.getHasChildSafetyLocks().toString() +"-/-";
                result += String.format("%.2f", familyCar.getVolumeBoot()) +"-/-";
                result += familyCar.getHasBackAirbags().toString();
            }
            else if (object instanceof SportsCar) {
                SportsCar sportsCar = (SportsCar)car;
                result += "-/-";
                result += String.format("%.2f", sportsCar.getHeight()) +"-/-";
                result += String.format("%.2f", sportsCar.getWeight()) +"-/-";
                result += sportsCar.getHasTurbochanger().toString() +"-/-";
                result += String.format("%.1f", sportsCar.getSecondsTo100KM());
            }
            return result;
        }
        return null;
    }
}