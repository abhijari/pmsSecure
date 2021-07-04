/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Educationdetail;
import entity.Experiencedetail;
import entity.Groups;
import entity.Interview;
import entity.Jobinerviews;
import entity.Projects;
import entity.User;
import entity.Usersgroup;
import entity.Userstechnology;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author abhishek jariwala
 */
@Stateless
public class AdminSessionBean implements AdminSessionBeanLocal {

    
    @PersistenceContext(unitName="ejbpu")
    EntityManager em;
    
    @Override
    public List<Usersgroup> getAllStudents() {
        return em.createNamedQuery("Usersgroup.findByGroupId").setParameter("groupId", 2).getResultList();
    }

    @Override
    public List<Usersgroup> getAllCompanies() {
        return em.createNamedQuery("Usersgroup.findVerifiedCompany").setParameter("groupId", 3).getResultList();
    }

    @Override
    public List<Usersgroup> getCompanyRequest() {
        return em.createNamedQuery("Usersgroup.findRequestCompany").setParameter("groupId", 3).getResultList();
    }

    @Override
    public void updateRequest(int userId, boolean isVerified) {
        
        User u = em.find(User.class, userId);
        u.setIsVerified(isVerified);
        em.merge(u);
    }

    @Override
    public void addStudent(User data) {
        User userObj=new User();
        userObj.setUsername(data.getUsername());
        userObj.setName(data.getName());
        userObj.setEmail(data.getEmail());
        userObj.setContact(data.getContact());
        userObj.setGender(data.getGender());
      //  userObj.setDob(data.getDob());
       userObj.setPassword(data.getPassword());
        em.persist(userObj);
        em.flush();
        int userId=userObj.getId();
         Usersgroup ug = new Usersgroup();
        ug.setUserId(new User(userId));
        ug.setGroupId(new Groups(2));
        em.persist(ug);
    }

    @Override
    public void updateStudent(int userId, User data) {
        User u = em.find(User.class, userId);
        u.setName(data.getName());
        u.setUsername(data.getUsername());
        u.setEmail(data.getEmail());
        u.setContact(data.getContact());
        u.setGender(data.getGender());
        em.merge(u);
    }

    @Override
    public void deleteStudent(int userId) {
       User userObj=em.find(User.class, userId);
       em.remove(userObj);
    }

    @Override
    public List<Educationdetail> getAllEducationDetail(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Experiencedetail> getAllExperienceDetail(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Projects> getAllProjects(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Userstechnology> getAllStudentTechnology(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Userstechnology> getAllCompanyTechnology(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCompany(User data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCompany(int userId, User data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDelete(int userId) {
       User userObj=em.find(User.class, userId);
       em.remove(userObj);
    }

    @Override
    public void addInterview(int userId, Interview data) {
                
        
        
                Interview iv = new Interview();
                iv.setCompanyId(new User(userId));
                iv.setDate(data.getDate());
                iv.setDescription(data.getDescription());
                iv.setLocation(data.getLocation());
                em.persist(iv);
                em.flush();

                int uid = iv.getId();
                
//                Jobinerviews ji = new Jobinerviews();
//                ji.setCompanyId(new User(userId));
//                ji.setDate(data.getDate());
//                ji.setDescription(data.getDescription());
//                ji.setLocation(data.getLocation());
                
                //get student Id
                List<Integer> studeList;
                studeList = this.getInterviewUsers(userId);
                
                for (Integer i : studeList){
                    System.out.print(i + " ");
                    Jobinerviews jis = new Jobinerviews();
                    jis.setInterviewId(new Interview(uid));
                    jis.setCompanyId(new User(userId));
                    jis.setDate(data.getDate());
                    jis.setDescription("f");
                    jis.setLocation("f");
                    jis.setStudentId(new User(i));
                    em.persist(jis);
                }
                
                //to company
//                ji.setStudentId(new User(userId));
                
       
    }
    
     @Override
    public List<Integer> getInterviewUsers(int UserID) {

             //SELECT userId FROM userstechnology WHERE technologyId IN (SELECT technologyId FROM `userstechnology` WHERE userId = 4) GROUP BY userId
//SELECT userId FROM userstechnology WHERE technologyId IN (SELECT technologyId FROM `userstechnology` WHERE userId = 4) and userId!=4 GROUP BY userId

        //with company
//         return em.createNativeQuery("select userId from userstechnology"
//                 +" where technologyId IN (SELECT technologyId from userstechnology"
//                 +" where userId = '"+ UserID +"') and userId!='"+ UserID +"' GROUP BY userId ").getResultList();
         
         //without company

         return em.createNativeQuery("SELECT ut.userId FROM userstechnology ut,usersgroup ug WHERE ut.technologyId IN "
                 +"(SELECT technologyId FROM userstechnology WHERE userId = '"+ UserID +"') and "+
                 "(ug.userId = ut.userId and ug.groupId != 3) GROUP BY ut.userId").getResultList();
    }

    @Override
    public List<Interview> allInterviews() {
        return em.createNamedQuery("Interview.findAll").getResultList();
    }
    
    @Override
    public User getStudentDeatil(int userId) {
        return (User)em.createNamedQuery("User.findById").setParameter("id",userId).getSingleResult();
    }
}
