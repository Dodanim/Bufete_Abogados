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
@Table(name = "bitacora")
@NamedQueries({
    @NamedQuery(name = "BitacoraEntity.findAll", query = "SELECT b FROM BitacoraEntity b")
    , @NamedQuery(name = "BitacoraEntity.findByIdBitacora", query = "SELECT b FROM BitacoraEntity b WHERE b.idBitacora = :idBitacora")
     ,@NamedQuery(name = "BitacoraEntity.findByReferencia", query = "SELECT b FROM BitacoraEntity b WHERE b.referencia.referencia = :referencia")
     , @NamedQuery(name = "BitacoraEntity.findByDetalle", query = "SELECT b FROM BitacoraEntity b WHERE b.detalle = :detalle")
    , @NamedQuery(name = "BitacoraEntity.findByFecha", query = "SELECT b FROM BitacoraEntity b WHERE b.fecha = :fecha")})
public class BitacoraEntity implements Serializable {
private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdBitacora")
    private Integer idBitacora;
    @Column(name = "Detalle")
    private String detalle;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
@JoinColumn(name = "IdColaborador", referencedColumnName = "IdColaborador")
    @ManyToOne
    private ColaboradorEntity idColaborador;
    @JoinColumn(name = "Referencia", referencedColumnName = "Referencia")
    @ManyToOne(optional = false)
    private CasoEntity referencia;

    public BitacoraEntity() {
    }

    public BitacoraEntity(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }
// esto es nuevo se genero por la claswe converter de la bitacora
    public BitacoraEntity(String trimmedValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//solo ese pedacito es...
    public Integer getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBitacora != null ? idBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitacoraEntity)) {
            return false;
        }
        BitacoraEntity other = (BitacoraEntity) object;
        if ((this.idBitacora == null && other.idBitacora != null) || (this.idBitacora != null && !this.idBitacora.equals(other.idBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.BitacoraEntity[ idBitacora=" + idBitacora + " ]";
    }

  

    public BitacoraEntity(Integer idBitacora, boolean estado) {
        this.idBitacora = idBitacora;
        this.estado = estado;
    }


    
}
