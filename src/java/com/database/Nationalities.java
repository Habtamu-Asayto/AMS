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
@Table(name = "nationalities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nationalities.findAll", query = "SELECT n FROM Nationalities n"),
    @NamedQuery(name = "Nationalities.findById", query = "SELECT n FROM Nationalities n WHERE n.id = :id"),
    @NamedQuery(name = "Nationalities.findByNationalityName", query = "SELECT n FROM Nationalities n WHERE n.nationalityName = :nationalityName")})
public class Nationalities implements Serializable {

    @OneToMany(mappedBy = "nationality")
    private Collection<Misikir> misikirCollection;

    @OneToMany(mappedBy = "nationality")
    private Collection<Tewokay> tewokayCollection;

    @OneToMany(mappedBy = "nationality")
    private Collection<Wekay> wekayCollection;

    @OneToMany(mappedBy = "nationality")
    private Collection<Regions> regionsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2000)
    @Column(name = "nationality_name")
    private String nationalityName; 

    public Nationalities() {
    }

    public Nationalities(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
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
        if (!(object instanceof Nationalities)) {
            return false;
        }
        Nationalities other = (Nationalities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nationalityName;
    }

    @XmlTransient
    public Collection<Regions> getRegionsCollection() {
        return regionsCollection;
    }

    public void setRegionsCollection(Collection<Regions> regionsCollection) {
        this.regionsCollection = regionsCollection;
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
