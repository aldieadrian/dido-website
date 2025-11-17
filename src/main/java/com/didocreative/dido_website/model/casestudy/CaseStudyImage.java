package com.didocreative.dido_website.model.casestudy;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "case_study_image")
public class CaseStudyImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseStudyImageId;

    @Column(nullable = false) // Foreign key to CaseStudyImageSection
    private Long caseStudyImageSectionId;

    @Column(nullable = false, length = 1024)
    private String imageUrl;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date modifiedTime;

    public CaseStudyImage() {
    }

    public CaseStudyImage(Long caseStudyImageId, Long caseStudyImageSectionId, String imageUrl,
                          Date createdTime, Date modifiedTime) {
        this.caseStudyImageId = caseStudyImageId;
        this.caseStudyImageSectionId = caseStudyImageSectionId;
        this.imageUrl = imageUrl;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Long getCaseStudyImageId() {
        return caseStudyImageId;
    }

    public void setCaseStudyImageId(Long caseStudyImageId) {
        this.caseStudyImageId = caseStudyImageId;
    }

    public Long getCaseStudyImageSectionId() {
        return caseStudyImageSectionId;
    }

    public void setCaseStudyImageSectionId(Long caseStudyImageSectionId) {
        this.caseStudyImageSectionId = caseStudyImageSectionId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        return "CaseStudyImage{" +
                "caseStudyImageId=" + caseStudyImageId +
                ", caseStudyImageSectionId=" + caseStudyImageSectionId +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
