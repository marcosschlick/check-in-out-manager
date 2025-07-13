package com.checkinout.manager.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Schema(description = "Entity representing an event in the system")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Schema(description = "Unique ID of the event", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Name of the event", example = "Tech Conference 2025")
    @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
    @Column(nullable = false, length = 255)
    private String name;

    @Schema(description = "Unique code of the event (6 uppercase alphanumeric characters)", example = "TC2025")
    @Pattern(regexp = "[A-Z0-9]{6}", message = "Code must be 6 uppercase alphanumeric characters")
    @Column(nullable = false, length = 6, unique = true)
    private String code;

    @Schema(description = "Owner of the event", implementation = User.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Schema(description = "Description of the event", example = "Annual technology conference", nullable = true)
    @Column(columnDefinition = "TEXT")
    private String description;

    @Schema(description = "URL of the event's image", example = "https://example.com/events/event.jpg", nullable = true)
    @Column(name = "image_url", length = 255)
    private String imageUrl;


    @Schema(description = "Timestamp when the event was created", example = "2025-01-15T10:30:00")
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the event was deactivated", example = "2025-03-20T14:45:00", nullable = true)
    @Column(name = "deactivated_at")
    private LocalDateTime deactivatedAt;
}
