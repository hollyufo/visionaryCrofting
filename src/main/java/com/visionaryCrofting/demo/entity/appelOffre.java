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
    @Column(name = "quantité")
    private int quantité;

    public appelOffre() {
    }

    public appelOffre(int id, String ref, String refProduit, boolean status, int quantité) {
        this.id = id;
        this.ref = ref;
        this.refProduit = refProduit;
        this.status = status;
        this.quantité = quantité;
    }

    public appelOffre(String ref, String refProduit, boolean status, int quantité) {
        this.ref = ref;
        this.refProduit = refProduit;
        this.status = status;
        this.quantité = quantité;
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
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    @Override
    public String toString() {
        return "appelOffre{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", status=" + status +
                ", quantité=" + quantité +
                '}';
    }
}
