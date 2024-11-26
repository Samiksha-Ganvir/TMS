//package com.sprint.demo.service;
//
//import java.util.List;
//
//import com.sprint.demo.entity.TaskCategory;
//
//public interface TaskCategoryService {
//
//    TaskCategory saveTaskCategory(TaskCategory taskCategory);
//
//    TaskCategory getTaskCategory(int categoryId);
//
//	TaskCategory updateTaskCategory(int categoryId, TaskCategory taskCategory);
//
//	TaskCategory createTaskCategory(TaskCategory taskCategory);
//
//	TaskCategory getTaskCategoryById(int categoryId);
//
//	List<TaskCategory> getAllTaskCategories();
//}
//
//

package com.sprint.demo.service;

import com.sprint.demo.entity.TaskCategory;

import java.util.List;

public interface TaskCategoryService {

    TaskCategory saveTaskCategory(TaskCategory taskCategory);

    TaskCategory getTaskCategory(int categoryId);

    TaskCategory updateTaskCategory(int categoryId, TaskCategory taskCategory);

    TaskCategory createTaskCategory(TaskCategory taskCategory);

    TaskCategory getTaskCategoryById(int categoryId);

    List<TaskCategory> getAllTaskCategories();

	void deleteTaskCategory(int categoryId);
}
