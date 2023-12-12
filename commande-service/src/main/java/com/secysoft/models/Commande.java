package com.secysoft.models;

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
    private Long idCommande;

    @Column(name = "nom_commande",nullable = false)
    private String nomCommande;

    @Column(name = "designation",nullable = false)
    private String designation;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idclient")
    private Client client;


}
