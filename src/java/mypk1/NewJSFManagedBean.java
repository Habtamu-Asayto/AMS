/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mypk1;

import com.database.Users;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author habtamu
 */
@Named(value = "newJSFManagedBean")
@RequestScoped
public class NewJSFManagedBean {
    private String name, password;
    private boolean isLoggedin=false;
    private Users loggeduser;

    FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
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

    public boolean isIsLoggedin() {
        return isLoggedin;
    }

    public void setIsLoggedin(boolean isLoggedin) {
        this.isLoggedin = isLoggedin;
    }

    public Users getLoggeduser() {
        return loggeduser;
    }

    public void setLoggeduser(Users loggeduser) {
        this.loggeduser = loggeduser;
    }
    public void verifyLogin(){
        HttpServletRequest obj = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if(!(obj.isUserInRole("Admin") || obj.isUserInRole("User"))){
            doRedirect("/AMS/faces/login.xhtml");
        }
    }
    public void verifyAdminLogin(){
        HttpServletRequest obj = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if(!obj.isUserInRole("Admin")){
            doRedirect("/AMS/faces/login.xhtml");
            System.err.println("Verify Check");
        }
    }
    public void verifyManagerLogin(){
        HttpServletRequest obj = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if(!obj.isUserInRole("Manager")){
            doRedirect("/AMS/faces/login.xhtml");
            System.err.println("Verify Check");
        }
    }
     
    public void doRedirect(String url){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error","zerror");
            FacesContext.getCurrentInstance().addMessage(null, message);  
        } catch (IOException ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);  
        }
     }
    
    public NewJSFManagedBean() {
    }
    
    public void mylogin(){ 
        
        final Logger logger = Logger.getLogger(NewJSFManagedBean.class); 
        logger.debug(this.name + " is Trying to Login");
         
        HttpServletRequest obj = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try {
            
            obj.login(name, password);  
            logger.debug("User Logged using username : "+this.name); 
            session.setAttribute("name", this.name);
            if(obj.isUserInRole("Admin")){
                this.isLoggedin=true;
                doRedirect("index.xhtml");
            }
            else if(obj.isUserInRole("User")){
                this.isLoggedin=true;
                doRedirect("index.xhtml");
            }
            else{
                this.isLoggedin=false;
                doRedirect("login.xhtml");
            }
        } catch (ServletException e) {
            System.err.println(e);
        } 
    }
    
    public void myLogout(){
        final Logger logger = Logger.getLogger(NewJSFManagedBean.class); 
        String uname;
        uname = (String) session.getAttribute("name");
       HttpServletRequest obj = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try { 
            this.isLoggedin = false;
            obj.logout();
            doRedirect("/AMS/faces/login.xhtml");
            logger.debug(uname + " is Logged out ");
        } catch (ServletException e) {
            System.err.println(e);
        }
 
    }
    
    
}
