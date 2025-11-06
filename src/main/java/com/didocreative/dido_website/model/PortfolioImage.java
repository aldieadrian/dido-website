package com.didocreative.dido_website.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "portfolio_image")
public class PortfolioImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioImageId;

    @Column(nullable = false) // Foreign key to PortfolioImageSection
    private Long portfolioImageSectionId;

    @Column(nullable = false, length = 1024)
    private String imageUrl;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date modifiedTime;

    // Constructor
    public PortfolioImage() {
    }

    public PortfolioImage(Long portfolioImageId, Long portfolioImageSectionId,
                          String imageUrl, Date createdTime, Date modifiedTime) {
        this.portfolioImageId = portfolioImageId;
        this.portfolioImageSectionId = portfolioImageSectionId;
        this.imageUrl = imageUrl;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Long getPortfolioImageId() {
        return portfolioImageId;
    }

    public void setPortfolioImageId(Long portfolioImageId) {
        this.portfolioImageId = portfolioImageId;
    }

    public Long getPortfolioImageSectionId() {
        return portfolioImageSectionId;
    }

    public void setPortfolioImageSectionId(Long portfolioImageSectionId) {
        this.portfolioImageSectionId = portfolioImageSectionId;
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

    // toString method
    @Override
    public String toString() {
        return "PortfolioImage{" +
                "portfolioImageId=" + portfolioImageId +
                ", portfolioImageSectionId=" + portfolioImageSectionId +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
