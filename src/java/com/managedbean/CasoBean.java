/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.entities.CasoEntity;
import com.entities.ClienteEntity;
import com.model.CasoModel;
import com.model.ClienteModel;
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
public class CasoBean {

    CasoModel modelo = new CasoModel();
    private CasoEntity caso;
    private List<CasoEntity> lista;
    private List<ClienteEntity> listaClientes;
    private ClienteModel clienteModelo = new ClienteModel();

    public CasoBean() {
        caso = new CasoEntity();
    }

    public CasoModel getModelo() {
        return modelo;
    }

    public void setModelo(CasoModel modelo) {
        this.modelo = modelo;
    }

    public CasoEntity getCaso() {
        return caso;
    }

    public void setCaso(CasoEntity caso) {
        this.caso = caso;
    }

    public List<CasoEntity> getLista() {
        return modelo.listarRegistro();
    }

    public void setLista(List<CasoEntity> lista) {
        this.lista = lista;
    }

    public List<ClienteEntity> getListaClientes() {
        return clienteModelo.listarRegistro();
    }

    public void setListaClientes(List<ClienteEntity> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ClienteModel getClienteModelo() {
        return clienteModelo;
    }

    public void setClienteModelo(ClienteModel clienteModelo) {
        this.clienteModelo = clienteModelo;
    }

    public String guardarRegistro() {
        if (modelo.insertarRegistro(caso) != 1) {
            JsfUtil.setErrorMessage(null, "Ya existe un registro");
            return null;
        } else {
            JsfUtil.setFlashMessage("Eureka!", "se ingreso el registro");
        }
        return "casos?GomezLarios-redirect=true";
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
        return "casos?GomezLarios-redirect=true";
    }//fin del metodo eliminar colaborador

    public String enviarDato() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String referencia = request.getParameter("caso");
            caso = modelo.encontrarReferencia(referencia);
            return "caso";
        } catch (Exception e) {
            return null;
        }
    }

    public String modificarRegistro() {

        if (modelo.modificarRegistro(caso) > 0) {

            JsfUtil.setFlashMessage("exito", "El registro ha sido editado");
        }//fin if
        else {
            JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo editar el registro");
        }//fin else

        return "casos?GomezLarios-redirect=true";
    }

}//fin clase
