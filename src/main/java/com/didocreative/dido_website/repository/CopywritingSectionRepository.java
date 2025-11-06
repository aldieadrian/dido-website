package com.didocreative.dido_website.repository;

import com.didocreative.dido_website.model.PortfolioCopywritingSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopywritingSectionRepository extends JpaRepository<PortfolioCopywritingSection, Long> {

    // JpaRepository<CopywritingSection, Long> gives us:
    // - save(CopywritingSection entity)
    // - findById(Long copywritingSectionId)
    // - findAll()
    // - deleteById(Long copywritingSectionId)
    // - ...and many more

    // Get CopywritingSections by copywritingSectionKey
    List<PortfolioCopywritingSection> findByCopywritingSectionKey(String copywritingSectionKey);

    // Get CopywritingSections by copywritingSectionValue
    List<PortfolioCopywritingSection> findByCopywritingSectionValue(String copywritingSectionValue);

    // Get CopywritingSections by copywritingSectionDescription
    List<PortfolioCopywritingSection> findByCopywritingSectionDescription(String copywritingSectionDescription);
}
