package com.abgdev1997.picturesGallery.service;

import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

    Cloudinary cloudinary;

    private Map<String, String> valuesMap = new HashMap<>();

    public CloudinaryService(){
        valuesMap.put("cloud_name", "abgdev1997");
        valuesMap.put("api_key", "994786457829424");
        valuesMap.put("api_secret", "VR5WH2t2sih5-FsciKK_5cv_2z0");
        cloudinary = new Cloudinary(valuesMap);
    }



}
