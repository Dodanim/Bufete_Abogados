/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author KiDo
 */
@Entity
@Table(name = "log_usuario")
@NamedQueries({
    @NamedQuery(name = "LogUsuarioEntity.findAll", query = "SELECT l FROM LogUsuarioEntity l")
    , @NamedQuery(name = "LogUsuarioEntity.findByIdAccion", query = "SELECT l FROM LogUsuarioEntity l WHERE l.idAccion = :idAccion")
    , @NamedQuery(name = "LogUsuarioEntity.findByAccion", query = "SELECT l FROM LogUsuarioEntity l WHERE l.accion = :accion")
    , @NamedQuery(name = "LogUsuarioEntity.findByUsuario", query = "SELECT l FROM LogUsuarioEntity l WHERE l.usuario = :usuario")})
public class LogUsuarioEntity implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_accion")
    private Integer idAccion;
    @Basic(optional = false)
    @Column(name = "accion")
    private String accion;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;

  
    
   

    public LogUsuarioEntity() {
    }

    public LogUsuarioEntity(Integer idAccion) {
        this.idAccion = idAccion;
    }

    public LogUsuarioEntity(Integer idAccion, String accion, String usuario) {
        this.idAccion = idAccion;
        this.accion = accion;
        this.usuario = usuario;
    }

    public Integer getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Integer idAccion) {
        this.idAccion = idAccion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccion != null ? idAccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogUsuarioEntity)) {
            return false;
        }
        LogUsuarioEntity other = (LogUsuarioEntity) object;
        if ((this.idAccion == null && other.idAccion != null) || (this.idAccion != null && !this.idAccion.equals(other.idAccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.LogUsuarioEntity[ idAccion=" + idAccion + " ]";
    }
    
}
