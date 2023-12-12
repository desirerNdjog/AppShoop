package com.secysoft.services.impl;

import com.secysoft.models.Produit;
import com.secysoft.repositories.ProduitRepo;
import com.secysoft.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepo produitRepo;

    @Override
    public List<Produit> getAllProduit() {
        return produitRepo.findAll();
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitRepo.findById(id).orElse(null);
    }

    @Override
    public Produit addProduit(Produit produit) {
        return produitRepo.save(produit);
    }

    @Override
    public Produit updateProduitById(Long id, Produit updatedProduit) {
        Optional<Produit> existingProduit = produitRepo.findById(id);
        if (existingProduit.isPresent()) {
            Produit produitToUpdate = existingProduit.get();
            produitToUpdate.setNomProduit(updatedProduit.getNomProduit());
            produitToUpdate.setType(updatedProduit.getType());
            produitToUpdate.setPrix(updatedProduit.getPrix());
            produitToUpdate.setQteStoke(updatedProduit.getQteStoke());

            return produitRepo.save(produitToUpdate);
        }
        return null;
    }

    @Override
    public void deleteProduitById(Long id) {
        produitRepo.deleteById(id);
    }
}
