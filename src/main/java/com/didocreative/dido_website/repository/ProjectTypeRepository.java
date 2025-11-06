package com.didocreative.dido_website.repository;

import com.didocreative.dido_website.model.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long> {

    // JpaRepository<ProjectType, Long> gives us:
    // - save(ProjectType entity)
    // - findById(Long projectTypeId)
    // - findAll()
    // - deleteById(Long projectTypeId)
    // - ...and many more

    // Get ProjectTypes by key
    List<ProjectType> findByKey(String key);

    // Get ProjectTypes by value
    List<ProjectType> findByValue(String value);

    // Get ProjectTypes by description
    List<ProjectType> findByDescription(String description);
}
