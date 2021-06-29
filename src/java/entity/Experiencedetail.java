/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abhishek jariwala
 */
@Entity
@Table(name = "experiencedetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencedetail.findAll", query = "SELECT e FROM Experiencedetail e"),
    @NamedQuery(name = "Experiencedetail.findById", query = "SELECT e FROM Experiencedetail e WHERE e.id = :id"),
    @NamedQuery(name = "Experiencedetail.findByIsCurrentJob", query = "SELECT e FROM Experiencedetail e WHERE e.isCurrentJob = :isCurrentJob"),
    @NamedQuery(name = "Experiencedetail.findByJoinedDate", query = "SELECT e FROM Experiencedetail e WHERE e.joinedDate = :joinedDate"),
    @NamedQuery(name = "Experiencedetail.findByLeavingDate", query = "SELECT e FROM Experiencedetail e WHERE e.leavingDate = :leavingDate"),
    @NamedQuery(name = "Experiencedetail.findByJobTitle", query = "SELECT e FROM Experiencedetail e WHERE e.jobTitle = :jobTitle"),
    @NamedQuery(name = "Experiencedetail.findByCompanyName", query = "SELECT e FROM Experiencedetail e WHERE e.companyName = :companyName"),
    @NamedQuery(name = "Experiencedetail.findByDescription", query = "SELECT e FROM Experiencedetail e WHERE e.description = :description"),
    @NamedQuery(name = "Experiencedetail.findByStudentId", query = "SELECT e FROM Experiencedetail e WHERE e.studentId.id = :userId")})

public class Experiencedetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isCurrentJob")
    private boolean isCurrentJob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "joinedDate")
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "leavingDate")
    @Temporal(TemporalType.DATE)
    private Date leavingDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "jobTitle")
    private String jobTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "companyName")
    private String companyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "studentId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User studentId;

    public Experiencedetail() {
    }

    public Experiencedetail(Integer id) {
        this.id = id;
    }

    public Experiencedetail(Integer id, boolean isCurrentJob, Date joinedDate, Date leavingDate, String jobTitle, String companyName, String description) {
        this.id = id;
        this.isCurrentJob = isCurrentJob;
        this.joinedDate = joinedDate;
        this.leavingDate = leavingDate;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsCurrentJob() {
        return isCurrentJob;
    }

    public void setIsCurrentJob(boolean isCurrentJob) {
        this.isCurrentJob = isCurrentJob;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getStudentId() {
        return studentId;
    }

    public void setStudentId(User studentId) {
        this.studentId = studentId;
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
        if (!(object instanceof Experiencedetail)) {
            return false;
        }
        Experiencedetail other = (Experiencedetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Experiencedetail[ id=" + id + " ]";
    }
    
}
