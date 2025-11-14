package com.didocreative.dido_website.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "case_study_copywriting")
public class CaseStudyCopywriting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseStudyCopywritingId;

    @Column(nullable = false)
    private Long caseStudyCopywritingSectionId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String copytext;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date modifiedTime;

    public CaseStudyCopywriting() {
    }

    public CaseStudyCopywriting(Long caseStudyCopywritingId, Long caseStudyCopywritingSectionId, String copytext,
                                Date createdTime, Date modifiedTime) {
        this.caseStudyCopywritingId = caseStudyCopywritingId;
        this.caseStudyCopywritingSectionId = caseStudyCopywritingSectionId;
        this.copytext = copytext;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Long getCaseStudyCopywritingId() {
        return caseStudyCopywritingId;
    }

    public void setCaseStudyCopywritingId(Long caseStudyCopywritingId) {
        this.caseStudyCopywritingId = caseStudyCopywritingId;
    }

    public Long getCaseStudyCopywritingSectionId() {
        return caseStudyCopywritingSectionId;
    }

    public void setCaseStudyCopywritingSectionId(Long caseStudyCopywritingSectionId) {
        this.caseStudyCopywritingSectionId = caseStudyCopywritingSectionId;
    }

    public String getCopytext() {
        return copytext;
    }

    public void setCopytext(String copytext) {
        this.copytext = copytext;
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
        return "CaseStudyCopywriting{" +
                "caseStudyCopywritingId=" + caseStudyCopywritingId +
                ", caseStudyCopywritingSectionId=" + caseStudyCopywritingSectionId +
                '}';
    }
}
