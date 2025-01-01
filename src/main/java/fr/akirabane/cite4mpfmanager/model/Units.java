package fr.akirabane.cite4mpfmanager.model;

import fr.akirabane.cite4mpfmanager.exceptions.CidErrorException;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "units")
public class Units {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pseudo", nullable = false)
    private String pseudo;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "skin", nullable = false)
    private String skin;

    @Column(name = "cid", nullable = false)
    private int cid;

    @Column(name = "grade", nullable = false)
    private String grade;

    @Column(name = "division", nullable = false)
    private String division;

    @Column(name = "matricule", nullable = false)
    private String matricule;

    public Units() {}

    public Units(int id, String pseudo, String uuid, String skin, int cid, String grade, String division, String matricule) {
        this.id = id;
        this.pseudo = pseudo;
        this.uuid = uuid;
        this.skin = skin;
        this.cid = cid;
        this.grade = grade;
        this.division = division;
        this.matricule = matricule;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
            throw new CidErrorException("CID must be 5 characters long");
        }
        this.cid = cid;
    }

    public String getMatricule() {
        return String.format("C4-MPF-%s.%s-%s", grade, division, cid);
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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
