/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.entities.BitacoraEntity;
import com.entities.CasoEntity;
import com.entities.ColaboradorEntity;
import com.model.BitacoraModel;
import com.model.CasoModel;
import com.model.ColaboradorModel;
import com.utils.JsfUtil;
import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KiDo
 */
@ManagedBean
@RequestScoped
public class BitacoraBean {

    private BitacoraModel modelo = new BitacoraModel();
    private BitacoraEntity bit;
    private List<BitacoraEntity> listaBitacora;
    private CasoModel caso = new CasoModel();
    private ColaboradorModel colmod = new ColaboradorModel();
    private List<ColaboradorEntity> listaColaboradores;
    private List<CasoEntity> listaCasos;
    @ManagedProperty("#{param.referencia}")
    private String ref;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public CasoModel getCaso() {
        return caso;
    }

    public void setCaso(CasoModel caso) {
        this.caso = caso;
    }

    public ColaboradorModel getColmod() {
        return colmod;
    }

    public void setColmod(ColaboradorModel colmod) {
        this.colmod = colmod;
    }

    public List<ColaboradorEntity> getListaColaboradores() {
        return colmod.listarRegistro();
    }

    public void setListaColaboradores(List<ColaboradorEntity> listaColaboradores) {
        this.listaColaboradores = listaColaboradores;
    }

    public List<CasoEntity> getListaCasos() {
        return caso.listarRegistro();
    }

    public void setListaCasos(List<CasoEntity> listaCasos) {
        this.listaCasos = listaCasos;
    }

    /**
     * Creates a new instance of BitacoraBean
     */
    public BitacoraBean() {
        bit = new BitacoraEntity();
    }

    public BitacoraEntity getBit() {
        return bit;
    }

    public void setBit(BitacoraEntity bit) {
        this.bit = bit;
    }

    public BitacoraModel getModelo() {
        return modelo;
    }

    public void setModelo(BitacoraModel modelo) {
        this.modelo = modelo;
    }

    public List<BitacoraEntity> getListaBitacora() {
        try {
            //System.out.println("REFERENCIA PARAM:"+ ref);
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().
                    getExternalContext().getRequest();
            String referencia = request.getParameter("referencia");
            if (!referencia.isEmpty()) {
                return modelo.encontrarAvance(referencia);
            } else {
                return modelo.encontrarAvance(bit.getReferencia().getReferencia());
//return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    public void setListaBitacora(List<BitacoraEntity> listaBitacora) {
        this.listaBitacora = listaBitacora;
    }

    public String guardarBitacora() {

        if (modelo.insertarRegistro(bit) != 1) {
            JsfUtil.setErrorMessage(null, "Ya existe un registro");

            return null;
        } else {
            limpiarForm();
            JsfUtil.setFlashMessage("Eureka!", "se ingreso el registro");
            return null;//"bitacora?GomezLarios-redirect=true&referencia="+ref;
        }

    }

    public String eliminarAvance() {
        //leyendo el parametro enviador desde la vista
        String identificador = JsfUtil.getRequest().getParameter("idBitacora");
        if (modelo.eliminarRegistro(identificador) > 0) {
            JsfUtil.setFlashMessage("exito", "El caso ha sido eliminado");
            return null;
        }//fin if
        else {
            JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
            return "bitacora?GomezLarios-redirect=true";
        }//fin else

    }//fin del metodo eliminar colaborador

    public String modificarRegistro() {
        String codigo = JsfUtil.getRequest().getParameter("codigo");
        if (modelo.insertarRegistro(bit) != 1) {
            modelo.modificarRegistro(bit);
            return "bitacora?GomezLarios-redirect=true";

        } else {
            return null;
        }
    }

    public String enviarDato(String referencia) {
        try {
            // HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            //String referencia= request.getParameter("referencia");
            listaBitacora = modelo.encontrarAvance(referencia);
            System.out.println("Referencia capturada" + referencia);
            return "listaBitacora";
        } catch (Exception e) {
            return null;
        }
    }

    public void limpiarForm() {
        bit.setDetalle(null);
        bit.setEstado(true);
        bit.setIdColaborador((ColaboradorEntity) null);
        bit.setFecha(null);
        bit.setIdBitacora(null);

    }
}
