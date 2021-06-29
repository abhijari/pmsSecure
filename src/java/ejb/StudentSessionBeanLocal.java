/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;
import entity.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author abhishek jariwala
 */
@Local
public interface StudentSessionBeanLocal {
    
    public void updateUserDeatil(User data,int userId);
    public User getUserDeatil(int userId);
            
    public List<Educationdetail> getAllEducationDetail(int userId); 
    public Educationdetail getSingleEducationdetail(int eduId);
    public void addEducationDetail(int userId,Educationdetail data);
    public void updateEducationDetail(int eduId,Educationdetail data);
    public void deleteEducationDetail(int eduId);
    
    public List<Experiencedetail> getAllExperienceDetail(int userId); 
    public Experiencedetail getSingleExperiencedetail(int expId);
    public void addExperienceDetail(int userId,Experiencedetail data);
    public void updateExperienceDetail(int expId,Experiencedetail data);
    public void deleteExperienceDetail(int expId);
    
    public List<Projects> getAllProjects(int userId);
    public Projects getSingleProjects(int proId);
    public void addProjectDetail(int userId,Projects data);
    public void updateProjectDetail(int proId,Projects data);    
    public void deleteProjectDetail(int proId);
    
    public List<Technology> getAlltechnology();
    public List<Userstechnology> getUserTechnology(int userId);    
    public void addTechnology(int userId,ArrayList<Integer> techIds);
    public void deleteTechnology(int userId,int techId);
    
    public List<Usersgroup> getAllCompanies();
    
    public List<Jobinerviews> getAllInerviews(int userId);
    public List<Jobinerviews> getInerviewbyDate(int userId,Date date);
    public List<Jobinerviews> getInerviewbyMonth(int userId,Date date);
    public List<Jobinerviews> getInerviewbyYear(int userId,Date date);
    public void updateStatus(int jobintID,int status);
   
}
