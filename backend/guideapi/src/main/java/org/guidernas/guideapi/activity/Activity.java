package org.guidernas.guideapi.activity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.geolatte.geom.Point;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="status", nullable = false)
    private String status;

    @OneToMany
    @Column(name="required_qualifications")
    private List<Qualification> requiredQualification;

    private String description;

    private Point location;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Enumerated
    private ActivityType type;

    @OneToMany
    private List<Guide> leaders;
    @OneToMany
    private List<Customer> attendees;

    private boolean isEnded;
    private boolean isStarted;
}
