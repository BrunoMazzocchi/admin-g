package com.mazzocchi.adming.web.controller.controller;

import com.mazzocchi.adming.domain.service.*;
import com.mazzocchi.adming.persistance.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.*;

import java.io.*;
import java.nio.file.*;

@Controller
@RequestMapping("/web/product")
public class ProductController {


    @Autowired
    private JewerlyService jewerlyService;

    @GetMapping("/all")
    public ModelAndView getAllMaterials() {
        ModelAndView modelAndView = new ModelAndView("web/product/products.html");
        modelAndView.addObject("products", jewerlyService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addMaterial() {
        ModelAndView modelAndView = new ModelAndView("web/product/add.html");
        return modelAndView;
    }

    @RequestMapping(path = "save", consumes = {"multipart/form-data"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView save(@ModelAttribute("material") JewelryDTO jewelryDTO, @RequestParam("myImage") MultipartFile multipartFile,
                             ModelMap model) {
        try {

            if (multipartFile != null && !multipartFile.isEmpty()) {

                String fileName = multipartFile.getOriginalFilename();
                String uploadDir = "D:\\gadmin-images\\" + fileName;
                String fileToBeSave = "http://localhost:8000/images/" + fileName;
                jewelryDTO.setImage(fileToBeSave);
                jewerlyService.save(jewelryDTO);
                saveFile(uploadDir, fileName, multipartFile);
            } else {
                System.out.println(jewelryDTO.getJewelryId());
                jewelryDTO.setImage("");
                jewerlyService.save(jewelryDTO);
            }
            return new ModelAndView("redirect:/web/material/all?msg=1", model);
        } catch (Exception error) {
            return new ModelAndView("redirect:/web/material/all?msg=2", model);
        }
    }


    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }


    @GetMapping("/edit/{id}")
    public ModelAndView editMaterial(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("web/material/edit.html");
        modelAndView.addObject("material", jewerlyService.findById(id));
        return modelAndView;
    }


}
