/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author memoriasIT
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "estudioCRUDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
    public Product getProductByID(Integer ID){
         Query q;
         List<Product> list;
         
         q = this.em.createNamedQuery("Product.findByProductId");
         q.setParameter("productId", ID);
         
         list = q.getResultList();
         
         if(list != null &&!list.isEmpty()){
             return list.get(0);
         } else {
             return null;
         }
    }
    
}
