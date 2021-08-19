package com.example.sajalniback.Response;

import java.util.Date;
import java.util.List;

public class JwtResponse {
    private String token;
    private Long id ;
    private String type = "Bearer";
    private String nom;
    private String email;
    private List<String> roles;
    private String mdp;
    private Date date;

    public JwtResponse(String token, Long id,  String nom, String email, List<String>roles, String mdp, Date date) {
        this.token = token;
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.roles = roles;
        this.mdp=mdp;
        this.date=date;
    }

    public Date getDate() {
        return date;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }



    public String getNom() {
        return nom;
    }

    public Long getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getMdp() {
        return mdp;
    }
}
