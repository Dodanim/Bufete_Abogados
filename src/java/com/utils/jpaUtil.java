/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utils;
import javax.persistence.EntityManager;
 import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author KiDo
 */
public class jpaUtil {
    private static final EntityManagerFactory emFactory;
    static{
    emFactory=
            Persistence.createEntityManagerFactory("Bufete_AbogadosPU");
    }

    public static EntityManager getEntityManager() {
        return  emFactory.createEntityManager();
    }
}
