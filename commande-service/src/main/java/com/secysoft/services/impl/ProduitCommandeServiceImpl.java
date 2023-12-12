package com.secysoft.services.impl;

import com.secysoft.models.ProduitCommande;
import com.secysoft.repositories.ProduitCommandeRepo;
import com.secysoft.services.ProduitCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitCommandeServiceImpl implements ProduitCommandeService {

    @Autowired
    private ProduitCommandeRepo produitCommandeRepo;

    @Override
    public List<ProduitCommande> getAllProduitCommande() {
        return produitCommandeRepo.findAll();
    }

    @Override
    public Optional<ProduitCommande> getProduitCommandeById(Long id) {
        return produitCommandeRepo.findById(id);
    }

    @Override
    public ProduitCommande addProduitCommande(ProduitCommande produitCommande) {
        // Ajoutez ici la logique de validation ou de traitement spécifique
        return produitCommandeRepo.save(produitCommande);
    }

    @Override
    public ProduitCommande updateProduitCommandeById(Long id, ProduitCommande updatedProduitCommande) {
        Optional<ProduitCommande> existingProduitCommande = produitCommandeRepo.findById(id);

        if (existingProduitCommande.isPresent()) {
            ProduitCommande produitCommandeToUpdate = existingProduitCommande.get();

            // Vérifiez si l'ID du client est présent et valide
            if (updatedProduitCommande.getId() != null) {

                // Assurez-vous que l'ID du client est présent et valide
                // (vous devrez peut-être effectuer une vérification plus approfondie ici)

                // Mettez à jour les autres champs si nécessaire
                produitCommandeToUpdate.setQteCommande(updatedProduitCommande.getQteCommande());
                produitCommandeToUpdate.setDateCommande(updatedProduitCommande.getDateCommande());
                produitCommandeToUpdate.setTotal(updatedProduitCommande.getTotal());

                return produitCommandeRepo.save(produitCommandeToUpdate);
            } else {
                // Gérez le cas où l'ID du client associé n'est pas présent ou invalide
                return null;
            }
        } else {
            // Gérez le cas où l'élément n'existe pas
            return null;
        }
    }

    @Override
    public void deleteProduitCommandeById(Long id) {
        produitCommandeRepo.deleteById(id);
    }
}
