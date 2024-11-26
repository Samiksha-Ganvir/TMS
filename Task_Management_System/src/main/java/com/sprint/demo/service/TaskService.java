package com.sprint.demo.service;

import com.sprint.demo.entity.Task;
import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();
    Task getTaskById(int taskId);
    Task createTask(Task task);
    Task updateTask(int taskId, Task task);
    void deleteTask(int taskId);
}

