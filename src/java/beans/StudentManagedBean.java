/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.StudentSessionBeanLocal;
import entity.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.Part;

/**
 *
 * @author abhishek jariwala
 */
@Named(value = "studentManagedBean")
@RequestScoped
public class StudentManagedBean {

    @EJB
    private StudentSessionBeanLocal studentSessionBean;

    String name,username,address,email,websiteLink,gitLink,linkedinLink,gender,description,contact,dob,companyname;

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
    
    //titles and buttonname
    String eduttl,edubtn,expttl,expbtn,prottl,probtn;
    int eduId,expId,proId;

    int[] userTechnology = {1,2};

    ArrayList<Integer> userTechnologies = new ArrayList<>();
    ArrayList<String> companyTechnologies = new ArrayList<>();

    public ArrayList<String> getCompanyTechnologies() {
        return companyTechnologies;
    }

    public void setCompanyTechnologies(ArrayList<String> companyTechnologies) {
        this.companyTechnologies = companyTechnologies;
    }


    public ArrayList<Integer> getUserTechnologies() {
        return userTechnologies;
    }

    public void setUserTechnologies(ArrayList<Integer> userTechnologies) {
        this.userTechnologies = userTechnologies;
    }

    public void saveTechnology(){
        System.out.println(this.userTechnologies.size());
        if(this.userTechnologies.size()>0){
            this.studentSessionBean.addTechnology(4, userTechnologies);
        }
        
    }
    
    public int[] getUserTechnology() {
        return userTechnology;
    }
    
    public void allUserTechnology(){ 
        List<Userstechnology> utech;
        utech = this.studentSessionBean.getUserTechnology(4);
        utech.forEach((action)->userTechnologies.add(action.getTechnologyId().getId()));
    }
    
    

    public void setUserTechnology(int[] userTechnology) {
        this.userTechnology = userTechnology;
    }
    public int getEduId() {
        return eduId;
    }

    public void setEduId(int eduId) {
        this.eduId = eduId;
    }

    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getEduttl() {
        return eduttl;
    }

    public void setEduttl(String eduttl) {
        this.eduttl = eduttl;
    }

    public String getEdubtn() {
        return edubtn;
    }

    public void setEdubtn(String edubtn) {
        this.edubtn = edubtn;
    }

    public String getExpttl() {
        return expttl;
    }

    public void setExpttl(String expttl) {
        this.expttl = expttl;
    }

    public String getExpbtn() {
        return expbtn;
    }

    public void setExpbtn(String expbtn) {
        this.expbtn = expbtn;
    }

    public String getProttl() {
        return prottl;
    }

    public void setProttl(String prottl) {
        this.prottl = prottl;
    }

    public String getProbtn() {
        return probtn;
    }

    public void setProbtn(String probtn) {
        this.probtn = probtn;
    }
    
    
    //edu detail
    String degreeName,universityName;
    int year;
    int years[] = {2017,2018,2019,2020,2021};

    public String getFf() {
        return ff;
    }

    public void setFf(String ff) {
        this.ff = ff;
    }
    String ff;

    public int[] getYears() {
        return years;
    }

    public void setYears(int[] years) {
        this.years = years;
    }
    double percentage,cgpa;
    
    //exp detail
    boolean isCurrentJob;
    String joinedDate,leavingDate,jobTitle,companyName,jobDescription;
    
    //pro deatil
    String proTitle,proDescription;

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public boolean isIsCurrentJob() {
        return isCurrentJob;
    }

