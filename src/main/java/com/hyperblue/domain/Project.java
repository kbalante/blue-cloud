package com.hyperblue.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;

/**
 * Project entity
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "project_key")
    private String projectKey;

    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate ;

    @Column(name = "owner_user_id", nullable = false)
    private Long owner ;

    @Column(name = "lead_user_id")
    private Long lead;

    @OneToMany(mappedBy="project", targetEntity=Task.class)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Long getLead() {
        return lead;
    }

    public void setLead(Long lead) {
        this.lead = lead;
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
                ", description='" + description + '\'' +
                ", projectKey='" + projectKey + '\'' +
                ", isPrivate=" + isPrivate +
                ", owner=" + owner +
                ", lead=" + lead +
                '}';
    }
}
