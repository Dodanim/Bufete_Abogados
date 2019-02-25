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
import com.model.TipoUsuariosModel;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.entities.TipousuarioEntity;


@FacesConverter(forClass= TipousuarioEntity.class)
public class TipoUsuarioConvert implements Converter {
    TipoUsuariosModel modelo= new TipoUsuariosModel();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value ==null || value.isEmpty()){
         return null;
        } try{        
        TipousuarioEntity tipo= modelo.encontrarTipoUsuario(value);
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
         if(value instanceof TipousuarioEntity){
         
             return((TipousuarioEntity ) value).getIdTipoUsuario();
         }else{
         
         return"";
         }
         
    }
    
}
