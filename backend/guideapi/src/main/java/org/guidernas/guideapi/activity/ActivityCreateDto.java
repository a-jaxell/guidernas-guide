package org.guidernas.guideapi.activity;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Activity}
 */
public record ActivityCreateDto(String status, @Size(max = 255) String description,
                                @FutureOrPresent LocalDateTime startTime, @FutureOrPresent LocalDateTime endTime,
                                ActivityType type) implements Serializable {
}