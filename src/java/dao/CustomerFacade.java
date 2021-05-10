/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Customer;
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
public class CustomerFacade extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "estudioCRUDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
    public Customer findCustomerByID(Integer ID){
        Query q;
        List<Customer> clientes;
        
        q = this.em.createNamedQuery("Customer.findByCustomerId");
        q.setParameter("customerId", ID);
        
        clientes = q.getResultList();
        
        if (clientes != null && clientes.isEmpty() == false){
            return clientes.get(0);
        } else {
            return null;
        }
    }
    
    
        public List<Customer> findCustomerByName(String filtro){
        Query q;
        List<Customer> clientes;
        
        q = em.createQuery("SELECT c FROM Customer c WHERE c.name LIKE :nombre");
        q.setParameter("nombre", "%" + filtro + "%");  
                
        clientes = q.getResultList();
        
        if (clientes != null && clientes.isEmpty() == false){
            return clientes;
        } else {
            return null;
        }
    }
    
}
