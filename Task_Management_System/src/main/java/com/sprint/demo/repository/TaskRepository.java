//package com.sprint.demo.repository;
//
//
//import com.sprint.demo.entity.Task;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface TaskRepository extends JpaRepository<Task, Integer> {
//
//    List<Task> findByStatus(String status);
//
//    List<Task> findByUserId(int userId);
//
//    List<Task> findByProjectId(int projectId);
//}
package com.sprint.demo.repository;

import com.sprint.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	    // Find tasks by status
	    List<Task> findByStatus(String status);

	    // Find tasks by userId (updated to use correct reference for User)
	    List<Task> findByUser_UserId(Integer userId);

	    // Find tasks by projectId
	    List<Task> findByProject_ProjectId(int projectId);

	    // Find tasks by userId and status (updated to use correct reference for User)
	    List<Task> findByUser_UserIdAndStatus(Integer userId, String status);

	    // Find tasks by priority and status
	    List<Task> findByPriorityAndStatus(String priority, String status);

	    // Find tasks by due date before and status not equal to the specified value
	    List<Task> findByDueDateBeforeAndStatusNot(LocalDate dueDate, String status);

	    List<Task> findByTaskCategory_CategoryId(int categoryId);
	}

