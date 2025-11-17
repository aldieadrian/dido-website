package com.didocreative.dido_website.repository.portfolio;

import com.didocreative.dido_website.model.portfolio.PortfolioCopywritingSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioCopywritingSectionRepository extends JpaRepository<PortfolioCopywritingSection, Long> {

    // JpaRepository<PortfolioCopywritingSection, Long> gives us:
    // - save(PortfolioCopywritingSection entity)
    // - findById(Long portfolioCopywritingSectionId)
    // - findAll()
    // - deleteById(Long portfolioCopywritingSectionId)
    // - ...and many more

    // Get CopywritingSections by key
    List<PortfolioCopywritingSection> findByKey(String key);

    // Get CopywritingSections by value
    List<PortfolioCopywritingSection> findByValue(String value);

    // Get CopywritingSections by description
    List<PortfolioCopywritingSection> findByDescription(String description);

    // Find all sections for a specific portfolio
    List<PortfolioCopywritingSection> findByPortfolioId(Long portfolioId);
}
