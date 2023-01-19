package com.mazzocchi.adming.domain.service;

import com.mazzocchi.adming.persistance.enitity.*;
import com.mazzocchi.adming.persistance.repository.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Optional <List<Client>> getAllClients() {
        return Optional.ofNullable(clientRepository.findAll());
    }

    public Optional<Client> getClientById(Integer id) {
        return clientRepository.getClientByClientId(id);
    }

    public Optional<Client> getClientByFirstNameOrLastName(String firstName, String lastName) {
        return clientRepository.getClientByFirstNameOrLastName(firstName, lastName);
    }

    public Optional<Client> getClientByFirstNameAndLastName(String firstName, String lastName) {
        return clientRepository.getClientByFirstNameAndLastName(firstName, lastName);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }

    public Client update(Client client) {
        Client clientToUpdate = clientRepository.findById(client.getClientId()).orElseThrow();
        BeanUtils.copyProperties(client, clientToUpdate, "clientId");
        return clientRepository.save(clientToUpdate);
    }
}
