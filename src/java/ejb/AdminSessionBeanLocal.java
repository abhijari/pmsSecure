/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.*;
import java.util.*;
import javax.ejb.Local;

/**
 *
 * @author abhishek jariwala
 */
@Local
public interface AdminSessionBeanLocal {

    public List<Usersgroup> getAllStudents();
    public void addStudent(User data);
    public void updateStudent(int userId,User data);
    public void deleteStudent(int userId);
    public List<Educationdetail> getAllEducationDetail(int userId); 
    public List<Experiencedetail> getAllExperienceDetail(int userId); 
    public List<Projects> getAllProjects(int userId);
    public List<Userstechnology> getAllStudentTechnology(int userId);  
    
    public List<Usersgroup> getCompanyRequest();
    public List<Usersgroup> getAllCompanies();
    public List<Userstechnology> getAllCompanyTechnology(int userId);        
    public void addCompany(User data);
    public void updateCompany(int userId,User data);
    public void deleteDelete(int userId);
    public void updateRequest(int userId,boolean isVerified);
    
    public List<Interview> allInterviews();
    public void addInterview(int userId,Interview data);
    public List<Integer> getInterviewUsers(int UserID);
    public User getStudentDeatil(int userId);
}
