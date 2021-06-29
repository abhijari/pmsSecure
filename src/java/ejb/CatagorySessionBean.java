/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.*;

/**
 *
 * @author abhishek jariwala
 */
@Stateless
public class CatagorySessionBean implements CatagorySessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName="ejbpu")
    EntityManager em;

    @Override
    public List<Catagory> allCatagory() {
        return em.createNamedQuery("Catagory.findAll").getResultList();
    }

    @Override
    public void edit(int catId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int catId) {
        Catagory cat=em.find(Catagory.class, catId);
            em.remove(cat);  
    }

    @Override
    public void add(Catagory data) {
        em.persist(data);
    }
    
    
}
