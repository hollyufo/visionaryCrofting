package com.visionaryCrofting.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client",uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;
    @Column(
            nullable = false,
            unique = true
    )
    private String email;
    @Column(
            nullable = false
    )
    private String password;
    private String tel;
    @OneToMany(cascade = CascadeType.ALL)
    List<Commande> commandes;

    public Client() {
    }

    public Client(String email, String password, String tel, List<Commande> commandes) {
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.commandes = commandes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
