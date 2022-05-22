package com.database;

import com.database.util.JsfUtil;
import com.database.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

@Named("appointmentController")
@SessionScoped
public class AppointmentController implements Serializable {

    @EJB
    private com.database.AppointmentFacade ejbFacade;
    private List<Appointment> items = null;
    private Appointment selected;
    private String text;
    
    private Date dateDe;
    private Date dateTimeDe;
    private Date dateTimeMillis;
    private List<Date> multi;
    private List<Date> range;
    private List<Date> invalidDates;
    private List<Integer> invalidDays;
    private Date minDate;
    private Date maxDate;
    private Date minTime;
    private Date maxTime;
    private Date minDateTime;
    private Date maxDateTime;

    private Date date13;

    public Date getDate13() {
        return date13;
    }

    public Date getDateDe() {
        return dateDe;
    }

    public void setDateDe(Date dateDe) {
        this.dateDe = dateDe;
    }

    public Date getDateTimeDe() {
        return dateTimeDe;
    }

    public void setDateTimeDe(Date dateTimeDe) {
        this.dateTimeDe = dateTimeDe;
    }

    public Date getDateTimeMillis() {
        return dateTimeMillis;
    }

    public void setDateTimeMillis(Date dateTimeMillis) {
        this.dateTimeMillis = dateTimeMillis;
    }

    public List<Date> getMulti() {
        return multi;
    }

    public void setMulti(List<Date> multi) {
        this.multi = multi;
    }

    public List<Date> getRange() {
        return range;
    }

    public void setRange(List<Date> range) {
        this.range = range;
    }

    public List<Date> getInvalidDates() {
        return invalidDates;
    }

    public void setInvalidDates(List<Date> invalidDates) {
        this.invalidDates = invalidDates;
    }

    public List<Integer> getInvalidDays() {
        return invalidDays;
    }

    public void setInvalidDays(List<Integer> invalidDays) {
        this.invalidDays = invalidDays;
    }

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    public Date getMinTime() {
        return minTime;
    }

    public void setMinTime(Date minTime) {
        this.minTime = minTime;
    }

    public Date getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Date maxTime) {
        this.maxTime = maxTime;
    }

    public Date getMinDateTime() {
        return minDateTime;
    }

    public void setMinDateTime(Date minDateTime) {
        this.minDateTime = minDateTime;
    }

    public Date getMaxDateTime() {
        return maxDateTime;
    }

    public void setMaxDateTime(Date maxDateTime) {
        this.maxDateTime = maxDateTime;
    }

    public void setDate13(Date date13) {
        this.date13 = date13;
    }
    @PostConstruct
    public void init() {
        invalidDates = new ArrayList<>();
        Date today = new Date();
        invalidDates.add(today);
        long oneDay = 24 * 60 * 60 * 1000;
        for (int i = 0; i < 5; i++) {
            invalidDates.add(new Date(invalidDates.get(i).getTime() + oneDay));
        }

        invalidDays = new ArrayList<>();
        invalidDays.add(0);
        /* the first day of week is disabled */
        invalidDays.add(3);

        minDate = new Date(today.getTime() - (365 * oneDay));
        maxDate = new Date(today.getTime() + (365 * oneDay));

        Calendar tmp = Calendar.getInstance();
        tmp.set(Calendar.HOUR_OF_DAY, 9);
        tmp.set(Calendar.MINUTE, 0);
        tmp.set(Calendar.SECOND, 0);
        tmp.set(Calendar.MILLISECOND, 0);
        minTime = tmp.getTime();

        tmp = Calendar.getInstance();
        tmp.set(Calendar.HOUR_OF_DAY, 17);
        tmp.set(Calendar.MINUTE, 0);
        tmp.set(Calendar.SECOND, 0);
        tmp.set(Calendar.MILLISECOND, 0);
        maxTime = tmp.getTime();

        minDateTime = new Date(today.getTime() - (7 * oneDay));
        maxDateTime = new Date(today.getTime() + (7 * oneDay));

        dateDe = GregorianCalendar.getInstance().getTime();
        dateTimeDe = GregorianCalendar.getInstance().getTime();
        dateTimeMillis = GregorianCalendar.getInstance().getTime();
    }
    
    public AppointmentController() {
    } 
    public Appointment getSelected() {
        return selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    

    public void setSelected(Appointment selected) {
        this.selected = selected;
    } 

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AppointmentFacade getFacade() {
        return ejbFacade;
    }

    public Appointment prepareCreate() {
        selected = new Appointment();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AppointmentCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AppointmentUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AppointmentDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Appointment> getItems() {
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

    public Appointment getAppointment(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Appointment> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Appointment> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Appointment.class)
    public static class AppointmentControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AppointmentController controller = (AppointmentController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "appointmentController");
            return controller.getAppointment(getKey(value));
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
            if (object instanceof Appointment) {
                Appointment o = (Appointment) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Appointment.class.getName()});
                return null;
            }
        }

    }

}
