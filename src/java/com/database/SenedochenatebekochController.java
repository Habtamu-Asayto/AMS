package com.database;

import com.database.util.JsfUtil;
import com.database.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.Date;

import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import javax.inject.Inject;


import org.primefaces.event.TabChangeEvent;

import org.primefaces.event.FlowEvent;

@Named("senedochenatebekochController")
@SessionScoped
public class SenedochenatebekochController implements Serializable {

    @EJB
    private com.database.SenedochenatebekochFacade ejbFacade;
    private List<Senedochenatebekoch> items = null;
    private Senedochenatebekoch selected;
    private int searchcasenumber;

    public int getSearchcasenumber() {
        return searchcasenumber;
    }

    public void setSearchcasenumber(int searchcasenumber) {
        this.searchcasenumber = searchcasenumber;
    }
    
     @EJB
    private com.database.CasenumberFacade casenumberejbFacade;
      @Inject 
        ServiceDeliveryofficeController serviceoffice;  
     @Inject 
        WekayController wek;
     @Inject 
        TewokayController tew;
       @Inject 
        MekinashiyachController mekina;
         @Inject 
        MisikirController misikir;
      
         @Inject 
        CasenumberController casen;
    
  
       public void searchbCaseNumber(int casenumber)
       {
    System.out.println("Finding with the case number  ===> "+casenumber);
         this.casenumber=casenumber;
          
       
       }
    public SenedochenatebekochController() {
    }

    public Senedochenatebekoch getSelected() {
        return selected;
    }

    public void setSelected(Senedochenatebekoch selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SenedochenatebekochFacade getFacade() {
        return ejbFacade;
    }
   private int casenumber;

    public int getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(int casenumber) {
        this.casenumber = casenumber;
    }
public void onLoadInitialization()
{
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    
    if (!facesContext.isPostback() ) {
        
       wek.prepareCreate();
       tew.prepareCreate();
       mekina.prepareCreate();
       misikir.prepareCreate();
        serviceoffice.prepareCreate();
     selected= new Senedochenatebekoch();
     
   }
}
 public void onLoadInitializationConfirmation()
  {
   FacesContext facesContext = FacesContext.getCurrentInstance();
   
   if (!facesContext.isPostback() ) 
    { 
       wek.prepareCreate();
       tew.prepareCreate();
       mekina.prepareCreate();
       misikir.prepareCreate();
       serviceoffice.prepareCreate();
    } 
}
public void do_redirectforconirmation()
{
    returnpage("wekay/Listconfirmation",false);

}
    public Senedochenatebekoch prepareCreate() {
        wek.prepareCreate();
       tew.prepareCreate();
         
        selected = new Senedochenatebekoch();
        initializeEmbeddableKey();
        return selected;
    }
   
  public void create(String casenumber,String email) {
        Date d= new Date();
        this.selected.setGlgalotyetekebetken(d);
        this.selected.setCasenumber(casenumber);
        this.selected.setAgelgloteteyaki(email);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SenedochenatebekochCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SenedochenatebekochCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
 public void update(Users u) {
        //this.selected.setAgelglotsechbalemuya(u);
         Date d= new Date();
        this.selected.setGelgalotyetesetebetken(d);
        
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SenedochenatebekochUpdated"));
    }
    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SenedochenatebekochUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SenedochenatebekochDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Senedochenatebekoch> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Senedochenatebekoch getSenedochenatebekoch(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Senedochenatebekoch> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Senedochenatebekoch> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Senedochenatebekoch.class)
    public static class SenedochenatebekochControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SenedochenatebekochController controller = (SenedochenatebekochController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "senedochenatebekochController");
            return controller.getSenedochenatebekoch(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Senedochenatebekoch) {
                Senedochenatebekoch o = (Senedochenatebekoch) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Senedochenatebekoch.class.getName()});
                return null;
            }
        }

    }
private boolean renderoldeditbutton=true;

    public boolean isRenderoldeditbutton() {
        return renderoldeditbutton;
    }

    public void setRenderoldeditbutton(boolean renderoldeditbutton) {
        this.renderoldeditbutton = renderoldeditbutton;
    }
    public String returnpage(String path,boolean renderold) {
        Casenumber cn= new Casenumber();
        cn.setStatus("ongoing");
        casenumberejbFacade.create(cn);
        casenumber=casenumberejbFacade.find(cn.getId()).getId();
    
        renderoldeditbutton=renderold;
             
        return path + "?faces-redirect=true";
 
    }
    
     public String returnpageconfirm(String path) {
      int x=Integer.parseInt(selected.getCasenumber());
         this.casenumber=x;
        return path + "?faces-redirect=true";
 
    }
    public void onTabChange(TabChangeEvent event) {
  int size=0;
 
  String casenu=this.casenumber+"";
     System.out.println("The tab "+event.getTab().getId()+" yes ===> Is cliexcked ");
   if (event.getTab().getId().equals("wuklantab")) {
       if(wek.findByCaseId(casenu).isEmpty())
       {
        FacesMessage msg = new FacesMessage("Successful", "Please Fill Wekays");
        FacesContext.getCurrentInstance().addMessage(null, msg);
       }   
      
   } else if((event.getTab().getId().equals("tewokaytab")))
           {
     if(mekina.findByCaseId(casenu).isEmpty())
       {
        FacesMessage msg = new FacesMessage("Successful", "Please Fill Wuklna Data");
        FacesContext.getCurrentInstance().addMessage(null, msg);
       }  
               
   }
   else if((event.getTab().getId().equals("misikirtab")))
           {
     if(tew.findByCaseId(casenu).isEmpty())
       {
        FacesMessage msg = new FacesMessage("Successful", "Please Fill Tewokay Data");
        FacesContext.getCurrentInstance().addMessage(null, msg);
       }  
               
   }
}
     

public void updateConfirm(int u) {
    Casenumber cn = casenumberejbFacade.find(u);
    cn.setStatus("Closed"); 
    casen.setSelected(cn);
    casen.update();
    persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SenedochenatebekochUpdated"));
    }

}
