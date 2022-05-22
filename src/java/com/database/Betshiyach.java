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
@Table(name = "betshiyach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Betshiyach.findAll", query = "SELECT b FROM Betshiyach b"),
    @NamedQuery(name = "Betshiyach.findById", query = "SELECT b FROM Betshiyach b WHERE b.id = :id"),
    @NamedQuery(name = "Betshiyach.findByCartakutr", query = "SELECT b FROM Betshiyach b WHERE b.cartakutr = :cartakutr"),
    @NamedQuery(name = "Betshiyach.findByShachname", query = "SELECT b FROM Betshiyach b WHERE b.shachname = :shachname"),
    @NamedQuery(name = "Betshiyach.findByShachfname", query = "SELECT b FROM Betshiyach b WHERE b.shachfname = :shachfname"),
    @NamedQuery(name = "Betshiyach.findByShachlastname", query = "SELECT b FROM Betshiyach b WHERE b.shachlastname = :shachlastname"),
    @NamedQuery(name = "Betshiyach.findByGezhname", query = "SELECT b FROM Betshiyach b WHERE b.gezhname = :gezhname"),
    @NamedQuery(name = "Betshiyach.findByGezhfname", query = "SELECT b FROM Betshiyach b WHERE b.gezhfname = :gezhfname"),
    @NamedQuery(name = "Betshiyach.findByGezhlastname", query = "SELECT b FROM Betshiyach b WHERE b.gezhlastname = :gezhlastname"),
    @NamedQuery(name = "Betshiyach.findByYebrmetenm", query = "SELECT b FROM Betshiyach b WHERE b.yebrmetenm = :yebrmetenm"),
    @NamedQuery(name = "Betshiyach.findByYebotawadrasha", query = "SELECT b FROM Betshiyach b WHERE b.yebotawadrasha = :yebotawadrasha"),
    @NamedQuery(name = "Betshiyach.findByBotasifat", query = "SELECT b FROM Betshiyach b WHERE b.botasifat = :botasifat")})
public class Betshiyach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "cartakutr")
    private String cartakutr;
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
    @Size(max = 200)
    @Column(name = "yebrmetenm")
    private String yebrmetenm;
    @Size(max = 200)
    @Column(name = "yebotawadrasha")
    private String yebotawadrasha;
    @Size(max = 200)
    @Column(name = "botasifat")
    private String botasifat;

    public Betshiyach() {
    }

    public Betshiyach(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCartakutr() {
        return cartakutr;
    }

    public void setCartakutr(String cartakutr) {
        this.cartakutr = cartakutr;
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

    public String getYebrmetenm() {
        return yebrmetenm;
    }

    public void setYebrmetenm(String yebrmetenm) {
        this.yebrmetenm = yebrmetenm;
    }

    public String getYebotawadrasha() {
        return yebotawadrasha;
    }

    public void setYebotawadrasha(String yebotawadrasha) {
        this.yebotawadrasha = yebotawadrasha;
    }

    public String getBotasifat() {
        return botasifat;
    }

    public void setBotasifat(String botasifat) {
        this.botasifat = botasifat;
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
        if (!(object instanceof Betshiyach)) {
            return false;
        }
        Betshiyach other = (Betshiyach) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.databse.Betshiyach[ id=" + id + " ]";
    }
    
}
