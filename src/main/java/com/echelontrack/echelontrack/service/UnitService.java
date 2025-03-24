package com.echelontrack.echelontrack.service;


import com.echelontrack.echelontrack.entities.Unit;
import com.echelontrack.echelontrack.exceptionHandling.ResourceNotFoundException;
import com.echelontrack.echelontrack.repositories.UnitRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public Optional<Unit> getUnitById(Long id) {

        return Optional.ofNullable(unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found with ID: " + id)));

    }

    public Unit createUnit(Unit unit) {

        return unitRepository.save(unit);

    }

    @Transactional
    public void deleteUnit(Long id) {
        if (!unitRepository.existsById(id)) {
            throw new ResourceNotFoundException("Unit not found with ID: " + id);
        }
        unitRepository.deleteById(id);
    }

}
