package com.visionaryCrofting.demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class appelOffre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "ref")
    private String ref;
    @Column(name = "refProduit")
    private String refProduit;
    @Column(name = "status")
    private boolean status;
    @Column(name = "quantity")
    private int quantity;

    public appelOffre() {
    }

    public appelOffre(int id, String ref, String refProduit, boolean status, int quantity) {
        this.id = id;
        this.ref = ref;
        this.refProduit = refProduit;
        this.status = status;
        this.quantity = quantity;
    }

    public appelOffre(String ref, String refProduit, boolean status, int quantity) {
        this.ref = ref;
        this.refProduit = refProduit;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuantité() {
        return quantity;
    }

    public void setQuantité(int quantité) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "appelOffre{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", status=" + status +
                ", quantité=" + quantity +
                '}';
    }
}
