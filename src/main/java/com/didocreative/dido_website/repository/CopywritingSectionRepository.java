package com.didocreative.dido_website.repository;

import com.didocreative.dido_website.model.CopywritingSection;
import com.didocreative.dido_website.model.ImageSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopywritingSectionRepository extends JpaRepository<CopywritingSection, Long> {

    // JpaRepository<CopywritingSection, Long> gives us:
    // - save(CopywritingSection entity)
    // - findById(Long copywritingSectionId)
    // - findAll()
    // - deleteById(Long copywritingSectionId)
    // - ...and many more

    // Get CopywritingSections by copywritingSectionKey
    List<CopywritingSection> findByCopywritingSectionKey(String copywritingSectionKey);

    // Get CopywritingSections by copywritingSectionValue
    List<CopywritingSection> findByCopywritingSectionValue(String copywritingSectionValue);

    // Get CopywritingSections by copywritingSectionDescription
    List<CopywritingSection> findByCopywritingSectionDescription(String copywritingSectionDescription);
}
