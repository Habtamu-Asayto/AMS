package com.database;

import com.database.util.JsfUtil;
import com.database.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("misikirController")
@SessionScoped
public class MisikirController implements Serializable {

    @EJB
    private com.database.MisikirFacade ejbFacade;
    private List<Misikir> items = null;
    private Misikir selected;
 private boolean renderupdatebutton=false;

    public boolean isRenderupdatebutton() {
        return renderupdatebutton;
    }

    public void setRenderupdatebutton(boolean renderupdatebutton) {
        this.renderupdatebutton = renderupdatebutton;
    }
    public MisikirController() {
    }

    public Misikir getSelected() {
        return selected;
    }

    public void setSelected(Misikir selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MisikirFacade getFacade() {
        return ejbFacade;
    }

    public Misikir prepareCreate() {
        selected = new Misikir();
        initializeEmbeddableKey();
        return selected;
    }

     public void create(String caseid) {
      this.selected.setCasenumber(caseid);
       persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MisikirCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
      public List<Misikir> findByCaseId(String caseid)
    {
    List<Misikir> data=null;
     data=getFacade().findByCaseId(caseid);
     return data;
    }
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MisikirCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
   
       public void updatebyid(Misikir w) {
                 this.selected=w;
                 this.renderupdatebutton=true;
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("WekayUpdated"));
    }
    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MisikirUpdated"));
    }
 public void destroyById(Misikir te) {
       selected=te;
         persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MisikirDeleted"));
        if (!JsfUtil.isValidationFailed()) {
          
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MisikirDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Misikir> getItems() {
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

    public Misikir getMisikir(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Misikir> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Misikir> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Misikir.class)
    public static class MisikirControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MisikirController controller = (MisikirController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "misikirController");
            return controller.getMisikir(getKey(value));
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
            if (object instanceof Misikir) {
                Misikir o = (Misikir) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Misikir.class.getName()});
                return null;
            }
        }

    }
@PostConstruct
     public void init()
     {
      selected= new Misikir();
     
     }
}
