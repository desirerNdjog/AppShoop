package com.secysoft.models;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "produitCommande")
public class ProduitCommande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prdoduitCommandeId",nullable = false)
    private Long id;

    @Column(nullable = false,name = "quantité_commande")
    private Integer qteCommande;

    @Column(name = "dateCommande", nullable = false)
    private Date dateCommande;

    @Column(name= "total",nullable = false)
    private Integer total;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "commande_id")
    private Commande commande;



}
