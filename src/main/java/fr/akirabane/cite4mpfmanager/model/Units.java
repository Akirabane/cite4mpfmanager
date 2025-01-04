package fr.akirabane.cite4mpfmanager.model;

import fr.akirabane.cite4mpfmanager.exceptions.CidErrorException;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Set;
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

    @Column(name="Statut")
    private String statut;

    @Column(name="Commentaire")
    private String commentaire;

    @Column(name="BaseUnion", nullable = false)
    private boolean isBaseUnion;

    @Column(name="BaseDivision", nullable = false)
    private boolean isBaseDivision;

    @Column(name="Up", nullable = false)
    private Date up;

    @Column(name="Recrutement", nullable = false)
    private Date recrutement;

    @Column(name="Activite", nullable = false)
    private boolean activite;

    @Column(name="UniteFormatrice", nullable = false)
    private boolean uniteFormatrice;

    @Column(name="ReferentDivision", nullable = false)
    private boolean referentDivision;

    @Column(name="Blames")
    private int blames;

    @Column(name="SecondJob")
    private String secondJob;

    public Units() {}

    public Units(int id, String pseudo, String uuid, String skin, int cid, String grade, String division, String matricule, String statut, String commentaire, boolean isBaseUnion, boolean isBaseDivision, Date up, Date recrutement, boolean activite, boolean uniteFormatrice, boolean referentDivision, int blames, String secondJob) {
        this.id = id;
        this.pseudo = pseudo;
        this.uuid = uuid;
        this.skin = skin;
        this.cid = cid;
        this.grade = grade;
        this.division = division;
        this.matricule = matricule;
        this.statut = statut;
        this.commentaire = commentaire;
        this.isBaseUnion = isBaseUnion;
        this.isBaseDivision = isBaseDivision;
        this.up = up;
        this.recrutement = recrutement;
        this.activite = activite;
        this.uniteFormatrice = uniteFormatrice;
        this.referentDivision = referentDivision;
        this.blames = blames;
        this.secondJob = secondJob;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public boolean isBaseUnion() {
        return isBaseUnion;
    }

    public void setIsBaseUnion(boolean isBaseUnion) {
        this.isBaseUnion = isBaseUnion;
    }

    public boolean isBaseDivision() {
        return isBaseDivision;
    }

    public void setIsBaseDivision(boolean isBaseDivision) {
        this.isBaseDivision = isBaseDivision;
    }

    public Date getUp() {
        return up;
    }

    public void setUp(Date up) {
        this.up = up;
    }

    public Date getRecrutement() {
        return recrutement;
    }

    public void setRecrutement(Date recrutement) {
        this.recrutement = recrutement;
    }

    public boolean isActivite() {
        return activite;
    }

    public void setActivite(boolean activite) {
        this.activite = activite;
    }

    public boolean isUniteFormatrice() {
        return uniteFormatrice;
    }

    public void setUniteFormatrice(boolean uniteFormatrice) {
        this.uniteFormatrice = uniteFormatrice;
    }

    public boolean isReferentDivision() {
        return referentDivision;
    }

    public void setReferentDivision(boolean referentDivision) {
        this.referentDivision = referentDivision;
    }

    public int getBlames() {
        return blames;
    }

    public void setBlames(int blames) {
        this.blames = blames;
    }

    public String getSecondJob() {
        return secondJob;
    }

    public void setSecondJob(String secondJob) {
        this.secondJob = secondJob;
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
        if(Set.of("EvO", "EpU", "CmD").contains(grade)) {
            return String.format("C4-MPF-%s-%s", grade, cid);
        };
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
