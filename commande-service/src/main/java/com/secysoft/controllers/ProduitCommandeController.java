package com.secysoft.controllers;



import com.secysoft.models.ProduitCommande;
import com.secysoft.repositories.ProduitCommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProduitCommandeController {
    @Autowired
    private ProduitCommandeRepo produitCommandeRepo;

    @GetMapping("/getAllProduitCommande")
    public ResponseEntity<List<ProduitCommande>> getAllProduitCommande (){
        try {
            List<ProduitCommande> produitCommandeList = new ArrayList<>();
            produitCommandeRepo.findAll().forEach(produitCommandeList::add);

            if (produitCommandeList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(produitCommandeList, HttpStatus.OK);
        }catch (Exception ex ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getProduitCommandeById/{id}")
    public  ResponseEntity<ProduitCommande> getProduitCommandeById(@PathVariable Long id){
        Optional<ProduitCommande> produitCommandeData = produitCommandeRepo.findById(id);

        if (produitCommandeData.isPresent()){
            return new ResponseEntity<>(produitCommandeData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/addProduitCommande")
    public ResponseEntity<ProduitCommande> addProduitCommande(@RequestBody ProduitCommande produitCommande){
        ProduitCommande produitCommandeObj = produitCommandeRepo.save(produitCommande);

        return new ResponseEntity<>(produitCommandeObj, HttpStatus.OK);

    }

    @PostMapping("/updateProduitCommandeById/{id}")
    public ResponseEntity<ProduitCommande> updateProduitCommandeById(@PathVariable Long id, @RequestBody ProduitCommande newProduitCommandeData){
        Optional<ProduitCommande> oldProduitCommandeData = produitCommandeRepo.findById(id);

        if (oldProduitCommandeData.isPresent()){
            ProduitCommande updateProduitCommandeData = oldProduitCommandeData.get();
            updateProduitCommandeData.setQteCommande(newProduitCommandeData.getQteCommande());
            updateProduitCommandeData.setTotal(newProduitCommandeData.getTotal());
            updateProduitCommandeData.setDateCommande(newProduitCommandeData.getDateCommande());

            ProduitCommande produitCommandeObj = produitCommandeRepo.save(updateProduitCommandeData);
            return new ResponseEntity<>(produitCommandeObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/deleteProduitCommandeById/{id}")
    public ResponseEntity<HttpStatus> deleteProduitCommandeById(@PathVariable Long id){
        produitCommandeRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }
}
