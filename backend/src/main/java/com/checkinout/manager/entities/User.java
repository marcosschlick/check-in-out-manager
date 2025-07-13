package com.checkinout.manager.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "Entity representing a system user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "document"), @UniqueConstraint(columnNames = "email")})
public class User {
    @Schema(description = "Unique ID of the user", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Full name of the user", example = "Alfredo Palmer")
    @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
    @Column(nullable = false, length = 255)
    private String name;

    @Schema(description = "Identification document (11-digit CPF or 8-digit Uruguayan ID)", example = "44424166058")
    @Pattern(regexp = "^\\d{8}$|^\\d{11}$", message = "Document must be 8 or 11 digits")
    @Column(nullable = false, length = 11, unique = true)
    private String document;

    @Schema(description = "User's email address", example = "user@example.com")
    @Email(message = "Invalid email format")
    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Schema(description = "User's date of birth", example = "2000-6-28")
    @Past(message = "Birth date must be in the past")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Schema(description = "Hashed user password", example = "$2a$10$E7sZlCb7jX3oQ5Z4U1zJvO.8s9s0KbX0Jc8vY2rT3d4n5v6c7d8e9f0g")
    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Schema(description = "URL of the user's profile picture", example = "https://example.com/profile/user.jpg", nullable = true)
    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Schema(description = "Timestamp when the user was created", example = "2025-01-15T10:30:00")
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the user was deactivated (if applicable)", example = "2025-03-20T14:45:00", nullable = true)
    @Column(name = "deactivated_at")
    private LocalDateTime deactivatedAt;
}