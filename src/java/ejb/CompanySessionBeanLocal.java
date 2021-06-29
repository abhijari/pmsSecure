/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abhishek jariwala
 */
@Local
public interface CompanySessionBeanLocal {
    
    public void updateUserDeatil(User data,int userId);
    public User getUserDeatil(int userId);

    public List<Usersgroup> getAllStudents();
    public List<Usersgroup> getStudentsByTechnology(int userId);
    public List<Educationdetail> getAllEducationDetail(int userId); 
    public List<Experiencedetail> getAllExperienceDetail(int userId); 
    public List<Projects> getAllProjects(int userId);
    public List<Userstechnology> getAllStudentTechnology(int userId);    

    
    public List<Technology> getAlltechnology();
    public List<Userstechnology> getUserTechnology(int userId);        
    public void addTechnology(int userId,ArrayList<Integer> techIds);
    public void deleteTechnology(int userId,int techId);
    
    public List<Interview> getAllInerviews(int userId);
    public List<Jobinerviews> getInerviewbyDate(int userId,Date date);
    public List<Jobinerviews> getInerviewbyMonth(int userId,Date date);
    public List<Jobinerviews> getInerviewbyYear(int userId,Date date);
    
    public List<Requestinterviewdates> getAllRequest(int userId);
    public List<Requestinterviewdates> updateRequest(int reqId);
    public List<Long> getInterviewStatus(int intId);

        
        


}
