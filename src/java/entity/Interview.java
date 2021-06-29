/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abhishek jariwala
 */
@Entity
@Table(name = "interview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interview.findAll", query = "SELECT i FROM Interview i"),
    @NamedQuery(name = "Interview.findById", query = "SELECT i FROM Interview i WHERE i.id = :id"),
    @NamedQuery(name = "Interview.findByDate", query = "SELECT i FROM Interview i WHERE i.date = :date"),
    @NamedQuery(name = "Interview.findByDescription", query = "SELECT i FROM Interview i WHERE i.description = :description"),
    @NamedQuery(name = "Interview.findByComapny", query = "SELECT i FROM Interview i WHERE i.companyId.id = :id"),
    @NamedQuery(name = "Interview.findByLocation", query = "SELECT i FROM Interview i WHERE i.location = :location")})

public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 5000)
    @Column(name = "description")
    private String description;
    @Size(max = 5000)
    @Column(name = "location")
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interviewId")
    private List<Jobinerviews> jobinerviewsList;
    @JoinColumn(name = "companyId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User companyId;

    public Interview() {
    }

    public Interview(Integer id) {
        this.id = id;
    }

    public Interview(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public List<Jobinerviews> getJobinerviewsList() {
        return jobinerviewsList;
    }

    public void setJobinerviewsList(List<Jobinerviews> jobinerviewsList) {
        this.jobinerviewsList = jobinerviewsList;
    }

    public User getCompanyId() {
        return companyId;
    }

    public void setCompanyId(User companyId) {
        this.companyId = companyId;
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
        if (!(object instanceof Interview)) {
            return false;
        }
        Interview other = (Interview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Interview[ id=" + id + " ]";
    }
    
}
