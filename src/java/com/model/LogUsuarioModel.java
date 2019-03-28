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
import com.entities.LogUsuarioEntity;
import javax.persistence.NoResultException;
/**
 *
 * @author KiDo
 */
public class LogUsuarioModel {
    public List<LogUsuarioEntity> listarRegistro(){
        EntityManager em = jpaUtil.getEntityManager();
         try{
             Query consulta = em.createNamedQuery("LogUsuarioEntity.findAll");
             List<LogUsuarioEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        } catch(Exception e){
            em.close();
            return null;
        }
    
    }
    public List<LogUsuarioEntity> listarRegistroA(){
        EntityManager em = jpaUtil.getEntityManager();
         try{
             Query consulta = em.createNamedQuery("ClienteEntity.findAllA");
             List<LogUsuarioEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        } catch(Exception e){
            em.close();
            return null;
        }
    
    }
    
    public LogUsuarioEntity obtenerRegistro(String clave){
    EntityManager em = jpaUtil.getEntityManager();
        try{
            LogUsuarioEntity bit;
        bit = em.find(LogUsuarioEntity.class, clave);
        em.close();
        return bit;
        }catch(Exception e){
        em.close();
        return null;
        }
    }
    
    public int insertarRegistro(LogUsuarioEntity bit){
    EntityManager em = jpaUtil.getEntityManager();
    EntityTransaction tran = em.getTransaction();
    try{
    tran.begin();
    em.persist(bit);
    tran.commit();
    em.close();
    return 1;
    } catch(Exception e){
    em.close();
    return 0;
    }
    }
    
    public int modificarRegistro(LogUsuarioEntity bit){
    EntityManager em = jpaUtil.getEntityManager();
   
     int modificada=0;
     try{
        // ClienteEntity bit= em.find(ClienteEntity.class, registro);
     if(bit!=null){
     EntityTransaction tran = em.getTransaction();
    tran.begin();
     em.merge(bit);
     tran.commit();
     em.close();
     modificada=1;
     return modificada;
     }
     else{
     return 0;
     } 
     
     }catch(Exception e){
     em.close();
         return 0;
     }
    }
    
    public int eliminarRegistro(String clave){
       
    EntityManager em = jpaUtil.getEntityManager();
    int filaBorrada=0;
    try{
        LogUsuarioEntity bit = em.find(LogUsuarioEntity.class,Integer.parseInt(clave));
        
    if(bit != null){
    EntityTransaction tran = em.getTransaction();
        tran.begin();
    em.remove(bit);
    tran.commit();
    filaBorrada=1;
    }
    em.close();
    return filaBorrada;
                
    }catch(Exception e){
    em.close();
        return 0;
    }
    }
    
    
     public LogUsuarioEntity encontrarReferencia(Integer referencia) {
         try{
        EntityManager em = jpaUtil.getEntityManager();
        //recuperando el objeto a modificar
        // EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
        EntityTransaction tran = em.getTransaction();
        tran.begin();//Iniciando transaccion
        Query consulta = em.createNamedQuery("LogUsuarioEntity.findByUsuario");
        consulta.setParameter("usuario", referencia);
        LogUsuarioEntity cliente = (LogUsuarioEntity) consulta.getSingleResult();
        tran.commit();//confirmando la transaccion
        em.close();
        return cliente;
        
         }catch(NoResultException e){
         return null;
         }
    }// fin de encontrar avance pro referencia
}// fin clase
