package com.didocreative.dido_website.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "copywriting")
public class Copywriting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long copywritingId;

    @Column(nullable = false)
    private Long pageId;

    @Column(nullable = false)
    private Long copywritingSectionId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String copytext;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date modifiedTime;

    // Constructor
    public Copywriting() {
    }

    public Copywriting(Long copywritingId, Long pageId,
                       Long copywritingSectionId, String copytext,
                       Date createdTime, Date modifiedTime) {
        this.copywritingId = copywritingId;
        this.pageId = pageId;
        this.copywritingSectionId = copywritingSectionId;
        this.copytext = copytext;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    // Getter Setter
    public Long getCopywritingId() {
        return copywritingId;
    }

    public void setCopywritingId(Long copywritingId) {
        this.copywritingId = copywritingId;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getCopywritingSectionId() {
        return copywritingSectionId;
    }

    public void setCopywritingSectionId(Long copywritingSectionId) {
        this.copywritingSectionId = copywritingSectionId;
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
        return "Copywriting{" +
                "copywritingId=" + copywritingId +
                ", pageId='" + pageId + '\'' +
                ", copywritingSectionId='" + copywritingSectionId + '\'' +
                '}';
    }
}
