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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author KiDo
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "UsuarioEntity.findAll", query = "SELECT u FROM UsuarioEntity u")
    , @NamedQuery(name = "UsuarioEntity.findByIdUsuario", query = "SELECT u FROM UsuarioEntity u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "UsuarioEntity.findByNombre", query = "SELECT u FROM UsuarioEntity u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "UsuarioEntity.findByApellido", query = "SELECT u FROM UsuarioEntity u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "UsuarioEntity.checkLogin", query = "SELECT u FROM UsuarioEntity u WHERE u.idUsuario = :idUsuario AND u.password = :password")
        , @NamedQuery(name = "UsuarioEntity.findByPassword", query = "SELECT u FROM UsuarioEntity u WHERE u.password = :password")})
public class UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdUsuario")
    private String idUsuario;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
@JoinColumn(name = "IdTipoUsuario", referencedColumnName = "IdTipoUsuario")
    @ManyToOne(optional = false)
    private TipousuarioEntity idTipoUsuario;

    public UsuarioEntity() {
    }

    public UsuarioEntity(String idUsuario) {
        this.idUsuario = idUsuario;
    }

// public UsuarioEntity(String idUsuario, String nombre, String apellido, String password, boolean estado) {
//        this.idUsuario = idUsuario;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.password = password;
//        this.estado = estado;
//    }


    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipousuarioEntity getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TipousuarioEntity idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioEntity)) {
            return false;
        }
        UsuarioEntity other = (UsuarioEntity) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.UsuarioEntity[ idUsuario=" + idUsuario + " ]";
    }

}
