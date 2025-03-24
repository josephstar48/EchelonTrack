package com.echelontrack.echelontrack.service;

import com.echelontrack.echelontrack.entities.TaskOrganization;
import com.echelontrack.echelontrack.exceptionHandling.ResourceNotFoundException;
import com.echelontrack.echelontrack.repositories.TaskOrganizationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TaskOrganizationService {

    private final TaskOrganizationRepository taskOrganizationRepository;

    public TaskOrganizationService(TaskOrganizationRepository taskOrganizationRepository) {
        this.taskOrganizationRepository = taskOrganizationRepository;
    }

    public List<TaskOrganization> getTaskOrganizations() {
        return taskOrganizationRepository.findAll();
    }

    public List<TaskOrganization> getByOpordId(String opordId) {
        List<TaskOrganization> results = taskOrganizationRepository.findByOpordId(opordId);
        if (results.isEmpty()) {
            throw new ResourceNotFoundException("No Task Organizations found for OPORD ID: " + opordId);
        }
        return results;
    }


    public TaskOrganization createTaskOrganization(TaskOrganization taskOrganization) {
        if (taskOrganization == null) {
            throw new IllegalArgumentException("Task Organization cannot be null");
        }
        return taskOrganizationRepository.save(taskOrganization);
    }

    @Transactional
    public TaskOrganization updateTaskOrganization(Long id, TaskOrganization updatedTaskOrganization) {
        // Fetch the existing TaskOrganization from the repository
        TaskOrganization existingTaskOrganization = taskOrganizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task Organization not found with ID: " + id));

        // Update the fields of the existing TaskOrganization only if the updated values are not null
        if (updatedTaskOrganization.getOpordId() != null) {
            existingTaskOrganization.setOpordId(updatedTaskOrganization.getOpordId());
        }

        if (updatedTaskOrganization.getUnit() != null) {
            existingTaskOrganization.setUnit(updatedTaskOrganization.getUnit());
        }

        if (updatedTaskOrganization.getMissionRole() != null) {
            existingTaskOrganization.setMissionRole(updatedTaskOrganization.getMissionRole());
        }

        // Save the updated TaskOrganization
        return taskOrganizationRepository.save(existingTaskOrganization);
    }

    @Transactional
    public void deleteTaskOrganization(Long id) {
        if (!taskOrganizationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task Organization not found with ID: " + id);
        }
        taskOrganizationRepository.deleteById(id);
    }

}

