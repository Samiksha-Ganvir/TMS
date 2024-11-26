package com.sprint.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.sprint.demo.entity.Project;

public interface ProjectService {

    // Save a project
    Project saveProject(Project project);

    // Get project by ID
    Project getProjectById(Integer projectId);

    // Get all projects
    List<Project> getAllProjects();

    // Update project
    Project updateProject(Integer projectId, Project updatedProject);

    // Delete project
    void deleteProject(Integer projectId);

    // Assign user to project
    Project assignUserToProject(Integer projectId, Integer userId);

	List<Project> getOngoingProjects();

	//List<Project> getProjectsByDateRange(LocalDate startDate, LocalDate endDate);
}

