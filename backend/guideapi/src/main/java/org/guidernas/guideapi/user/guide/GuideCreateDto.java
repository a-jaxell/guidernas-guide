package org.guidernas.guideapi.user.guide;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link Guide}
 */
public record GuideCreateDto(@Size(max = 255) @NotBlank String firstName,
                             @Size(max = 255) @NotBlank String lastName) implements Serializable {
}