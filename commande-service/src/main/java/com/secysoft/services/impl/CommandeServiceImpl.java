package com.secysoft.services.impl;


import com.secysoft.models.Commande;
import com.secysoft.repositories.ClientRepo;
import com.secysoft.repositories.CommandeRepo;
import com.secysoft.services.CommandeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeRepo commandeRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Override
    @Transactional
    public List<Commande> getAllCommande() {

        return commandeRepo.findAll();
    }

    @Override
    @Transactional
    public Commande getCommandeById(Long id) {
        return commandeRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Commande addCommande(Commande commande) {
        // Assurez-vous que la référence vers le client est non nulle
        if (commande.getClient() != null) {
            // Récupérez l'ID du client à partir de la commande
            Long clientId = commande.getClient().getIdclient();

            // Vérifiez si le client existe dans le repository
            if (clientId != null && clientRepo.existsById(clientId)) {
                return commandeRepo.save(commande);
            } else {
                // Gérez le cas où l'ID du client est manquant ou invalide
                // Lancez une exception, retournez null, ou gérez d'une autre manière
                return null;
            }
        } else {
            // Gérez le cas où la référence vers le client est nulle
            // Lancez une exception, retournez null, ou gérez d'une autre manière
            return null;
        }
    }

    @Override
    @Transactional
    public Commande updateCommandeById(Long id, Commande updatedCommande) {
        // Assurez-vous que l'ID du client est présent et valide
        if (updatedCommande.getClient() != null && clientRepo.existsById(updatedCommande.getClient().getIdclient())) {
            Optional<Commande> existingCommande = commandeRepo.findById(id);
            if (existingCommande.isPresent()) {
                Commande commandeToUpdate = existingCommande.get();
                commandeToUpdate.setNomCommande(updatedCommande.getNomCommande());
                commandeToUpdate.setDesignation(updatedCommande.getDesignation());
                return commandeRepo.save(commandeToUpdate);
            }
            return null; // une exception appropriée si l'id de la commande n'est pas trouvé
        } else {
            //  le cas où l'ID du client est manquant ou invalide
            return null;
        }
    }


    @Override
    @Transactional
    public void deleteCommandeById(Long id) {
        commandeRepo.deleteById(id);
    }



}