    public void setIsCurrentJob(boolean isCurrentJob) {
        this.isCurrentJob = isCurrentJob;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(String leavingDate) {
        this.leavingDate = leavingDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getproTitle() {
        return proTitle;
    }

    public void setproTitle(String proTitle) {
        this.proTitle = proTitle;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }
    
    private Part profilePic;

    public Part getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Part profilePic) {
        this.profilePic = profilePic;
    }
    User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGitLink() {
        return gitLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
    /**
     * Creates a new instance of StudentManagedBean
     */
    public List<Technology> allTechnology(){
        return this.studentSessionBean.getAlltechnology();
    }
    private void getProfile(){
        user = this.studentSessionBean.getUserDeatil(4);
        this.name = user.getName();
        this.username = user.getUsername();
        this.address = user.getAddress();
        this.email = user.getEmail();
        this.contact = user.getContact();
        this.gender = user.getGender();
        this.dob = user.getDob().toString();
        this.description = user.getDescription();
        this.linkedinLink = user.getLinkedinLink();
        this.gitLink = user.getGitLink();
        this.websiteLink = user.getWebsiteLink();
    }
    public List<Usersgroup> allCompanies(){
        return this.studentSessionBean.getAllCompanies();
    }
    
    public void updateProfile(){
        User updateUser = new User();
        updateUser.setGitLink(gitLink);
        updateUser.setWebsiteLink(websiteLink);
        updateUser.setLinkedinLink(linkedinLink);
        updateUser.setAddress(address);
        updateUser.setDescription(description);
        
        this.studentSessionBean.updateUserDeatil(updateUser,user.getId());
    }
    
    public void addEducation(){
        System.out.println(this.edubtn);
        System.out.println(this.eduId); 
        if(this.edubtn.equals("Add")){
            Educationdetail eduDetail = new Educationdetail();
            eduDetail.setDegreeName(degreeName);
            eduDetail.setUniversityName(universityName);
            eduDetail.setYear(year);
            eduDetail.setPercentage(percentage);
            eduDetail.setCgpa(cgpa);
            this.studentSessionBean.addEducationDetail(4, eduDetail);
        }
        else{
            Educationdetail eduDetail = new Educationdetail();
            eduDetail.setDegreeName(degreeName);
            eduDetail.setUniversityName(universityName);
            eduDetail.setYear(year);
            eduDetail.setPercentage(percentage);
            eduDetail.setCgpa(cgpa);
            this.studentSessionBean.updateEducationDetail(this.eduId, eduDetail);
        }


//        System.out.println(eduDetail.getDegreeName());
//        System.out.println(eduDetail.getUniversityName());
//        System.out.println(eduDetail.getYear());
//        System.out.println(eduDetail.getPercentage());
//        System.out.println(eduDetail.getCgpa());

    }
    public void addEducationPrompt(){
        this.eduttl=this.edubtn="Add";
    }
    public List<Educationdetail> getEducationDetail(){
        return this.studentSessionBean.getAllEducationDetail(4);
    }
    
    public void deleteEducationdetail(int eduId){
        this.studentSessionBean.deleteEducationDetail(eduId);
    }
    
    public void editEducationdetail(int eduId){
        this.eduId = eduId;
        this.eduttl=this.edubtn="Update";
        System.out.println(this.edubtn);
        Educationdetail edu = new Educationdetail();
        edu = this.studentSessionBean.getSingleEducationdetail(eduId);
        System.out.println(edu.getDegreeName());
        this.degreeName = edu.getDegreeName();
        this.universityName = edu.getUniversityName();
        this.year = edu.getYear();
        this.percentage = edu.getPercentage();
        this.cgpa = edu.getCgpa();
    }
    
    
    public void addExperience(){
        
         System.out.println(this.expbtn);
        System.out.println(this.expId); 
        if(this.expbtn.equals("Add")){
                   Experiencedetail expDetail = new Experiencedetail();
                    expDetail.setCompanyName(companyName);
                    expDetail.setJobTitle(jobTitle);
                    expDetail.setDescription(jobDescription);
                    expDetail.setIsCurrentJob(isCurrentJob);
                    expDetail.setJoinedDate(new Date());
                    expDetail.setLeavingDate(new Date());
                    this.studentSessionBean.addExperienceDetail(4, expDetail);  
        }
        else{
            Experiencedetail expDetail = new Experiencedetail();
                    expDetail.setCompanyName(companyName);
                    expDetail.setJobTitle(jobTitle);
                    expDetail.setDescription(jobDescription);
                    expDetail.setIsCurrentJob(isCurrentJob);
                    expDetail.setJoinedDate(new Date());
                    expDetail.setLeavingDate(new Date());
                    this.studentSessionBean.updateExperienceDetail(expId, expDetail);
            
        }
 
//        System.out.println(expDetail.getCompanyName());
//        System.out.println(expDetail.getJobTitle());
//        System.out.println(expDetail.getDescription());
//        System.out.println(expDetail.getIsCurrentJob());
//        System.out.println(expDetail.getJoinedDate());
//        System.out.println(expDetail.getLeavingDate());

        

    }
    public void addExperiencePrompt(){
        this.expttl=this.expbtn="Add";
    }
    public List<Experiencedetail> getExperience(){
        return this.studentSessionBean.getAllExperienceDetail(4);
    }
    
    public void deleteExperiencedetail(int expId){
        this.studentSessionBean.deleteExperienceDetail(expId);
    }
    
    public void editExperiencedetail(int expId){
        this.expId = expId;
        this.expttl=this.expbtn="Update";
        Experiencedetail exp = new Experiencedetail();
        exp = this.studentSessionBean.getSingleExperiencedetail(expId);
        this.companyName= exp.getCompanyName();
        this.jobTitle= exp.getJobTitle();
        this.joinedDate = exp.getJoinedDate().toString();
        this.leavingDate = exp.getLeavingDate().toString();
        this.jobDescription= exp.getDescription();
        this.isCurrentJob  = exp.getIsCurrentJob();
        
    }
    public void ss(){
        this.ff = "erfer";
        this.cgpa=50;
        System.out.println("djwefunkwjfnkjr");
        //return null;
    }
    public void addProject(){
         System.out.println(this.probtn);
        System.out.println(this.proId); 
        if(this.probtn.equals("Add")){
                    Projects proDetail= new Projects();
                    proDetail.setTitle(this.proTitle);        
                    proDetail.setDescription(this.proDescription);
                    this.studentSessionBean.addProjectDetail(4,proDetail);
        }
        else{
            Projects proDetail= new Projects();
                    proDetail.setTitle(this.proTitle);        
                    proDetail.setDescription(this.proDescription);
                    this.studentSessionBean.updateProjectDetail(proId, proDetail);
        }

    }
    public void addProjectPrompt(){
        this.prottl=this.probtn="Add";
    }
    public List<Projects> getProjects(){
        return this.studentSessionBean.getAllProjects(4);
    }
    
    public void deleteProjects(int proId){
        this.studentSessionBean.deleteProjectDetail(proId);
    }
    
     public void editProjects(int proId){
         this.proId = proId;
         this.prottl=this.probtn="Update";
         Projects pro = new Projects();
         pro = this.studentSessionBean.getSingleProjects(proId);
         this.proTitle = pro.getTitle();
         this.proDescription = pro.getDescription();
    }
    
     public List<Jobinerviews> allInterview(){
        return this.studentSessionBean.getAllInerviews(4);
     }  
     
     public void updateStatus(int jobintId,int status){
                 System.out.println("vvr");

         this.studentSessionBean.updateStatus(jobintId, status);
     }
     public String companyDetail(int userId){
         
         System.out.println(userId);
        User CompanyUser = new User();
        CompanyUser = this.studentSessionBean.getUserDeatil(userId);
        this.name = CompanyUser.getName();
        companyname = CompanyUser.getCompanyname();
        this.username = CompanyUser.getUsername();
        this.address = CompanyUser.getAddress();
        this.email = CompanyUser.getEmail();
        this.contact = CompanyUser.getContact();
        this.gender = CompanyUser.getGender();
        this.description = CompanyUser.getDescription();
        this.linkedinLink = CompanyUser.getLinkedinLink();
        this.websiteLink = CompanyUser.getWebsiteLink();
        
        companyTechnologies.clear();
        List<Userstechnology> utech;
        utech = this.studentSessionBean.getUserTechnology(userId);
        utech.forEach((action)->companyTechnologies.add(action.getTechnologyId().getName()));
        return "companyDetail.xhtml";
     }
    @PostConstruct
    public void init() {
        allUserTechnology();
        getProfile();
        this.eduttl=this.edubtn="Add";
        this.expttl=this.expbtn="Add";
        this.prottl=this.probtn="Add";
        this.ff = "eaa";
    }
    
     public StudentManagedBean() {
       // getProfile();
        
    }
    
    
}
