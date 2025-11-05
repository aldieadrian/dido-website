package com.didocreative.dido_website.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column(nullable = false)
    private Long pageId;

    @Column(nullable = false)
    private Long imageSectionId;

    @Column(nullable = false, length = 1024)
    private String imageUrl;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date modifiedTime;

    // Constructor
    public Image() {
    }

    public Image(Long imageId, Long pageId, Long imageSectionId,
                 String imageUrl,Date createdTime, Date modifiedTime) {
        this.imageId = imageId;
        this.pageId = pageId;
        this.imageSectionId = imageSectionId;
        this.imageUrl = imageUrl;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    // Getter Setter
    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getImageSectionId() {
        return imageSectionId;
    }

    public void setImageSectionId(Long imageSectionId) {
        this.imageSectionId = imageSectionId;
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
        return "Image{" +
                "imageId=" + imageId +
                ", pageId='" + pageId + '\'' +
                ", imageSectionId='" + imageSectionId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
