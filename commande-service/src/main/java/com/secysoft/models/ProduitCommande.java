package com.secysoft.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
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
    private String total;

}
