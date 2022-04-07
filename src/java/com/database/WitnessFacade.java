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
public class WitnessFacade extends AbstractFacade<Witness> {

    @PersistenceContext(unitName = "AMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WitnessFacade() {
        super(Witness.class);
    }
     public void createNew(Witness wit) {
        em.persist(wit);
    }

    public List<Witness> findByCaseId(int caseId) {
          List<Witness> wit = null;
          wit = em.createQuery("SELECT c FROM Witness c WHERE c.onecase.id = :st").setParameter("st", caseId).getResultList();
          return wit;
    }
    
}
