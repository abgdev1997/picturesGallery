package com.abgdev1997.picturesGallery.controller;

import com.abgdev1997.picturesGallery.dto.MessageDto;
import com.abgdev1997.picturesGallery.entity.Image;
import com.abgdev1997.picturesGallery.service.CloudinaryService;
import com.abgdev1997.picturesGallery.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
public class CloudinaryController {

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImageService imagenService;

    /**
     * List of images
     * @return list
     */
    public ResponseEntity<List<Image>> list(){
        List<Image> list = imagenService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    /**
     * Upload image
     * @param multipartFile
     * @return Map result and HttpStatus.OK
     * @throws IOException
     */
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile) throws IOException {
        //Leemos la imagen
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        //Comprobamos si es una imagen
        if(bi == null) {
            return new ResponseEntity(new MessageDto("This isn't a image!"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        Image image = new Image(
                (String)result.get("original_filename"),
                (String)result.get("url"),
                (String)result.get("public_id"));
        imagenService.save(image);
        return new ResponseEntity(new MessageDto("Upload image!"), HttpStatus.OK);
    }

    /**
     * Delete image
     * @param id
     * @return Map result and HttpStatus.OK
     * @throws IOException
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> upload(@PathVariable("id") Long id) throws IOException {
        if(!imagenService.exists(id)){
            return new ResponseEntity(new MessageDto("Image don't exists!"), HttpStatus.NOT_FOUND);
        }
        Image image = imagenService.getOne(id).get();
        Map result = cloudinaryService.delete(image.getImagenId());
        imagenService.delete(id);
        return new ResponseEntity(new MessageDto("Delete image!"), HttpStatus.OK);
    }


}
