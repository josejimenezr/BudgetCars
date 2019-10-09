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
 * @Description:  class that implement Converter interface that allows to converter customer object to string
 */

@FacesConverter(value = "customerConverter")
public class CustomerConverter implements Converter {
    
    /*
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                Customer customer = customerEJB.findCustomerByID(Long.parseLong(value));
                return customer;
            } catch(NumberFormatException e) {
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Customer) object).getId());
        }
        else {
            return null;
        }
    }    
}*/
    // convert from String to Customer 
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        // Check if it is added a number
        try {
            // Split the string in the define values
            String[] stringArray = value.split("-/-");
        
            if (stringArray.length > 0) {
                // Create a customer by setting the values
                Customer customer = new Customer();
                customer.setId(Long.parseLong(stringArray[0]));
                customer.setFirstName(stringArray[1]);
                customer.setLastName(stringArray[2]);
                customer.setStreetAddress(stringArray[3]);
                customer.setSuburb(stringArray[4]);
                customer.setStateName(stringArray[5]);
                customer.setPostcode(stringArray[6]);
                customer.setEmailAddress(stringArray[7]);
                customer.setMobilePhoneNumber(stringArray[8]);
                return customer;
            }
            return null;
        }
        catch (NumberFormatException e) {
            return null;
        }
        /*if(value != null && value.trim().length() > 0) {
            try {
                BudgetCarsController service = (ThemeService) fc.getExternalContext().getApplicationMap().get("themeService");
                return service.getThemes().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }*/
    }
    
    // Converter form a object to a String
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        // Verify if it is a customer object
        if (value instanceof Customer) {
            Customer customer = (Customer)value;
            String result;
            result = customer.getId().toString() +"-/-";
            result += customer.getFirstName() +"-/-";
            result += customer.getLastName() +"-/-";
            result += customer.getStreetAddress() +"-/-";
            result += customer.getSuburb() +"-/-";
            result += customer.getStateName() +"-/-";
            result += customer.getPostcode() +"-/-";
            result += customer.getEmailAddress() +"-/-";
            result += customer.getMobilePhoneNumber();
            return result;
        }
        
        return null;
        //return ((Customer) value).getId().toString();
    }
}
