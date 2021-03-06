/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Ingenieria
 */
@FacesValidator("emailValidator") 
public class EmailValidator implements Validator
{
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {        
        
        Pattern pattern = Pattern.compile("\\w+@\\w+.\\w+");
        Matcher matcher =pattern.matcher((CharSequence)value);
        HtmlInputText htmlInputText = (HtmlInputText) component;
        String label;
        
        if(htmlInputText.getLabel()==null || htmlInputText.getLabel().trim().equals(""))
             label = htmlInputText.getId();                               
        else label = htmlInputText.getLabel();              
        
        if(!matcher.matches()){ //si hay error en la validacion anterior entra en el if
            FacesMessage facesMessage = new FacesMessage(label+": no es una direccion de Email válida");
            throw new ValidatorException(facesMessage);            
        }
    }         
}
