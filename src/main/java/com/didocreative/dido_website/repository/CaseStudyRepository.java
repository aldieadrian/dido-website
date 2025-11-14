package com.didocreative.dido_website.repository;

import com.didocreative.dido_website.model.CaseStudy;
import com.didocreative.dido_website.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseStudyRepository extends JpaRepository<Portfolio, Long>  {

    // JpaRepository<CaseStudy, Long> gives us:
    // - save(CaseStudy entity)
    // - findById(Long caseStudyId)
    // - findAll()
    // - deleteById(Long caseStudyId)
    // - ...and many more

    // Get CaseStudies by projectTypeId
    List<CaseStudy> findByProjectTypeId(Long projectTypeId);

    // Get CaseStudies by title
    List<CaseStudy> findByTitle(String title);
}
