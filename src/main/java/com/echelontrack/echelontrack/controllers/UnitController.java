package com.echelontrack.echelontrack.controllers;

import com.echelontrack.echelontrack.entities.Unit;
import com.echelontrack.echelontrack.service.UnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/units")
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public ResponseEntity<List<Unit>> getAllUnits() {
        List<Unit> units = unitService.getAllUnits();
        return ResponseEntity.ok(units);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Unit> getUnitById(@PathVariable Long id) {
        Optional<Unit> unit = unitService.getUnitById(id);
        return unit.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Unit> createUnit(@RequestBody Unit unit) {
        Unit createdUnit = unitService.createUnit(unit);
        return ResponseEntity.status(201).body(createdUnit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unit> updateUnit(@PathVariable Long id, @RequestBody Unit unit) {
        Unit updatedUnit = unitService.updateUnit(id, unit);
        return ResponseEntity.ok(updatedUnit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
        unitService.deleteUnit(id);
        return ResponseEntity.noContent().build();
    }

}
