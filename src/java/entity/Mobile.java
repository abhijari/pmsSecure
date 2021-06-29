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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abhishek jariwala
 */
@Entity
@Table(name = "mobile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mobile.findAll", query = "SELECT m FROM Mobile m"),
    @NamedQuery(name = "Mobile.findById", query = "SELECT m FROM Mobile m WHERE m.id = :id"),
    @NamedQuery(name = "Mobile.findByName", query = "SELECT m FROM Mobile m WHERE m.name = :name"),
    @NamedQuery(name = "Mobile.findByYear", query = "SELECT m FROM Mobile m WHERE m.year = :year"),
    @NamedQuery(name = "Mobile.findBySize", query = "SELECT m FROM Mobile m WHERE m.size = :size"),
    @NamedQuery(name = "Mobile.findByMemory", query = "SELECT m FROM Mobile m WHERE m.memory = :memory"),
    @NamedQuery(name = "Mobile.findByCamera", query = "SELECT m FROM Mobile m WHERE m.camera = :camera")})
public class Mobile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    private int year;
    @Basic(optional = false)
    @NotNull
    @Column(name = "size")
    private float size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "memory")
    private float memory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "camera")
    private float camera;
    @JoinColumn(name = "catagoryid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Catagory catagoryid;
    @JoinColumn(name = "comapnyid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company comapnyid;

    public Mobile() {
    }

    public Mobile(Integer id) {
        this.id = id;
    }

    public Mobile(Integer id, String name, int year, float size, float memory, float camera) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.size = size;
        this.memory = memory;
        this.camera = camera;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getMemory() {
        return memory;
    }

    public void setMemory(float memory) {
        this.memory = memory;
    }

    public float getCamera() {
        return camera;
    }

    public void setCamera(float camera) {
        this.camera = camera;
    }

    public Catagory getCatagoryid() {
        return catagoryid;
    }

    public void setCatagoryid(Catagory catagoryid) {
        this.catagoryid = catagoryid;
    }

    public Company getComapnyid() {
        return comapnyid;
    }

    public void setComapnyid(Company comapnyid) {
        this.comapnyid = comapnyid;
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
        if (!(object instanceof Mobile)) {
            return false;
        }
        Mobile other = (Mobile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mobile[ id=" + id + " ]";
    }
    
}
