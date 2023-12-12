// ClientService.java
package com.secysoft.services;

import com.secysoft.models.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClient();

    Client getClientById(Long id);

    Client addClient(Client client);

    Client updateClientById(Long id, Client client);

    void deleteClientById(Long id);
}