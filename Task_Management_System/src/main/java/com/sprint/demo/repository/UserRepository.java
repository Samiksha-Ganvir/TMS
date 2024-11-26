package com.sprint.demo.repository;



import com.sprint.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    List<User> findByUsernameContainingIgnoreCase(String name);
    
    // New method to find users by full name
    List<User> findByFullNameContainingIgnoreCase(String fullName);  // Case-insensitive search by full name
	boolean existsByUsername(String username);
}
