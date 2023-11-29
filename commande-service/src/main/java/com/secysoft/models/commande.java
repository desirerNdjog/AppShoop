package com.secysoft.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name = "commande")

public class commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "nom_commande", updatable = true,nullable = false)
    String nom_commande;
    @Column(name = "designation",updatable = true,nullable = false)
    String designation;
    // clientId
}
