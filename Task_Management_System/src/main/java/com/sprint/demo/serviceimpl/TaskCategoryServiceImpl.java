//package com.sprint.demo.serviceimpl;
//
//import com.sprint.demo.entity.TaskCategory;
//import com.sprint.demo.repository.TaskCategoryRepository;
//import com.sprint.demo.service.TaskCategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TaskCategoryServiceImpl implements TaskCategoryService {
//
//    @Autowired
//    private TaskCategoryRepository taskCategoryRepository;
//
//    // Get all task categories
//    @Override
//    public List<TaskCategory> getAllTaskCategories() {
//        return taskCategoryRepository.findAll();
//    }
//
//    // Get a task category by its ID
//    @Override
//    public TaskCategory getTaskCategoryById(int categoryId) {
//        Optional<TaskCategory> taskCategoryOptional = taskCategoryRepository.findById(categoryId);
//        return taskCategoryOptional.orElseThrow(() -> new RuntimeException("TaskCategory not found"));
//    }
//
//    // Create a new task category
//    @Override
//    public TaskCategory createTaskCategory(TaskCategory taskCategory) {
//        return taskCategoryRepository.save(taskCategory);
//    }
//
//    // Update an existing task category
//    @Override
//    public TaskCategory updateTaskCategory(int categoryId, TaskCategory taskCategory) {
//        if (!taskCategoryRepository.existsById(categoryId)) {
//            throw new RuntimeException("TaskCategory not found");
//        }
//        taskCategory.setCategoryId(categoryId); // Ensure the ID is set to the correct value
//        return taskCategoryRepository.save(taskCategory);
//    }
//
//    // Delete a task category by ID
//    @Override
//    public void deleteTaskCategory(int categoryId) {
//        if (!taskCategoryRepository.existsById(categoryId)) {
//            throw new RuntimeException("TaskCategory not found");
//        }
//        taskCategoryRepository.deleteById(categoryId);
//    }
//
//	@Override
//	public TaskCategory saveTaskCategory(TaskCategory taskCategory) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public TaskCategory getTaskCategory(int categoryId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}

package com.sprint.demo.serviceimpl;

import com.sprint.demo.entity.TaskCategory;
import com.sprint.demo.repository.TaskCategoryRepository;
import com.sprint.demo.service.TaskCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoryServiceImpl implements TaskCategoryService {

    private final TaskCategoryRepository taskCategoryRepository;

    public TaskCategoryServiceImpl(TaskCategoryRepository taskCategoryRepository) {
        this.taskCategoryRepository = taskCategoryRepository;
    }

    // Save a new task category
    @Override
    public TaskCategory saveTaskCategory(TaskCategory taskCategory) {
        return taskCategoryRepository.save(taskCategory);
    }

    // Get task category by ID
    @Override
    public TaskCategory getTaskCategory(int categoryId) {
        return taskCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("TaskCategory not found"));
    }

    // Update an existing task category
    @Override
    public TaskCategory updateTaskCategory(int categoryId, TaskCategory taskCategory) {
        if (!taskCategoryRepository.existsById(categoryId)) {
            throw new RuntimeException("TaskCategory not found");
        }
        taskCategory.setCategoryId(categoryId); // Ensure the ID is set to the correct value
        return taskCategoryRepository.save(taskCategory);
    }

    // Create a new task category
    @Override
    public TaskCategory createTaskCategory(TaskCategory taskCategory) {
        return taskCategoryRepository.save(taskCategory);
    }

    // Get a task category by its ID
    @Override
    public TaskCategory getTaskCategoryById(int categoryId) {
        return taskCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("TaskCategory not found"));
    }

    // Get all task categories
    @Override
    public List<TaskCategory> getAllTaskCategories() {
        return taskCategoryRepository.findAll();
    }

	@Override
	public void deleteTaskCategory(int categoryId) {
		// TODO Auto-generated method stub
		
	}
}
