package com.mazzocchi.adming.persistance.repository;

import com.mazzocchi.adming.persistance.enitity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

}
