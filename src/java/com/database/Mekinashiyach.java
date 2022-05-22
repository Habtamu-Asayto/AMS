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
@Table(name = "mekinashiyach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mekinashiyach.findAll", query = "SELECT m FROM Mekinashiyach m"),
    @NamedQuery(name = "Mekinashiyach.findById", query = "SELECT m FROM Mekinashiyach m WHERE m.id = :id"),
    @NamedQuery(name = "Mekinashiyach.findByShachname", query = "SELECT m FROM Mekinashiyach m WHERE m.shachname = :shachname"),
    @NamedQuery(name = "Mekinashiyach.findByShachfname", query = "SELECT m FROM Mekinashiyach m WHERE m.shachfname = :shachfname"),
    @NamedQuery(name = "Mekinashiyach.findByShachlastname", query = "SELECT m FROM Mekinashiyach m WHERE m.shachlastname = :shachlastname"),
    @NamedQuery(name = "Mekinashiyach.findByGezhname", query = "SELECT m FROM Mekinashiyach m WHERE m.gezhname = :gezhname"),
    @NamedQuery(name = "Mekinashiyach.findByGezhfname", query = "SELECT m FROM Mekinashiyach m WHERE m.gezhfname = :gezhfname"),
    @NamedQuery(name = "Mekinashiyach.findByGezhlastname", query = "SELECT m FROM Mekinashiyach m WHERE m.gezhlastname = :gezhlastname"),
    @NamedQuery(name = "Mekinashiyach.findByTargakutr", query = "SELECT m FROM Mekinashiyach m WHERE m.targakutr = :targakutr"),
    @NamedQuery(name = "Mekinashiyach.findByChancikutr", query = "SELECT m FROM Mekinashiyach m WHERE m.chancikutr = :chancikutr"),
    @NamedQuery(name = "Mekinashiyach.findByMotorkutr", query = "SELECT m FROM Mekinashiyach m WHERE m.motorkutr = :motorkutr"),
    @NamedQuery(name = "Mekinashiyach.findByYebrmetenm", query = "SELECT m FROM Mekinashiyach m WHERE m.yebrmetenm = :yebrmetenm")})
public class Mekinashiyach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "shachname")
    private String shachname;
     
    @Size(max = 200)
    @Column(name = "shachfname")
    private String shachfname;
    
    @Size(max = 200)
    @Column(name = "shachlastname")
    private String shachlastname;
    @Size(max = 200)
    @Column(name = "gezhname")
    private String gezhname;
    @Size(max = 200)
    @Column(name = "gezhfname")
    private String gezhfname;
    @Size(max = 200)
    @Column(name = "gezhlastname")
    private String gezhlastname;
    @Size(max = 100)
    @Column(name = "targakutr")
    private String targakutr;
    @Size(max = 100)
    @Column(name = "chancikutr")
    private String chancikutr;
    @Size(max = 100)
    @Column(name = "motorkutr")
    private String motorkutr;
    @Size(max = 200)
    @Column(name = "yebrmetenm")
    private String yebrmetenm;
 
    @Size(max = 1000)
    @Column(name = "caseid")
    private String caseid;

    Mekinashiyach() {
         }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }
    
    public Mekinashiyach(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShachname() {
        return shachname;
    }

    public void setShachname(String shachname) {
        this.shachname = shachname;
    }

    public String getShachfname() {
        return shachfname;
    }

    public void setShachfname(String shachfname) {
        this.shachfname = shachfname;
    }

    public String getShachlastname() {
        return shachlastname;
    }

    public void setShachlastname(String shachlastname) {
        this.shachlastname = shachlastname;
    }

    public String getGezhname() {
        return gezhname;
    }

    public void setGezhname(String gezhname) {
        this.gezhname = gezhname;
    }

    public String getGezhfname() {
        return gezhfname;
    }

    public void setGezhfname(String gezhfname) {
        this.gezhfname = gezhfname;
    }

    public String getGezhlastname() {
        return gezhlastname;
    }

    public void setGezhlastname(String gezhlastname) {
        this.gezhlastname = gezhlastname;
    }

    public String getTargakutr() {
        return targakutr;
    }

    public void setTargakutr(String targakutr) {
        this.targakutr = targakutr;
    }

    public String getChancikutr() {
        return chancikutr;
    }

    public void setChancikutr(String chancikutr) {
        this.chancikutr = chancikutr;
    }

    public String getMotorkutr() {
        return motorkutr;
    }

    public void setMotorkutr(String motorkutr) {
        this.motorkutr = motorkutr;
    }

    public String getYebrmetenm() {
        return yebrmetenm;
    }

    public void setYebrmetenm(String yebrmetenm) {
        this.yebrmetenm = yebrmetenm;
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
        if (!(object instanceof Mekinashiyach)) {
            return false;
        }
        Mekinashiyach other = (Mekinashiyach) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.databse.Mekinashiyach[ id=" + id + " ]";
    }
    
}
