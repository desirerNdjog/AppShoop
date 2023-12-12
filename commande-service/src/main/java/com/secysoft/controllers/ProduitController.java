package com.secysoft.controllers;

import com.secysoft.models.Produit;
import com.secysoft.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/getAllProduit")
    public List<Produit> getAllProduit() {
        return produitService.getAllProduit();
    }

    @GetMapping("/getProduitById/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    @PostMapping("/addProduit")
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.addProduit(produit);
    }

    @PutMapping("/updateProduitById/{id}")
    public Produit updateProduitById(@PathVariable Long id, @RequestBody Produit updatedProduit) {
        return produitService.updateProduitById(id, updatedProduit);
    }

    @DeleteMapping("/deleteProduitById/{id}")
    public void deleteProduitById(@PathVariable Long id) {
        produitService.deleteProduitById(id);
    }
}
