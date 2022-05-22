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
public class ZonesFacade extends AbstractFacade<Zones> {

    @PersistenceContext(unitName = "AMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZonesFacade() {
        super(Zones.class);
    }

   public List<Zones> findbyregion(Integer id) {
       List<Zones> allbyregion;
        allbyregion=em.createQuery("SELECT z FROM Zones z WHERE z.regionid.id = :id").setParameter("id", id).getResultList();
         return allbyregion;
    }
    
}
