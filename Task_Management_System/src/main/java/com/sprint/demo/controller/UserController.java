//package com.sprint.demo.controller;
//
//import com.sprint.demo.entity.User;
//import com.sprint.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/post")
////    public User createUser(@RequestBody User user) {
////        return userService.createUser(user);
////    }
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User createdUser = userService.createUser(user);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
////    public User getUserById(@PathVariable Integer id) {
////        return userService.getUserById(id);
////    }
//  
//
//
//    public ResponseEntity<List<User>> searchUsersByName(@PathVariable String name) {
//        List<User> users = userService.searchUsersByName(name);
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("/search/fullname/{fullName}")
//    public List<User> searchUsersByFullName(@PathVariable String fullName) {
//        return userService.searchUsersByFullName(fullName);  // New endpoint to search by full name
//    }
//
//    @GetMapping("/all")
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @PutMapping("/update/{id}")
//    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteUser(@PathVariable Integer id) {
//        userService.deleteUser(id);
//    }
//}
//


package com.sprint.demo.controller;

import com.sprint.demo.entity.User;
import com.sprint.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping("/post")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Get a user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Get all users
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Update an existing user
    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User updatedUser) {
        User user = userService.updateUser(userId, updatedUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Delete a user
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Search users by username
    @GetMapping("/search/{name}")
    public ResponseEntity<List<User>> searchUsersByName(@PathVariable String name) {
        List<User> users = userService.searchUsersByName(name);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Search users by full name
    @GetMapping("/search/fullname/{fullName}")
    public ResponseEntity<List<User>> searchUsersByFullName(@PathVariable String fullName) {
        List<User> users = userService.searchUsersByFullName(fullName);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
