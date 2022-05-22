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
public class MekinashiyachFacade extends AbstractFacade<Mekinashiyach> {

    @PersistenceContext(unitName = "AMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MekinashiyachFacade() {
        super(Mekinashiyach.class);
    }

    public List<Mekinashiyach> findByCaseId(String caseid) {
        
          List<Mekinashiyach> data=null;
         data=em.createQuery("SELECT w FROM Mekinashiyach w WHERE w.caseid = :casenumber").setParameter("casenumber", caseid).getResultList();
      return data;
    }
    
}
