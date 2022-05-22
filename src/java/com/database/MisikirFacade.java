/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fedlu
 */
@Stateless
public class MisikirFacade extends AbstractFacade<Misikir> {

    @PersistenceContext(unitName = "AMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MisikirFacade() {
        super(Misikir.class);
    }
public List<Misikir> findByCaseId(String caseid) {
     
         List<Misikir> data=null;
         data=em.createQuery("SELECT w FROM Misikir  w WHERE w.casenumber = :casenumber").setParameter("casenumber", caseid).getResultList();
      return data;
    }
   
}
