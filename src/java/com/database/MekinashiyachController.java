package com.database;

import com.database.util.JsfUtil;
import com.database.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.PrimeFaces;

@Named("mekinashiyachController")
@SessionScoped
public class MekinashiyachController implements Serializable {

    @EJB
    private com.database.MekinashiyachFacade ejbFacade;
    private List<Mekinashiyach> items = null;
    private Mekinashiyach selected;

    public MekinashiyachController() {
    }

    public Mekinashiyach getSelected() {
        return selected;
    }

    public void setSelected(Mekinashiyach selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MekinashiyachFacade getFacade() {
        return ejbFacade;
    }

    public Mekinashiyach prepareCreate() {
        selected = new Mekinashiyach();
        initializeEmbeddableKey();
        return selected;
    }

    public void create(String caseid) {
         
        this.selected.setCaseid(caseid);
        this.renderupdatebutton=false;
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MekinashiyachCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    boolean renderupdatebutton=false;
   

  
    public boolean isRenderupdatebutton() {
        return renderupdatebutton;
    }

    public void setRenderupdatebutton(boolean renderupdatebutton) {
        this.renderupdatebutton = renderupdatebutton;
    }
    
public void updatebyid(Mekinashiyach mek) {
    
    
     this.selected=mek;
     this.renderupdatebutton=true;
    
     
//      PrimeFaces.current().ajax().update("mekinaForm:displayt");
      
    }
    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MekinashiyachUpdated"));
        prepareCreate();
        this.renderupdatebutton=false;
    }
  public void destroyById(Mekinashiyach sel) {
          this.selected=sel;
        
      persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MekinashiyachDeleted"));
        if (!JsfUtil.isValidationFailed()) {
          selected=new Mekinashiyach();
        }
    }
    public void destroy() {
        
      persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MekinashiyachDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
  
    public List<Mekinashiyach> findByCaseId(String caseid)
    {
    List<Mekinashiyach> data=null;
     data=getFacade().findByCaseId(caseid);
     return data;
    }
    public List<Mekinashiyach> getItems() {
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

    public Mekinashiyach getMekinashiyach(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Mekinashiyach> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Mekinashiyach> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Mekinashiyach.class)
    public static class MekinashiyachControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MekinashiyachController controller = (MekinashiyachController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "mekinashiyachController");
            return controller.getMekinashiyach(getKey(value));
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
            if (object instanceof Mekinashiyach) {
                Mekinashiyach o = (Mekinashiyach) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Mekinashiyach.class.getName()});
                return null;
            }
        }

    }

}
