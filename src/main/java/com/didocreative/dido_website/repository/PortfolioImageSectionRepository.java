package com.didocreative.dido_website.repository;

import com.didocreative.dido_website.model.PortfolioImageSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioImageSectionRepository extends JpaRepository<PortfolioImageSection, Long> {

    // JpaRepository<PortfolioImageSection, Long> gives us:
    // - save(PortfolioImageSection entity)
    // - findById(Long portfolioImageSection)
    // - findAll()
    // - deleteById(Long portfolioImageSection)
    // - ...and many more

    // Get ImageSections by key
    List<PortfolioImageSection> findByKey(String key);

    // Get ImageSections by value
    List<PortfolioImageSection> findByValue(String value);

    // Get ImageSections by description
    List<PortfolioImageSection> findByDescription(String description);

    // Find all sections for a specific portfolio
    List<PortfolioImageSection> findByPortfolioId(Long portfolioId);
}
