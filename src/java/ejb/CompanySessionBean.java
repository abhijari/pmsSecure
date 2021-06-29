/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Educationdetail;
import entity.Experiencedetail;
import entity.Interview;
import entity.Jobinerviews;
import entity.Projects;
import entity.Requestinterviewdates;
import entity.Technology;
import entity.User;
import entity.Usersgroup;
import entity.Userstechnology;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author abhishek jariwala
 */
@Stateless
public class CompanySessionBean implements CompanySessionBeanLocal {

    @PersistenceContext(unitName="ejbpu")
    EntityManager em;

    @Override
    public void updateUserDeatil(User data,int userId) {
        User u = em.find(User.class, userId);
        u.setAddress(data.getAddress());
        u.setLinkedinLink(data.getLinkedinLink());
        u.setWebsiteLink(data.getWebsiteLink());
        u.setDescription(data.getDescription());
        em.merge(u);
    }

    @Override
    public List<Usersgroup> getAllStudents() {
        return em.createNamedQuery("Usersgroup.findByGroupId").setParameter("groupId", 2).getResultList();
    }

    @Override
    public List<Usersgroup> getStudentsByTechnology(int userId) {
        return em.createNamedQuery("Userstechnology.findByUserId").setParameter("id", userId).getResultList();
    }

    @Override
    public List<Educationdetail> getAllEducationDetail(int userId) {
        return em.createNamedQuery("Educationdetail.findByStudentId").setParameter("userId", userId).getResultList();
    }

    @Override
    public List<Experiencedetail> getAllExperienceDetail(int userId) {
        return em.createNamedQuery("Experiencedetail.findByStudentId").setParameter("userId", userId).getResultList();   
    }

    @Override
    public List<Projects> getAllProjects(int userId) {
        return em.createNamedQuery("Projects.findByStudentId").setParameter("userId", userId).getResultList();   
    }

    @Override
    public List<Userstechnology> getAllStudentTechnology(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Userstechnology> getUserTechnology(int userId) {
        return em.createNamedQuery("Userstechnology.findByUserId").setParameter("id", userId).getResultList();
    }

    @Override
    public void addTechnology(int userId, ArrayList<Integer> techIds) {
  Query query = em.createQuery("DELETE FROM Userstechnology u WHERE u.userId.id = :id");
          query.setParameter("id", userId).executeUpdate();
  
        for(Integer id: techIds){
            Userstechnology ut = new Userstechnology();
            ut.setUserId(new User(userId));
            ut.setTechnologyId(new Technology(id));
            em.persist(ut);
        }    }

    @Override
    public void deleteTechnology(int userId, int techId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public List<Jobinerviews> getInerviewbyDate(int userId, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jobinerviews> getInerviewbyMonth(int userId, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jobinerviews> getInerviewbyYear(int userId, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Requestinterviewdates> getAllRequest(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Requestinterviewdates> updateRequest(int reqId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserDeatil(int userId) {
        return (User)em.createNamedQuery("User.findById").setParameter("id",userId).getSingleResult();
    }

    @Override
    public List<Technology> getAlltechnology() {
        return em.createNamedQuery("Technology.findAll").getResultList();
    }

    @Override
    public List<Interview> getAllInerviews(int userId) {
        return em.createNamedQuery("Interview.findByComapny").setParameter("id",userId).getResultList();
    }

    @Override
    public List<Long> getInterviewStatus(int intId) {
        
        

//         Query query = em.createNativeQuery("SELECT (SELECT COUNT(interviewId) FROM jobinerviews WHERE status=0 and interviewId ='"+intId+"') AS notanswered,"
//                +"(SELECT COUNT(interviewId) FROM jobinerviews WHERE status=1 and interviewId ='"+intId+"') AS interested,"
//                +"(SELECT COUNT(interviewId) FROM jobinerviews WHERE status=2 and interviewId ='"+intId+"') AS notinterested");
         Query query = em.createNativeQuery("SELECT COUNT(interviewId) FROM jobinerviews WHERE status=0 and interviewId ='"+intId+"'");
         long notanswered = (long) query.getSingleResult();
         Query query2 = em.createNativeQuery("SELECT COUNT(interviewId) FROM jobinerviews WHERE status=1 and interviewId ='"+intId+"'");
         long interested = (long) query2.getSingleResult();
         Query query3 = em.createNativeQuery("SELECT COUNT(interviewId) FROM jobinerviews WHERE status=2 and interviewId ='"+intId+"'");
         long notinterested = (long) query3.getSingleResult();
         
         List < Long > arrList = new ArrayList < Long > ();
         arrList.add(notanswered);
         arrList.add(interested);
         arrList.add(notinterested);
                  System.out.println(arrList);
        return arrList;

         
         

    }
}
