package com.hyperblue.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Task entity
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="project_id", referencedColumnName="id")
    private Project project;

    @Column(name = "summary", nullable = false)
    private String summary;

    @Column(name = "description")
    private String description ;

    @Column(name = "status")
    private String status ;

    @Column(name = "priority")
    private String priority ;

    @Column(name = "owner_user_id", nullable = false)
    private Long ownerUserID ;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getOwnerUserID() {
        return ownerUserID;
    }

    public void setOwnerUserID(Long ownerUserID) {
        this.ownerUserID = ownerUserID;
    }

    @Override
    public String toString() {
        return "Task{" +
                "project=" + project +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", ownerUserID=" + ownerUserID +
                '}';
    }
}
