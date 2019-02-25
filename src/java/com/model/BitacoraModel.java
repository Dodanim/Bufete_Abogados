/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;
import com.utils.jpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.entities.BitacoraEntity;
import com.entities.CasoEntity;
/**
 *
 * @author KiDo
 */
public class BitacoraModel {
    public List<BitacoraEntity> listarRegistro(){
        EntityManager em = jpaUtil.getEntityManager();
         try{
             Query consulta = em.createNamedQuery("BitacoraEntity.findAll");
             List<BitacoraEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        } catch(Exception e){
            em.close();
            return null;
        }
    
    }
    public BitacoraEntity obtenerRegistro(String clave){
    EntityManager em = jpaUtil.getEntityManager();
        try{
            BitacoraEntity bitacora;
        bitacora = em.find(BitacoraEntity.class, clave);
        em.close();
        return bitacora;
        }catch(Exception e){
        em.close();
        return null;
        }
    }
    
    public int insertarRegistro(BitacoraEntity bitacora){
    EntityManager em = jpaUtil.getEntityManager();
    EntityTransaction tran = em.getTransaction();
    try{
    tran.begin();
    em.persist(bitacora);
    tran.commit();
    em.close();
    return 1;
    } catch(Exception e){
    em.close();
    return 0;
    }
    }
    
    public int modificarRegistro(BitacoraEntity bitacora){
    EntityManager em = jpaUtil.getEntityManager();
     EntityTransaction tran = em.getTransaction();
     try{
     tran.begin();
     em.merge(bitacora);
     tran.commit();
     em.close();
     return 1;
     }catch(Exception e){
     em.close();
         return 0;
     }
    }
    
    public int eliminarRegistro(String clave){
    EntityManager em = jpaUtil.getEntityManager();
    int filaBorrada=0;
    try{
        BitacoraEntity bit = em.find(BitacoraEntity.class, clave);
    if(bit != null){
    EntityTransaction tran = em.getTransaction();
        tran.begin();
    em.remove(bit);
    tran.commit();
    filaBorrada=-1;
    }
    em.close();
    return filaBorrada;
                
    }catch(Exception e){
    em.close();
        return 0;
    }
    }
    
    
     public BitacoraEntity encontrarReferencia(String referencia) {
        EntityManager em = jpaUtil.getEntityManager();
        //recuperando el objeto a modificar
        // EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
        EntityTransaction tran = em.getTransaction();
        tran.begin();//Iniciando transaccion
        Query consulta = em.createNamedQuery("BitacoraEntity.findByReferenciaR");
        consulta.setParameter("referencia", referencia);
        BitacoraEntity bit = (BitacoraEntity) consulta.getSingleResult();
        tran.commit();//confirmando la transaccion
        em.close();
        return bit;

    }// fin de encontrar avance pro referencia
     
     public List<BitacoraEntity> encontrarAvance(String referencia) {
        EntityManager em = jpaUtil.getEntityManager();
          EntityTransaction tran = em.getTransaction();
        tran.begin();//Iniciando transaccion
        Query consulta = em.createNamedQuery("BitacoraEntity.findByReferencia");
        consulta.setParameter("referencia", referencia);
        List<BitacoraEntity> lista = consulta.getResultList();
        tran.commit();//confirmando la transaccion
        em.close();

        return lista;

    }// fin de encontrar avances
public void Limpiar(){

}
}// fin clase
