/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.inject.Default;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fedlu
 */
@Entity
@Table(name = "senedochenatebekoch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Senedochenatebekoch.findAll", query = "SELECT s FROM Senedochenatebekoch s"),
    @NamedQuery(name = "Senedochenatebekoch.findById", query = "SELECT s FROM Senedochenatebekoch s WHERE s.id = :id"),
    @NamedQuery(name = "Senedochenatebekoch.findByHager", query = "SELECT s FROM Senedochenatebekoch s WHERE s.hager = :hager"),
   })
public class Senedochenatebekoch implements Serializable {

    @Size(max = 2000)
    @Column(name = "casenumber")
    private String casenumber;
    
    @Size(max = 2000)
    @Column(name = "agelgloteteyaki")
    private String agelgloteteyaki;

  
    @Column(name = "glgalotyetekebetken")
    @Temporal(TemporalType.DATE)
    private Date glgalotyetekebetken;
    
    @Column(name = "gelgalotyetesetebetken")
    @Temporal(TemporalType.DATE)
    private Date gelgalotyetesetebetken;
    
    
    @JoinColumn(name = "seriviceoffice", referencedColumnName = "id")
    @ManyToOne
    private ServiceDeliveryoffice seriviceoffice; 
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
     @Size(max = 200)
    @Column(name = "hager")
    private String hager;
    
    @Size(max = 200)
    @Column(name = "kebele")
    private String kebele;

 
    @Column(name = "filekutr")
    private String filekutr;
    @Size(max = 200)
    
    @Column(name = "mezgebuyetekemetebetbota")
    private String mezgebuyetekemetebetbota;
    @Size(max = 200)
    @Column(name = "getbzat")
    private String getbzat;
    @Size(max = 200)
   
    @Column(name = "filepath")
    private String filepath;
    
   
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
   

  
  
    @JoinColumn(name = "regionid", referencedColumnName = "id")
    @ManyToOne
    private Regions regionid;

    
    @JoinColumn(name = "woredaid", referencedColumnName = "id")
    @ManyToOne
    private Weredas woredaid;
    @JoinColumn(name = "zoneid", referencedColumnName = "id")
    @ManyToOne
    private Zones zoneid;

    public Senedochenatebekoch() {
    }

    public Senedochenatebekoch(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
     
    public String getAgelgloteteyaki() {
        return agelgloteteyaki;
    }

    public void setAgelgloteteyaki(String agelgloteteyaki) {
        this.agelgloteteyaki = agelgloteteyaki;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHager() {
        return hager;
    }

    public void setHager(String hager) {
        this.hager = hager;
    }

    public String getKebele() {
        return kebele;
    }

    public void setKebele(String kebele) {
        this.kebele = kebele;
    }

    public Date getGelgalotyetesetebetken() {
        return gelgalotyetesetebetken;
    }

    public void setGelgalotyetesetebetken(Date gelgalotyetesetebetken) {
        this.gelgalotyetesetebetken = gelgalotyetesetebetken;
    }


    public String getFilekutr() {
        return filekutr;
    }

    public void setFilekutr(String filekutr) {
        this.filekutr = filekutr;
    }

    public String getMezgebuyetekemetebetbota() {
        return mezgebuyetekemetebetbota;
    }

    public void setMezgebuyetekemetebetbota(String mezgebuyetekemetebetbota) {
        this.mezgebuyetekemetebetbota = mezgebuyetekemetebetbota;
    }

    public String getGetbzat() {
        return getbzat;
    }

    public void setGetbzat(String getbzat) {
        this.getbzat = getbzat;
    }

  

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

  
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

   
  

    public Regions getRegionid() {
        return regionid;
    }

    public void setRegionid(Regions regionid) {
        this.regionid = regionid;
    }



    public Weredas getWoredaid() {
        return woredaid;
    }

    public void setWoredaid(Weredas woredaid) {
        this.woredaid = woredaid;
    }

    public Zones getZoneid() {
        return zoneid;
    }

    public void setZoneid(Zones zoneid) {
        this.zoneid = zoneid;
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
        if (!(object instanceof Senedochenatebekoch)) {
            return false;
        }
        Senedochenatebekoch other = (Senedochenatebekoch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.databse.Senedochenatebekoch[ id=" + id + " ]";
    }

    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber;
    }

    public Date getGlgalotyetekebetken() {
        return glgalotyetekebetken;
    }

    public void setGlgalotyetekebetken(Date glgalotyetekebetken) {
        this.glgalotyetekebetken = glgalotyetekebetken;
    }

    public ServiceDeliveryoffice getSeriviceoffice() {
        return seriviceoffice;
    }

    public void setSeriviceoffice(ServiceDeliveryoffice seriviceoffice) {
        this.seriviceoffice = seriviceoffice;
    } 
    
}
