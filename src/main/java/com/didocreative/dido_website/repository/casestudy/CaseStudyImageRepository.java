package com.didocreative.dido_website.repository.casestudy;

import com.didocreative.dido_website.model.casestudy.CaseStudyImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseStudyImageRepository extends JpaRepository<CaseStudyImage, Long> {

    // JpaRepository<CaseStudyImage, Long> gives us:
    // - save(CaseStudyImage entity)
    // - findById(Long caseStudyImageId)
    // - findAll()
    // - deleteById(Long caseStudyImageId)
    // - ...and many more

    // Find all images for a specific section
    List<CaseStudyImage> findByCaseStudyImageSectionId(Long caseStudyImageSectionId);
}
