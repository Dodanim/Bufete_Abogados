/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author KiDo
 */
@Entity
@Table(name = "tipousuario")
@NamedQueries({
    @NamedQuery(name = "TipousuarioEntity.findAll", query = "SELECT t FROM TipousuarioEntity t")
    , @NamedQuery(name = "TipousuarioEntity.findByIdTipoUsuario", query = "SELECT t FROM TipousuarioEntity t WHERE t.idTipoUsuario = :idTipoUsuario")
    , @NamedQuery(name = "TipousuarioEntity.findByTipo", query = "SELECT t FROM TipousuarioEntity t WHERE t.tipo = :tipo")})
public class TipousuarioEntity implements Serializable {
private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdTipoUsuario")
    private String idTipoUsuario;
    @Basic(optional = false)
    @Column(name = "Tipo")
    private String tipo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoUsuario")
    private List<UsuarioEntity> usuarioEntityList;

    public TipousuarioEntity() {
    }

    public TipousuarioEntity(String idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public TipousuarioEntity(String idTipoUsuario, String tipo) {
        this.idTipoUsuario = idTipoUsuario;
        this.tipo = tipo;
    }

    public String getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(String idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<UsuarioEntity> getUsuarioEntityList() {
        return usuarioEntityList;
    }

    public void setUsuarioEntityList(List<UsuarioEntity> usuarioEntityList) {
        this.usuarioEntityList = usuarioEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoUsuario != null ? idTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipousuarioEntity)) {
            return false;
        }
        TipousuarioEntity other = (TipousuarioEntity) object;
        if ((this.idTipoUsuario == null && other.idTipoUsuario != null) || (this.idTipoUsuario != null && !this.idTipoUsuario.equals(other.idTipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.TipousuarioEntity[ idTipoUsuario=" + idTipoUsuario + " ]";
    }   
}
