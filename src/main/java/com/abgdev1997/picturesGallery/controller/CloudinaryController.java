package com.abgdev1997.picturesGallery.controller;

import com.abgdev1997.picturesGallery.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        Map result = cloudinaryService.upload(multipartFile);
        return new ResponseEntity(result, HttpStatus.OK);
    }



}
