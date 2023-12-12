package com.secysoft.services;

import com.secysoft.models.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> getAllProduit();
    Produit getProduitById(Long id);
    Produit addProduit(Produit produit);
    Produit updateProduitById(Long id, Produit updatedProduit);
    void deleteProduitById(Long id);
}

