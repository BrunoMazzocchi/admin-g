package com.mazzocchi.adming.persistance.repository;

import com.mazzocchi.adming.persistance.enitity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface ProductionOrderRepository extends JpaRepository<ProductionOrder, Integer> {
    List<ProductionOrder> findAll();
    ProductionOrder save(ProductionOrder productionOrder);

    Optional<ProductionOrder> findByProductionOrderId(int id);

}
