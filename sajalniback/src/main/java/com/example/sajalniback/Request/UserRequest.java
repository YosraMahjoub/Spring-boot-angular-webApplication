package com.example.sajalniback.Request;

import com.example.sajalniback.model.ERole;

public class UserRequest {
    private final String nom;
    private final String email;
    private final String mdp;
    private final ERole roles;

    public UserRequest(String nom, String email, String mdp, ERole roles) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.roles = roles;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return mdp;
    }

    public ERole getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
