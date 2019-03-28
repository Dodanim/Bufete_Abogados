/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.faces.context.FacesContext;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author KiDo
 */
public class CrearSession extends HttpServlet{
    private static final long serialVersionUID = 1L;
 
protected void doGet(String objeto) throws ServletException, IOException {
 HttpServletRequest request= (HttpServletRequest) FacesContext
                 .getCurrentInstance().getExternalContext().getRequest();
HttpSession misession= request.getSession(true);
//Producto miproducto= new Producto(1,"telefono",300);
misession.setAttribute("objeto",objeto);
}

}
