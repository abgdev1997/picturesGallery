package com.abgdev1997.picturesGallery.service;

import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public Map upload(MultipartFile multipartFile){
        return null;
    }

    public Map delete(String id){
        return null;
    }

    /**
     * Convert MultipartFile on File
     * @param multipartFile
     * @return file
     * @throws IOException
     */
    private File convert(MultipartFile multipartFile) throws IOException {
        //Creamos un archivo para alojar el que llega por props
        File file = new File(multipartFile.getOriginalFilename());
        //Creamos un objeto FileOutputStream para poder guardar el archivo
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }

}
