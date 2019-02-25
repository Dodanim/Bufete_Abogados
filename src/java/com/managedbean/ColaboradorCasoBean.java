/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;

/**
 *
 * @author KiDo
 */


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import com.entities.ColaboradorCasoEntity;
import com.entities.ColaboradorEntity;
import com.entities.CasoEntity;
import com.model.ColaboradorCasoModel;
import com.model.ColaboradorModel;
import com.model.CasoModel;
import com.utils.JsfUtil;


@ManagedBean
@RequestScoped
public class ColaboradorCasoBean {
        ColaboradorCasoModel modelo = new ColaboradorCasoModel();
        ColaboradorModel colmod = new ColaboradorModel();
        CasoModel casmod=new CasoModel();
        private ColaboradorCasoEntity colcaso;
        private List<ColaboradorCasoEntity> listaColCasos;
        private List<ColaboradorEntity> listaColaboradores;
        private List<CasoEntity> listaCasos;

    public ColaboradorModel getColmod() {
        return colmod;
    }

    public void setColmod(ColaboradorModel colmod) {
        this.colmod = colmod;
    }

    public CasoModel getCasmod() {
        return casmod;
    }

    public void setCasmod(CasoModel casmod) {
        this.casmod = casmod;
    }

    public List<ColaboradorEntity> getListaColaboradores() {
        return colmod.listarRegistro();
    }

    public void setListaColaboradores(List<ColaboradorEntity> listaColaboradores) {
        this.listaColaboradores = listaColaboradores;
    }

    public List<CasoEntity> getListaCasos() {
        return casmod.listarRegistro();
    }

    public void setListaCasos(List<CasoEntity> listaCasos) {
        this.listaCasos = listaCasos;
    }
       
    
    public ColaboradorCasoBean() {
        colcaso = new ColaboradorCasoEntity();
    } //fin del constructor colaborador

    public ColaboradorCasoModel getModelo() {
        return modelo;
    }

    public void setModelo(ColaboradorCasoModel modelo) {
        this.modelo = modelo;
    }

    public ColaboradorCasoEntity getColcaso() {
        return colcaso;
    }

    public void setColcaso(ColaboradorCasoEntity colcaso) {
        this.colcaso = colcaso;
    }

    public List<ColaboradorCasoEntity> getListaColCasos() {
        return modelo.listarColCasos();
    }

    public void setListaColCasos(List<ColaboradorCasoEntity> listaColCasos) {
        this.listaColCasos = listaColCasos;
    }

    
    ///////////////// fin de los setter y getter 
    public String guardarColCaso(){
    if(modelo.ingresarColCaso(colcaso)!=1){
        modelo.modificarColCaso(colcaso);
         JsfUtil.setFlashMessage("exito","Caso reasignado exitosamente");
        return "colcaso?faces-redirect=true";
    
    }//fin if
    else{
        JsfUtil.setFlashMessage("exito","Caso asignado exitosamente");
            //forzando la redireccion en el cliente
            return "colcaso?faces-redirect=true";
    }
    }// fin del metodo guardar colaborador
    
   public String eliminarColCaso(){
       //leyendo el parametro enviador desde la vista
       String identificador = JsfUtil.getRequest().getParameter("referencia");
       if(modelo.eliminarColCaso(identificador)>0){
           JsfUtil.setFlashMessage("exito", "El caso ha sido eliminado");
       }//fin if
       else{
           JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
       }//fin else
       return "colcaso?faces-redirect=true";
   }//fin del metodo eliminar colaborador
    public void rellenarCampos(){
    }
}//fin de la clase caso bean
