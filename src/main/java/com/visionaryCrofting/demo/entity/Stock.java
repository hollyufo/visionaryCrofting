package com.visionaryCrofting.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Stock",uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stock_id")
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "tel")
    private String tel;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "stock")
    @JsonBackReference
    private List<Product> product;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "stock")
    @JsonBackReference
    private List<AppelOffre> appelOffres;


    public Stock() {
    }

    public Stock(Long id, String nom, String adresse, String tel, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }

    public Stock(String nom, String adresse, String tel, String email, String password) {
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public List<AppelOffre> getAppelOffres() {
        return appelOffres;
    }

    public void setAppelOffres(List<AppelOffre> appelOffres) {
        this.appelOffres = appelOffres;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "stock{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
