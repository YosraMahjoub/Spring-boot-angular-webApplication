package com.example.sajalniback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dossier")
public class Dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dossier_seq")
    private Long id;
    @Column(name = "ref", nullable = false)
    private String refbf;
    @Column(name = "cin", nullable = false)
    private String cin;
    @Column(name = "passport", nullable = false)
    private String passport;
    @Column(name = "importateur", nullable = false)
    private String importateur;
    @Column(name = "marque", nullable = false)
    private String marque;
    @Column(name = "modele", nullable = false)
    private String modele;
    @Column(name = "num_avis", nullable = false)
    private String numAvis;
    @Column(name = "date_decision" )
    private Date dateDecision;
    @Column(name = "date_validation")
    private Date dateValidation;
    @Column(name = "statut")
    private String statut;
    @Column(name = "id_demande")
    private Long idDemande;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", nullable = false)
    @JsonIgnore
    private User user;

    public void setIdDemande(Long idDemande) {
        this.idDemande = idDemande;
    }

    public Long getIdDemande() {
        return idDemande;
    }

    public Dossier() {

    }

    public Dossier(Long id, String refbf, String cin, String passport, String importateur, String marque, String modele, String numAvis, Date dateDecision, Date dateValidation, String statut) {
        this.id = id;
        this.refbf = refbf;
        this.cin = cin;
        this.passport = passport;
        this.importateur = importateur;
        this.marque = marque;
        this.modele = modele;
        this.numAvis = numAvis;
        this.dateDecision = dateDecision;
        this.dateValidation = dateValidation;
        this.statut = statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getStatut() {
        return statut;
    }

    public Long getId() {
        return id;
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

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getNumAvis() {
        return numAvis;
    }

    public Date getDateDecision() {
        return dateDecision;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRefbf(String refbf) {
        this.refbf = refbf;
    }

    public String getRefbf() {
        return refbf;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setImportateur(String importateur) {
        this.importateur = importateur;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setNumAvis(String numAvis) {
        this.numAvis = numAvis;
    }

    public void setDateDecision(Date dateDecision) {
        this.dateDecision = dateDecision;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
