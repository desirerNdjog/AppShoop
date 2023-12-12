package com.secysoft.services;

import com.secysoft.models.Commande;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommandeService {
    List<Commande> getAllCommande();
    Commande getCommandeById(Long id);
    Commande addCommande(Commande commande);
    Commande updateCommandeById(Long id, Commande updatedCommande);
    void deleteCommandeById(Long id);

}
