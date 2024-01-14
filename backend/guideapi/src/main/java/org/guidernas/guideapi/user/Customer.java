package org.guidernas.guideapi.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.guidernas.guideapi.activity.Activity;
import org.guidernas.guideapi.qualification.Qualification;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer extends User {

    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "user")
    private Set<Qualification> qualifications = new HashSet<>();

    @ManyToMany(mappedBy = "attendees")
    private Set<Activity> attendedActivities = new HashSet<>();
}
