package com.echelontrack.echelontrack.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task_organizations")

public class TaskOrganization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @Column(nullable = false)
    private String opordId;          // OPORD reference

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    @JsonIgnore
    private Unit unit;              // References the unit

    private String missionRole;       //"Main Effort", "Supporting Effort", etc

}
