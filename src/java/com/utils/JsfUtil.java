/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author KiDo
 */
public class JsfUtil {
    public static void setErrorMessage(String idClient, String msg){
    FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
    FacesContext.getCurrentInstance().addMessage(idClient, mensaje);
   
    }
    public static void setFlashMessage(String name, String msg){
    FacesContext.getCurrentInstance().getExternalContext().getFlash().put(name,msg);
   
    }
    public static HttpServletRequest getRequest(){
    return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
}//end class
