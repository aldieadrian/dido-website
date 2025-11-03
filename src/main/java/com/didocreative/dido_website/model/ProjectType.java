package com.didocreative.dido_website.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "project_type")
public class ProjectType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectTypeId;

    @Column(nullable = false, length = 256)
    private String projectTypeKey;

    @Column(nullable = false, length = 512)
    private String projectTypeValue;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String projectTypeDescription;

    @Column(nullable = false, updatable = false)
    private Date createdTime;

    @Column(nullable = false)
    private Date modifiedTime;

    // Constructor
    public ProjectType() {
    }

    public ProjectType(Long projectTypeId, String projectTypeKey,
                       String projectTypeValue, String projectTypeDescription,
                       Date createdTime, Date modifiedTime) {
        this.projectTypeId = projectTypeId;
        this.projectTypeKey = projectTypeKey;
        this.projectTypeValue = projectTypeValue;
        this.projectTypeDescription = projectTypeDescription;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    // Getter Setter
    public Long getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Long projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public String getProjectTypeKey() {
        return projectTypeKey;
    }

    public void setProjectTypeKey(String projectTypeKey) {
        this.projectTypeKey = projectTypeKey;
    }

    public String getProjectTypeValue() {
        return projectTypeValue;
    }

    public void setProjectTypeValue(String projectTypeValue) {
        this.projectTypeValue = projectTypeValue;
    }

    public String getProjectTypeDescription() {
        return projectTypeDescription;
    }

    public void setProjectTypeDescription(String projectTypeDescription) {
        this.projectTypeDescription = projectTypeDescription;
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
        return "ProjectType{" +
                "projectTypeId=" + projectTypeId +
                ", projectTypeKey='" + projectTypeKey + '\'' +
                ", projectTypeDescription='" + projectTypeDescription + '\'' +
                '}';
    }
}
