/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.entities.ClienteEntity;
import com.entities.LogUsuarioEntity;
import com.model.ClienteModel;
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
public class ClienteBean {
ClienteModel modelo = new ClienteModel();
private ClienteEntity cliente;
private List<ClienteEntity> lista;
private LogUsuarioEntity registro;
private LogUsuarioModel modeloRegistro;

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public LogUsuarioEntity getRegistro() {
        return registro;
    }

    public void setRegistro(LogUsuarioEntity registro) {
        this.registro = registro;
    }

    public LogUsuarioModel getModeloRegistro() {
        return modeloRegistro;
    }

    public void setModeloRegistro(LogUsuarioModel modeloRegistro) {
        this.modeloRegistro = modeloRegistro;
    }
    public ClienteModel getModelo() {
        return modelo;
    }

    public void setModelo(ClienteModel modelo) {
        this.modelo = modelo;
    }
/**
     * Creates a new instance of BitacoraBean
     */
    public ClienteBean() {
        cliente = new ClienteEntity();
    }

    public ClienteEntity getBit() {
        return cliente;
    }

    public void setBit(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
    public List<ClienteEntity> getLista(){
        return modelo.listarRegistro();
    }
    
    public String guardarRegistro(){
       HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
  
     String usua= request.getSession().getAttribute("usuario").toString();
        System.out.println("USUARIO:"+usua);
    if(modelo.insertarRegistro(cliente)!=1){
    JsfUtil.setErrorMessage(null, "Ya existe un registro");
    return null;
    }else{
       // registro.setAccion("GUARDAR USUARIO:");
        //registro.setUsuario(usua);
        modeloRegistro.insertarRegistro(registro);
    JsfUtil.setFlashMessage("Eureka!", "se ingreso el registro");
    return "clientes?GomezLarios-redirect=true";
   
    }
    }

    public String eliminarRegistro(){
       //leyendo el parametro enviador desde la vista
       String identificador = JsfUtil.getRequest().getParameter("idCliente");
  
       if(modelo.eliminarRegistro(identificador)>0){
           JsfUtil.setFlashMessage("exito", "El caso ha sido eliminado");
       }//fin if
       else{
           JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
       }//fin else
       return "clientes?GomezLarios-redirect=true";
   }//fin del metodo eliminar colaborador
   
   
      public String enviarDato(){
          try{
       HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //String referencia= request.getParameter("idCliente");
        int referencia= Integer.parseInt(request.getParameter("idCliente"));
        cliente= modelo.encontrarReferencia(referencia);
       return "cliente";
          }catch(Exception e){
          return null;
          }
   }
   
    public String modificarRegistro(){
 try{
       if(modelo.modificarRegistro(cliente)>0){
           
           JsfUtil.setFlashMessage("exito", "El registro ha sido editado");
            return "clientes?GomezLarios-redirect=true";
       }//fin if
       else{
           JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo editar el registro");
           return null;
       }//fin else
      
       }catch(Exception e){
          return null;
          }
    }
    


}//fin clase
