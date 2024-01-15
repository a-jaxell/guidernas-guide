package org.guidernas.guideapi.user.guide;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.guidernas.guideapi.activity.Activity;
import org.guidernas.guideapi.qualification.Qualification;
import org.guidernas.guideapi.user.organization.Organization;
import org.guidernas.guideapi.user.Professional;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "guide")
public class Guide extends Professional {

    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "user")
    private Set<Qualification> qualifications = new HashSet<>();

    @ManyToMany(mappedBy = "leaders")
    private Set<Activity> activitiesLed = new HashSet<>();

    @ManyToMany(mappedBy = "guides")
    private Set<Organization> associatedOrganizations = new HashSet<>();
}
