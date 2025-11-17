package com.didocreative.dido_website.repository.portfolio;

import com.didocreative.dido_website.model.portfolio.PortfolioCopywriting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioCopywritingRepository extends JpaRepository<PortfolioCopywriting, Long> {

    // JpaRepository<PortfolioCopywriting, Long> gives us:
    // - save(PortfolioCopywriting entity)
    // - findById(Long portfolioCopywritingId)
    // - findAll()
    // - deleteById(Long portfolioCopywritingId)
    // - ...and many more

    // Find all entries for a specific section
    List<PortfolioCopywriting> findByPortfolioCopywritingSectionId(Long portfolioCopywritingSectionId);
}
