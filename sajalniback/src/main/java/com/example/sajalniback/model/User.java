package com.example.sajalniback.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "user",
uniqueConstraints = {
@UniqueConstraint(columnNames = "email")
	})
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "mdp", nullable = false)
    private String mdp;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "date")
    private Date date;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    public User() {
    }

    public User(String nom, String mdp, String email) {
        this.nom = nom;
        this.mdp = mdp;
        this.email = email;
    }

    public User(Long id, String nom, String mdp, String email, Date date, Set<Role> roles) {
        this.id = id;
        this.nom = nom;
        this.mdp = mdp;
        this.email = email;
        this.date = date;
        this.roles = roles;
    }

    public Date getDate() {
        return date;
    }



    public void setDate(Date date) {
        this.date = date;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", mdp='" + mdp + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }




    public String getMdp() {
        return mdp;
    }

    public String getEmail() {
        return email;
    }

}
