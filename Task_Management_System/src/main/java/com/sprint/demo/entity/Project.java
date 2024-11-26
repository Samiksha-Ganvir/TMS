package com.sprint.demo.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "Project")
public class Project {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY) // Uncomment this if the ID should be auto-generated.
    @Column(name = "Project_ID")
    private Integer projectId;

    @Column(name = "Project_Name", nullable = false)
    private String projectName;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "Start_Date")
    private LocalDate startDate;

    @Column(name = "End_Date")
    private LocalDate endDate;
    
    

    @ManyToOne
    @JoinColumn(name = "User_ID", referencedColumnName = "User_ID")
    private User user;

    // Default constructor
    public Project() {
    }

    // Getters and setters
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

