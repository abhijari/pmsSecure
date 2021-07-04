/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.AdminSessionBeanLocal;
import entity.User;
import entity.Usersgroup;
import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

import dynamic.Items;
import entity.Interview;
import entity.Jobinerviews;
import java.text.SimpleDateFormat;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
/**
 *
 * @author abhishek jariwala
 */

@Named(value = "adminManagedBean")
@SessionScoped
public class AdminManagedBean implements Serializable{

    @EJB
    private AdminSessionBeanLocal adminSessionBean;
    int companyId;
    private Date Intdate;
    String username, name, password, email, contact, gender;
    Date dob;
    int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    String Description,Location;

    
      HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
      
    
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public Date getIntdate() {
        return Intdate;
    }

    public void setIntdate(Date Intdate) {
        this.Intdate = Intdate;
    }


    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
    
    
     public String updateProfile(){
//         System.out.println("------");
//         System.out.println( userId);
        User uObj = new User();
        uObj.setName(name);
        uObj.setUsername(username);
        uObj.setEmail(email);
        uObj.setContact(contact);
        uObj.setGender(gender);
      
      this.adminSessionBean.updateStudent(uid,uObj);
      return "students.xhtml";

    }
     
    public String EditStudent(int userId){
        
        System.out.println("dedemfiefefikenfienfnefjnejnejfbjebfjeb");
        User user = this.adminSessionBean.getStudentDeatil(userId);
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.contact = user.getContact();
        this.gender = user.getGender();
        this.uid = user.getId();
        return "editStudent.xhtml";
    }
    public String addStudentIn() {
        System.out.println("------------>>>>>>>>");
        User userDetail = new User();
        userDetail.setUsername(username);
        userDetail.setName(name);
        userDetail.setContact(contact);
        userDetail.setEmail(email);
        //userDetail.setDob(dob);
        userDetail.setGender(gender);
        String tempPass = this.getAlphaNumericString(6);
        
        Pbkdf2PasswordHashImpl pass = new Pbkdf2PasswordHashImpl();
        userDetail.setPassword(pass.generate( tempPass.toCharArray()));
        
        this.adminSessionBean.addStudent(userDetail);
        this.sendmail(tempPass);
        return "students.xhtml";

    }
    
    public String getAlphaNumericString(int n)
    {
  
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "!@#$%";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }
    public void deleteStudentIn(int userId) {
        System.out.println(userId);
        this.adminSessionBean.deleteStudent(userId);
    }
    /**
     * Creates a new instance of AdminManagedBean
     */
     private List<Items> items ;

     public void add() {
        Items item = new Items();
        item.setLabel("Date " + (items.size()+1));
        items.add(item);
        
        
        items.forEach((action)-> System.out.println(action.getValue()) );
    }

     public void onDateSelect(SelectEvent event) {  
    FacesContext facesContext = FacesContext.getCurrentInstance();  
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
    facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));  
    System.out.println(this.Intdate);
    }  
    public void click() {  
    RequestContext requestContext = RequestContext.getCurrentInstance();  
    requestContext.update("form:display");  
    requestContext.execute("PF('dlg').show()");  
        System.out.println(this.Intdate.toString());
    }  
    public void remove(Items item) {
        items.remove(item);
    }
       public void addInterview(){
                        System.out.println("defe");
                System.out.println(this.companyId);


//                Jobinerviews ji = new Jobinerviews();
//                ji.setDate(Intdate);
//                ji.setDescription("efefe");
//                ji.setLocation("syuwd");
              //  this.adminSessionBean.addInterview(this.companyId, ji);
                
                
                Interview iv = new Interview();
                iv.setDate(Intdate);
                iv.setDescription("dd");
                iv.setLocation("def");
                List<String> studentEmailList = this.adminSessionBean.addInterview(companyId, iv);
                
                User user = this.adminSessionBean.getStudentDeatil(this.companyId);
                String company = user.getCompanyname();
                System.out.println("yoyo"+ studentEmailList);

                for (String i : studentEmailList){
                    this.sendInterviewmail(i,company,this.Intdate.toString());
                }
 }
       
       public List<Interview> AllInterviews(){
           
//           int ss = (int) request.getSession().getAttribute("UserId");
//           System.out.println("iddddddddd"+ss);
           return this.adminSessionBean.allInterviews();
       }
       
       //public delete
    
    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public AdminManagedBean() {
    }
    
    public List<Usersgroup> allStudents(){
        return this.adminSessionBean.getAllStudents();
    }
    
    public List<Usersgroup> allCompanies(){
        return this.adminSessionBean.getAllCompanies();
    }
    
    public List<Usersgroup> companyRequest(){
        return this.adminSessionBean.getCompanyRequest();
    }
    
    public void updateRequest(boolean isAccept,int userid){
        System.out.println("is="+isAccept);        
        System.out.println(userid);
        
       this.adminSessionBean.updateRequest(userid, isAccept);
    }
    
    public void deleteCompany(int userId){
        this.adminSessionBean.deleteDelete(userId);
    }
    
    @PostConstruct
    public void init() {
//        System.out.println("c");
//        items = new ArrayList<>();
//         Items item = new Items();
//        item.setLabel("Date " + (items.size()+1));
//        items.add(item);
    }
    
    
     public void sendmail(String Password){
        
         String to = this.email;//change accordingly  
      String from = "dfordevil11@gmail.com";//change accordingly  
      String pass = "Devil@1111";//or IP address  
      
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
            message.setText("You Placement Management Website Password is "+Password);
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
     
     
     
      public void sendInterviewmail(String email,String company,String date){
        
         String to = email;//change accordingly  
      String from = "dfordevil11@gmail.com";//change accordingly  
      String pass = "Devil@1111";//or IP address  
      
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
            message.setText(company+" would like to invite you to attend an interview on "+date+". for more information check website...");
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
