package org.guidernas.guideapi.user.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.guidernas.guideapi.activity.Activity;
import org.guidernas.guideapi.user.Professional;
import org.guidernas.guideapi.user.guide.Guide;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "organization")
public class Organization extends Professional {

    @Size(max = 255)
    @Column(name = "organization_name", nullable = false)
    private String organizationName;

    @Size(max = 255)
    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "organization_associated_guides",
            joinColumns = @JoinColumn(name = "organization_id"),
            inverseJoinColumns = @JoinColumn(name = "guide_id")
    )
    private Set<Guide> guides = new HashSet<>();

    @OneToMany(mappedBy = "hostOrganization")
    private Set<Activity> hostedActivities = new HashSet<>();

}
