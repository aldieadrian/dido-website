package com.didocreative.dido_website.repository;

import com.didocreative.dido_website.model.PortfolioImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioImageRepository extends JpaRepository<PortfolioImage, Long> {

    // JpaRepository<PortfolioImage, Long> gives us:
    // - save(PortfolioImage entity)
    // - findById(Long portfolioImageId)
    // - findAll()
    // - deleteById(Long portfolioImageId)
    // - ...and many more

    // Find all images for a specific section
    List<PortfolioImage> findByPortfolioImageSectionId(Long portfolioImageSectionId);
}
