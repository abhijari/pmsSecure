/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abhishek jariwala
 */
@Entity
@Table(name = "usersgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usersgroup.findAll", query = "SELECT u FROM Usersgroup u"),
    @NamedQuery(name = "Usersgroup.findById", query = "SELECT u FROM Usersgroup u WHERE u.id = :id"),
    @NamedQuery(name = "Usersgroup.findByGroupId", query = "SELECT u FROM Usersgroup u WHERE u.groupId.id = :groupId"),
    @NamedQuery(name = "Usersgroup.findVerifiedCompany", query = "SELECT u FROM Usersgroup u WHERE u.groupId.id = :groupId and u.userId.isVerified=1"),
    @NamedQuery(name = "Usersgroup.findRequestCompany", query = "SELECT u FROM Usersgroup u WHERE u.groupId.id = :groupId and u.userId.isVerified=0")})
public class Usersgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @JoinColumn(name = "userId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "groupId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Groups groupId;

    public Usersgroup() {
    }

    public Usersgroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
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
        if (!(object instanceof Usersgroup)) {
            return false;
        }
        Usersgroup other = (Usersgroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usersgroup[ id=" + id + " ]";
    }
    
}
