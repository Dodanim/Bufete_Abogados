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
import com.entities.ColaboradorEntity;
import javax.persistence.NoResultException;

/**
 *
 * @author KiDo
 */
public class ColaboradorModel {
public List<ColaboradorEntity> listarRegistro() {
        EntityManager em = jpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("ColaboradorEntity.findAll");
            List<ColaboradorEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }

    }
//    public List<ClienteEntity> listarRegistroA(){
//        EntityManager em = jpaUtil.getEntityManager();
//         try{
//             Query consulta = em.createNamedQuery("ClienteEntity.findAllA");
//             List<ClienteEntity> lista = consulta.getResultList();
//            em.close();
//            return lista;
//        } catch(Exception e){
//            em.close();
//            return null;
//        }
//    
//    }

    public ColaboradorEntity obtenerRegistro(String clave) {
        EntityManager em = jpaUtil.getEntityManager();
        try {
            ColaboradorEntity bit;
            bit = em.find(ColaboradorEntity.class, clave);
            em.close();
            return bit;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    public int insertarRegistro(ColaboradorEntity bit) {
        EntityManager em = jpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(bit);
            tran.commit();
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }

    public int modificarRegistro(ColaboradorEntity bit) {
        EntityManager em = jpaUtil.getEntityManager();

        int modificada = 0;
        try {
            // ClienteEntity bit= em.find(ClienteEntity.class, registro);
            if (bit != null) {
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.merge(bit);
                tran.commit();
                em.close();
                modificada = 1;
                return modificada;
            } else {
                return 0;
            }

        } catch (Exception e) {
            em.close();
            return 0;
        }
    }

    public int eliminarRegistro(String clave) {

        EntityManager em = jpaUtil.getEntityManager();
        int filaBorrada = 0;
        try {
            ColaboradorEntity bit = em.find(ColaboradorEntity.class, Integer.parseInt(clave));

            if (bit != null) {
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(bit);
                tran.commit();
                filaBorrada = 1;
            }
            em.close();
            return filaBorrada;

        } catch (Exception e) {
            em.close();
            return 0;
        }
    }

    public ColaboradorEntity encontrarReferencia(String referencia) {
        try {
            EntityManager em = jpaUtil.getEntityManager();
            //recuperando el objeto a modificar
            // EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
            EntityTransaction tran = em.getTransaction();
            tran.begin();//Iniciando transaccion
            Query consulta = em.createNamedQuery("ColaboradorEntity.findByIdColaborador");
            consulta.setParameter("idColaborador", referencia);
            ColaboradorEntity cliente = (ColaboradorEntity) consulta.getSingleResult();
            tran.commit();//confirmando la transaccion
            em.close();
            return cliente;

        } catch (NoResultException e) {
            return null;
        }
    }// fin de encontrar avance pro referencia
}// fin clase
