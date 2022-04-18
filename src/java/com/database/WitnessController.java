package com.database;

import com.database.util.JsfUtil;
import com.database.util.JsfUtil.PersistAction;
import java.io.IOException;
import java.io.InputStream;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.inject.Named; 
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter; 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FilesUploadEvent;
import org.primefaces.model.file.UploadedFile;

@Named("witnessController")
@ViewScoped
public class WitnessController implements Serializable {

    @EJB
    private com.database.WitnessFacade ejbFacade;
    private List<Witness> items = null;
    private Witness selected;

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
        System.out.println("File Size : "+file.getSize());
    }
    
    @PostConstruct
    public void init(){
        selected = new Witness();
    } 
    
    public void importWitness(FilesUploadEvent event){
        System.out.println("File Size : "+file.getSize());
        this.file = (UploadedFile) event.getFiles();
        if(file.getSize() > 0){
            try {
                // poi-ooxml
                InputStream inputStream = file.getInputStream();
                XSSFWorkbook lib = new XSSFWorkbook(inputStream);
                Sheet sheet = lib.getSheetAt(0);
                Iterator<Row> iterator = sheet.iterator();
                int i=0;
                while(iterator.hasNext()) {
                    Row currentRow = iterator.next();
                    if(i>0) {
                        if(currentRow.getCell(0)!= null &&
                           currentRow.getCell(1)!= null &&
                           currentRow.getCell(2)!= null &&
                           currentRow.getCell(3)!= null &&
                           currentRow.getCell(4)!= null ){
                            selected.setFullname(currentRow.getCell(0).getStringCellValue());
                            selected.setEmail(currentRow.getCell(1).getStringCellValue());
                            selected.setPhone(currentRow.getCell(2).getStringCellValue());
                            selected.setAddress(currentRow.getCell(3).getStringCellValue());
                            selected.setAnswer(currentRow.getCell(4).getStringCellValue());
                            ejbFacade.create(selected);
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Table Successfully Imported"));
                        }
                        else{
                            break;
                        }
                    }
                    i++;
                }
                
                
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "There is Error"));
        }
    }
    
    
    public WitnessController() {
    }

    public Witness getSelected() {
        return selected;
    }

    public void setSelected(Witness selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private WitnessFacade getFacade() {
        return ejbFacade;
    }

    public Witness prepareCreate() {
        selected = new Witness();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("WitnessCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("WitnessUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("WitnessDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Witness> getItems() {
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

    public Witness getWitness(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Witness> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Witness> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Witness.class)
    public static class WitnessControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            WitnessController controller = (WitnessController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "witnessController");
            return controller.getWitness(getKey(value));
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
            if (object instanceof Witness) {
                Witness o = (Witness) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Witness.class.getName()});
                return null;
            }
        }

    }

}
