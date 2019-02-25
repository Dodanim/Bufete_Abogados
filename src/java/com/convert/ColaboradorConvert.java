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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.model.ColaboradorModel;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.entities.ColaboradorEntity;

/**
 *
 * @author Kido
 */
@FacesConverter(forClass= ColaboradorEntity.class)
public class ColaboradorConvert implements Converter {
    ColaboradorModel modelo= new ColaboradorModel();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value ==null || value.isEmpty()){
         return null;
        } try{
        
        ColaboradorEntity tipo= modelo.obtenerRegistro(value);
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
         if(value instanceof ColaboradorEntity){
         
             return((ColaboradorEntity ) value).getIdColaborador();
         }else{
         
         return"";
         }
         
    }
    
}
