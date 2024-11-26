package com.sprint.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class TaskCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @OneToMany(mappedBy = "taskCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    // Constructors
    public TaskCategory() {}


    // Getters and setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
