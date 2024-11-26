package com.sprint.demo.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.demo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Custom query methods can be added here if needed
}

