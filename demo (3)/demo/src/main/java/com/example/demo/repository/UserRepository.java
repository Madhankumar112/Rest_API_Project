package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByEmail(String email); // Example of a custom query method

    // Custom JPQL query to find all users sorted by a specific field
    @Query("SELECT u FROM User u ORDER BY u.name ASC") // Default sorting by name
    List<User> findAllSortedByName();

    // Custom JPQL query to find all users sorted by a specific field dynamically
    @Query("SELECT u FROM User u ORDER BY CASE WHEN :sortField = 'name' THEN u.name " +"WHEN :sortField = 'email' THEN u.email " +"WHEN :sortField = 'role' THEN u.role " +"ELSE u.name END ASC")
    List<User> findAllSortedByField(@Param("sortField") String sortField);
}