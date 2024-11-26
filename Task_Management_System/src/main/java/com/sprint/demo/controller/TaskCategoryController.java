//package com.sprint.demo.controller;
//
//import com.sprint.demo.entity.TaskCategory;
//import com.sprint.demo.service.TaskCategoryService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("api/taskCategory")
//public class TaskCategoryController {
//
//    private TaskCategoryService taskCategoryService;
//
//    @PostMapping("/post")
//    public TaskCategory createTaskCategory(@RequestBody TaskCategory taskCategory) {
//        return taskCategoryService.saveTaskCategory(taskCategory);
//    }
//
//    @GetMapping("category/{categoryId}")
//    public TaskCategory getTaskCategory1(@PathVariable int categoryId) {
//        return taskCategoryService.getTaskCategory(categoryId);
//    }
//    
//    @GetMapping("task/{taskId}")
//    public TaskCategory getTaskCategory(@PathVariable int categoryId) {
//        return taskCategoryService.getTaskCategory(categoryId);
//    }
//}
package com.sprint.demo.controller;

import com.sprint.demo.entity.TaskCategory;
import com.sprint.demo.service.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taskCategories")
public class TaskCategoryController {

    private final TaskCategoryService taskCategoryService;

    public TaskCategoryController(TaskCategoryService taskCategoryService) {
        this.taskCategoryService = taskCategoryService;
    }

    // Get all task categories
    @GetMapping("/all")
    public ResponseEntity<List<TaskCategory>> getAllTaskCategories() {
        List<TaskCategory> taskCategories = taskCategoryService.getAllTaskCategories();
        return new ResponseEntity<>(taskCategories, HttpStatus.OK);
    }

    // Get a task category by its ID
    @GetMapping("/{categoryId}")
    public ResponseEntity<TaskCategory> getTaskCategoryById(@PathVariable int categoryId) {
        try {
            TaskCategory taskCategory = taskCategoryService.getTaskCategoryById(categoryId);
            return new ResponseEntity<>(taskCategory, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Create a new task category
    @PostMapping
    public ResponseEntity<TaskCategory> createTaskCategory(@RequestBody TaskCategory taskCategory) {
        TaskCategory createdTaskCategory = taskCategoryService.createTaskCategory(taskCategory);
        return new ResponseEntity<>(createdTaskCategory, HttpStatus.CREATED);
    }

    // Update an existing task category
    @PutMapping("/{categoryId}")
    public ResponseEntity<TaskCategory> updateTaskCategory(
            @PathVariable int categoryId, @RequestBody TaskCategory taskCategory) {
        try {
            TaskCategory updatedTaskCategory = taskCategoryService.updateTaskCategory(categoryId, taskCategory);
            return new ResponseEntity<>(updatedTaskCategory, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete a task category by ID
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteTaskCategory(@PathVariable int categoryId) {
        try {
            taskCategoryService.deleteTaskCategory(categoryId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
