package com.placementtracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "aptitude_attempt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AptitudeAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many attempts belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Many attempts belong to one topic
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private AptitudeTopic topic;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private LocalDate attemptDate;

    @Column(columnDefinition = "TEXT")
    private String notes;
}
