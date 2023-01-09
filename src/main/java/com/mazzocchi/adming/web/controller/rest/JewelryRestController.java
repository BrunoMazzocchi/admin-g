package com.mazzocchi.adming.web.controller.rest;

import com.mazzocchi.adming.domain.service.*;
import com.mazzocchi.adming.persistance.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jewelry")
public class JewelryRestController {
    @Autowired
    private JewerlyService jewelryService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllJewelry() {
        return new ResponseEntity<>(jewelryService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addJewelry(@RequestBody JewelryDTO jewelryDTO) {
        return new ResponseEntity<>(jewelryService.save(jewelryDTO), HttpStatus.OK);
    }
}
