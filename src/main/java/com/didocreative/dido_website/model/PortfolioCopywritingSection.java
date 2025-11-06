package com.didocreative.dido_website.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "portfolio_copywriting_section")
public class PortfolioCopywritingSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioCopywritingSectionId;

    @Column(nullable = false) // Foreign key to Portfolio
    private Long portfolioId;

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

    // Constructor
    public PortfolioCopywritingSection() {
    }

    public PortfolioCopywritingSection(Long portfolioCopywritingSectionId, Long portfolioId,
                                       String key, String value, String description,
                                       Date createdTime, Date modifiedTime) {
        this.portfolioCopywritingSectionId = portfolioCopywritingSectionId;
        this.portfolioId = portfolioId;
        this.key = key;
        this.value = value;
        this.description = description;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    // Getter Setter
    public Long getPortfolioCopywritingSectionId() {
        return portfolioCopywritingSectionId;
    }

    public void setPortfolioCopywritingSectionId(Long portfolioCopywritingSectionId) {
        this.portfolioCopywritingSectionId = portfolioCopywritingSectionId;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
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
        return "PortfolioCopywritingSection{" +
                "portfolioCopywritingSectionId=" + portfolioCopywritingSectionId +
                ", portfolioId=" + portfolioId +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
