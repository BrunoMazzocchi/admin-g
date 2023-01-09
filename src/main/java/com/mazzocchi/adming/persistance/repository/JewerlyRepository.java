package com.mazzocchi.adming.persistance.repository;

import com.mazzocchi.adming.persistance.enitity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface JewerlyRepository extends JpaRepository<Jewelry, Integer> {
    List<Jewelry> findAll();
    Optional<Jewelry> findById(Integer id);
    List<Jewelry> findByName(String name);


    List<Jewelry> findByKilate(Integer kilate);
    List<Jewelry> findByMaterials(Material material);

    Jewelry save (Jewelry jewelry);
    void deleteById(Integer id);


}
