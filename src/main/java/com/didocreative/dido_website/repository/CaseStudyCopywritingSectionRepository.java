package com.didocreative.dido_website.repository;

import com.didocreative.dido_website.model.CaseStudyCopywritingSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseStudyCopywritingSectionRepository extends JpaRepository<CaseStudyCopywritingSection, Long> {

    // JpaRepository<CaseStudyCopywritingSection, Long> gives us:
    // - save(CaseStudyCopywritingSection entity)
    // - findById(Long caseStudyCopywritingSectionId)
    // - findAll()
    // - deleteById(Long caseStudyCopywritingSectionId)
    // - ...and many more

    // Get CopywritingSections by key
    List<CaseStudyCopywritingSection> findByKey(String key);

    // Get CopywritingSections by value
    List<CaseStudyCopywritingSection> findByValue(String value);

    // Get CopywritingSections by description
    List<CaseStudyCopywritingSection> findByDescription(String description);

    // Find all sections for a specific caseStudy
    List<CaseStudyCopywritingSection> findByCaseStudyId(Long caseStudyId);
}
