package com.secysoft.models;

 import jakarta.persistence.FetchType;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "commande")

public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commandeId",nullable = false)
    private Long id;

    @Column(name = "nom_commande",nullable = false)
    private String nomCommande;

    @Column(name = "designation",nullable = false)
    private String designation;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "client")
    private Client client;

    //@OneToMany(mappedBy = "commande", fetch = FetchType.LAZY)
   // private Set<Produit> produit;
}
