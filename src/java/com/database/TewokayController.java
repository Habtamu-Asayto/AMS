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

@Named("tewokayController")
@SessionScoped
public class TewokayController implements Serializable {

    @EJB
    private com.database.TewokayFacade ejbFacade;
    private List<Tewokay> items = null;
    private Tewokay selected;
private boolean renderupdatebutton;

    public boolean isRenderupdatebutton() {
        return renderupdatebutton;
    }

    public void setRenderupdatebutton(boolean renderupdatebutton) {
        this.renderupdatebutton = renderupdatebutton;
    }
    public TewokayController() {
    }

    public Tewokay getSelected() {
        return selected;
    }

    public void setSelected(Tewokay selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TewokayFacade getFacade() {
        return ejbFacade;
    }

    public Tewokay prepareCreate() {
        selected = new Tewokay();
        initializeEmbeddableKey();
        return selected;
    }
  public void create(String caseid) {
      this.selected.setCasenumber(caseid);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TewokayCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
         
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TewokayCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
   public void updatebyid(Tewokay w) {
                 this.selected=w;
                 this.renderupdatebutton=true;
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TewokayUpdated"));
    }
    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TewokayUpdated"));
    }
   public void destroyById(Tewokay te) {
       selected=te;
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TewokayDeleted"));
        if (!JsfUtil.isValidationFailed()) {
          
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TewokayDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
   public List<Tewokay> findByCaseId(String caseid)
    {
    List<Tewokay> data=null;
     data=getFacade().findByCaseId(caseid);
     return data;
    }
    public List<Tewokay> getItems() {
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

    public Tewokay getTewokay(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Tewokay> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tewokay> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tewokay.class)
    public static class TewokayControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TewokayController controller = (TewokayController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tewokayController");
            return controller.getTewokay(getKey(value));
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
            if (object instanceof Tewokay) {
                Tewokay o = (Tewokay) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tewokay.class.getName()});
                return null;
            }
        }

    }
@PostConstruct
     public void init()
     {
      selected= new Tewokay();
     
     }
}
