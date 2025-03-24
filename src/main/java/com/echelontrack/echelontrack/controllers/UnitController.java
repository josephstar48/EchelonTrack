package com.echelontrack.echelontrack.controllers;

import com.echelontrack.echelontrack.entities.Unit;
import com.echelontrack.echelontrack.service.UnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public List<Unit> getAllUnits() {
        return unitService.getAllUnits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unit> getUnitById(@PathVariable Long id) {
        return unitService.getUnitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Unit createUnit(@RequestBody Unit unit) {
        return unitService.createUnit(unit);
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
