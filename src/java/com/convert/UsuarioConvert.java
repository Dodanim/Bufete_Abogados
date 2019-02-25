/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convert;

import com.model.UsuariosModel;
import com.entities.UsuarioEntity;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author Kido
 */
@FacesConverter(forClass= UsuarioEntity.class)
public class UsuarioConvert implements Converter {
    UsuariosModel modelo= new UsuariosModel();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value ==null || value.isEmpty()){
         return null;
        } try{
        
        UsuarioEntity tipo= modelo.encontrarUsuario(value);
        return tipo;
        }catch(Exception e){
        return null;
        }
    }// fin

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         //To change body of generated methods, choose Tools | Templates.
         if(value==null){
         return "";
         }
         if(value instanceof UsuarioEntity){
         
             return((UsuarioEntity ) value).getIdUsuario();
         }else{
         
         return"";
         }
         
    }
    
}

