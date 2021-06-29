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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abhishek jariwala
 */
@Entity
@Table(name = "requestinterviewdates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requestinterviewdates.findAll", query = "SELECT r FROM Requestinterviewdates r"),
    @NamedQuery(name = "Requestinterviewdates.findById", query = "SELECT r FROM Requestinterviewdates r WHERE r.id = :id"),
    @NamedQuery(name = "Requestinterviewdates.findByDatetime", query = "SELECT r FROM Requestinterviewdates r WHERE r.datetime = :datetime"),
    @NamedQuery(name = "Requestinterviewdates.findByIsAccept", query = "SELECT r FROM Requestinterviewdates r WHERE r.isAccept = :isAccept")})
public class Requestinterviewdates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isAccept")
    private boolean isAccept;
    @JoinColumn(name = "companyId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User companyId;

    public Requestinterviewdates() {
    }

    public Requestinterviewdates(Integer id) {
        this.id = id;
    }

    public Requestinterviewdates(Integer id, Date datetime, boolean isAccept) {
        this.id = id;
        this.datetime = datetime;
        this.isAccept = isAccept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public boolean getIsAccept() {
        return isAccept;
    }

    public void setIsAccept(boolean isAccept) {
        this.isAccept = isAccept;
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
        if (!(object instanceof Requestinterviewdates)) {
            return false;
        }
        Requestinterviewdates other = (Requestinterviewdates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Requestinterviewdates[ id=" + id + " ]";
    }
    
}
