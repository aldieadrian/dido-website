package com.didocreative.dido_website.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @Column(nullable = false, length = 512)
    private String portfolioTitle;

    @Column(nullable = false, updatable = false)
    private Date createdTime;

    @Column(nullable = false)
    private Date modifiedTime;

    // --- "Many-to-One" link to ProjectType ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_type_id", nullable = false)
    private ProjectType projectType;

    // Constructor
    public Portfolio() {
    }

    public Portfolio(Long portfolioId, String portfolioTitle,
                     Date createdTime, Date modifiedTime,
                     ProjectType projectType) {
        this.portfolioId = portfolioId;
        this.portfolioTitle = portfolioTitle;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.projectType = projectType;
    }

    // Getter Setter
    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioTitle() {
        return portfolioTitle;
    }

    public void setPortfolioTitle(String portfolioTitle) {
        this.portfolioTitle = portfolioTitle;
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

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    // toString method
    @Override
    public String toString() {
        return "Portfolio{" +
                "portfolioId=" + portfolioId +
                ", portfolioTitle='" + portfolioTitle + '\'' +
                ", projectType='" + projectType + '\'' +
                '}';
    }
}
