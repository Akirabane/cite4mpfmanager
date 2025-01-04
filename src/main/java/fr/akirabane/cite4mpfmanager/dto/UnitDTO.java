package fr.akirabane.cite4mpfmanager.dto;

import java.util.Date;

public class UnitDTO {

    private int id;
    private String pseudo;
    private String uuid;
    private String skin;
    private int cid;
    private String grade;
    private String division;
    private String matricule;
    private String statut;
    private String commentaire;
    private boolean isBaseUnion;
    private boolean isBaseDivision;
    private Date up;
    private Date recrutement;
    private boolean activite;
    private boolean uniteFormatrice;
    private boolean referentDivision;
    private int blames;
    private String secondJob;

    public UnitDTO() {}

    public UnitDTO(int id, String pseudo, String uuid, String skin, int cid, String grade, String division, String matricule, String statut, String commentaire, boolean isBaseUnion, boolean isBaseDivision, Date up, Date recrutement, boolean activite, boolean uniteFormatrice, boolean referentDivision, int blames, String secondJob) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public int getCid() {
        return cid;
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public String toString() {
        return "UnitDTO{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", uuid='" + uuid + '\'' +
                ", skin='" + skin + '\'' +
                ", cid=" + cid +
                ", grade='" + grade + '\'' +
                ", division='" + division + '\'' +
                ", matricule='" + matricule + '\'' +
                '}';
    }
}
