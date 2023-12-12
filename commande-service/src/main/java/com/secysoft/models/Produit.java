package com.secysoft.models;

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
    private Long idPrduit;

    @Column(name = "nom_produit",nullable = false)
    private String nomProduit;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(nullable = false,name = "prix")
    private Integer prix;

    @Column(nullable = false,name = "qteStoke")
    private Integer qteStoke;





}
