package com.abgdev1997.picturesGallery.controller;

import com.abgdev1997.picturesGallery.dto.MessageDto;
import com.abgdev1997.picturesGallery.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
public class CloudinaryController {

    @Autowired
    CloudinaryService cloudinaryService;

    /**
     * Upload image
     * @param multipartFile
     * @return Map result and HttpStatus.OK
     * @throws IOException
     */
    @PostMapping("/upload")
    public ResponseEntity<Map> upload(@RequestParam MultipartFile multipartFile) throws IOException {
        //Leemos la imagen
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        //Comprobamos si es una imagen
        if(bi == null) {
            return new ResponseEntity(new MessageDto("This isn't a image!"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * Delete image
     * @param id
     * @return Map result and HttpStatus.OK
     * @throws IOException
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> upload(@PathVariable("id") String id) throws IOException {
        Map result = cloudinaryService.delete(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }


}
