package com.secysoft.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Data
@Entity
@Table(name = "produit")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "nom_produit", updatable = true,nullable = false)
    String nom_produit;
    @Column(name = "type",updatable = true,nullable = false)
    String type;
    @Column(nullable = false,updatable = true,name = "prix")
    Integer prix;
    @Column(nullable = false,updatable = true,name = "qteStoke")
    Integer qteStoke;



}
