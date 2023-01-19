package com.mazzocchi.adming.persistance.repository;

import com.mazzocchi.adming.persistance.enitity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface JewelryRepository extends JpaRepository<Jewelry, Integer> {

    List<Jewelry> findAll();
    Jewelry save(Jewelry jewelry);

    Optional<Jewelry> findByJewelryId(Integer id);
    Optional<Jewelry> findByName(String name);


}