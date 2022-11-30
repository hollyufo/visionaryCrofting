package com.visionaryCrofting.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "Commande",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ref")
})
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande_id")
    private Long id;
    @Column(nullable = false,unique = true)
    private String ref;
    @Column(nullable = false)
    private LocalDate date;
    private Double prixTotal;
    // collum for the enum status
    @Column(nullable = false)
    private String status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    //@JsonManagedReference
    private Client client;

    @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL)
    //@JsonBackReference
    private List<CommandeItem> commandeItems;

}