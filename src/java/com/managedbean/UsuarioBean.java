/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;

import com.entities.TipousuarioEntity;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.entities.UsuarioEntity;
import com.model.UsuariosModel;

import com.utils.JsfUtil;
import com.utils.SecurityUtils;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KiDo
 */
@ManagedBean
@RequestScoped
public class UsuarioBean {

    UsuariosModel modelo = new UsuariosModel();
    private UsuarioEntity usuario;
    private List<UsuarioEntity> lista;
    private List<TipousuarioEntity>listaTipos;
   private TipousuariosModel tipomodel= new TipousuariosModel();
   
      public UsuarioBean() {
        usuario = new UsuarioEntity();
    }

    public List<TipousuarioEntity> getListaTipos() {
        return tipomodel.listarTipos();
    }

    public void setListaTipos(List<TipousuarioEntity> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public TipousuariosModel getTipomodel() {
        return tipomodel;
    }

    public void setTipomodel(TipousuariosModel tipomodel) {
        this.tipomodel = tipomodel;
    }

    public UsuariosModel getModelo() {
        return modelo;
    }

    public void setModelo(UsuariosModel modelo) {
        this.modelo = modelo;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

   

    public List<UsuarioEntity> getLista() {
        return modelo.listarUsuarios();
    }

    public void setLista(List<UsuarioEntity> lista) {
        this.lista = lista;
    }
   
      

    public String guardarRegistro() {
        try {
            usuario.setPassword(SecurityUtils.encriptarSHA(usuario.getPassword()));
      
              
        if (modelo.ingresarUsuarios(usuario) != 1) {
            JsfUtil.setErrorMessage(null, "Ya existe un registro");
            return null;
        } else {
            JsfUtil.setFlashMessage("Eureka!", "se ingreso el registro");
          limpiar();
             return "nuevoUsuario?GomezLarios-redirect=true";
        }
          } catch (Exception ex) {
             
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
       
    }

    public String eliminarRegistro() {
        //leyendo el parametro enviador desde la vista
        String identificador = JsfUtil.getRequest().getParameter("idCliente");

        if (modelo.eliminarUsuarios(identificador) > 0) {
            JsfUtil.setFlashMessage("exito", "El caso ha sido eliminado");
        }//fin if
        else {
            JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
        }//fin else
        return "nuevoUsuario?GomezLarios-redirect=true";
    }//fin del metodo eliminar colaborador

    public String enviarDato() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            //String referencia= request.getParameter("idCliente");
            String referencia = request.getParameter("usuario");
            usuario = modelo.encontrarUsuario(referencia);
            return "usuario";
        } catch (Exception e) {
            return null;
        }
    }

    public String modificarRegistro() {

        if (modelo.modificarUsuarios(usuario) > 0) {

            JsfUtil.setFlashMessage("exito", "El registro ha sido editado");
            limpiar();
              return "nuevoUsuario?GomezLarios-redirect=true";
        }//fin if
        else {
            JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo editar el registro");
            return null;
        }//fin else

      
    }
public void limpiar(){
 usuario.setNombre(null);
 usuario.setApellido(null);
 usuario.setIdUsuario(null);
 usuario.setPassword(null);
 usuario.setEstado(true);
}
}//fin clase
