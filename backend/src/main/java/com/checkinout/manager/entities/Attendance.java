package com.checkinout.manager.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Schema(description = "Entity representing an attendance record")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attendances", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "session_id"}))
public class Attendance {
    @Schema(description = "Unique ID of the attendance record", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "User who attended", implementation = User.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Schema(description = "Session attended", implementation = Session.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @Schema(description = "Timestamp when user checked in", example = "2025-02-15T08:45:00")
    @Column(name = "check_in_time", nullable = false)
    private LocalDateTime checkInTime;

    @Schema(description = "Timestamp when user checked out", example = "2025-02-15T10:20:00", nullable = true)
    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @AssertTrue(message = "Check-out time must be after check-in time")
    public boolean isValidCheckOutTime() {
        return checkOutTime == null || checkOutTime.isAfter(checkInTime);
    }

    @Schema(description = "Timestamp when the record was created", example = "2025-02-15T10:30:00")
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was deactivated", example = "2025-03-20T14:45:00", nullable = true)
    @Column(name = "deactivated_at")
    private LocalDateTime deactivatedAt;
}
