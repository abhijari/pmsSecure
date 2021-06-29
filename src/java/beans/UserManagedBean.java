/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.UserSessionBeanLocal;
import entity.*;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*; 
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;
/**
 *
 * @author abhishek jariwala
 */
@Named(value = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable{

    @EJB
    private UserSessionBeanLocal userSessionBean;

    
    private String name,username,password,address,email,websiteLink,description,companyname,gender,gitLink,linkedinLink,contact;
    private Integer cityId,stateId;
    private Date dob;
    private List<City> citylist = new ArrayList<City>();

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public Integer getStateId() {
        return stateId;
    }

    public List<City> getCitylist() {
        return citylist;
    }

    public void setCitylist(List<City> citylist) {
        this.citylist = citylist;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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


    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
        this.stateId=0;
    }
    
  
    
    public List<City> onStateChange(){
        
        
        return this.userSessionBean.stateCity(this.stateId);
    }
    public List<State> allState(){
        return userSessionBean.allStates();
    }
   
    public void login(){
        
    }
    public void Register() throws IOException{
        
        User u = new User();
        Pbkdf2PasswordHashImpl pass = new Pbkdf2PasswordHashImpl();
        u.setCompanyname(this.companyname);
        u.setName(this.name);
        u.setUsername(this.username);
        u.setPassword(pass.generate( this.password.toCharArray()));
        u.setCityId(new City(this.cityId));
        u.setAddress(this.address);
        u.setEmail(this.email);
        u.setWebsiteLink(this.websiteLink);
        u.setContact(this.contact);
        u.setDescription(this.description);
        
       this.userSessionBean.registerUser(u,3);
//        System.out.println("name="+u.getCompanyname());
//        System.out.println("name="+u.getName());
//        System.out.println("name="+u.getUsername());
//       System.out.println("name="+u.getPassword());
//        System.out.println("name="+u.getCityId());
//       System.out.println("name="+u.getAddress());
//       System.out.println("name="+u.getEmail());
//        System.out.println("name="+u.getWebsiteLink());
//        System.out.println("name="+u.getContact());
//        System.out.println("name="+u.getDescription());
        
      //  this.sendmail();
        this.stateId=0;
        
    }
    
    public void sendmail(){
        
         String to = this.email;//change accordingly  
      String from = "dfordevil11@gmail.com";//change accordingly  
      String pass = "abhijari13";//or IP address  
      
       Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
       
      Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        
        
        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress toAddress = new InternetAddress();
            // To get the array of addresses
            toAddress = new InternetAddress(to);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject("pms");
            message.setText("Thank you for register , we will notify you after verify your account and then u can access a web...");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
