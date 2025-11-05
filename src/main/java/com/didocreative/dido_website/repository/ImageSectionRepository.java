package com.didocreative.dido_website.repository;

import com.didocreative.dido_website.model.ImageSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageSectionRepository extends JpaRepository<ImageSection, Long> {

    // JpaRepository<ImageSection, Long> gives us:
    // - save(ImageSection entity)
    // - findById(Long imageSectionId)
    // - findAll()
    // - deleteById(Long imageSectionId)
    // - ...and many more

    // Get ImageSections by imageSectionKey
    List<ImageSection> findByImageSectionKey(String imageSectionKey);

    // Get ImageSections by imageSectionValue
    List<ImageSection> findByImageSectionValue(String imageSectionValue);

    // Get ImageSections by imageSectionDescription
    List<ImageSection> findByImageSectionDescription(String imageSectionDescription);
}
