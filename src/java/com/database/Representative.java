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
@Table(name = "representative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Representative.findAll", query = "SELECT r FROM Representative r"),
    @NamedQuery(name = "Representative.findById", query = "SELECT r FROM Representative r WHERE r.id = :id"),
    @NamedQuery(name = "Representative.findByRepcustomertype", query = "SELECT r FROM Representative r WHERE r.repcustomertype = :repcustomertype"),
    @NamedQuery(name = "Representative.findByRepfirstname", query = "SELECT r FROM Representative r WHERE r.repfirstname = :repfirstname"),
    @NamedQuery(name = "Representative.findByRepmiddlename", query = "SELECT r FROM Representative r WHERE r.repmiddlename = :repmiddlename"),
    @NamedQuery(name = "Representative.findByReplastname", query = "SELECT r FROM Representative r WHERE r.replastname = :replastname"),
    @NamedQuery(name = "Representative.findByRepcountry", query = "SELECT r FROM Representative r WHERE r.repcountry = :repcountry"),
    @NamedQuery(name = "Representative.findByRepsex", query = "SELECT r FROM Representative r WHERE r.repsex = :repsex"),
    @NamedQuery(name = "Representative.findByRephousenumber", query = "SELECT r FROM Representative r WHERE r.rephousenumber = :rephousenumber"),
    @NamedQuery(name = "Representative.findByRepphone", query = "SELECT r FROM Representative r WHERE r.repphone = :repphone"),
    @NamedQuery(name = "Representative.findByReptinnumber", query = "SELECT r FROM Representative r WHERE r.reptinnumber = :reptinnumber")})
public class Representative implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 700)
    @Column(name = "repcustomertype")
    private String repcustomertype;
    @Size(max = 700)
    @Column(name = "repfirstname")
    private String repfirstname;
    @Size(max = 700)
    @Column(name = "repmiddlename")
    private String repmiddlename;
    @Size(max = 700)
    @Column(name = "replastname")
    private String replastname;
    @Size(max = 700)
    @Column(name = "repcountry")
    private String repcountry;
    @Size(max = 100)
    @Column(name = "repsex")
    private String repsex;
    @Size(max = 100)
    @Column(name = "rephousenumber")
    private String rephousenumber;
    @Size(max = 100)
    @Column(name = "repphone")
    private String repphone;
    @Column(name = "reptinnumber")
    private Integer reptinnumber;
    @JoinColumn(name = "repgrantid", referencedColumnName = "id")
    @ManyToOne
    private Grantor repgrantid;

    public Representative() {
    }

    public Representative(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepcustomertype() {
        return repcustomertype;
    }

    public void setRepcustomertype(String repcustomertype) {
        this.repcustomertype = repcustomertype;
    }

    public String getRepfirstname() {
        return repfirstname;
    }

    public void setRepfirstname(String repfirstname) {
        this.repfirstname = repfirstname;
    }

    public String getRepmiddlename() {
        return repmiddlename;
    }

    public void setRepmiddlename(String repmiddlename) {
        this.repmiddlename = repmiddlename;
    }

    public String getReplastname() {
        return replastname;
    }

    public void setReplastname(String replastname) {
        this.replastname = replastname;
    }

    public String getRepcountry() {
        return repcountry;
    }

    public void setRepcountry(String repcountry) {
        this.repcountry = repcountry;
    }

    public String getRepsex() {
        return repsex;
    }

    public void setRepsex(String repsex) {
        this.repsex = repsex;
    }

    public String getRephousenumber() {
        return rephousenumber;
    }

    public void setRephousenumber(String rephousenumber) {
        this.rephousenumber = rephousenumber;
    }

    public String getRepphone() {
        return repphone;
    }

    public void setRepphone(String repphone) {
        this.repphone = repphone;
    }

    public Integer getReptinnumber() {
        return reptinnumber;
    }

    public void setReptinnumber(Integer reptinnumber) {
        this.reptinnumber = reptinnumber;
    }

    public Grantor getRepgrantid() {
        return repgrantid;
    }

    public void setRepgrantid(Grantor repgrantid) {
        this.repgrantid = repgrantid;
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
        if (!(object instanceof Representative)) {
            return false;
        }
        Representative other = (Representative) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.Representative[ id=" + id + " ]";
    }
    
}
