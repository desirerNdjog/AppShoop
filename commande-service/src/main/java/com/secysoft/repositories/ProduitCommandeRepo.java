package com.secysoft.repositories;

import com.secysoft.models.ProduitCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitCommandeRepo extends JpaRepository<ProduitCommande, Long> {
}
