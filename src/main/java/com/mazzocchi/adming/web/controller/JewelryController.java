package com.mazzocchi.adming.web.controller;

import com.mazzocchi.adming.domain.service.*;
import com.mazzocchi.adming.persistance.enitity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jewelry")
public class JewelryController {

    @Autowired
    private JewelryService jewelryService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllJewelry() {
        return new ResponseEntity<>(jewelryService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveJewelry(@RequestBody Jewelry jewelry) {
        return new ResponseEntity<>(jewelryService.save(jewelry), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJewelryById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(jewelryService.getJewelryById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getJewelryByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(jewelryService.getJewelryByName(name), HttpStatus.OK);
    }
}
