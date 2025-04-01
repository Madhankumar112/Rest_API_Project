package com.example.demo.Services;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null); // Handle not found case appropriately
    }

    // Create a new user
    public User createUser (User user) {
        return userRepository.save(user);
    }

    // Update an existing user
    public User updateUser (Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id); // Set the ID to ensure the correct user is updated
            return userRepository.save(user);
        }
        return null; // Or throw an exception if the user does not exist
    }

    // Delete a user by ID
    public void deleteUser (Long id) {
        userRepository.deleteById(id);
    }

    // Retrieve all users sorted by name
    public List<User> getAllUsersSortedByName() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    // Retrieve all users sorted by a specific field
    public List<User> getAllUsersSortedByField(String sortField) {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, sortField));
    }

    public Page<User> getUsersPage(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    public List<User> getAllUsersSorted(String sortBy) {
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
        return userRepository.findAll(sort);
    }
}
