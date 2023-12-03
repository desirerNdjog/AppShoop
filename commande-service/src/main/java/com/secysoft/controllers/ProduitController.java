package com.secysoft.controllers;



import com.secysoft.models.Produit;

import com.secysoft.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProduitController {
    @Autowired
    private ProduitRepo produitRepo;

    @GetMapping("/getAllProduit")
    public ResponseEntity<List<Produit>> getAllProduit (){
        try {
            List<Produit> produitList = new ArrayList<>();
            produitRepo.findAll().forEach(produitList::add);

            if (produitList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(produitList, HttpStatus.OK);
        }catch (Exception ex ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("/getProduitById/{id}")
    public  ResponseEntity<Produit> getProduitById(@PathVariable Long id){
        Optional<Produit> produitData = produitRepo.findById(id);

        if (produitData.isPresent()){
            return new ResponseEntity<>(produitData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/addProduit")
    public ResponseEntity<Produit> addProduit(@RequestBody Produit produit){
        Produit produitObj = produitRepo.save(produit);

        return new ResponseEntity<>(produitObj, HttpStatus.OK);

    }

    @PostMapping("/updateProduitById/{id}")
    public ResponseEntity<Produit> updateProduitById(@PathVariable Long id, @RequestBody Produit newProduitData){
        Optional<Produit> oldProduitData = produitRepo.findById(id);

        if (oldProduitData.isPresent()){
            Produit updateProduitData = oldProduitData.get();
            updateProduitData.setNomProduit(newProduitData.getNomProduit());
            updateProduitData.setPrix(newProduitData.getPrix());
            updateProduitData.setType(newProduitData.getType());
            updateProduitData.setQteStoke(newProduitData.getQteStoke());

            Produit produitObj = produitRepo.save(updateProduitData);
            return new ResponseEntity<>(produitObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @DeleteMapping("/deleteProduitById/{id}")
    public ResponseEntity<HttpStatus> deleteProduitById(@PathVariable Long id){
        produitRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }

}
