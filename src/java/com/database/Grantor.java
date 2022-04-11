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
 * @author habtamu
 */
@Entity
@Table(name = "grantor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grantor.findAll", query = "SELECT g FROM Grantor g"),
    @NamedQuery(name = "Grantor.findById", query = "SELECT g FROM Grantor g WHERE g.id = :id"),
    @NamedQuery(name = "Grantor.findByCustomertype", query = "SELECT g FROM Grantor g WHERE g.customertype = :customertype"),
    @NamedQuery(name = "Grantor.findByFirstname", query = "SELECT g FROM Grantor g WHERE g.firstname = :firstname"),
    @NamedQuery(name = "Grantor.findByMiddlename", query = "SELECT g FROM Grantor g WHERE g.middlename = :middlename"),
    @NamedQuery(name = "Grantor.findByLastname", query = "SELECT g FROM Grantor g WHERE g.lastname = :lastname"),
    @NamedQuery(name = "Grantor.findByCountry", query = "SELECT g FROM Grantor g WHERE g.country = :country"),
    @NamedQuery(name = "Grantor.findBySex", query = "SELECT g FROM Grantor g WHERE g.sex = :sex"),
    @NamedQuery(name = "Grantor.findByHousenumber", query = "SELECT g FROM Grantor g WHERE g.housenumber = :housenumber"),
    @NamedQuery(name = "Grantor.findByPhone", query = "SELECT g FROM Grantor g WHERE g.phone = :phone"),
    @NamedQuery(name = "Grantor.findByTinnumber", query = "SELECT g FROM Grantor g WHERE g.tinnumber = :tinnumber"),
    @NamedQuery(name = "Grantor.findByOrgName", query = "SELECT g FROM Grantor g WHERE g.orgname = :orgname"),
    @NamedQuery(name = "Grantor.findByAddress", query = "SELECT g FROM Grantor g WHERE g.address = :address")})

public class Grantor implements Serializable {

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
    
    @Size(max = 700)
    @Column(name = "orgname")
    private String orgname;
    
    @Size(max = 700)
    @Column(name = "address")
    private String address;
    
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
    @OneToMany(mappedBy = "grantid")
    private Collection<Property> propertyCollection;
    @JoinColumn(name = "repid", referencedColumnName = "id")
    @ManyToOne
    private Reprenstative repid;

    public Grantor() {
    }

    public Grantor(Integer id) {
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

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Property> getPropertyCollection() {
        return propertyCollection;
    }

    public void setPropertyCollection(Collection<Property> propertyCollection) {
        this.propertyCollection = propertyCollection;
    }

    public Reprenstative getRepid() {
        return repid;
    }

    public void setRepid(Reprenstative repid) {
        this.repid = repid;
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
        if (!(object instanceof Grantor)) {
            return false;
        }
        Grantor other = (Grantor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.Grantor[ id=" + id + " ]";
    }
    
}
