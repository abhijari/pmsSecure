/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Educationdetail;
import entity.Experiencedetail;
import entity.Jobinerviews;
import entity.Projects;
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
public class StudentSessionBean implements StudentSessionBeanLocal {

    @PersistenceContext(unitName="ejbpu")
    EntityManager em;

    @Override
    public void updateUserDeatil(User data,int userId) {
        
        User u = em.find(User.class, userId);
        u.setAddress(data.getAddress());
        u.setGitLink(data.getGitLink());
        u.setLinkedinLink(data.getLinkedinLink());
        u.setWebsiteLink(data.getWebsiteLink());
        u.setDescription(data.getDescription());
        em.merge(u);
    }

    @Override
    public List<Educationdetail> getAllEducationDetail(int userId) {
        return em.createNamedQuery("Educationdetail.findByStudentId").setParameter("userId", userId).getResultList();
    }

    @Override
    public void addEducationDetail(int userId, Educationdetail data) {
//        System.out.println(data.getDegreeName());
//        System.out.println(data.getUniversityName());
//        System.out.println(data.getYear());
//        System.out.println(data.getPercentage());
//        System.out.println(data.getCgpa());
        
        Educationdetail edu = new Educationdetail();
        edu.setStudentId(new User(userId));
        edu.setDegreeName(data.getDegreeName());
        edu.setUniversityName(data.getUniversityName());
        edu.setYear(data.getYear());
        edu.setPercentage(data.getPercentage());
        edu.setCgpa(data.getCgpa());
        em.persist(edu);
    }

    @Override
    public void updateEducationDetail(int eduId, Educationdetail data) {
        Educationdetail edu = em.find(Educationdetail.class, eduId);
        edu.setDegreeName(data.getDegreeName());
        edu.setUniversityName(data.getUniversityName());
        edu.setYear(data.getYear());
        edu.setPercentage(data.getPercentage());
        edu.setCgpa(data.getCgpa());
        em.merge(edu);
    }

    @Override
    public void deleteEducationDetail(int eduId) {
            Educationdetail edu=em.find(Educationdetail.class, eduId);
            em.remove(edu);

    }

    @Override
    public List<Experiencedetail> getAllExperienceDetail(int userId) {
        return em.createNamedQuery("Experiencedetail.findByStudentId").setParameter("userId", userId).getResultList();   
    }

    @Override
    public void addExperienceDetail(int userId, Experiencedetail data) {
        Experiencedetail exp = new Experiencedetail();
        exp.setStudentId(new User(userId));
        exp.setCompanyName(data.getCompanyName());
        exp.setDescription(data.getDescription());
        exp.setJobTitle(data.getJobTitle());
        exp.setIsCurrentJob(data.getIsCurrentJob());
        exp.setJoinedDate(data.getJoinedDate());
        exp.setLeavingDate(data.getLeavingDate());
        em.persist(exp);
    }

    @Override
    public void updateExperienceDetail(int expId, Experiencedetail data) {
        Experiencedetail exp = em.find(Experiencedetail.class, expId);
        exp.setCompanyName(data.getCompanyName());
        exp.setDescription(data.getDescription());
        exp.setJobTitle(data.getJobTitle());
        exp.setIsCurrentJob(data.getIsCurrentJob());
        exp.setJoinedDate(data.getJoinedDate());
        exp.setLeavingDate(data.getLeavingDate());
        em.merge(exp);
    }

    @Override
    public void deleteExperienceDetail(int expId) {
            Experiencedetail exp=em.find(Experiencedetail.class, expId);
            em.remove(exp);    
    }

    @Override
    public List<Projects> getAllProjects(int userId) {
        return em.createNamedQuery("Projects.findByStudentId").setParameter("userId", userId).getResultList();   
    }

    @Override
    public void addProjectDetail(int userId, Projects data) {
        Projects pro = new Projects();
        pro.setStudentId(new User(userId));
        pro.setTitle(data.getTitle());
        pro.setDescription(data.getDescription());
        em.persist(pro);
    }

    @Override
    public void updateProjectDetail(int proId, Projects data) {
        Projects pro = em.find(Projects.class, proId);
        pro.setTitle(data.getTitle());
        pro.setDescription(data.getDescription());
        em.merge(pro);
    }

    @Override
    public void deleteProjectDetail(int proId) {
            Projects pro=em.find(Projects.class, proId);
            em.remove(pro); 
    }

    @Override
    public List<Userstechnology> getUserTechnology(int userId) {
        return em.createNamedQuery("Userstechnology.findByUserId").setParameter("id", userId).getResultList();
    }

    @Override
    public void addTechnology(int userId, ArrayList<Integer> techIds) {
        
        //em.createNamedQuery("Userstechnology.deleteAllByUser").setParameter("id", userId);
        
          Query query = em.createQuery("DELETE FROM Userstechnology u WHERE u.userId.id = :id");
          query.setParameter("id", userId).executeUpdate();
  
        for(Integer id: techIds){
            Userstechnology ut = new Userstechnology();
            ut.setUserId(new User(userId));
            ut.setTechnologyId(new Technology(id));
            em.persist(ut);
        }
            
    }

    @Override
    public void deleteTechnology(int userId, int techId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usersgroup> getAllCompanies() {
        return em.createNamedQuery("Usersgroup.findVerifiedCompany").setParameter("groupId", 3).getResultList();
    }

    @Override
    public List<Jobinerviews> getAllInerviews(int userId) {
           return em.createNamedQuery("Jobinerviews.findByStudent").setParameter("id", userId).getResultList();
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
    public User getUserDeatil(int userId) {
        return (User)em.createNamedQuery("User.findById").setParameter("id",userId).getSingleResult();
    }

    @Override
    public Educationdetail getSingleEducationdetail(int eduId) {
        return (Educationdetail)em.createNamedQuery("Educationdetail.findById").setParameter("id",eduId).getSingleResult();
    }

    @Override
    public Experiencedetail getSingleExperiencedetail(int expId) {
        return (Experiencedetail)em.createNamedQuery("Experiencedetail.findById").setParameter("id",expId).getSingleResult();
    }

    @Override
    public Projects getSingleProjects(int proId) {
        return (Projects)em.createNamedQuery("Projects.findById").setParameter("id", proId).getSingleResult();
    }

    @Override
    public List<Technology> getAlltechnology() {
        return em.createNamedQuery("Technology.findAll").getResultList();
    }

    @Override
    public void updateStatus(int jobintID,int status) {
        Jobinerviews ji = em.find(Jobinerviews.class, jobintID);
        ji.setStatus(status);
        em.merge(ji);
    }
}
