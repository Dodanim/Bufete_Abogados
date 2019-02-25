/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.entities.LogUsuarioEntity;
import com.model.LogUsuarioModel;
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
public class LogUsuarioBean {
LogUsuarioModel modelo = new LogUsuarioModel();
private LogUsuarioEntity cliente;
private List<LogUsuarioEntity> lista;

    public LogUsuarioModel getModelo() {
        return modelo;
    }

    public void setModelo(LogUsuarioModel modelo) {
        this.modelo = modelo;
    }

    public LogUsuarioEntity getCliente() {
        return cliente;
    }

    public void setCliente(LogUsuarioEntity cliente) {
        this.cliente = cliente;
    }

    public List<LogUsuarioEntity> getLista() {
        return modelo.listarRegistro();
    }

    public void setLista(List<LogUsuarioEntity> lista) {
        this.lista = lista;
    }


  
/**
     * Creates a new instance of BitacoraBean
     */
  
    
    public String guardarRegistro(){
    if(modelo.insertarRegistro(cliente)!=1){
    JsfUtil.setErrorMessage(null, "Ya existe un registro");
    return null;
    }else{
    JsfUtil.setFlashMessage("Eureka!", "se ingreso el registro");
    }
    return "clientes?GomezLarios-redirect=true";
    }

    public String eliminarRegistro(){
       //leyendo el parametro enviador desde la vista
       String identificador = JsfUtil.getRequest().getParameter("idCliente");
  
       if(modelo.eliminarRegistro(identificador)>0){
           //JsfUtil.setFlashMessage("exito", "El caso ha sido eliminado");
       }//fin if
       else{
          // JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
       }//fin else
       return "clientes?GomezLarios-redirect=true";
   }//fin del metodo eliminar colaborador
   
   
//      public String enviarDato(){
//          try{
//       HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        //String referencia= request.getParameter("idCliente");
//        int referencia= Integer.parseInt(request.getParameter("idCliente"));
//        cliente= modelo.encontrarReferencia(referencia);
//       return "cliente";
//          }catch(Exception e){
//          return null;
//          }
//   }
   
    public String modificarRegistro(){
 try{
       if(modelo.modificarRegistro(cliente)>0){
           
          // JsfUtil.setFlashMessage("exito", "El registro ha sido editado");
            return "clientes?GomezLarios-redirect=true";
       }//fin if
       else{
          // JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo editar el registro");
           return null;
       }//fin else
      
       }catch(Exception e){
          return null;
          }
    }
    


}//fin clase
