package com.visionaryCrofting.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Fournisseur",uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Fournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fournisseur_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "tel")
    private String tel;
    @Column(name = "password")
    private String  password;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "fournisseur")
    @JsonBackReference
    List<AppelOffre> appelOffre;


    public Fournisseur() {
    }

    public Fournisseur(Long id, String name, String email, String tel, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.password = password;
    }

    public Fournisseur(String name, String email, String tel, String password) {
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AppelOffre> getAppelOffre() {
        return appelOffre;
    }

    public void setAppelOffre(List<AppelOffre> appelOffre) {
        this.appelOffre = appelOffre;
    }
    @Override
    public String toString() {
        return "fournisseur{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
