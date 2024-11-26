package com.sprint.demo.serviceimpl;

import com.sprint.demo.entity.Task;
import com.sprint.demo.repository.TaskRepository;
import com.sprint.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Get all tasks
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get a task by its ID
    @Override
    public Task getTaskById(int taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        return taskOptional.orElseThrow(() -> new RuntimeException("Task not found"));
    }

    // Create a new task
    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Update an existing task
    @Override
    public Task updateTask(int taskId, Task task) {
        if (!taskRepository.existsById(taskId)) {
            throw new RuntimeException("Task not found");
        }
        task.setTaskId(taskId); // Ensure the ID is set to the correct value
        return taskRepository.save(task);
    }

    // Delete a task by ID
    @Override
    public void deleteTask(int taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new RuntimeException("Task not found");
        }
        taskRepository.deleteById(taskId);
    }
}


