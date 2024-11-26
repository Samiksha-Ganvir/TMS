package com.sprint.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.demo.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    // Custom queries can be added here if needed
	List<Project> findByStartDateBeforeAndEndDateAfter(LocalDate startDate, LocalDate endDate);
//	List<Project> findByStartDateBetweenAndEndDateBetween(LocalDate startDate, LocalDate endDate);
}

