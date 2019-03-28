/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.entities.PoderEntity;
import com.entities.ClienteEntity;
import com.model.PoderModel;
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
public class PoderBean {
PoderModel modelo = new PoderModel();
private ClienteModel clienteModelo = new ClienteModel();
private PoderEntity registro;
private List<PoderEntity> lista;
private List<ClienteEntity> listaClientes;

    public List<ClienteEntity> getListaClientes() {
        return clienteModelo.listarRegistro();
    }

    public void setListaClientes(List<ClienteEntity> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public PoderModel getModelo() {
        return modelo;
    }

    public void setModelo(PoderModel modelo) {
        this.modelo = modelo;
    }

    public PoderEntity getRegistro() {
        return registro;
    }

    public void setRegistro(PoderEntity registro) {
        this.registro = registro;
    }

    public List<PoderEntity> getLista() {
        return modelo.listarRegistro();
    }

    public void setLista(List<PoderEntity> lista) {
        this.lista = lista;
    }


   
/**
     * Creates a new instance of BitacoraBean
     */
    public PoderBean() {
        registro = new PoderEntity();
    }

  
    
    public String guardarRegistro(){
    if(modelo.insertarRegistro(registro)!=1){
    JsfUtil.setErrorMessage(null, "Ya existe un registro");
    return null;
    }else{
    JsfUtil.setFlashMessage("Eureka!", "se ingreso el registro");
    }
    return "clientes?GomezLarios-redirect=true";
    }

    public String eliminarRegistro(){
       //leyendo el parametro enviador desde la vista
       String identificador = JsfUtil.getRequest().getParameter("identificador");
      
       if(modelo.eliminarRegistro(identificador)>0){
           JsfUtil.setFlashMessage("exito", "El caso ha sido eliminado");
       }//fin if
       else{
           JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo borrar el registro");
       }//fin else
       return "poderes?GomezLarios-redirect=true";
   }//fin del metodo eliminar colaborador
   
   
      public String enviarDato(){
          try{
       HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //String referencia= request.getParameter("idCliente");
        int referencia= Integer.parseInt(request.getParameter("idregistro"));
        registro = modelo.encontrarReferencia(referencia);
       return "registro";
          }catch(Exception e){
          return null;
          }
   }
   
    public String modificarRegistro(){

       if(modelo.modificarRegistro(registro)>0){
           
           JsfUtil.setFlashMessage("exito", "El registro ha sido editado");
       }//fin if
       else{
           JsfUtil.setErrorMessage(null, "Lo sentimos, no se pudo editar el registro");
       }//fin else
      
       return "poderes?GomezLarios-redirect=true";
    }
    


}//fin clase
