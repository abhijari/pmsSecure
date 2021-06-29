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
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
/**
 *
 * @author abhishek jariwala
 */

@Named(value = "adminManagedBean")
@ViewScoped
public class AdminManagedBean implements Serializable{

    @EJB
    private AdminSessionBeanLocal adminSessionBean;
    int companyId;
    private Date Intdate;
    String Description,Location;

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
                this.adminSessionBean.addInterview(companyId, iv);
                
                

 }
       
       public List<Interview> AllInterviews(){
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
    
    @PostConstruct
    public void init() {
//        System.out.println("c");
//        items = new ArrayList<>();
//         Items item = new Items();
//        item.setLabel("Date " + (items.size()+1));
//        items.add(item);
    }
}
