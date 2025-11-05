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

    // Get ProjectTypes by projectTypeKey
    List<ProjectType> findByProjectTypeKey(String projectTypeKey);

    // Get ProjectTypes by projectTypeValue
    List<ProjectType> findByProjectTypeValue(String projectTypeValue);

    // Get ProjectTypes by projectTypeDescription
    List<ProjectType> findByProjectTypeDescription(String projectTypeDescription);
}
