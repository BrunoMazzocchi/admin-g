package com.mazzocchi.adming.persistance.repository;

import com.mazzocchi.adming.persistance.enitity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findAll();
    Optional<Client> getClientByClientId(Integer id);
    Optional<Client> getClientByFirstNameOrLastName(String firstName, String lastName);

    Optional<Client> getClientByFirstNameAndLastName(String firstName, String lastName);

    Client save(Client client);
    void delete(Client client);

}
