package fr.akirabane.cite4mpfmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "units")
public class Units {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cid", nullable = false, unique = true)
    private int cid;

    @Column(name = "grade", nullable = false)
    private String grade;

    @Column(name = "division", nullable = false)
    private String division;

    public Units() {
        // Constructeur par défaut requis par Hibernate
    }

    public Units(int id, String grade, String division, int cid) {
        this.id = id;
        this.grade = grade;
        this.division = division;
        this.cid = cid;
    }

    public int getId() {
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        if (String.valueOf(cid).length() != 5) {
            throw new IllegalArgumentException("CID must be 5 digits long");
        }

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
