package com.placementtracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "company_stage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many stages belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Many stages belong to one company
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(nullable = false)
    private String stageName;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDate stageDate;

    @Column(columnDefinition = "TEXT")
    private String notes;
}
