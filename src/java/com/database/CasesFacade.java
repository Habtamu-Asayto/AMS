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
 * @author habtamu
 */
@Stateless
public class CasesFacade extends AbstractFacade<Cases> {

    @PersistenceContext(unitName = "AMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CasesFacade() {
        super(Cases.class);
    }
    public List<Cases> findCasebyId(int num) {
      List<Cases> cases = null;
      cases = em.createQuery("SELECT c FROM Cases c WHERE c.caseStatus = :st").setParameter("st", num).getResultList();
      return cases;
   }

    public List<Cases> findImportantCasebyId(String level) {
      List<Cases> cases = null;
      cases = em.createQuery("SELECT c FROM Cases c WHERE c.caseLevel = :st").setParameter("st", level).getResultList();
      return cases;
   }
}
