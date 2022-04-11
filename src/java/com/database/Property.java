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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author habtamu
 */
@Entity
@Table(name = "property")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Property.findAll", query = "SELECT p FROM Property p"),
    @NamedQuery(name = "Property.findById", query = "SELECT p FROM Property p WHERE p.id = :id"),
    @NamedQuery(name = "Property.findByPropertyname", query = "SELECT p FROM Property p WHERE p.propertyname = :propertyname"),
    @NamedQuery(name = "Property.findByMotornumber", query = "SELECT p FROM Property p WHERE p.motornumber = :motornumber"),
    @NamedQuery(name = "Property.findByChansinumber", query = "SELECT p FROM Property p WHERE p.chansinumber = :chansinumber"),
    @NamedQuery(name = "Property.findByLibrenumber", query = "SELECT p FROM Property p WHERE p.librenumber = :librenumber"),
    @NamedQuery(name = "Property.findByCode", query = "SELECT p FROM Property p WHERE p.code = :code"),
    @NamedQuery(name = "Property.findByPlatenumber", query = "SELECT p FROM Property p WHERE p.platenumber = :platenumber"),
    @NamedQuery(name = "Property.findByVehicletype", query = "SELECT p FROM Property p WHERE p.vehicletype = :vehicletype"),
    @NamedQuery(name = "Property.findByHousenumber", query = "SELECT p FROM Property p WHERE p.housenumber = :housenumber"),
    @NamedQuery(name = "Property.findByResidencearea", query = "SELECT p FROM Property p WHERE p.residencearea = :residencearea"),
    @NamedQuery(name = "Property.findByHousetype", query = "SELECT p FROM Property p WHERE p.housetype = :housetype"),
    @NamedQuery(name = "Property.findByCompanyname", query = "SELECT p FROM Property p WHERE p.companyname = :companyname"),
    @NamedQuery(name = "Property.findByBusinessregno", query = "SELECT p FROM Property p WHERE p.businessregno = :businessregno"),
    @NamedQuery(name = "Property.findByBusinessliceno", query = "SELECT p FROM Property p WHERE p.businessliceno = :businessliceno"),
    @NamedQuery(name = "Property.findByTinno", query = "SELECT p FROM Property p WHERE p.tinno = :tinno"),
    @NamedQuery(name = "Property.findByBusinesscategory", query = "SELECT p FROM Property p WHERE p.businesscategory = :businesscategory"),
    @NamedQuery(name = "Property.findByDetail", query = "SELECT p FROM Property p WHERE p.detail = :detail")})
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 700)
    @Column(name = "propertyname")
    private String propertyname;
    @Size(max = 100)
    @Column(name = "motornumber")
    private String motornumber;
    @Size(max = 100)
    @Column(name = "chansinumber")
    private String chansinumber;
    @Size(max = 100)
    @Column(name = "librenumber")
    private String librenumber;
    @Size(max = 100)
    @Column(name = "code")
    private String code;
    @Size(max = 100)
    @Column(name = "platenumber")
    private String platenumber;
    @Size(max = 700)
    @Column(name = "vehicletype")
    private String vehicletype;
    @Size(max = 100)
    @Column(name = "housenumber")
    private String housenumber;
    @Size(max = 700)
    @Column(name = "residencearea")
    private String residencearea;
    @Size(max = 700)
    @Column(name = "housetype")
    private String housetype;
    @Size(max = 700)
    @Column(name = "companyname")
    private String companyname;
    @Size(max = 700)
    @Column(name = "businessregno")
    private String businessregno;
    @Size(max = 700)
    @Column(name = "businessliceno")
    private String businessliceno;
    @Size(max = 700)
    @Column(name = "tinno")
    private String tinno;
    @Size(max = 700)
    @Column(name = "businesscategory")
    private String businesscategory;
    @Size(max = 2147483647)
    @Column(name = "detail")
    private String detail;
    @JoinColumn(name = "grantid", referencedColumnName = "id")
    @ManyToOne
    private Grantor grantid;
    @JoinColumn(name = "repid", referencedColumnName = "id")
    @ManyToOne
    private Reprenstative repid;

    public Property() {
    }

    public Property(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
    }

    public String getMotornumber() {
        return motornumber;
    }

    public void setMotornumber(String motornumber) {
        this.motornumber = motornumber;
    }

    public String getChansinumber() {
        return chansinumber;
    }

    public void setChansinumber(String chansinumber) {
        this.chansinumber = chansinumber;
    }

    public String getLibrenumber() {
        return librenumber;
    }

    public void setLibrenumber(String librenumber) {
        this.librenumber = librenumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(String platenumber) {
        this.platenumber = platenumber;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getResidencearea() {
        return residencearea;
    }

    public void setResidencearea(String residencearea) {
        this.residencearea = residencearea;
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getBusinessregno() {
        return businessregno;
    }

    public void setBusinessregno(String businessregno) {
        this.businessregno = businessregno;
    }

    public String getBusinessliceno() {
        return businessliceno;
    }

    public void setBusinessliceno(String businessliceno) {
        this.businessliceno = businessliceno;
    }

    public String getTinno() {
        return tinno;
    }

    public void setTinno(String tinno) {
        this.tinno = tinno;
    }

    public String getBusinesscategory() {
        return businesscategory;
    }

    public void setBusinesscategory(String businesscategory) {
        this.businesscategory = businesscategory;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Grantor getGrantid() {
        return grantid;
    }

    public void setGrantid(Grantor grantid) {
        this.grantid = grantid;
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
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.Property[ id=" + id + " ]";
    }
    
}
