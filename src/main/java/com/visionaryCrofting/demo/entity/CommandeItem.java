package com.visionaryCrofting.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CommandeItem",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ref")
})
public class CommandeItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ref" , nullable = false,unique = true)
    private String ref;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price;
    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "commande_id")
    //@JsonManagedReference
    private Commande commande;
    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "product_id")
    //@JsonBackReference
    private Product product;

    public CommandeItem() {
    }

    public CommandeItem(Long id, String ref, int quantity, double price) {
        this.id = id;
        this.ref = ref;
        this.quantity = quantity;
        this.price = price;
    }

    public CommandeItem(String ref, int quantity, double price) {
        this.ref = ref;
        this.quantity = quantity;
        this.price = price;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "commandItem{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
