package com.example.sajalniback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "demande")
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demande_seq")
    private long refsw;
    @Column(name = "cin", nullable = false)
    private String cin;
    @Column(name = "passport", nullable = false)
    private String passport;
    @Column(name = "importateur" , nullable = false)
    private String importateur;
    @Column(name = "statut" )
    private String statut;
    @Column(name = "marque", nullable = false)
    private String marque;
    @Column(name = "modele", nullable = false)
    private String modele;
    @Column(name = "num_serie", nullable = false)
    private String numSerie;
    @Column(name = "imei1", nullable = false)
    private String imei1;
    @Column(name = "imei2", nullable = false)
    private String imei2;


    @Column(name = "imei3", nullable = false)
    private String imei3;
    @Column(name = "date_creation")
    private Date dateCreation;
    @Column(name = "date_validation")
    private Date dateValidation;
    @Column(name = "commentaire")
    private String commentaire;
    @Column(name = "ref", nullable = false)
    private String refbf;
    @Column(name = "id_dossier")
    private Long idDossier;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public Demande() {

    }

    public Demande(String cin, String passport, String marque, String modele, String numSerie, String imei1, String imei2, String refbf,String importateur,String imei3) {
        this.cin = cin;
        this.passport = passport;
        this.marque = marque;
        this.modele = modele;
        this.numSerie = numSerie;
        this.imei1 = imei1;
        this.imei2 = imei2;
        this.imei3 = imei3;
        this.refbf=refbf;
        this.importateur=importateur;
    }


    public void setIdDossier(Long idDossier) {
        this.idDossier = idDossier;
    }

    public Long getIdDossier() {
        return idDossier;
    }

    public long getRefsw() {
        return refsw;
    }

    public String getCin() {
        return cin;
    }

    public String getPassport() {
        return passport;
    }

    public String getImportateur() {
        return importateur;
    }

    public String getRefbf() {
        return refbf;
    }

    public void setRefbf(String refbf) {
        this.refbf = refbf;
    }

    public String getStatut() {
        return statut;
    }

    public void setImportateur(String importateur) {
        this.importateur = importateur;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public String getImei1() {
        return imei1;
    }

    public String getImei2() {
        return imei2;
    }

    public String getImei3() {
        return imei3;
    }

    public Date getDateCreation() {
        return dateCreation;
    }


    public Date getDateValidation() {
        return dateValidation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setRefsw(long refsw) {
        this.refsw = refsw;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public void setImei1(String imei1) {
        this.imei1 = imei1;
    }

    public void setImei2(String imei2) {
        this.imei2 = imei2;
    }

    public void setImei3(String imei3) {
        this.imei3 = imei3;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }


    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
