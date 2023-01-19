package com.mazzocchi.adming.web.controller;

import com.mazzocchi.adming.domain.service.*;
import com.mazzocchi.adming.persistance.enitity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class ProductionOrderController {
    @Autowired
    private ProductionOrderService productionOrderService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllOrders() {
        return new ResponseEntity<>(productionOrderService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveClient(@RequestBody ProductionOrder productionOrder) {
        return new ResponseEntity<>(productionOrderService.save(productionOrder), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable int id) {
        return new ResponseEntity<>(productionOrderService.get(id), HttpStatus.OK);
    }
}
