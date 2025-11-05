package com.didocreative.dido_website.repository;

import com.didocreative.dido_website.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    // JpaRepository<Image, Long> gives us:
    // - save(Image entity)
    // - findById(Long imageId)
    // - findAll()
    // - deleteById(Long imageId)
    // - ...and many more

    // Get Images by pageId
    List<Image> findByPageId(Long pageId);

    // Get Images by imageSectionId
    List<Image> findByImageSectionId(Long imageSectionId);
}
