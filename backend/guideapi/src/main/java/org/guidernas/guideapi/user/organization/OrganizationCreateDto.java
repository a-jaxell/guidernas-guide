package org.guidernas.guideapi.user.organization;

import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link Organization}
 */
public record OrganizationCreateDto(@Size(max = 255) String organizationName,
                                    @Size(max = 255) String description) implements Serializable {
}