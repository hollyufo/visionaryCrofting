package com.visionaryCrofting.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Product",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ref")
})
public class Product implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "product_id")
    private Long id;
   @Column(name = "ref",nullable = false,unique = true)
    private String ref;
   @Column(name = "nom")
    private String nom;
   @Column(name = "category")
    private String category;
   @Column(name = "descreption")
    private String descreption;
   @Column(name = "quantity")
    private int quantity;
    @OneToOne(cascade = CascadeType.ALL)
    private CommandeItem commandeItem;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id")
    private Stock stock;

    public Product() {
    }

    public Product(String ref, String nom, String category, String descreption, int quantity) {
        this.ref = ref;
        this.nom = nom;
        this.category = category;
        this.descreption = descreption;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
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

    public CommandeItem getCommandeItem() {
        return commandeItem;
    }

    public void setCommandeItems(CommandeItem commandeItem) {
        this.commandeItem = commandeItem;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
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
