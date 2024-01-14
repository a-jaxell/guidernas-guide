package org.guidernas.guideapi.qualification;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.guidernas.guideapi.user.User;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "qualification")
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "title")
    private String title;

    @Size(max = 255)
    @Column(name = "description")
    private String description;

    @PastOrPresent
    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @FutureOrPresent
    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
