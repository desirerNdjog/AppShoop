package com.secysoft.controllers;

import com.secysoft.models.ProduitCommande;
import com.secysoft.services.ProduitCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produitCommande")
public class ProduitCommandeController {

    @Autowired
    private ProduitCommandeService produitCommandeService;

    @GetMapping("/getAllProduitCommande")
    public ResponseEntity<List<ProduitCommande>> getAllProduitCommande() {
        List<ProduitCommande> produitCommande = produitCommandeService.getAllProduitCommande();
        return new ResponseEntity<>(produitCommande, HttpStatus.OK);
    }

    @GetMapping("/getProduitCommandeById/{id}")
    public ResponseEntity<ProduitCommande> getProduitCommandeById(@PathVariable Long id) {
        Optional<ProduitCommande> produitCommande = produitCommandeService.getProduitCommandeById(id);
        return produitCommande.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addProduitCommande/{produitId}/{commandeId}")
    public ResponseEntity<ProduitCommande> addProduitCommande(
            @PathVariable Long produitId,
            @PathVariable Long commandeId,
            @RequestBody ProduitCommande produitCommande
    ) {
        ProduitCommande addedProduitCommande = produitCommandeService.addProduitCommande( produitCommande);
        return new ResponseEntity<>(addedProduitCommande, HttpStatus.CREATED);
    }

    @PutMapping("/updateProduitCommandeById/{id}")
    public ResponseEntity<ProduitCommande> updateProduitCommandeById(
            @PathVariable Long id,
            @RequestBody ProduitCommande updatedProduitCommande
    ) {
        ProduitCommande updatedProduitCommandeResult = produitCommandeService.updateProduitCommandeById(id, updatedProduitCommande);
        if (updatedProduitCommandeResult != null) {
            return new ResponseEntity<>(updatedProduitCommandeResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteProduitCommandeById")
    public ResponseEntity<Void> deleteProduitCommandeById(@PathVariable Long id) {
        produitCommandeService.deleteProduitCommandeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
