/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fedlu
 */
@Entity
@Table(name = "casenumber")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casenumber.findAll", query = "SELECT c FROM Casenumber c"),
    @NamedQuery(name = "Casenumber.findById", query = "SELECT c FROM Casenumber c WHERE c.id = :id"),
    @NamedQuery(name = "Casenumber.findByCasenumber", query = "SELECT c FROM Casenumber c WHERE c.casenumber = :casenumber")})
public class Casenumber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "casenumber")
    private Integer casenumber;
    
    @Size(max = 200)
    @Column(name = "status")
    private String status;

    public Casenumber() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public Casenumber(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(Integer casenumber) {
        this.casenumber = casenumber;
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
        if (!(object instanceof Casenumber)) {
            return false;
        }
        Casenumber other = (Casenumber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.Casenumber[ id=" + id + " ]";
    }
    
}
