package com.abgdev1997.picturesGallery.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    /**
     * Upload to Cloudinary
     * @param multipartFile
     * @return Map result
     * @throws IOException
     */
    public Map upload(MultipartFile multipartFile) throws IOException {
        //Convertimos el multipart
        File file = convert(multipartFile);
        //lo subimos a cloudinary
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        //Borramos el FileOutputStream
        file.delete();

        return result;
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
        //Creamos un archivo para alojar el nombre del multipart que llega por props
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        //Creamos un objeto FileOutputStream para poder guardar el archivo en forma file
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }

}
