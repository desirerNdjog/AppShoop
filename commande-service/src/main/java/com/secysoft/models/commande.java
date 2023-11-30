package com.secysoft.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name = "commande")

public class commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commandeId",nullable = false)
    private Long id;
    @Column(name = "nom_commande",nullable = false)
    private String nomCommande;
    @Column(name = "designation",nullable = false)
    private String designation;
    // clientId
}
