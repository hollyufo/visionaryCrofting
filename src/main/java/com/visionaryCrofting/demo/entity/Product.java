package com.visionaryCrofting.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
    @OneToMany(mappedBy ="product" ,cascade = CascadeType.ALL)
    //@JsonManagedReference
    private List<CommandeItem> commandeItems;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id")
    //@JsonManagedReference
    private Stock stock;
}
