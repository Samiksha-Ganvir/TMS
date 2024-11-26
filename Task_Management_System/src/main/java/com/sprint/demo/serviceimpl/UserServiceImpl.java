package com.sprint.demo.serviceimpl;

import com.sprint.demo.entity.User;
import com.sprint.demo.exception.UserAlreadyExistsException;
import com.sprint.demo.exception.UserNotFoundException;
import com.sprint.demo.repository.UserRepository;
import com.sprint.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Override
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
    public User createUser(User user) {
        // Check if user already exists
        if (userRepository.existsByUsername(user.getUsername()) || userRepository.existsByUsername(user.getEmail())) {
            throw new UserAlreadyExistsException("User with username " + user.getUsername() + " or email " + user.getEmail() + " already exists.");
        }
        return userRepository.save(user);
    }


//    @Override
//    public User getUserById(Integer userId) {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//    }
    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Integer userId, User user) {
        User existingUser = getUserById(userId);
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setFullName(user.getFullName());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> searchUsersByName(String name) {
        return userRepository.findByUsernameContainingIgnoreCase(name);
    }

    @Override
    public List<User> searchUsersByFullName(String fullName) {
        return userRepository.findByFullNameContainingIgnoreCase(fullName);  // New method for full name search
    }
}

