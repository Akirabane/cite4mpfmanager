package fr.akirabane.cite4mpfmanager.model;

import fr.akirabane.cite4mpfmanager.Implementations.CIDHibernateImpl;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "units")
public class Units {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grade", nullable = false)
    private String grade;

    @Column(name = "division", nullable = false)
    private String division;

    @Embedded
    @Column(name = "cid", nullable = false, unique = true)
    private CIDHibernateImpl cid;

    public Units() {
        // Constructeur par défaut requis par Hibernate
    }

    public Units(Long id, String grade, String division, CIDHibernateImpl cid) {
        this.id = id;
        this.grade = grade;
        this.division = division;
        this.cid = cid;
    }

    public Long getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public CIDHibernateImpl getCid() {
        return cid;
    }

    public void setCid(CIDHibernateImpl cid) {
        this.cid = cid;
    }

    public String getMatricule() {
        return String.format("C4-%s.%s-%s", grade, division, cid);
    }

    @Override
    public String toString() {
        return "Units{" +
                "id=" + id +
                ", grade='" + grade + '\'' +
                ", division='" + division + '\'' +
                ", matricule='" + getMatricule() + '\'' +
                '}';
    }
}
