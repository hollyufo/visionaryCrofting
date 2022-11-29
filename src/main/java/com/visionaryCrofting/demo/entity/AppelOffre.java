package com.visionaryCrofting.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AppelOffre",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ref")
})
public class AppelOffre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ref" , nullable = false,unique = true)
    private String ref;

    public String getRefProduit() {
        return refProduit;
    }

    public void setRefProduit(String refProduit) {
        this.refProduit = refProduit;
    }

    @Column(name = "refProduit")
    private String refProduit;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "quantity")
    private int quantity;

    public AppelOffre() {
    }

    public AppelOffre(Long id, String ref, String refProduit, Status status, int quantity) {
        this.id = id;
        this.ref = ref;
        this.refProduit = refProduit;
        this.status = status;
        this.quantity = quantity;
    }

    public AppelOffre(String ref, String refProduit, Status status, int quantity) {
        this.ref = ref;
        this.refProduit = refProduit;
        this.status = status;
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

    public Status isStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
