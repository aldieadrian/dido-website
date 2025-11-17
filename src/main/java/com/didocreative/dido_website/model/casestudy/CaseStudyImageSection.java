package com.didocreative.dido_website.model.casestudy;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "case_study_image_section")
public class CaseStudyImageSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseStudyImageSectionId;

    @Column(nullable = false)
    private Long caseStudyId;

    @Column(nullable = false, length = 256)
    private String key;

    @Column(nullable = false, length = 512)
    private String value;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date modifiedTime;

    public CaseStudyImageSection() {
    }

    public CaseStudyImageSection(Long caseStudyImageSectionId, Long caseStudyId, String key, String value,
                                 String description, Date createdTime, Date modifiedTime) {
        this.caseStudyImageSectionId = caseStudyImageSectionId;
        this.caseStudyId = caseStudyId;
        this.key = key;
        this.value = value;
        this.description = description;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Long getCaseStudyImageSectionId() {
        return caseStudyImageSectionId;
    }

    public void setCaseStudyImageSectionId(Long caseStudyImageSectionId) {
        this.caseStudyImageSectionId = caseStudyImageSectionId;
    }

    public Long getCaseStudyId() {
        return caseStudyId;
    }

    public void setCaseStudyId(Long caseStudyId) {
        this.caseStudyId = caseStudyId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "CaseStudyImageSection{" +
                "caseStudyImageSectionId=" + caseStudyImageSectionId +
                ", caseStudyId=" + caseStudyId +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
