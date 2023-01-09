package com.mazzocchi.adming.web.controller.rest;

import com.mazzocchi.adming.domain.service.*;
import com.mazzocchi.adming.persistance.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/material")
public class MaterialRestController {
    @Autowired
    private MaterialService materialService;

    @GetMapping(value = "/{name}")
    public MaterialDTO getMaterialByName(@PathVariable("name") String name) {
        return materialService.findByName(name);
    }

    @GetMapping(value = "/all")
    public Iterable<MaterialDTO> getAllMaterials() {
        return materialService.findAll();
    }

    @PostMapping(value = "/add")
    public MaterialDTO save(@RequestBody MaterialDTO materialDTO) {
        return materialService.save(materialDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        materialService.deleteById(id);
    }

}
