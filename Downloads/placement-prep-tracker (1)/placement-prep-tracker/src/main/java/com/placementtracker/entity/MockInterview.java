package com.placementtracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "mock_interview")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MockInterview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many interviews belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Many interviews can be for one company (optional)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false)
    private LocalDate interviewDate;

    private String interviewerName;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String notes;
}
