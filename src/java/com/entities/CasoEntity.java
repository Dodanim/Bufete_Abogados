/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author KiDo
 */
@Entity
@Table(name = "caso")
@NamedQueries({
    @NamedQuery(name = "CasoEntity.findAll", query = "SELECT c FROM CasoEntity c order by c.estado")
    , @NamedQuery(name = "CasoEntity.findByReferencia", query = "SELECT c FROM CasoEntity c WHERE c.referencia = :referencia")
    , @NamedQuery(name = "CasoEntity.findByTituloCaso", query = "SELECT c FROM CasoEntity c WHERE c.tituloCaso = :tituloCaso")
    , @NamedQuery(name = "CasoEntity.findByMateria", query = "SELECT c FROM CasoEntity c WHERE c.materia = :materia")
    , @NamedQuery(name = "CasoEntity.findByJuzgado", query = "SELECT c FROM CasoEntity c WHERE c.juzgado = :juzgado")
    , @NamedQuery(name = "CasoEntity.findByNumJuez", query = "SELECT c FROM CasoEntity c WHERE c.numJuez = :numJuez")
    , @NamedQuery(name = "CasoEntity.findByDemandante", query = "SELECT c FROM CasoEntity c WHERE c.demandante = :demandante")
    , @NamedQuery(name = "CasoEntity.findByDemandado", query = "SELECT c FROM CasoEntity c WHERE c.demandado = :demandado")
    , @NamedQuery(name = "CasoEntity.findByProceso", query = "SELECT c FROM CasoEntity c WHERE c.proceso = :proceso")
    , @NamedQuery(name = "CasoEntity.findByJurisprudencia", query = "SELECT c FROM CasoEntity c WHERE c.jurisprudencia = :jurisprudencia")
    , @NamedQuery(name = "CasoEntity.findByDetalleCaso", query = "SELECT c FROM CasoEntity c WHERE c.detalleCaso = :detalleCaso")
    , @NamedQuery(name = "CasoEntity.findByReferenciaExterna", query = "SELECT c FROM CasoEntity c WHERE c.referenciaExterna = :referenciaExterna")
    , @NamedQuery(name = "CasoEntity.findByFechaInicio", query = "SELECT c FROM CasoEntity c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "CasoEntity.findByFechaFin", query = "SELECT c FROM CasoEntity c WHERE c.fechaFin = :fechaFin")})
public class CasoEntity implements Serializable {
private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Referencia")
    private String referencia;
    @Column(name = "TituloCaso")
    private String tituloCaso;
    @Basic(optional = false)
    @Column(name = "Materia")
    private String materia;
    @Column(name = "Juzgado")
    private String juzgado;
    @Column(name = "NumJuez")
    private String numJuez;
    @Column(name = "Demandante")
    private String demandante;
    @Column(name = "Demandado")
    private String demandado;
    @Column(name = "Proceso")
    private String proceso;
    @Column(name = "Jurisprudencia")
    private String jurisprudencia;
    @Column(name = "DetalleCaso")
    private String detalleCaso;
    @Column(name = "ReferenciaExterna")
    private String referenciaExterna;
    @Column(name = "FechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "IdCliente", referencedColumnName = "IdCliente")
    @ManyToOne(optional = false)
    private ClienteEntity idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referencia")
    private List<BitacoraEntity> bitacoraEntityList;
    @OneToMany(mappedBy = "referencia")
    private List<ColaboradorCasoEntity> colaboradorcasoEntityList;

    public CasoEntity() {
    }

//    public CasoEntity(String referencia) {
//        this.referencia = referencia;
//    }
//
//    public CasoEntity(String referencia, String materia) {
//        this.referencia = referencia;
//        this.materia = materia;
//    }

    public CasoEntity(String referencia, String materia, boolean estado) {
        this.referencia = referencia;
        this.materia = materia;
        this.estado = estado;
    }

    
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTituloCaso() {
        return tituloCaso;
    }

    public void setTituloCaso(String tituloCaso) {
        this.tituloCaso = tituloCaso;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getJuzgado() {
        return juzgado;
    }

    public void setJuzgado(String juzgado) {
        this.juzgado = juzgado;
    }

    public String getNumJuez() {
        return numJuez;
    }

    public void setNumJuez(String numJuez) {
        this.numJuez = numJuez;
    }

    public String getDemandante() {
        return demandante;
    }

    public void setDemandante(String demandante) {
        this.demandante = demandante;
    }

    public String getDemandado() {
        return demandado;
    }

    public void setDemandado(String demandado) {
        this.demandado = demandado;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getJurisprudencia() {
        return jurisprudencia;
    }

    public void setJurisprudencia(String jurisprudencia) {
        this.jurisprudencia = jurisprudencia;
    }

    public String getDetalleCaso() {
        return detalleCaso;
    }

    public void setDetalleCaso(String detalleCaso) {
        this.detalleCaso = detalleCaso;
    }

    public String getReferenciaExterna() {
        return referenciaExterna;
    }

    public void setReferenciaExterna(String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ClienteEntity getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteEntity idCliente) {
        this.idCliente = idCliente;
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
        hash += (referencia != null ? referencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoEntity)) {
            return false;
        }
        CasoEntity other = (CasoEntity) object;
        if ((this.referencia == null && other.referencia != null) || (this.referencia != null && !this.referencia.equals(other.referencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.CasoEntity[ referencia=" + referencia + " ]";
    }



    
    
}
