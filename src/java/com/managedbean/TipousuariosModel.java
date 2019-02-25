/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;

import com.entities.TipousuarioEntity;
import com.utils.jpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author KiDo
 */
class TipousuariosModel {
    public List<TipousuarioEntity> listarTipos() {
        //obtengo una instsancia de EntityManager
        EntityManager em = jpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("TipousuarioEntity.findAll");
            //El metodo getResultList() de la clase Query permite obtener
            //la lista de resultados de una consulta de seleccion
            List<TipousuarioEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }// fin metodo

    public int ingresarTipoUsuarios(TipousuarioEntity usuario) {
        EntityManager em = jpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            //  usuarios.setPassword(SecurityUtils.encriptarSHA(usuarios.getPassword()));
            tran.begin();

            em.persist(usuario);
            tran.commit();
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }

    }// fin metodo insertar

    public int modificarUsuarios(TipousuarioEntity usuario) {
        EntityManager em = jpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try {
            tra.begin();//iniciando transacion
            em.merge(usuario);//actualiznado el objeto en la BD
            tra.commit(); //confirmando la transaccion
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }// fin del metodo modificar colaborador

    public int eliminarTipoUsuarios(String idTipousuario) {
        EntityManager em = jpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
            //Recuperando el objeto a eliminar
            TipousuarioEntity col = em.find(TipousuarioEntity.class, idTipousuario);
            if (col != null) {
                EntityTransaction tran = em.getTransaction();
                tran.begin();//Iniciando transaccion
                em.remove(col);//Borrando la instancia
                tran.commit();//confirmando la transaccion
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;

        } catch (Exception e) {
            em.close();
            return 0;
        }
    }//fin metodo

    public TipousuarioEntity encontrarTipoUsuario(String idTipoUsuario) {
        EntityManager em = jpaUtil.getEntityManager();
        //recuperando el objeto a modificar
        // EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
        EntityTransaction tran = em.getTransaction();
        tran.begin();//Iniciando transaccion
        Query consulta = em.createNamedQuery("TipousuarioEntity.findByIdTipoUsuario");
        consulta.setParameter("idTipoUsuario", idTipoUsuario);

        TipousuarioEntity bit = (TipousuarioEntity) consulta.getSingleResult();

        tran.commit();//confirmando la transaccion
        em.close();

        return bit;

    }// fin de encontrar colaborador

    
}
