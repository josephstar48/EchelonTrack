package com.echelontrack.echelontrack.controllers;

import com.echelontrack.echelontrack.entities.TaskOrganization;
import com.echelontrack.echelontrack.service.TaskOrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-organizations")
public class TaskOrganizationController {

    private final TaskOrganizationService taskOrganizationService;

    public TaskOrganizationController(TaskOrganizationService taskOrganizationService) {
        this.taskOrganizationService = taskOrganizationService;
    }

    @GetMapping
    public ResponseEntity<List<TaskOrganization>> getAllTaskOrganizations() {
        List<TaskOrganization> taskOrganizations = taskOrganizationService.getTaskOrganizations();
        return ResponseEntity.ok(taskOrganizations);
    }

    @GetMapping("/opord/{opordId}")
    public ResponseEntity<List<TaskOrganization>> getTaskOrganizationsByOpordId(@PathVariable String opordId) {
        List<TaskOrganization> taskOrganizations = taskOrganizationService.getByOpordId(opordId);
        return ResponseEntity.ok(taskOrganizations);
    }

    @PostMapping
    public ResponseEntity<TaskOrganization> createTaskOrganization(@RequestBody TaskOrganization taskOrganization) {
        TaskOrganization createdTaskOrganization = taskOrganizationService.createTaskOrganization(taskOrganization);
        return new ResponseEntity<>(createdTaskOrganization, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskOrganization> updateTaskOrganization(@PathVariable Long id, @RequestBody TaskOrganization taskOrganization) {
        TaskOrganization updatedTaskOrganization = taskOrganizationService.updateTaskOrganization(id, taskOrganization);
        return ResponseEntity.ok(updatedTaskOrganization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskOrganization(@PathVariable Long id) {
        taskOrganizationService.deleteTaskOrganization(id);
        return ResponseEntity.noContent().build();
    }

}







