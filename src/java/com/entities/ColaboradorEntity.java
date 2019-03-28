/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "colaborador")
@NamedQueries({
    @NamedQuery(name = "ColaboradorEntity.findAll", query = "SELECT c FROM ColaboradorEntity c")
    , @NamedQuery(name = "ColaboradorEntity.findByIdColaborador", query = "SELECT c FROM ColaboradorEntity c WHERE c.idColaborador = :idColaborador")
    , @NamedQuery(name = "ColaboradorEntity.findByNombre", query = "SELECT c FROM ColaboradorEntity c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "ColaboradorEntity.findByApellido", query = "SELECT c FROM ColaboradorEntity c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "ColaboradorEntity.findByCorreo", query = "SELECT c FROM ColaboradorEntity c WHERE c.correo = :correo")
    , @NamedQuery(name = "ColaboradorEntity.findByTelefono", query = "SELECT c FROM ColaboradorEntity c WHERE c.telefono = :telefono")})
public class ColaboradorEntity implements Serializable {
 private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdColaborador")
    private String idColaborador;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Correo")
    private String correo;
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(mappedBy = "idColaborador")
    private List<BitacoraEntity> bitacoraEntityList;
    @OneToMany(mappedBy = "idColaborador")
    private List<ColaboradorCasoEntity> colaboradorcasoEntityList;

    public ColaboradorEntity() {
    }

    public ColaboradorEntity(String idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(String idColaborador) {
        this.idColaborador = idColaborador;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
   
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<BitacoraEntity> getBitacoraEntityList() {
        return bitacoraEntityList;
    }

    public void setBitacoraEntityList(List<BitacoraEntity> bitacoraEntityList) {
        this.bitacoraEntityList = bitacoraEntityList;
    }

    public List<ColaboradorCasoEntity> getColaboradorcasoEntityList() {
        return colaboradorcasoEntityList;
    }

    public void setColaboradorcasoEntityList(List<ColaboradorCasoEntity> colaboradorcasoEntityList) {
        this.colaboradorcasoEntityList = colaboradorcasoEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColaborador != null ? idColaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColaboradorEntity)) {
            return false;
        }
        ColaboradorEntity other = (ColaboradorEntity) object;
        if ((this.idColaborador == null && other.idColaborador != null) || (this.idColaborador != null && !this.idColaborador.equals(other.idColaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.ColaboradorEntity[ idColaborador=" + idColaborador + " ]";
    }


   
    
}
