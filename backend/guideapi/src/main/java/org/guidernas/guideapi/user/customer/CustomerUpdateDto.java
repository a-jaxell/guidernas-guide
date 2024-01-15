package org.guidernas.guideapi.user.customer;

import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link Customer}
 */
public record CustomerUpdateDto(Long id, @Size(max = 255) String firstName,
                                @Size(max = 255) String lastName) implements Serializable {
}