package com.mazzocchi.adming.domain.service;

import com.mazzocchi.adming.persistance.enitity.*;
import com.mazzocchi.adming.persistance.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ProductionOrderService {
    @Autowired
    ProductionOrderRepository productionOrderRepository;


    public List<ProductionOrder> getAll(){
        return productionOrderRepository.findAll();
    }
    public ProductionOrder save (ProductionOrder productionOrder) {return productionOrderRepository.save(productionOrder);}

    public ProductionOrder get(int id) {
        return productionOrderRepository.findByProductionOrderId(id).orElse(null);
    }
}
