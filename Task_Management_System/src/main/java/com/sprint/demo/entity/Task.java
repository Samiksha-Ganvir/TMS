//package com.sprint.demo.entity;
//
//
//import java.time.LocalDate;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class Task {
//
//	@Id
//	//@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "Task_ID")
//    private int taskId;
//
//	@Column(name = "Due_Date")
//    private LocalDate dueDate; 
//    
//    @Column(name = "Task_Name")
//    private String taskName;
//    
//    @Column(name = "Description")
//    private String description;
//    
//    @Column(name = "Priority")
//    private String priority;
//    
//    @Column(name = "Status")
//    private String status;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Project_ID")
//    @JsonIgnore
//    private Project project;
//    
//    @ManyToOne(fetch = FetchType.LAZY) 
//    @JoinColumn(name = "User_ID")
//    @JsonIgnore
//    private User user; 
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "task_category_mapping", 
//        joinColumns = @JoinColumn(name = "task_id"), 
//        inverseJoinColumns = @JoinColumn(name = "category_id")
//    )
//    
//    @ManyToOne
//    @JoinColumn(name = "category_id") // This creates the foreign key column
//    private TaskCategory taskCategory;
//    
//    
//    // Getters and Setters
//    public int getTaskId() {
//        return taskId;
//    }
//
//    public void setTaskId(int taskId) {
//        this.taskId = taskId;
//    }
//
//    public String getTaskName() {
//        return taskName;
//    }
//
//    public void setTaskName(String taskName) {
//        this.taskName = taskName;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public LocalDate getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(LocalDate dueDate) {
//        this.dueDate = dueDate;
//    }
//
//    public String getPriority() {
//        return priority;
//    }
//
//    public void setPriority(String priority) {
//        this.priority = priority;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
//
//
package com.sprint.demo.entity;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Task_ID")
    private int taskId;

    @Column(name = "Due_Date")
    private LocalDate dueDate;

    @Column(name = "Task_Name")
    private String taskName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Priority")
    private String priority;

    @Column(name = "Status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Project_ID")
    @JsonIgnore
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID")
    @JsonIgnore
    private User user;

    // Removed the redundant @ManyToMany relationship, as the @ManyToOne should handle the task-category association
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id") // Fixed to correctly match schema column
    private TaskCategory taskCategory;

    // Getters and Setters
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskCategory getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(TaskCategory taskCategory) {
        this.taskCategory = taskCategory;
    }

	public void setProject(Project project) {
		// TODO Auto-generated method stub
		
	}

	public Integer getProjectId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getUserId() {
		// TODO Auto-generated method stub
		return null;
	}
}
