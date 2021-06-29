/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author abhishek jariwala
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {

    @PersistenceContext(unitName="ejbpu")
    EntityManager em;

    @Override
    public List<State> allStates() {
        return em.createNamedQuery("State.findAll").getResultList();
    }
    
    @Override
    public List<City> stateCity(int cityId){
        State s = em.find(State.class, cityId);
        return em.createNamedQuery("City.findByState").setParameter("stateId", s).getResultList();
    }
    
    @Override
    public void registerUser(User u,int groupId){
        System.out.println("yup="+u.getAddress());
        em.persist(u);
        em.flush();
        
        int uid = u.getId();
        
        Usersgroup ug = new Usersgroup();
        ug.setUserId(new User(uid));
        ug.setGroupId(new Groups(groupId));
        em.persist(ug);
    }

    @Override
    public User getSession(String username) {
        return (User) em.createNamedQuery("User.findByUsername").setParameter("username", username).getSingleResult();
    }

    
    
}
