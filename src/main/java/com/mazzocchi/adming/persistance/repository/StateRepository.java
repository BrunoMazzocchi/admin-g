package com.mazzocchi.adming.persistance.repository;

import com.mazzocchi.adming.persistance.enitity.*;
import com.mazzocchi.adming.persistance.enitity.enums.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface StateRepository extends JpaRepository<State, Integer> {

}
