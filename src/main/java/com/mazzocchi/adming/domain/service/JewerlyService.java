package com.mazzocchi.adming.domain.service;

import com.mazzocchi.adming.persistance.enitity.*;
import com.mazzocchi.adming.persistance.repository.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;
import com.mazzocchi.adming.persistance.dto.*;

import java.util.*;

@Service
public class JewerlyService {
    @Autowired
    private JewerlyRepository jewerlyRepository;

    public JewelryDTO findById(int id) {
        JewelryDTO jewerlyDTO = new JewelryDTO();
        jewerlyRepository.findById(id).ifPresent(jewerly -> BeanUtils.copyProperties(jewerly, jewerlyDTO));
        return jewerlyDTO;
    }

    public List<JewelryDTO> findAll() {
        List<JewelryDTO> jewelryDOS = new ArrayList<>();
        List<MaterialDTO> materialDTOS = new ArrayList<>();


        jewerlyRepository.findAll().stream().map(jewerly -> {
            JewelryDTO jewerlyDTO = new JewelryDTO();
            BeanUtils.copyProperties(jewerly, jewerlyDTO);
            jewerly.getMaterials().stream().map(material -> {
                MaterialDTO materialDTO = new MaterialDTO();
                BeanUtils.copyProperties(material, materialDTO);
                return materialDTO;
            }).forEach(materialDTOS::add);

            jewerlyDTO.setMaterials(materialDTOS);
            return jewerlyDTO;
        }).forEach(jewelryDOS::add);

        return jewelryDOS;
    }

    public JewelryDTO save(JewelryDTO jewelryDTO) {
        Jewelry jewelry = new Jewelry();
        List<Material> materials = new ArrayList<>();

        jewelryDTO.getMaterials().forEach(
                materialDTO -> {
                    Material material = new Material();
                    BeanUtils.copyProperties(materialDTO, material);
                    materials.add(material);
                }
        );


        BeanUtils.copyProperties(jewelryDTO, jewelry);
        jewelry.setMaterials(materials);
        jewerlyRepository.save(jewelry);
        return jewelryDTO;
    }
}
