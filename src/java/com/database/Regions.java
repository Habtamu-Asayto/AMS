/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fedlu
 */
@Entity
@Table(name = "regions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regions.findAll", query = "SELECT r FROM Regions r"),
    @NamedQuery(name = "Regions.findById", query = "SELECT r FROM Regions r WHERE r.id = :id"),
    @NamedQuery(name = "Regions.findByRegionname", query = "SELECT r FROM Regions r WHERE r.regionname = :regionname")})
public class Regions implements Serializable {

    @OneToMany(mappedBy = "region")
    private Collection<Misikir> misikirCollection;

    @OneToMany(mappedBy = "region")
    private Collection<Tewokay> tewokayCollection;

    @OneToMany(mappedBy = "region")
    private Collection<Wekay> wekayCollection;

    @JoinColumn(name = "nationality", referencedColumnName = "id")
    @ManyToOne
    private Nationalities nationality;
 

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "regionname")
    private String regionname; 
    @OneToMany(mappedBy = "regionid")
    private Collection<Zones> zonesCollection; 
    @OneToMany(mappedBy = "regionid")
    private Collection<Senedochenatebekoch> senedochenatebekochCollection;
     
    public Regions() {
    }

    public Regions(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }
 
    @XmlTransient
    public Collection<Zones> getZonesCollection() {
        return zonesCollection;
    }

    public void setZonesCollection(Collection<Zones> zonesCollection) {
        this.zonesCollection = zonesCollection;
    }
 

    @XmlTransient
    public Collection<Senedochenatebekoch> getSenedochenatebekochCollection() {
        return senedochenatebekochCollection;
    }

    public void setSenedochenatebekochCollection(Collection<Senedochenatebekoch> senedochenatebekochCollection) {
        this.senedochenatebekochCollection = senedochenatebekochCollection;
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
        if (!(object instanceof Regions)) {
            return false;
        }
        Regions other = (Regions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return regionname ;
    } 

    public Nationalities getNationality() {
        return nationality;
    }

    public void setNationality(Nationalities nationality) {
        this.nationality = nationality;
    }

    @XmlTransient
    public Collection<Wekay> getWekayCollection() {
        return wekayCollection;
    }

    public void setWekayCollection(Collection<Wekay> wekayCollection) {
        this.wekayCollection = wekayCollection;
    }

    @XmlTransient
    public Collection<Tewokay> getTewokayCollection() {
        return tewokayCollection;
    }

    public void setTewokayCollection(Collection<Tewokay> tewokayCollection) {
        this.tewokayCollection = tewokayCollection;
    }

    @XmlTransient
    public Collection<Misikir> getMisikirCollection() {
        return misikirCollection;
    }

    public void setMisikirCollection(Collection<Misikir> misikirCollection) {
        this.misikirCollection = misikirCollection;
    }
    
}
