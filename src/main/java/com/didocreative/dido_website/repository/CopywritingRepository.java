package com.didocreative.dido_website.repository;

import com.didocreative.dido_website.model.Copywriting;
import com.didocreative.dido_website.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopywritingRepository extends JpaRepository<Copywriting, Long> {

    // JpaRepository<Copywriting, Long> gives us:
    // - save(Copywriting entity)
    // - findById(Long copywritingId)
    // - findAll()
    // - deleteById(Long copywritingId)
    // - ...and many more

    // Get Copywritings by pageId
    List<Copywriting> findByPageId(Long pageId);

    // Get Copywritings by copywritingSectionId
    List<Copywriting> findByCopywritingSectionId(Long copywritingSectionId);
}
