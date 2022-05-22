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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "tewokay")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tewokay.findAll", query = "SELECT t FROM Tewokay t"),
    @NamedQuery(name = "Tewokay.findById", query = "SELECT t FROM Tewokay t WHERE t.id = :id"),
    @NamedQuery(name = "Tewokay.findByFirtstname", query = "SELECT t FROM Tewokay t WHERE t.firtstname = :firtstname"),
    @NamedQuery(name = "Tewokay.findByMiddlename", query = "SELECT t FROM Tewokay t WHERE t.middlename = :middlename"),
    @NamedQuery(name = "Tewokay.findByLastname", query = "SELECT t FROM Tewokay t WHERE t.lastname = :lastname"),
    @NamedQuery(name = "Tewokay.findByPassword", query = "SELECT t FROM Tewokay t WHERE t.password = :password"),
    @NamedQuery(name = "Tewokay.findByEmail", query = "SELECT t FROM Tewokay t WHERE t.email = :email"),
    @NamedQuery(name = "Tewokay.findByPhoneNumber", query = "SELECT t FROM Tewokay t WHERE t.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Tewokay.findByHousePhoneNumber", query = "SELECT t FROM Tewokay t WHERE t.housePhoneNumber = :housePhoneNumber"),
    @NamedQuery(name = "Tewokay.findByStatus", query = "SELECT t FROM Tewokay t WHERE t.status = :status"),
    @NamedQuery(name = "Tewokay.findByKebele", query = "SELECT t FROM Tewokay t WHERE t.kebele = :kebele"),
    @NamedQuery(name = "Tewokay.findByIdNumber", query = "SELECT t FROM Tewokay t WHERE t.idNumber = :idNumber"),
    @NamedQuery(name = "Tewokay.findByHouseNumber", query = "SELECT t FROM Tewokay t WHERE t.houseNumber = :houseNumber"),
    @NamedQuery(name = "Tewokay.findByPobox", query = "SELECT t FROM Tewokay t WHERE t.pobox = :pobox"),
    @NamedQuery(name = "Tewokay.findByDateOfBirth", query = "SELECT t FROM Tewokay t WHERE t.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Tewokay.findBySex", query = "SELECT t FROM Tewokay t WHERE t.sex = :sex"),
    @NamedQuery(name = "Tewokay.findByOrganizationname", query = "SELECT t FROM Tewokay t WHERE t.organizationname = :organizationname")})
public class Tewokay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2000)
    @Column(name = "firtstname")
    private String firtstname;
    
    @Size(max = 2000)
    @Column(name = "middlename")
    private String middlename;
    
     @Size(max = 2000)
    @Column(name = "casenumber")
    private String casenumber;

    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber;
    }
    
    @Size(max = 2000)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 2000)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2000)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Size(max = 50)
    @Column(name = "house_phone_number")
    private String housePhoneNumber;
    @Size(max = 20)
    @Column(name = "status")
    private String status;
    @Size(max = 200)
    @Column(name = "kebele")
    private String kebele;
    @Size(max = 200)
    @Column(name = "id_number")
    private String idNumber;
    @Size(max = 200)
    @Column(name = "house_number")
    private String houseNumber;
    @Size(max = 200)
    @Column(name = "pobox")
    private String pobox;
    @Size(max = 200)
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Size(max = 200)
    @Column(name = "sex")
    private String sex;
    @Lob
    @Column(name = "role")
    private byte[] role;
    @Size(max = 1000)
    @Column(name = "organizationname")
    private String organizationname;
    @JoinColumn(name = "nationality", referencedColumnName = "id")
    @ManyToOne
    private Nationalities nationality;
    @JoinColumn(name = "organization_type", referencedColumnName = "id")
    @ManyToOne
    private Officetypes organizationType;
    @JoinColumn(name = "region", referencedColumnName = "id")
    @ManyToOne
    private Regions region;
    @JoinColumn(name = "title", referencedColumnName = "id")
    @ManyToOne
    private Titlerank title;
    @JoinColumn(name = "woreda", referencedColumnName = "id")
    @ManyToOne
    private Weredas woreda;
    @JoinColumn(name = "zone", referencedColumnName = "id")
    @ManyToOne
    private Zones zone;

    public Tewokay() {
    }

    public Tewokay(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirtstname() {
        return firtstname;
    }

    public void setFirtstname(String firtstname) {
        this.firtstname = firtstname;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHousePhoneNumber() {
        return housePhoneNumber;
    }

    public void setHousePhoneNumber(String housePhoneNumber) {
        this.housePhoneNumber = housePhoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKebele() {
        return kebele;
    }

    public void setKebele(String kebele) {
        this.kebele = kebele;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPobox() {
        return pobox;
    }

    public void setPobox(String pobox) {
        this.pobox = pobox;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public byte[] getRole() {
        return role;
    }

    public void setRole(byte[] role) {
        this.role = role;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname;
    }

    public Nationalities getNationality() {
        return nationality;
    }

    public void setNationality(Nationalities nationality) {
        this.nationality = nationality;
    }

    public Officetypes getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(Officetypes organizationType) {
        this.organizationType = organizationType;
    }

    public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public Titlerank getTitle() {
        return title;
    }

    public void setTitle(Titlerank title) {
        this.title = title;
    }

    public Weredas getWoreda() {
        return woreda;
    }

    public void setWoreda(Weredas woreda) {
        this.woreda = woreda;
    }

    public Zones getZone() {
        return zone;
    }

    public void setZone(Zones zone) {
        this.zone = zone;
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
        if (!(object instanceof Tewokay)) {
            return false;
        }
        Tewokay other = (Tewokay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.Tewokay[ id=" + id + " ]";
    }
    
}
