package com.didocreative.dido_website.repository.casestudy;

import com.didocreative.dido_website.model.casestudy.CaseStudyImageSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseStudyImageSectionRepository extends JpaRepository<CaseStudyImageSection, Long> {

    // JpaRepository<CaseStudyImageSection, Long> gives us:
    // - save(CaseStudyImageSection entity)
    // - findById(Long caseStudyImageSectionId)
    // - findAll()
    // - deleteById(Long caseStudyImageSectionId)
    // - ...and many more

    // Get ImageSections by key
    List<CaseStudyImageSection> findByKey(String key);

    // Get ImageSections by value
    List<CaseStudyImageSection> findByValue(String value);

    // Get ImageSections by description
    List<CaseStudyImageSection> findByDescription(String description);

    // Find all sections for a specific caseStudy
    List<CaseStudyImageSection> findByCaseStudyId(Long caseStudyId);
}
