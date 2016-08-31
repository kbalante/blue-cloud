package com.hyperblue.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

/**
 * Project entity
 */
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "project_key", nullable = false)
    private String projectKey;

    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate ;

    @Column(name = "owner_user_id")
    private Long ownerUserID ;

    @Column(name = "lead_user_id")
    private Long leadUserID ;

    @JsonManagedReference
    @OneToMany(mappedBy="project", targetEntity=Task.class, fetch=FetchType.LAZY)
    private Collection tasks;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Long getOwnerUserID() {
        return ownerUserID;
    }

    public void setOwnerUserID(Long ownerUserID) {
        this.ownerUserID = ownerUserID;
    }

    public Long getLeadUserID() {
        return leadUserID;
    }

    public void setLeadUserID(Long leadUserID) {
        this.leadUserID = leadUserID;
    }

    public Collection getTasks() {
        return tasks;
    }

    public void setTasks(Collection tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projectKey='" + projectKey + '\'' +
                ", isPrivate=" + isPrivate +
                ", ownerUserID=" + ownerUserID +
                ", leadUserID=" + leadUserID +
                '}';
    }
}
