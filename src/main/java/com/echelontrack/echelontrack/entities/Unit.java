package com.echelontrack.echelontrack.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "units")

public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @Column(unique = true, nullable = false)
    private String unitUIC;

    @Column(nullable = false)
    private String unitName;         //full unit name

    private String shortName;        // shortened unit name
    private String unitDesignation;  //BN, BDE, DIV

    @Column(nullable = false)
    private String unitEchelon;     // Division, Brigade, Battalion

    private Integer personnelCount;

    @ManyToOne
    @JoinColumn(name = "parent_unit_id")
    @JsonIgnore
    private Unit parentUnit;                // references parent unit

}
