package com.didocreative.dido_website.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "copywriting_section")
public class CopywritingSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long copywritingSectionId;

    @Column(nullable = false, length = 256)
    private String copywritingSectionKey;

    @Column(nullable = false, length = 512)
    private String copywritingSectionValue;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String copywritingSectionDescription;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date modifiedTime;

    // Constructor
    public CopywritingSection() {
    }

    public CopywritingSection(Long copywritingSectionId, String copywritingSectionKey,
                              String copywritingSectionValue, String copywritingSectionDescription,
                              Date createdTime, Date modifiedTime) {
        this.copywritingSectionId = copywritingSectionId;
        this.copywritingSectionKey = copywritingSectionKey;
        this.copywritingSectionValue = copywritingSectionValue;
        this.copywritingSectionDescription = copywritingSectionDescription;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    // Getter Setter
    public Long getCopywritingSectionId() {
        return copywritingSectionId;
    }

    public void setCopywritingSectionId(Long copywritingSectionId) {
        this.copywritingSectionId = copywritingSectionId;
    }

    public String getCopywritingSectionKey() {
        return copywritingSectionKey;
    }

    public void setCopywritingSectionKey(String copywritingSectionKey) {
        this.copywritingSectionKey = copywritingSectionKey;
    }

    public String getCopywritingSectionValue() {
        return copywritingSectionValue;
    }

    public void setCopywritingSectionValue(String copywritingSectionValue) {
        this.copywritingSectionValue = copywritingSectionValue;
    }

    public String getCopywritingSectionDescription() {
        return copywritingSectionDescription;
    }

    public void setCopywritingSectionDescription(String copywritingSectionDescription) {
        this.copywritingSectionDescription = copywritingSectionDescription;
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
        return "CopywritingSection{" +
                "copywritingSectionId=" + copywritingSectionId +
                ", copywritingSectionKey='" + copywritingSectionKey + '\'' +
                ", copywritingSectionValue='" + copywritingSectionValue + '\'' +
                ", copywritingSectionDescription='" + copywritingSectionDescription + '\'' +
                '}';
    }
}
