package com.secysoft.controllers;


import com.secysoft.models.Commande;
import com.secysoft.repositories.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CommandeController {

    @Autowired
    private CommandeRepo commandeRepo;

    @GetMapping("/getAllCommande")
    public ResponseEntity<List<Commande>> getAllCommande (){
        try {
            List<Commande> commandeList = new ArrayList<>();
            commandeRepo.findAll().forEach(commandeList::add);

            if (commandeList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(commandeList, HttpStatus.OK);
        }catch (Exception ex ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getCommandeById/{id}")
    public  ResponseEntity<Commande> getCommandeById(@PathVariable Long id){
        Optional<Commande> commandeData = commandeRepo.findById(id);

        if (commandeData.isPresent()){
            return new ResponseEntity<>(commandeData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/addCommande")
    public ResponseEntity<Commande> addCommande(@RequestBody Commande commande){
        Commande commandeObj = commandeRepo.save(commande);

        return new ResponseEntity<>(commandeObj, HttpStatus.OK);

    }

    @PostMapping("/updateCommandeById/{id}")
    public ResponseEntity<Commande> updateCommandeById(@PathVariable Long id, @RequestBody Commande newCommandeData){
        Optional<Commande> oldCommandeData = commandeRepo.findById(id);

        if (oldCommandeData.isPresent()){
            Commande updateCommandeData = oldCommandeData.get();
            updateCommandeData.setNomCommande(newCommandeData.getNomCommande());
            updateCommandeData.setDesignation(newCommandeData.getDesignation());

            Commande commandeObj = commandeRepo.save(updateCommandeData);
            return new ResponseEntity<>(commandeObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/deleteCommandeById/{id}")
    public ResponseEntity<HttpStatus> deleteCommandeById(@PathVariable Long id){
        commandeRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }
}