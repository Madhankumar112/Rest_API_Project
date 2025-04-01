package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Lombok will generate the setter for this field

    private String name;
    private String email;
    private String password; // Consider hashing passwords in a real application
    private String role; // ATTENDEE, SPEAKER, ORGANIZER
    private String company;

    // No need to manually define setId if using Lombok's @Setter
}