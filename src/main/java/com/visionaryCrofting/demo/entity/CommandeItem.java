package com.visionaryCrofting.demo.entity;

import javax.persistence.*;

@Entity
public class CommandeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "ref")
    private String ref;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price;
    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "commande_id")
    private Commande commande;
    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    public CommandeItem() {
    }

    public CommandeItem(int id, String ref, int quantity, double price) {
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
