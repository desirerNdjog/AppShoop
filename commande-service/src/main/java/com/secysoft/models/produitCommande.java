package com.secysoft.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produitCommande")
public class produitCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(nullable = false,updatable = true,name = "qteStoke")
    Integer qteStoke;
}
