package com.sprint.demo.service;



import com.sprint.demo.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Integer userId);
    List<User> getAllUsers();
    User updateUser(Integer userId, User user);
    void deleteUser(Integer userId);
    List<User> searchUsersByName(String name);
    
    // New method to search users by full name
    List<User> searchUsersByFullName(String fullName);  // Search users by full name
}

