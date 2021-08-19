package com.example.sajalniback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "historique")
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historique_seq")
    private long id;
    @Column(name = "historique", nullable = false)
    private String historique;
    @Column(name = "intervenant", nullable = false)
    private String intervenant;
    @Column(name = "date" , nullable = false)
    private String date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dossier_id", nullable = false)
    @JsonIgnore
    private Dossier dossier;

    public void setId(long id) {
        this.id = id;
    }

    public void setHistorique(String historique) {
        this.historique = historique;
    }

    public void setIntervenant(String intervenant) {
        this.intervenant = intervenant;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public long getId() {
        return id;
    }

    public String getHistorique() {
        return historique;
    }

    public String getIntervenant() {
        return intervenant;
    }

    public String getDate() {
        return date;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public Historique() {
    }

    public Historique(long id, String historique, String intervenant, String date, Dossier dossier) {
        this.id = id;
        this.historique = historique;
        this.intervenant = intervenant;
        this.date = date;
        this.dossier = dossier;
    }
}
