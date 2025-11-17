package com.didocreative.dido_website.model.casestudy;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "case_study")
public class CaseStudy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseStudyId;

    @Column(nullable = false, length = 512)
    private String title;

    @Column(nullable = false)
    private Long projectTypeId;

    @Column(length = 1024) // URL for the cover image
    private String coverImageUrl;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date modifiedTime;

    public CaseStudy() {
    }

    public CaseStudy(Long caseStudyId, String title, Long projectTypeId, String coverImageUrl,
                     Date createdTime, Date modifiedTime) {
        this.caseStudyId = caseStudyId;
        this.title = title;
        this.projectTypeId = projectTypeId;
        this.coverImageUrl = coverImageUrl;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Long getCaseStudyId() {
        return caseStudyId;
    }

    public void setCaseStudyId(Long caseStudyId) {
        this.caseStudyId = caseStudyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Long projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
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
        return "CaseStudy{" +
                "caseStudyId=" + caseStudyId +
                ", title='" + title + '\'' +
                ", projectTypeId=" + projectTypeId +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                '}';
    }
}
