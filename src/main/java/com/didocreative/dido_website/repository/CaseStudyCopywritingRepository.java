package com.didocreative.dido_website.repository;

import com.didocreative.dido_website.model.CaseStudyCopywriting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseStudyCopywritingRepository extends JpaRepository<CaseStudyCopywriting, Long> {

    // JpaRepository<CaseStudyCopywriting, Long> gives us:
    // - save(CaseStudyCopywriting entity)
    // - findById(Long caseStudyCopywritingId)
    // - findAll()
    // - deleteById(Long caseStudyCopywritingId)
    // - ...and many more

    // Find all entries for a specific section
    List<CaseStudyCopywriting> findByCaseStudyCopywritingSectionId(Long caseStudyCopywritingSectionId);
}
