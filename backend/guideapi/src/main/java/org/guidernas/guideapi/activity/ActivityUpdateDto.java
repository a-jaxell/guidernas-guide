package org.guidernas.guideapi.activity;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Activity}
 */
public record ActivityUpdateDto(
        @NotNull
        @PositiveOrZero
        Long id,
        String status, @Size(max = 255) String description,
        @FutureOrPresent LocalDateTime startTime, @FutureOrPresent LocalDateTime endTime,
        ActivityType type) implements Serializable {
}