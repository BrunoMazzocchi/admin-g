package com.mazzocchi.adming.domain.service;

import com.mazzocchi.adming.persistance.dto.*;
import com.mazzocchi.adming.persistance.enitity.*;
import com.mazzocchi.adming.persistance.repository.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

}
