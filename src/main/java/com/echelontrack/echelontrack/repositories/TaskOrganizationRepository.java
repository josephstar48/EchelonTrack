package com.echelontrack.echelontrack.repositories;


import com.echelontrack.echelontrack.entities.TaskOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskOrganizationRepository extends JpaRepository<TaskOrganization, Long> {

    List<TaskOrganization> findByOpordId(String opordId);

}
