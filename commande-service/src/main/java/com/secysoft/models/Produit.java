package com.secysoft.models;
import java.util.Set;

import com.secysoft.CommandeService;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "produit")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produitId",nullable = false)
    private Long id;

    @Column(name = "nom_produit",nullable = false)
    private String nomProduit;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(nullable = false,name = "prix")
    private Integer prix;

    @Column(nullable = false,name = "qteStoke")
    private Integer qteStoke;

   // @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
   // private Set<Commande> commande;



}
