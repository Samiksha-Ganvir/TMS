package com.sprint.demo.repository;

import com.sprint.demo.entity.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Integer> {

    // Find all TaskCategory associations for a specific task
    List<TaskCategory> findByTasks_TaskId(int taskId);
}
