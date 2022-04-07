/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author habtamu
 */
@Entity
@Table(name = "appointment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.findById", query = "SELECT a FROM Appointment a WHERE a.id = :id"),
    @NamedQuery(name = "Appointment.findByCustomerName", query = "SELECT a FROM Appointment a WHERE a.customerName = :customerName"),
    @NamedQuery(name = "Appointment.findByCustomerEmail", query = "SELECT a FROM Appointment a WHERE a.customerEmail = :customerEmail"),
    @NamedQuery(name = "Appointment.findByCustomerPhone", query = "SELECT a FROM Appointment a WHERE a.customerPhone = :customerPhone"),
    @NamedQuery(name = "Appointment.findBySex", query = "SELECT a FROM Appointment a WHERE a.sex = :sex"),
    @NamedQuery(name = "Appointment.findByAppointmentdate", query = "SELECT a FROM Appointment a WHERE a.appointmentdate = :appointmentdate"),
    @NamedQuery(name = "Appointment.findByAppointmenttime", query = "SELECT a FROM Appointment a WHERE a.appointmenttime = :appointmenttime"),
    @NamedQuery(name = "Appointment.findByDetail", query = "SELECT a FROM Appointment a WHERE a.detail = :detail")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1000)
    @Column(name = "customer_name")
    private String customerName;
    @Size(max = 1000)
    @Column(name = "customer_email")
    private String customerEmail;
    @Size(max = 1000)
    @Column(name = "customer_phone")
    private String customerPhone;
    @Size(max = 1000)
    @Column(name = "sex")
    private String sex;
    @Column(name = "appointmentdate")
    @Temporal(TemporalType.DATE)
    private Date appointmentdate;
    @Column(name = "appointmenttime")
    @Temporal(TemporalType.TIME)
    private Date appointmenttime;
    @Size(max = 2147483647)
    @Column(name = "detail")
    private String detail;

    public Appointment() {
    }

    public Appointment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getAppointmentdate() {
        return appointmentdate;
    }

    public void setAppointmentdate(Date appointmentdate) {
        this.appointmentdate = appointmentdate;
    }

    public Date getAppointmenttime() {
        return appointmenttime;
    }

    public void setAppointmenttime(Date appointmenttime) {
        this.appointmenttime = appointmenttime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.Appointment[ id=" + id + " ]";
    }
    
}
