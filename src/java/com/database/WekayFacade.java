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
public class WekayFacade extends AbstractFacade<Wekay> {

    @PersistenceContext(unitName = "AMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WekayFacade() {
        super(Wekay.class);
    }

    public List<Wekay> findByCaseId(String caseid) {
        List<Wekay> data=null;
         data=em.createQuery("SELECT w FROM Wekay w WHERE w.casenumber = :casenumber").setParameter("casenumber", caseid).getResultList();
      return data;
    }
    
}
