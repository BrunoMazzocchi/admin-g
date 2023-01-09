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

    public MaterialDTO findByName(String name) {
        MaterialDTO materialDTO = new MaterialDTO();
        Material material = materialRepository.findByName(name);

        BeanUtils.copyProperties(material, materialDTO);
        return materialDTO;
    }

    public List<MaterialDTO> findAll() {
        List<MaterialDTO> materialDTOList = new ArrayList<>();
        List<Material> materialList = materialRepository.findAll();

        for (Material material : materialList) {
            MaterialDTO materialDTO = new MaterialDTO();
            BeanUtils.copyProperties(material, materialDTO);
            materialDTOList.add(materialDTO);
        }
        return materialDTOList;
    }


    public MaterialDTO save (MaterialDTO materialDTO) {
        Material material = new Material();
        BeanUtils.copyProperties(materialDTO, material);
        material = materialRepository.save(material);
        BeanUtils.copyProperties(material, materialDTO);
        return materialDTO;
    }

    public MaterialDTO findById(int id) {
        Material material = materialRepository.findById(id).get();
        MaterialDTO materialDTO = new MaterialDTO();
        BeanUtils.copyProperties(material, materialDTO);
        return materialDTO;
    }

    public void deleteById(Integer id) {
        materialRepository.deleteById(id);
    }

}
