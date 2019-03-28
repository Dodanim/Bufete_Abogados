/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author KiDo
 */
@Entity
@Table(name = "colaboradorcaso")
@NamedQueries({
    @NamedQuery(name = "ColaboradorcasoEntity.findAll", query = "SELECT c FROM ColaboradorCasoEntity c")
    , @NamedQuery(name = "ColaboradorcasoEntity.findByIdColaboradorCaso", query = "SELECT c FROM ColaboradorCasoEntity c WHERE c.idColaboradorCaso = :idColaboradorCaso")
    , @NamedQuery(name = "ColaboradorcasoEntity.findByFechaAsignacion", query = "SELECT c FROM ColaboradorCasoEntity c WHERE c.fechaAsignacion = :fechaAsignacion")})
public class ColaboradorCasoEntity implements Serializable {
private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdColaboradorCaso")
    private Integer idColaboradorCaso;
    @Basic(optional = false)
    @Column(name = "fechaAsignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;

    
    @JoinColumn(name = "IdColaborador", referencedColumnName = "IdColaborador")
    @ManyToOne
    private ColaboradorEntity idColaborador;
    @JoinColumn(name = "Referencia", referencedColumnName = "Referencia")
    @ManyToOne
    private CasoEntity referencia;

    public ColaboradorCasoEntity() {
    }

    public ColaboradorCasoEntity(Integer idColaboradorCaso) {
        this.idColaboradorCaso = idColaboradorCaso;
    }

    public ColaboradorCasoEntity(Integer idColaboradorCaso, Date fechaAsignacion) {
        this.idColaboradorCaso = idColaboradorCaso;
        this.fechaAsignacion = fechaAsignacion;
    }

    public Integer getIdColaboradorCaso() {
        return idColaboradorCaso;
    }

    public void setIdColaboradorCaso(Integer idColaboradorCaso) {
        this.idColaboradorCaso = idColaboradorCaso;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public ColaboradorEntity getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(ColaboradorEntity idColaborador) {
        this.idColaborador = idColaborador;
    }

    public CasoEntity getReferencia() {
        return referencia;
    }

    public void setReferencia(CasoEntity referencia) {
        this.referencia = referencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColaboradorCaso != null ? idColaboradorCaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColaboradorCasoEntity)) {
            return false;
        }
        ColaboradorCasoEntity other = (ColaboradorCasoEntity) object;
        if ((this.idColaboradorCaso == null && other.idColaboradorCaso != null) || (this.idColaboradorCaso != null && !this.idColaboradorCaso.equals(other.idColaboradorCaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.ColaboradorcasoEntity[ idColaboradorCaso=" + idColaboradorCaso + " ]";
    }


 
    
}
