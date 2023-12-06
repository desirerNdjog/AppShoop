/*package com.secysoft.controllers;
import com.secysoft.models.Client;
import com.secysoft.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
// @RestController: Indique que cette classe est un contrôleur Spring qui gère les requêtes HTTP.
public class ClientController {

    @Autowired
    // @Autowired: Utilisé pour l'injection de dépendances
    private ClientRepo clientRepo;

    @GetMapping("/getAllClient")
    public ResponseEntity<List<Client>> getAllClient (){
        try {
            List<Client> clientList = new ArrayList<>();
            clientRepo.findAll().forEach(clientList::add);

            if (clientList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clientList, HttpStatus.OK);
        }catch (Exception ex ) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getClientById/{id}")
    public  ResponseEntity<Client> getClientById(@PathVariable Long id){
        Optional<Client> clientData = clientRepo.findById(id);

        if (clientData.isPresent()){
            return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PostMapping("/addClient")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client clientObj = clientRepo.save(client);

        return new ResponseEntity<>(clientObj, HttpStatus.OK);

    }
    @PostMapping("/updateClientById/{id}")
    public ResponseEntity<Client> updateClientById(@PathVariable Long id, @RequestBody Client newClientData){
        Optional<Client> oldClientData = clientRepo.findById(id);

        if (oldClientData.isPresent()){
            Client updateClientData = oldClientData.get();
            updateClientData.setEmail(newClientData.getEmail());
            updateClientData.setNomClient(newClientData.getNomClient());

            Client clientObj = clientRepo.save(updateClientData);
            return new ResponseEntity<>(clientObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/deleteClientById/{id}")
    public ResponseEntity<HttpStatus> deleteClientById(@PathVariable Long id){
        clientRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }

}**/

package com.secysoft.controllers;

import com.secysoft.models.Client;
import com.secysoft.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/getAllClient")
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    @GetMapping("/getClientById/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/updateClientById/{id}")
    public Client updateClientById(@PathVariable Long id, @RequestBody Client updatedClient) {
        return clientService.updateClientById(id, updatedClient);
    }

    @DeleteMapping("/deleteClientById/{id}")
    public void deleteClientById(@PathVariable Long id) {
        clientService.deleteClientById(id);
    }
}

