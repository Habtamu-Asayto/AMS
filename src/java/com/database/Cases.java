/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author habtamu
 */
@Entity
@Table(name = "cases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cases.findAll", query = "SELECT c FROM Cases c"),
    @NamedQuery(name = "Cases.findById", query = "SELECT c FROM Cases c WHERE c.id = :id"),
    @NamedQuery(name = "Cases.findByCustomerName", query = "SELECT c FROM Cases c WHERE c.customerName = :customerName"),
    @NamedQuery(name = "Cases.findByPhone", query = "SELECT c FROM Cases c WHERE c.phone = :phone"),
    @NamedQuery(name = "Cases.findByEmail", query = "SELECT c FROM Cases c WHERE c.email = :email"),
    @NamedQuery(name = "Cases.findByStatus", query = "SELECT c FROM Cases c WHERE c.status = :status"),
    @NamedQuery(name = "Cases.findByCaseType", query = "SELECT c FROM Cases c WHERE c.caseType = :caseType"),
    @NamedQuery(name = "Cases.findByCaseLevel", query = "SELECT c FROM Cases c WHERE c.caseLevel = :caseLevel"),
    @NamedQuery(name = "Cases.findByCaseDetail", query = "SELECT c FROM Cases c WHERE c.caseDetail = :caseDetail"),
    @NamedQuery(name = "Cases.findByJudgeName", query = "SELECT c FROM Cases c WHERE c.judgeName = :judgeName"),
    @NamedQuery(name = "Cases.findByCourtType", query = "SELECT c FROM Cases c WHERE c.courtType = :courtType"),
    @NamedQuery(name = "Cases.findByCourtPlace", query = "SELECT c FROM Cases c WHERE c.courtPlace = :courtPlace"),
    @NamedQuery(name = "Cases.findByCourtProcessDetail", query = "SELECT c FROM Cases c WHERE c.courtProcessDetail = :courtProcessDetail"),
    @NamedQuery(name = "Cases.findBySex", query = "SELECT c FROM Cases c WHERE c.sex = :sex"),
    @NamedQuery(name = "Cases.findByBeginDate", query = "SELECT c FROM Cases c WHERE c.beginDate = :beginDate"),
    @NamedQuery(name = "Cases.findByCaseStatus", query = "SELECT c FROM Cases c WHERE c.caseStatus = :caseStatus")})
public class Cases implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1000)
    @Column(name = "customer_name")
    private String customerName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 1000)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 1000)
    @Column(name = "email")
    private String email;
    @Size(max = 1000)
    @Column(name = "status")
    private String status;
    @Size(max = 1000)
    @Column(name = "case_type")
    private String caseType;
    @Size(max = 1000)
    @Column(name = "case_level")
    private String caseLevel;
    @Size(max = 2147483647)
    @Column(name = "case_detail")
    private String caseDetail;
    @Size(max = 1000)
    @Column(name = "judge_name")
    private String judgeName;
    @Size(max = 1000)
    @Column(name = "court_type")
    private String courtType;
    @Size(max = 1000)
    @Column(name = "court_place")
    private String courtPlace;
    @Size(max = 2147483647)
    @Column(name = "court_process_detail")
    private String courtProcessDetail;
    @Size(max = 100)
    @Column(name = "sex")
    private String sex;
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Column(name = "case_status")
    private Integer caseStatus;
    @OneToMany(mappedBy = "onecase")
    private Collection<Witness> witnessCollection;

    public Cases() {
    }

    public Cases(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseLevel() {
        return caseLevel;
    }

    public void setCaseLevel(String caseLevel) {
        this.caseLevel = caseLevel;
    }

    public String getCaseDetail() {
        return caseDetail;
    }

    public void setCaseDetail(String caseDetail) {
        this.caseDetail = caseDetail;
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }

    public String getCourtType() {
        return courtType;
    }

    public void setCourtType(String courtType) {
        this.courtType = courtType;
    }

    public String getCourtPlace() {
        return courtPlace;
    }

    public void setCourtPlace(String courtPlace) {
        this.courtPlace = courtPlace;
    }

    public String getCourtProcessDetail() {
        return courtProcessDetail;
    }

    public void setCourtProcessDetail(String courtProcessDetail) {
        this.courtProcessDetail = courtProcessDetail;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(Integer caseStatus) {
        this.caseStatus = caseStatus;
    }

    @XmlTransient
    public Collection<Witness> getWitnessCollection() {
        return witnessCollection;
    }

    public void setWitnessCollection(Collection<Witness> witnessCollection) {
        this.witnessCollection = witnessCollection;
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
        if (!(object instanceof Cases)) {
            return false;
        }
        Cases other = (Cases) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.database.Cases[ id=" + id + " ]";
    }
    
}
