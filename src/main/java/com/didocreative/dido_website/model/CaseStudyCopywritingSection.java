package com.didocreative.dido_website.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "case_study_copywriting_section")
public class CaseStudyCopywritingSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseStudyCopywritingSectionId;

    @Column(nullable = false) // Foreign key to CaseStudy
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

    public CaseStudyCopywritingSection() {
    }

    public CaseStudyCopywritingSection(Long caseStudyCopywritingSectionId, Long caseStudyId, String key, String value,
                                       String description, Date createdTime, Date modifiedTime) {
        this.caseStudyCopywritingSectionId = caseStudyCopywritingSectionId;
        this.caseStudyId = caseStudyId;
        this.key = key;
        this.value = value;
        this.description = description;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    // Getter Setter
    public Long getCaseStudyCopywritingSectionId() {
        return caseStudyCopywritingSectionId;
    }

    public void setCaseStudyCopywritingSectionId(Long caseStudyCopywritingSectionId) {
        this.caseStudyCopywritingSectionId = caseStudyCopywritingSectionId;
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

    // toString method
    @Override
    public String toString() {
        return "CaseStudyCopywritingSection{" +
                "caseStudyCopywritingSectionId=" + caseStudyCopywritingSectionId +
                ", caseStudyId=" + caseStudyId +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
