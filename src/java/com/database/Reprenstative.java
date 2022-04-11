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
 * @author habtamu
 */
@Entity
@Table(name = "reprenstative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reprenstative.findAll", query = "SELECT r FROM Reprenstative r"),
    @NamedQuery(name = "Reprenstative.findById", query = "SELECT r FROM Reprenstative r WHERE r.id = :id"),
    @NamedQuery(name = "Reprenstative.findByCustomertype", query = "SELECT r FROM Reprenstative r WHERE r.customertype = :customertype"),
    @NamedQuery(name = "Reprenstative.findByFirstname", query = "SELECT r FROM Reprenstative r WHERE r.firstname = :firstname"),
    @NamedQuery(name = "Reprenstative.findByMiddlename", query = "SELECT r FROM Reprenstative r WHERE r.middlename = :middlename"),
    @NamedQuery(name = "Reprenstative.findByLastname", query = "SELECT r FROM Reprenstative r WHERE r.lastname = :lastname"),
    @NamedQuery(name = "Reprenstative.findByCountry", query = "SELECT r FROM Reprenstative r WHERE r.country = :country"),
    @NamedQuery(name = "Reprenstative.findBySex", query = "SELECT r FROM Reprenstative r WHERE r.sex = :sex"),
    @NamedQuery(name = "Reprenstative.findByHousenumber", query = "SELECT r FROM Reprenstative r WHERE r.housenumber = :housenumber"),
    @NamedQuery(name = "Reprenstative.findByPhone", query = "SELECT r FROM Reprenstative r WHERE r.phone = :phone"),
    @NamedQuery(name = "Reprenstative.findByTinnumber", query = "SELECT r FROM Reprenstative r WHERE r.tinnumber = :tinnumber"),
    @NamedQuery(name = "Reprenstative.findByGrantid", query = "SELECT r FROM Reprenstative r WHERE r.grantid = :grantid")})
public class Reprenstative implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 700)
    @Column(name = "customertype")
    private String customertype;
    @Size(max = 700)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 700)
    @Column(name = "middlename")
    private String middlename;
    @Size(max = 700)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 700)
    @Column(name = "country")
    private String country;
    @Size(max = 100)
    @Column(name = "sex")
    private String sex;
    @Size(max = 100)
    @Column(name = "housenumber")
    private String housenumber;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "phone")
    private String phone;
    @Column(name = "tinnumber")
    private Integer tinnumber;
    @Column(name = "grantid")
    private Integer grantid;
    @OneToMany(mappedBy = "repid")
    private Collection<Property> propertyCollection;
    @OneToMany(mappedBy = "repid")
    private Collection<Grantor> grantorCollection;

    public Reprenstative() {
    }

    public Reprenstative(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getTinnumber() {
        return tinnumber;
    }

    public void setTinnumber(Integer tinnumber) {
        this.tinnumber = tinnumber;
    }

    public Integer getGrantid() {
        return grantid;
    }

    public void setGrantid(Integer grantid) {
        this.grantid = grantid;
    }

    @XmlTransient
    public Collection<Property> getPropertyCollection() {
        return propertyCollection;
    }

    public void setPropertyCollection(Collection<Property> propertyCollection) {
        this.propertyCollection = propertyCollection;
    }

    @XmlTransient
    public Collection<Grantor> getGrantorCollection() {
        return grantorCollection;
    }

    public void setGrantorCollection(Collection<Grantor> grantorCollection) {
        this.grantorCollection = grantorCollection;
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
        if (!(object instanceof Reprenstative)) {
            return false;
        }
        Reprenstative other = (Reprenstative) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.Reprenstative[ id=" + id + " ]";
    }
    
}
