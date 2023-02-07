/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validation;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("bookingdate")
public class Datevalidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        Date bdate=(Date) o;
        Date validDob = new Date();
        if(bdate!= null && bdate.before(validDob)){
            FacesMessage msg;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"you cant book for date which is in past","imposible");
            throw new ValidatorException(msg);
        }
    }
    
}
