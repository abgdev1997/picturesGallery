package com.abgdev1997.picturesGallery.service;

import com.abgdev1997.picturesGallery.entity.Image;
import com.abgdev1997.picturesGallery.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    /**
     * Find a list with all the images
     * @return
     */
    public List<Image> list(){
        return imageRepository.findByOrderById();
    }

    /**
     * Save a image
     * @param image
     */
    public void save(Image image){
        imageRepository.save(image);
    }
}
