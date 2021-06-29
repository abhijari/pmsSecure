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
@Table(name = "educationdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educationdetail.findAll", query = "SELECT e FROM Educationdetail e"),
    @NamedQuery(name = "Educationdetail.findById", query = "SELECT e FROM Educationdetail e WHERE e.id = :id"),
    @NamedQuery(name = "Educationdetail.findByDegreeName", query = "SELECT e FROM Educationdetail e WHERE e.degreeName = :degreeName"),
    @NamedQuery(name = "Educationdetail.findByUniversityName", query = "SELECT e FROM Educationdetail e WHERE e.universityName = :universityName"),
    @NamedQuery(name = "Educationdetail.findByYear", query = "SELECT e FROM Educationdetail e WHERE e.year = :year"),
    @NamedQuery(name = "Educationdetail.findByPercentage", query = "SELECT e FROM Educationdetail e WHERE e.percentage = :percentage"),
    @NamedQuery(name = "Educationdetail.findByCgpa", query = "SELECT e FROM Educationdetail e WHERE e.cgpa = :cgpa"),
    @NamedQuery(name = "Educationdetail.findByStudentId", query = "SELECT e FROM Educationdetail e WHERE e.studentId.id = :userId")})

public class Educationdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "degreeName")
    private String degreeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "universityName")
    private String universityName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    private int year;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percentage")
    private double percentage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cgpa")
    private double cgpa;
    @JoinColumn(name = "studentId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User studentId;

    public Educationdetail() {
    }

    public Educationdetail(Integer id) {
        this.id = id;
    }

    public Educationdetail(Integer id, String degreeName, String universityName, int year, double percentage, double cgpa) {
        this.id = id;
        this.degreeName = degreeName;
        this.universityName = universityName;
        this.year = year;
        this.percentage = percentage;
        this.cgpa = cgpa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
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
        if (!(object instanceof Educationdetail)) {
            return false;
        }
        Educationdetail other = (Educationdetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Educationdetail[ id=" + id + " ]";
    }
    
}
