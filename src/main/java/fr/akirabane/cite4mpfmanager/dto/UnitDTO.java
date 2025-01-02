package fr.akirabane.cite4mpfmanager.dto;

public class UnitDTO {

    private int id;
    private String pseudo;
    private String uuid;
    private String skin;
    private int cid;
    private String grade;
    private String division;
    private String matricule;

    public UnitDTO() {}

    public UnitDTO(int id, String pseudo, String uuid, String skin, int cid, String grade, String division, String matricule) {
        this.id = id;
        this.pseudo = pseudo;
        this.uuid = uuid;
        this.skin = skin;
        this.cid = cid;
        this.grade = grade;
        this.division = division;
        this.matricule = matricule;
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

    public void setCid(int cid) {
        this.cid = cid;
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
