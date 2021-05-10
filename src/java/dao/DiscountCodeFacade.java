/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.DiscountCode;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author memoriasIT
 */
@Stateless
public class DiscountCodeFacade extends AbstractFacade<DiscountCode> {

    @PersistenceContext(unitName = "estudioCRUDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiscountCodeFacade() {
        super(DiscountCode.class);
    }
    
}
