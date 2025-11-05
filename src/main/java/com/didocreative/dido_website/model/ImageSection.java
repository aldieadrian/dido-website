package com.didocreative.dido_website.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "image_section")
public class ImageSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageSectionId;

    @Column(nullable = false, length = 256)
    private String imageSectionKey;

    @Column(nullable = false, length = 512)
    private String imageSectionValue;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String imageSectionDescription;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date modifiedTime;

    // Constructor
    public ImageSection() {
    }

    public Long getImageSectionId() {
        return imageSectionId;
    }

    public void setImageSectionId(Long imageSectionId) {
        this.imageSectionId = imageSectionId;
    }

    public String getImageSectionKey() {
        return imageSectionKey;
    }

    public void setImageSectionKey(String imageSectionKey) {
        this.imageSectionKey = imageSectionKey;
    }

    public String getImageSectionValue() {
        return imageSectionValue;
    }

    public void setImageSectionValue(String imageSectionValue) {
        this.imageSectionValue = imageSectionValue;
    }

    public String getImageSectionDescription() {
        return imageSectionDescription;
    }

    public void setImageSectionDescription(String imageSectionDescription) {
        this.imageSectionDescription = imageSectionDescription;
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
        return "ImageSection{" +
                "imageSectionId=" + imageSectionId +
                ", imageSectionKey='" + imageSectionKey + '\'' +
                ", imageSectionValue='" + imageSectionValue + '\'' +
                '}';
    }
}
