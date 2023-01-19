package com.mazzocchi.adming.domain.service;

import com.mazzocchi.adming.persistance.enitity.*;
import com.mazzocchi.adming.persistance.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class JewelryService {
    @Autowired
    private JewelryRepository jewelryRepository;


    public List<Jewelry> getAll(){
        return jewelryRepository.findAll();
    }

    public Jewelry save (Jewelry jewelry) {return jewelryRepository.save(jewelry);}

    public Jewelry getJewelryById(Integer id) {
        Optional<Jewelry> jewelry = jewelryRepository.findByJewelryId(id);
        if (jewelry.isPresent()) {
            return jewelry.get();
        } else {
            throw new IllegalArgumentException("Jewelry not found");
        }
    }

    public Jewelry getJewelryByName(String name) {
        Optional<Jewelry> jewelry = jewelryRepository.findByName(name);
        if (jewelry.isPresent()) {
            return jewelry.get();
        } else {
            throw new IllegalArgumentException("Jewelry not found");
        }
    }


}
