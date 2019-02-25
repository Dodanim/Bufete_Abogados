package com.managedbean;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.entities.UsuarioEntity;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.UsuariosModel;

@ManagedBean
@RequestScoped
public class LoginBean {

    private UsuariosModel usuariosModel = new UsuariosModel();
    private UsuarioEntity user;

    public LoginBean() {
        user = new UsuarioEntity();
    }

    public UsuarioEntity getUser() {
        return user;
    }

    public void setUser(UsuarioEntity user) {
        this.user = user;
    }

    public UsuariosModel getUsuariosModel() {
        return usuariosModel;
    }

    public void setUsuariosModel(UsuariosModel usuariosModel) {
        this.usuariosModel = usuariosModel;
    }

    public String verificarCredenciales() throws Exception {

        user = usuariosModel.checkLogin(user.getIdUsuario(), user.getPassword());

        if (user == null) { // Si las credenciales no son correctas...
            //Pasando mensaje de error a la vista
           
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Credenciales incorrectas", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            // Redireccionando a la pagina actual
            return null;
        } else { // si las credenciales son correctas
            //Obteniendo el request
            HttpServletRequest request = (HttpServletRequest) FacesContext
                    .getCurrentInstance().getExternalContext().getRequest();
            // Definiendo las variables de sesión
         
            request.getSession().setAttribute("usuario", user.getNombre());
            request.getSession().setAttribute("tipoUsuario", user.getIdTipoUsuario().getTipo());
            return "master_BA"; // Redireccionando a la pagina bienvenido.xhtml
        }
    }

    public boolean verificarSesion() throws IOException {
        try{
        boolean estado = true;
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        if (request.getSession().getAttribute("tipoUsuario") == null) {

            estado = false;
            FacesContext.getCurrentInstance().getExternalContext().dispatch("index.xhtml");
            return estado;

        } else {

            estado = true;
            return estado;
        } 
        }catch(Exception e){
            return false;    
                }
    }

    public String cerrarSesion() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext
                    .getCurrentInstance().getExternalContext().getRequest();
            request.getSession().removeAttribute("tipoUsuario");

            return "index";
        } catch (Exception e) {
            return "index";
        }
    }
}
