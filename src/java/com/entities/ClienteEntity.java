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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "ClienteEntity.findAll", query = "SELECT c FROM ClienteEntity c where c.estado=1")
    , @NamedQuery(name = "ClienteEntity.findAllA", query = "SELECT c FROM ClienteEntity c")
    , @NamedQuery(name = "ClienteEntity.findByIdCliente", query = "SELECT c FROM ClienteEntity c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "ClienteEntity.findByDi", query = "SELECT c FROM ClienteEntity c WHERE c.di = :di")
    , @NamedQuery(name = "ClienteEntity.findByNombre", query = "SELECT c FROM ClienteEntity c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "ClienteEntity.findByApellido", query = "SELECT c FROM ClienteEntity c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "ClienteEntity.findByRepresentanteLegal", query = "SELECT c FROM ClienteEntity c WHERE c.representanteLegal = :representanteLegal")
    , @NamedQuery(name = "ClienteEntity.findByCorreo", query = "SELECT c FROM ClienteEntity c WHERE c.correo = :correo")
    , @NamedQuery(name = "ClienteEntity.findByTelefono", query = "SELECT c FROM ClienteEntity c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "ClienteEntity.findByDireccion", query = "SELECT c FROM ClienteEntity c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "ClienteEntity.findByEstado", query = "SELECT c FROM ClienteEntity c WHERE c.estado = :estado")})
public class ClienteEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCliente")
    private Integer idCliente;
    @Basic(optional = false)
    @Column(name = "DI")
    private String di;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "RepresentanteLegal")
    private String representanteLegal;
    @Column(name = "Correo")
    private String correo;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;


   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<CasoEntity> casoEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<PoderEntity> poderEntityList;

    public ClienteEntity() {
    }

    public ClienteEntity(Integer idCliente) {
        this.idCliente = idCliente;
    }

//    public ClienteEntity(Integer idCliente, String di, boolean estado) {
//        this.idCliente = idCliente;
//        this.di = di;
//        this.estado = estado;
//    }
   public ClienteEntity(Integer idCliente,String di,String nombre,String apellido,
        String representanteLegal,String correo,String telefono,String direccion,boolean estado){
    this.idCliente=idCliente;
    this.di=di;
    this.nombre=nombre;
    this.apellido=apellido;
    this.representanteLegal=representanteLegal;
    this.correo=correo;
    this.telefono=telefono;
    this.direccion=direccion;
    this.estado=estado;
}
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getDi() {
        return di;
    }

    public void setDi(String di) {
        this.di = di;
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

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<CasoEntity> getCasoEntityList() {
        return casoEntityList;
    }

    public void setCasoEntityList(List<CasoEntity> casoEntityList) {
        this.casoEntityList = casoEntityList;
    }

    public List<PoderEntity> getPoderEntityList() {
        return poderEntityList;
    }

    public void setPoderEntityList(List<PoderEntity> poderEntityList) {
        this.poderEntityList = poderEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteEntity)) {
            return false;
        }
        ClienteEntity other = (ClienteEntity) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.ClienteEntity[ idCliente=" + idCliente + " ]";
    }

  
    
}
