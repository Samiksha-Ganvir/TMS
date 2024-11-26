package com.sprint.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.demo.entity.Project;
import com.sprint.demo.entity.User;
import com.sprint.demo.exception.ProjectAlreadyExistException;
import com.sprint.demo.exception.ProjectNotFoundException;
import com.sprint.demo.exception.UserNotFoundException;
import com.sprint.demo.repository.ProjectRepository;
import com.sprint.demo.repository.UserRepository;
import com.sprint.demo.service.ProjectService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

//   @Override
//    public Project saveProject(Project project) {
//        return projectRepository.save(project);
//    }
   
   @Override
   public Project saveProject(Project project) {
       Optional<Project> existingProject = projectRepository.findById(project.getProjectId());
       if (existingProject.isPresent()) {
           throw new ProjectAlreadyExistException("Project with ID " + project.getProjectId() + " already exists.");
       }
       return projectRepository.save(project);
   }
//    public Project saveProject(Project project) {
//        // Ensure userId is properly fetched and set in the project
//        User user = userRepository.findById(project.getUserId())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        // Set the user to the project
//        project.setUser(user);  // Assuming the Project entity has a setUser() method
//
//        // Save the project
//        return projectRepository.save(project);
//    }

    

    @Override
    public Project getProjectById(Integer projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Integer projectId, Project updatedProject) {
        if (projectRepository.existsById(projectId)) {
            updatedProject.setProjectId(projectId);
            return projectRepository.save(updatedProject);
        }
        return null;
    }

    @Override
    public void deleteProject(Integer projectId) {
        projectRepository.deleteById(projectId);
    }

 //   @Override
//    public Project assignUserToProject(Integer projectId, Integer userId) {
//        Project project = projectRepository.findById(projectId).orElse(null);
//        User user = userRepository.findById(userId).orElse(null);
//
//        if (project != null && user != null) {
//            project.setUser(user);
//            return projectRepository.save(project);
//        }
//        return null;
//    }
//    public Project assignUserToProject(Integer projectId, Integer userId) {
//        // Fetch the project by its ID
//        Project project = projectRepository.findById(projectId).orElse(null);
//        if (project == null) {
//            return null; // Project not found, return null
//        }
//
//        // Fetch the user by their ID
//        User user = userRepository.findById(userId).orElse(null);
//        if (user == null) {
//            return null; // User not found, return null
//        }
//
//        // Set the user for the project
//        project.setUser(user); // Ensure the setUser() method is properly setting the user
//
//        // Save the project with the assigned user
//        return projectRepository.save(project);
//    }
    @Override
    public Project assignUserToProject(Integer projectId, Integer userId) {
        // Fetch the project by its ID
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException("Project with ID " + projectId + " not found"));

        // Fetch the user by their ID
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

        // Set the user for the project
        project.setUser(user);

        // Save the project with the assigned user
        return projectRepository.save(project);
    }
   
    public List<Project> getOngoingProjects() {
        LocalDate currentDate = LocalDate.now();
        return projectRepository.findByStartDateBeforeAndEndDateAfter(currentDate, currentDate);
    }
    
//    public List<Project> getProjectsByDateRange(LocalDate startDate, LocalDate endDate) {
//        return projectRepository.findByStartDateBetweenAndEndDateBetween(startDate, endDate);
//    }





}
