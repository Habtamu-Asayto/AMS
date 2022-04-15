package com.database;

import com.database.util.JsfUtil;
import com.database.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("grantorController")
@SessionScoped
public class GrantorController implements Serializable {

    @EJB
    private com.database.GrantorFacade ejbFacade;
    private List<Grantor> items = null;
    private Grantor selected = new Grantor();

    public GrantorController() {
    }
    public void insert(){
        Random rand = new Random();
        rand.setSeed(12345); 
        System.out.println("Code : "+rand.nextInt());
        selected.setCasecode(""+rand.nextInt());
        
        this.ejbFacade.create(selected);
        this.selected = new Grantor(); 
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(" Grantor Registered successfully!"));
    }
     
    //Add Rows Dynamically  
    private List<Grantor> grantors; 

     @PostConstruct
    public void init() {
        grantors = new ArrayList<Grantor>();
    }
    
     public void add() { 
        System.out.println("Try to add");
        Grantor witnes=new Grantor();//Item item = new Item();
        grantors.add(witnes); 
    }

    public void remove(Grantor witnes) {
        System.out.println("Try to remove");
        grantors.remove(witnes);
    }
    
    public List<Grantor> getGrantors() {
        return grantors;
    }

    public void setGrantors(List<Grantor> grantors) {
        this.grantors = grantors;
    }
    
    
    
    public Grantor getSelected() {
        return selected;
    }

    public void setSelected(Grantor selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private GrantorFacade getFacade() {
        return ejbFacade;
    }

    public Grantor prepareCreate() {
        selected = new Grantor();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("GrantorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("GrantorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("GrantorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Grantor> getItems() {
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

    public Grantor getGrantor(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Grantor> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Grantor> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Grantor.class)
    public static class GrantorControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GrantorController controller = (GrantorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "grantorController");
            return controller.getGrantor(getKey(value));
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
            if (object instanceof Grantor) {
                Grantor o = (Grantor) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Grantor.class.getName()});
                return null;
            }
        }

    }

}
