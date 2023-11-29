package com.secysoft.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "email", updatable = true,nullable = false)
    String email;
    @Column(name = "nom_client",updatable = true,nullable = false)
    String nom_client;
    //int userId;
}
