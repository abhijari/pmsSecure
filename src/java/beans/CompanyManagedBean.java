/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.CompanySessionBeanLocal;
import entity.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abhishek jariwala
 */
@Named(value = "companyManagedBean")
@RequestScoped
public class CompanyManagedBean {

    @EJB
    private CompanySessionBeanLocal companySessionBean;
    User user = new User();
    User stud = new User();

     HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
      
    public User getStud() {
        return stud;
    }

    public void setStud(User stud) {
        this.stud = stud;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public ArrayList<Integer> getUserTechnologies() {
        return userTechnologies;
    }

    public void setUserTechnologies(ArrayList<Integer> userTechnologies) {
        this.userTechnologies = userTechnologies;
    }

    String name,companyname,username,address,email,websiteLink,linkedinLink,description,contact;
    ArrayList<Integer> userTechnologies = new ArrayList<>();
    int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Creates a new instance of CompanyManagedBean
     */
    
    public CompanyManagedBean() {
    }
    
    public List<Technology> allTechnology(){
        return this.companySessionBean.getAlltechnology();
    }
    
    public void saveTechnology(){
        System.out.println(this.userTechnologies.size());
        if(this.userTechnologies.size()>0){
            
            this.companySessionBean.addTechnology(getId(), userTechnologies);
        }
        
    }
    
    public void allUserTechnology(){ 
        List<Userstechnology> utech;
        utech = this.companySessionBean.getUserTechnology(getId());
        utech.forEach((action)->userTechnologies.add(action.getTechnologyId().getId()));
    }
    
     private void getProfile(){
        user = this.companySessionBean.getUserDeatil(getId());
        this.name = user.getName();
        this.companyname = user.getCompanyname();
        this.username = user.getUsername();
        this.address = user.getAddress();
        this.email = user.getEmail();
        this.contact = user.getContact();
        this.description = user.getDescription();
        this.linkedinLink = user.getLinkedinLink();
        this.websiteLink = user.getWebsiteLink();
    }
     
    public void updateProfile(){
        User updateUser = new User();
        updateUser.setWebsiteLink(websiteLink);
        updateUser.setLinkedinLink(linkedinLink);
        updateUser.setAddress(address);
        updateUser.setDescription(description);
        
        this.companySessionBean.updateUserDeatil(updateUser,user.getId());
    }
    public List<Usersgroup> allStudents(){
        return this.companySessionBean.getAllStudents();
    }
    
    public String viewStudDetail(int userId){
        this.studentId = userId;
        stud = this.companySessionBean.getUserDeatil(studentId);        
        System.out.println(studentId);
        return "studentDetail.xhtml";
    }
  
    public List<Long> interviewStatus(int intId){
        
        return this.companySessionBean.getInterviewStatus(intId);

    }
    public List<Educationdetail> eductionDetail(){
        return companySessionBean.getAllEducationDetail(studentId);
    }
    public List<Experiencedetail> experienceDetail(){
        return companySessionBean.getAllExperienceDetail(studentId);
    }
    public  List<Projects> projectDetail(){
        return companySessionBean.getAllProjects(studentId);
    }
    public List<Userstechnology> userTechnology(){
        return companySessionBean.getUserTechnology(studentId);
    }
    
    public List<Interview> allInterviews(){
        return this.companySessionBean.getAllInerviews(getId());
    }
    
    public int getId(){
          int ss = (int) request.getSession().getAttribute("UserId");
          return ss;
    }
    
    @PostConstruct
    public void init() {
        allUserTechnology();
        this.getProfile();
    }
}
