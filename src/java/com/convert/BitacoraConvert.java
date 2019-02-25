/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convert;

import com.model.BitacoraModel;
import com.entities.BitacoraEntity;
import java.util.ArrayList;
//import com.model.ClienteModel;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.Validator;
import org.apache.el.util.Validation;


/**
 *
 * @author Kido
 */
@FacesConverter(forClass= BitacoraEntity.class)
public class BitacoraConvert implements Converter {
    BitacoraModel modelo= new BitacoraModel();
     @Override
    public Object getAsObject(final FacesContext context, final UIComponent component, final String values)
    {
       // final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        final List<BitacoraEntity> result = new ArrayList<BitacoraEntity>(); 
        for (String value : values.split(",", -1))
        {           
            final String trimmedValue = value.trim();

          //  final Set<ConstraintViolation<BitacoraEntity>> violations = validator.validateValue(BitacoraEntity.class, "data", trimmedValue);
//            if (!violations.isEmpty())
//            {
//                throw new ConverterException(new FacesMessage(violations.iterator().next().getMessage()));
//            }

            result.add(new BitacoraEntity(trimmedValue));
        }       

       // final Set<ConstraintViolation<Rule>> violations = validator.validateValue(Rule.class, "destinations", result);
//        if (!violations.isEmpty())
//        {
//            throw new ConverterException(new FacesMessage(violations.iterator().next().getMessage()));
//        }       

        return result;
    }

//    @Override
//    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//        if(value ==null || value.isEmpty()){
//         return null;
//        } try{
//        
//         List<BitacoraEntity> tipo= modelo.encontrarAvance(value);
//        return tipo;
//        }catch(Exception e){
//        return null;
//        }
//    }// fin

    @Override
    public String getAsString(final FacesContext context, final UIComponent component, final Object value)
    {
        if (value instanceof List<?>)
        {
            final StringBuffer result = new StringBuffer();

            final List<?> list = (List<?>) value;

            for (int i = 0; i < list.size()-1; i++)
            {               
                if (list.get(i) instanceof BitacoraEntity)
                {
                    result.append(((BitacoraEntity) list.get(i)).getReferencia());
                    result.append(", ");
                }
                else
                {
                    throw new IllegalArgumentException( "Cannot convert " + value + " object to Destination in DestinationConverter." );
                }
            }

            if (!list.isEmpty())
            {
                if (list.get(list.size()-1) instanceof BitacoraEntity)
                {
                    result.append(((BitacoraEntity) list.get(list.size()-1)).getReferencia());
                }
                else
                {
                    throw new IllegalArgumentException( "Cannot convert " + value + " object to Destination in DestinationConverter." );
                }
            }

            return result.toString();
        }
        else
        {
            throw new IllegalArgumentException( "Cannot convert " + value + " object to List in DestinationConverter." );
        }
    }
//    public String getAsString(FacesContext context, UIComponent component, Object value) {
//         //To change body of generated methods, choose Tools | Templates.
//         if(value==null){
//         return "";
//         }
//         if(value instanceof BitacoraEntity){
//         
//             return((BitacoraEntity) value).getReferencia().getReferencia();
//         }else{
//         
//         return"";
//         }
//         
//    }
    
}

