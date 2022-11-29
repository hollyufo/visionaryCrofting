package com.visionaryCrofting.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Commande",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ref")
})
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande_id")
    private Long id;
    @Column(nullable = false,unique = true)
    private String ref;
    @Column(nullable = false)
    private LocalDate date;
    private Double prixTotal;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
   @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL)
    private List<CommandeItem> commandeItems;
    public Commande(){}
    public Commande(String ref, LocalDate date, Double prixTotal, Client client) {
        this.ref = ref;
        this.date = date;
        this.prixTotal = prixTotal;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }
}
