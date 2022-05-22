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
@Table(name = "service_deliveryoffice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceDeliveryoffice.findAll", query = "SELECT s FROM ServiceDeliveryoffice s"),
    @NamedQuery(name = "ServiceDeliveryoffice.findById", query = "SELECT s FROM ServiceDeliveryoffice s WHERE s.id = :id"),
    @NamedQuery(name = "ServiceDeliveryoffice.findByNameamharic", query = "SELECT s FROM ServiceDeliveryoffice s WHERE s.nameamharic = :nameamharic"),
    @NamedQuery(name = "ServiceDeliveryoffice.findByNameenglish", query = "SELECT s FROM ServiceDeliveryoffice s WHERE s.nameenglish = :nameenglish"),
    @NamedQuery(name = "ServiceDeliveryoffice.findByPhonenumber", query = "SELECT s FROM ServiceDeliveryoffice s WHERE s.phonenumber = :phonenumber"),
    @NamedQuery(name = "ServiceDeliveryoffice.findByDescriptionamharic", query = "SELECT s FROM ServiceDeliveryoffice s WHERE s.descriptionamharic = :descriptionamharic"),
    @NamedQuery(name = "ServiceDeliveryoffice.findByDescriptionenglish", query = "SELECT s FROM ServiceDeliveryoffice s WHERE s.descriptionenglish = :descriptionenglish")})
public class ServiceDeliveryoffice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 3000)
    @Column(name = "nameamharic")
    private String nameamharic;
    @Size(max = 3000)
    @Column(name = "nameenglish")
    private String nameenglish;
    @Size(max = 3000)
    @Column(name = "phonenumber")
    private String phonenumber;
    @Size(max = 2147483647)
    @Column(name = "descriptionamharic")
    private String descriptionamharic;
    @Size(max = 2147483647)
    @Column(name = "descriptionenglish")
    private String descriptionenglish;
    @OneToMany(mappedBy = "seriviceoffice")
    private Collection<Senedochenatebekoch> senedochenatebekochCollection;

    public ServiceDeliveryoffice() {
    }

    public ServiceDeliveryoffice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameamharic() {
        return nameamharic;
    }

    public void setNameamharic(String nameamharic) {
        this.nameamharic = nameamharic;
    }

    public String getNameenglish() {
        return nameenglish;
    }

    public void setNameenglish(String nameenglish) {
        this.nameenglish = nameenglish;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDescriptionamharic() {
        return descriptionamharic;
    }

    public void setDescriptionamharic(String descriptionamharic) {
        this.descriptionamharic = descriptionamharic;
    }

    public String getDescriptionenglish() {
        return descriptionenglish;
    }

    public void setDescriptionenglish(String descriptionenglish) {
        this.descriptionenglish = descriptionenglish;
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
        if (!(object instanceof ServiceDeliveryoffice)) {
            return false;
        }
        ServiceDeliveryoffice other = (ServiceDeliveryoffice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nameenglish;
    }
    
}
