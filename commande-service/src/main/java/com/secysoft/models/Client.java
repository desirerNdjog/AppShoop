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
@ToString
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @Column(name = "clientId",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "nom_client",nullable = false)
    private String nomClient;

}
