package com.mazzocchi.adming.web.controller;

import com.mazzocchi.adming.domain.service.*;
import com.mazzocchi.adming.persistance.dto.*;
import com.mazzocchi.adming.persistance.enitity.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable("id") Integer id) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(clientService.getClientById(id).orElseThrow(), clientDTO);
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }



    @PostMapping("/save")
    public ResponseEntity<?> saveClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

}
