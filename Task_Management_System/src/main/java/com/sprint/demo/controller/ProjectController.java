package com.sprint.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sprint.demo.entity.Project;
import com.sprint.demo.entity.User;
import com.sprint.demo.repository.UserRepository;
import com.sprint.demo.service.ProjectService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    //created
    @Autowired
    private UserRepository userRepository;  // Inject the UserRepository here

    // Create a new project
    @PostMapping("/post")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.saveProject(project);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }
    
//    @PostMapping("/post")
//    public ResponseEntity<Project> createProject(@RequestBody Project project) {
//        // Fetch the user by userId
//        User user = userRepository.findById(project.getUserId())
//                .orElseThrow(() -> new RuntimeException("User with ID " + project.getUserId() + " not found"));
//
//        // Set the user on the project
//        project.setUser(user);
//
//        // Save the project with the associated user
//        Project createdProject = projectService.saveProject(project);
//
//        // Return the created project
//        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
//    }
//    @PostMapping("/post")
//    public ResponseEntity<Project> createProject(@RequestBody Project project) {
//        // Fetch the user by userId (use the 'user' object for the association)
//        User user = userRepository.findById(project.getUser().getUserId())  // Access the User through the project.getUser()
//                .orElseThrow(() -> new RuntimeException("User with ID " + project.getUser().getUserId() + " not found"));
//
//        // Set the user on the project
//        project.setUser(user);
//
//        // Save the project with the associated user
//        Project createdProject = projectService.saveProject(project);
//
//        // Return the created project
//        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
//    }




    // Get all projects
    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    // Get project by ID
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Integer id) {
        Project project = projectService.getProjectById(id);
        return project != null ? new ResponseEntity<>(project, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update an existing project
    @PutMapping("/update/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Integer id, @RequestBody Project updatedProject) {
        Project project = projectService.updateProject(id, updatedProject);
        return project != null ? new ResponseEntity<>(project, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/ongoing")
    public ResponseEntity<List<Project>> getOngoingProjects() {
        List<Project> ongoingProjects = projectService.getOngoingProjects();
        return new ResponseEntity<>(ongoingProjects, HttpStatus.OK);
    }
    
//    @GetMapping("/date-range/{startDate}/{endDate}")
//    public ResponseEntity<List<Project>> getProjectsByDateRange(
//            @PathVariable("startDate") String startDateStr,
//            @PathVariable("endDate") String endDateStr) {
//
//        // Parse the startDate and endDate from String to LocalDate
//        LocalDate startDate = LocalDate.parse(startDateStr);
//        LocalDate endDate = LocalDate.parse(endDateStr);
//
//        // Fetch projects by date range
//        List<Project> projects = projectService.getProjectsByDateRange(startDate, endDate);
//
//        if (projects.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 if no projects are found
//        }
//
//        return new ResponseEntity<>(projects, HttpStatus.OK); // Return the list of projects
//    }
    

    // Delete a project
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Assign a user to a project
    @PutMapping("/{projectId}/assign/{userId}")
    public ResponseEntity<Project> assignUserToProject(@PathVariable Integer projectId, @PathVariable Integer userId) {
        Project updatedProject = projectService.assignUserToProject(projectId, userId);
        return updatedProject != null ? new ResponseEntity<>(updatedProject, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

