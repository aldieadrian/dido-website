package com.didocreative.dido_website.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

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

    // Constructor
    public Portfolio() {
    }

    public Portfolio(Long portfolioId, String title, Long projectTypeId,
                     String coverImageUrl, Date createdTime, Date modifiedTime) {
        this.portfolioId = portfolioId;
        this.title = title;
        this.projectTypeId = projectTypeId;
        this.coverImageUrl = coverImageUrl;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
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

    // toString method
    @Override
    public String toString() {
        return "Portfolio{" +
                "portfolioId=" + portfolioId +
                ", title='" + title + '\'' +
                ", projectTypeId=" + projectTypeId +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                '}';
    }
}
