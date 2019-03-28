/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convert;

/**
 *
 * @author KiDo
 */

import com.model.ClienteModel;
import com.entities.ClienteEntity;
import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author Kido
 */
@FacesConverter(forClass= ClienteEntity.class)
public class ClienteConverter implements Converter {
    
    ClienteModel modelo= new ClienteModel();
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
    if (submittedValue == null || submittedValue.isEmpty()) {
        return null;
    }

    try {
        return modelo.encontrarReferencia(Integer.valueOf(submittedValue));
    } catch (NumberFormatException e) {
        throw new ConverterException(new FacesMessage(submittedValue + " is not a valid ID"), e);
    }
}
//    @Override
//    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//        if(value ==null || value.isEmpty()){
//         return null;
//        } try{
//        
//        ClienteEntity tipo= modelo.encontrarCliente(Integer.parseInt(value));
//        return tipo;
//        }catch(Exception e){
//        return null;
//        }
//    }// fin
public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
    if (modelValue == null) {
        return "";
    }

    if (modelValue instanceof ClienteEntity) {
        return String.valueOf(((ClienteEntity) modelValue).getIdCliente());
    } else {
        throw new ConverterException(new FacesMessage(modelValue + " is not a valid idClient"));
    }
}
//    @Override
//    public String getAsString(FacesContext context, UIComponent component, Object value) {
//         //To change body of generated methods, choose Tools | Templates.
//         if(value==null){
//         return "";
//         }
//         if(value instanceof ClienteEntity){
//         
//             return((ClienteEntity ) value).getIdCliente();
//         }else{
//         
//         return"";
//         }
//         
//    }
    
}

