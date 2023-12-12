package com.secysoft.services;

import com.secysoft.models.ProduitCommande;

import java.util.List;
import java.util.Optional;

public interface ProduitCommandeService {
    List<ProduitCommande> getAllProduitCommande();
    Optional<ProduitCommande> getProduitCommandeById(Long id);
    ProduitCommande addProduitCommande(ProduitCommande produitCommande);
    ProduitCommande updateProduitCommandeById(Long id, ProduitCommande updatedProduitCommande);
    void deleteProduitCommandeById(Long id);
}
