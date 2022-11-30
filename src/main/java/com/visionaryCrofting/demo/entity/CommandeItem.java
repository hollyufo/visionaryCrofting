package com.visionaryCrofting.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
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

}
