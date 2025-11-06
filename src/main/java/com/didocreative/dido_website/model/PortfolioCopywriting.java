package com.didocreative.dido_website.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "portfolio_copywriting")
public class PortfolioCopywriting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioCopywritingId;

    @Column(nullable = false)
    private Long portfolioCopywritingSectionId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String copytext;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date modifiedTime;

    // Constructor
    public PortfolioCopywriting() {
    }

    public PortfolioCopywriting(Long portfolioCopywritingId, Long portfolioCopywritingSectionId,
                                String copytext, Date createdTime, Date modifiedTime) {
        this.portfolioCopywritingId = portfolioCopywritingId;
        this.portfolioCopywritingSectionId = portfolioCopywritingSectionId;
        this.copytext = copytext;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Long getPortfolioCopywritingId() {
        return portfolioCopywritingId;
    }

    public void setPortfolioCopywritingId(Long portfolioCopywritingId) {
        this.portfolioCopywritingId = portfolioCopywritingId;
    }

    public Long getPortfolioCopywritingSectionId() {
        return portfolioCopywritingSectionId;
    }

    public void setPortfolioCopywritingSectionId(Long portfolioCopywritingSectionId) {
        this.portfolioCopywritingSectionId = portfolioCopywritingSectionId;
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

    // toString method
    @Override
    public String toString() {
        return "PortfolioCopywriting{" +
                "portfolioCopywritingId=" + portfolioCopywritingId +
                ", portfolioCopywritingSectionId=" + portfolioCopywritingSectionId +
                '}';
    }
}
