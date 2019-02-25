/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.entities.ColaboradorEntity;
import com.model.ColaboradorModel;
import com.utils.JsfUtil;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 *
 * @author KiDo
 */
@ManagedBean
@RequestScoped
public class ColaboradorBean {

    ColaboradorModel modelo = new ColaboradorModel();
    private ColaboradorEntity colaborador;
    private List<ColaboradorEntity> lista;
    
   public ColaboradorBean() {
        colaborador = new ColaboradorEntity();
    }
    public ColaboradorModel getModelo() {
        return modelo;
    }

    public void setModelo(ColaboradorModel modelo) {
        this.modelo = modelo;
    }

    public ColaboradorEntity getColaborador() {
        return colaborador;
    }

    public void setRegistro(ColaboradorEntity colaborador) {
        this.colaborador = colaborador;
    }

    
    public List<ColaboradorEntity> getLista() {
        return modelo.listarRegistro();
    }

    public String guardarRegistro() {
        if (modelo.insertarRegistro(colaborador) != 1) {
            JsfUtil.setErrorMessage(null, "Ya existe un registro");
            return null;
        } else {
            JsfUtil.setFlashMessage("Eureka!", "se ingreso el registro");
        }
        return "colaborador?GomezLarios-redirect=true";
    }

    public String eliminarRegistro() {
        //leyendo el parametro enviador desde la vista
        String identificador = JsfUtil.getRequest().getParameter("idCliente");

        if (modelo.eliminarRegistro(identificador) > 0) {
            JsfUtil.setFlashMessage("exito", "El caso ha sido eliminado");
        }//fin if
        else {
            JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
        }//fin else
        return "colaborador?GomezLarios-redirect=true";
    }//fin del metodo eliminar colaborador

    public String enviarDato() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            //String referencia= request.getParameter("idCliente");
            String referencia = request.getParameter("colaborador");
            colaborador = modelo.encontrarReferencia(referencia);
            return "colaborador";
        } catch (Exception e) {
            return null;
        }
    }

    public String modificarRegistro() {

        if (modelo.modificarRegistro(colaborador) > 0) {

            JsfUtil.setFlashMessage("exito", "El registro ha sido editado");
        }//fin if
        else {
            JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo editar el registro");
        }//fin else

        return "colaborador?GomezLarios-redirect=true";
    }

}//fin clase
