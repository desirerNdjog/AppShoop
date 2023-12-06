package com.secysoft.services.impl;

import com.secysoft.models.Client;
import com.secysoft.repositories.ClientRepo;

import com.secysoft.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepo;

    @Override
    public List<Client> getAllClient() {
        return clientRepo.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Client updateClientById(Long id, Client updatedClient) {
        Optional<Client> existingClient = clientRepo.findById(id);
        if (existingClient.isPresent()) {
            Client clientToUpdate = existingClient.get();
            clientToUpdate.setEmail(updatedClient.getEmail());
            clientToUpdate.setNomClient(updatedClient.getNomClient());

            return clientRepo.save(clientToUpdate);
        }
        return null;
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepo.deleteById(id);
    }
}
