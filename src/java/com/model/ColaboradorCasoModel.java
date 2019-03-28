/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author KiDo
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigDecimal;
import com.utils.jpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.entities.ColaboradorCasoEntity;
/**
 *
 * @author Kido
 */
public class ColaboradorCasoModel {
     public List<ColaboradorCasoEntity>listarColCasos(){
    //obtengo una instsancia de EntityManager
    EntityManager em = jpaUtil.getEntityManager();
    try{
    Query consulta = em.createNamedQuery("ColaboradorCasoEntity.findAll");
    //El metodo getResultList() de la clase Query permite obtener
    //la lista de resultados de una consulta de seleccion
    List<ColaboradorCasoEntity> lista=consulta.getResultList();
    em.close();
    return lista;
    }catch(Exception e){
    em.close();
    return null;
    }
    }// fin metodo
    
    public int ingresarColCaso(ColaboradorCasoEntity idColaboradorCaso){
        EntityManager em = jpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(idColaboradorCaso);
            tran.commit();
            em.close();
            return 1;
        } catch(Exception e){
            em.close();
            return 0;
        }
    
    }// fin metodo insertar
   public int modificarColCaso(ColaboradorCasoEntity idColaboradorCaso){
       EntityManager em = jpaUtil.getEntityManager();
       EntityTransaction tra = em.getTransaction();
       try{
       tra.begin();//iniciando transacion
       em.merge(idColaboradorCaso);//actualiznado el objeto en la BD
       tra.commit(); //confirmando la transaccion
       em.close();
       return 1;
       }catch(Exception e){
           em.close();
           return 0;
       }
   }// fin del metodo modificar colaborador
   public int eliminarColCaso(String idColaboradorCaso){
       EntityManager em = jpaUtil.getEntityManager();
       int filasBorradas = 0;
       try{
       //Recuperando el objeto a eliminar
       ColaboradorCasoEntity col = em.find(ColaboradorCasoEntity.class, idColaboradorCaso);
       if(col !=null){
           EntityTransaction tran= em.getTransaction();
           tran.begin();//Iniciando transaccion
           em.remove(col);//Borrando la instancia
           tran.commit();//confirmando la transaccion
           filasBorradas=1;
       }em.close();
       return filasBorradas;
       
       
       }catch(Exception e){
           em.close();
           return 0;
       }
   }//fin metodo
   
   public ColaboradorCasoEntity encontrarColCaso(String idColaboradorCaso){
        EntityManager em = jpaUtil.getEntityManager();
        //recuperando el objeto a modificar
    // EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
      EntityTransaction tran= em.getTransaction();
       tran.begin();//Iniciando transaccion
         Query consulta = em.createNamedQuery("ColaboradorCasoEntity.findByIdColaboradorCaso");
               consulta.setParameter("idColaboradorCaso", idColaboradorCaso);
     
     ColaboradorCasoEntity cas=(ColaboradorCasoEntity) consulta.getSingleResult();
            cas.getIdColaboradorCaso();
           cas.getReferencia();
          cas.getIdColaborador();
            
            
            
       tran.commit();//confirmando la transaccion
            em.close();
     
     return cas;
     
   }// fin de encontrar colaborador
}
