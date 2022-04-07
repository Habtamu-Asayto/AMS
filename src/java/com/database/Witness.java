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
@Table(name = "witness")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Witness.findAll", query = "SELECT w FROM Witness w"),
    @NamedQuery(name = "Witness.findById", query = "SELECT w FROM Witness w WHERE w.id = :id"),
    @NamedQuery(name = "Witness.findByFullname", query = "SELECT w FROM Witness w WHERE w.fullname = :fullname"),
    @NamedQuery(name = "Witness.findByPhone", query = "SELECT w FROM Witness w WHERE w.phone = :phone"),
    @NamedQuery(name = "Witness.findByEmail", query = "SELECT w FROM Witness w WHERE w.email = :email"),
    @NamedQuery(name = "Witness.findByAddress", query = "SELECT w FROM Witness w WHERE w.address = :address"),
    @NamedQuery(name = "Witness.findByAnswer", query = "SELECT w FROM Witness w WHERE w.answer = :answer")})
public class Witness implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1000)
    @Column(name = "fullname")
    private String fullname;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 1000)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 1000)
    @Column(name = "email")
    private String email;
    @Size(max = 1000)
    @Column(name = "address")
    private String address;
    @Size(max = 2147483647)
    @Column(name = "answer")
    private String answer;
    @JoinColumn(name = "onecase", referencedColumnName = "id")
    @ManyToOne
    private Cases onecase;

    public Witness() {
    }

    public Witness(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Cases getOnecase() {
        return onecase;
    }

    public void setOnecase(Cases onecase) {
        this.onecase = onecase;
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
        if (!(object instanceof Witness)) {
            return false;
        }
        Witness other = (Witness) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.Witness[ id=" + id + " ]";
    }
    
}
