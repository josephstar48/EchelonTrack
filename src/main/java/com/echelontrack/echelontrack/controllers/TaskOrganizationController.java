package com.echelontrack.echelontrack.controllers;

import com.echelontrack.echelontrack.entities.TaskOrganization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TaskOrganizationController {











    @PutMapping("/{id}")
    public ResponseEntity<TaskOrganization> updateTaskOrganization(@PathVariable Long id, @RequestBody TaskOrganization taskOrganization) {
        TaskOrganization updatedTaskOrganization = taskOrganizationService.updateTaskOrganization(id, taskOrganization);
        return ResponseEntity.ok(updatedTaskOrganization);
    }

}







