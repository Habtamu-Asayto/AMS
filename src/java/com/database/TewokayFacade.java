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
public class TewokayFacade extends AbstractFacade<Tewokay> {

    @PersistenceContext(unitName = "AMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TewokayFacade() {
        super(Tewokay.class);
    }

    public List<Tewokay> findByCaseId(String caseid) {
     
         List<Tewokay> data=null;
         data=em.createQuery("SELECT w FROM Tewokay  w WHERE w.casenumber = :casenumber").setParameter("casenumber", caseid).getResultList();
      return data;
    }
    
}
