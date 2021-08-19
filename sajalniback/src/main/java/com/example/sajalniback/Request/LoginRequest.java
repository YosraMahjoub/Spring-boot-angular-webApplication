package com.example.sajalniback.Request;

public class LoginRequest {
    private final String email;
    private final String mdp;

    public LoginRequest( String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return mdp;
    }
    @Override
    public String toString() {
        return "LoginRequest{" +
                ", email='" + email + '\'' +
                ", password='" + mdp + '\'' +

                '}';
    }


}
