package com.echelontrack.echelontrack.repositories;


import com.echelontrack.echelontrack.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository <Unit, Long> {

    List<Unit> findByParentUnit(Unit parentUnit);

}
