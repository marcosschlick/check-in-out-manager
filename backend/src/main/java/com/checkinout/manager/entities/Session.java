package com.checkinout.manager.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Schema(description = "Entity representing a session within an event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sessions")
public class Session {
    @Schema(description = "Unique ID of the session", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Name of the session", example = "Keynote Presentation")
    @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
    @Column(nullable = false, length = 255, unique = true)
    private String name;

    @Schema(description = "Description of the session", example = "Opening keynote with industry leaders", nullable = true)
    @Column(columnDefinition = "TEXT")
    private String description;

    @Schema(description = "Event this session belongs to", implementation = Event.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Schema(description = "Start time of the session", example = "2025-02-15T09:00:00")
    @Future(message = "Start time must be in the future")
    private LocalDateTime startTime;

    @Schema(description = "End time of the session", example = "2025-02-15T10:30:00")
    @Future(message = "End time must be in the future")
    private LocalDateTime endTime;

    @AssertTrue(message = "End time must be after start time")
    public boolean isEndTimeAfterStartTime() {
        return endTime == null || startTime == null || endTime.isAfter(startTime);
    }

    @Schema(description = "Timestamp when the session was created", example = "2025-01-15T10:30:00")
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the session was deactivated", example = "2025-03-20T14:45:00", nullable = true)
    @Column(name = "deactivated_at")
    private LocalDateTime deactivatedAt;
}
