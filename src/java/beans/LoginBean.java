/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.UserSessionBeanLocal;
import entity.User;
import java.util.Set;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@Named(value = "loginBean")
@RequestScoped
 public class LoginBean {

    @EJB
    private UserSessionBeanLocal userSessionBean;
    
    @Inject private SecurityContext securityContext;

    private String username;
    private String password;
    private String message;
    private AuthenticationStatus status;
   private Set<String> roles;

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }
    
    /** AuthenticationStatus status= securityContext.authenticate(request, response, 
//                                   withParams().credential(creden
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
   public String login()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        try{
        
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
      
        request.getSession().setAttribute("logged-group", ""); 
        
        Credential credential = new UsernamePasswordCredential(username, new Password(password));
        AuthenticationStatus status= securityContext.authenticate(request, response, withParams().credential(credential));
                                           
     
                 System.out.println("In st"+status);

       if (status.equals(SEND_CONTINUE)) {
            // Authentication mechanism has send a redirect, should not
            // send anything to response from JSF now. The control will now go into HttpAuthenticationMechanism
            context.responseComplete();
       } 
       
 
         System.out.println("In bean"+roles);
         if(roles.contains("Admin"))
           {
               System.out.println("In admin");
               User u = this.userSessionBean.getSession(username);
               System.out.println("In idddddddddddddd"+u.getId());
               request.getSession().setAttribute("UserId", u.getId());

               request.getSession().setAttribute("logged-group", "Admin");
              return "Admin/dashboard.xhtml?faces-redirect=true";
           }
        //   else if(securityContext.isCallerInRole("Supervisor"))
       else if(roles.contains("Company"))
           {
               System.out.println("In supervisor");
                  User u = this.userSessionBean.getSession(username);
                  if(u.getIsVerified() == true){
                      System.out.println("In idddddddddddddd"+u.getId());
                        request.getSession().setAttribute("UserId", u.getId());
                        request.getSession().setAttribute("logged-group", "Company");
                        return "/Company/dashboard.xhtml?faces-redirect=true";
                  }
                  else{
                       message = "you can login after admin verfiy your account !!!";
                        
                  }
               
           }
          else if(roles.contains("Student"))
           {
               System.out.println("In supervisor");
                  User u = this.userSessionBean.getSession(username);
               System.out.println("In idddddddddddddd"+u.getId());
               request.getSession().setAttribute("UserId", u.getId());
               request.getSession().setAttribute("logged-group", "Student");
               return "/Student/dashboard.xhtml?faces-redirect=true";
           }
        
       //} 
       
       
        }
        catch (Exception e)
        {
             message = "Out- Either user or login is wrong !!!";
           //   e.printStackTrace();
        }
//        
      return "/Login.xhtml";
    }
   
   private static void addError(FacesContext context, String message) {
        context = FacesContext.getCurrentInstance();
        context
                .addMessage(
                        null,
                        new FacesMessage(SEVERITY_ERROR, message, null));
    }
   public String logout() throws ServletException
   {
       System.out.println("In Log out");
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
          request.getSession().setAttribute("logged-group", "");
            request.getSession().setAttribute("userId", "");
           request.logout();
          request.getSession().invalidate();
         
          
          return "Login.xhtml";
             
             }
    
}
