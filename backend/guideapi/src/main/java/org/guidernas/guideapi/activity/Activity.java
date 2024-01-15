package org.guidernas.guideapi.activity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.guidernas.guideapi.user.customer.Customer;
import org.guidernas.guideapi.user.guide.Guide;
import org.guidernas.guideapi.user.organization.Organization;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="status", nullable = false)
    private String status;

    @Column(name = "description")
    @Size(max = 255)
    private String description;

    //private Point location;

    @FutureOrPresent
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    // maybe a custom validation to ensure end_time isnt before start.
    @FutureOrPresent
    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "host_organization_id")
    private Organization hostOrganization;

    @Enumerated
    private ActivityType type;

    @ManyToMany
    @JoinTable(
            name = "activity_guide",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "guide_id")
    )
    private Set<Guide> leaders = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "activity_attendee",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> attendees = new HashSet<>();

    private boolean isEnded;
    private boolean isStarted;
}
