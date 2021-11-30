package com.abgdev1997.picturesGallery.repository;


import com.abgdev1997.picturesGallery.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByOrderById();

    void deleteById(String id);
}
