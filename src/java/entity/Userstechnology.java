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
@Table(name = "userstechnology")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userstechnology.findAll", query = "SELECT u FROM Userstechnology u"),
    @NamedQuery(name = "Userstechnology.findById", query = "SELECT u FROM Userstechnology u WHERE u.id = :id"),
    @NamedQuery(name = "Userstechnology.findByUserId", query = "SELECT u FROM Userstechnology u WHERE u.userId.id = :id"),
    @NamedQuery(name = "Userstechnology.deleteAllByUser", query = "DELETE FROM Userstechnology u WHERE u.userId.id = :id")})


public class Userstechnology implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @JoinColumn(name = "technologyId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Technology technologyId;
    @JoinColumn(name = "userId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User userId;

    public Userstechnology() {
    }

    public Userstechnology(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Technology getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Technology technologyId) {
        this.technologyId = technologyId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Userstechnology)) {
            return false;
        }
        Userstechnology other = (Userstechnology) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Userstechnology[ id=" + id + " ]";
    }
    
}
