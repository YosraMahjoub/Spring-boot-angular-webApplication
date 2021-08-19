package com.example.sajalniback.Request;

import java.util.Set;

public class RegisterRequest {
    private final String nom;
    private final String email;
        private final String mdp;


    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return mdp;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + mdp + '\'' +

                '}';
    }

    public RegisterRequest(String nom, String email, String mdp) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
    }
}
