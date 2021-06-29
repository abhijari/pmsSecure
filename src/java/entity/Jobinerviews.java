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
@Table(name = "jobinerviews")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jobinerviews.findAll", query = "SELECT j FROM Jobinerviews j"),
    @NamedQuery(name = "Jobinerviews.findById", query = "SELECT j FROM Jobinerviews j WHERE j.id = :id"),
    @NamedQuery(name = "Jobinerviews.findByLocation", query = "SELECT j FROM Jobinerviews j WHERE j.location = :location"),
    @NamedQuery(name = "Jobinerviews.findByDate", query = "SELECT j FROM Jobinerviews j WHERE j.date = :date"),
    @NamedQuery(name = "Jobinerviews.findByDescription", query = "SELECT j FROM Jobinerviews j WHERE j.description = :description"),
    @NamedQuery(name = "Jobinerviews.findByStudent", query = "SELECT j FROM Jobinerviews j WHERE j.studentId.id = :id"),
    @NamedQuery(name = "Jobinerviews.findByStatus", query = "SELECT j FROM Jobinerviews j WHERE j.status = :status")})
public class Jobinerviews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "companyId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User companyId;
    @JoinColumn(name = "studentId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User studentId;
    @JoinColumn(name = "interviewId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Interview interviewId;

    public Jobinerviews() {
    }

    public Jobinerviews(Integer id) {
        this.id = id;
    }

    public Jobinerviews(Integer id, String location, Date date, String description, int status) {
        this.id = id;
        this.location = location;
        this.date = date;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getCompanyId() {
        return companyId;
    }

    public void setCompanyId(User companyId) {
        this.companyId = companyId;
    }

    public User getStudentId() {
        return studentId;
    }

    public void setStudentId(User studentId) {
        this.studentId = studentId;
    }

    public Interview getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Interview interviewId) {
        this.interviewId = interviewId;
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
        if (!(object instanceof Jobinerviews)) {
            return false;
        }
        Jobinerviews other = (Jobinerviews) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Jobinerviews[ id=" + id + " ]";
    }
    
}
