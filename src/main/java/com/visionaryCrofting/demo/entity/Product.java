package com.visionaryCrofting.demo.entity;

import javax.persistence.*;
import java.util.List;

public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   @Column(name = "ref")
    private String ref;
   @Column(name = "nom")
    private String nom;
   @Column(name = "category")
    private String category;
   @Column(name = "descreption")
    private String descreption;
   @Column(name = "quantity")
    private int quantity;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CommandeItem> commandeItems;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id")
    private Stock stock;

    public Product(int id, String ref, String nom, String category, String descreption, int quantity) {
        this.id = id;
        this.ref = ref;
        this.nom = nom;
        this.category = category;
        this.descreption = descreption;
        this.quantity = quantity;
    }

    public Product() {
    }

    public Product(String ref, String nom, String category, String descreption, int quantity) {
        this.ref = ref;
        this.nom = nom;
        this.category = category;
        this.descreption = descreption;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", nom='" + nom + '\'' +
                ", category='" + category + '\'' +
                ", descreption='" + descreption + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
