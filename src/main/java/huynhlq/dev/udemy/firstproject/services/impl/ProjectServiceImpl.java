package huynhlq.dev.udemy.firstproject.services.impl;

import huynhlq.dev.udemy.firstproject.common.Logger;
import huynhlq.dev.udemy.firstproject.entities.Project;
import huynhlq.dev.udemy.firstproject.exceptions.ProjectIdException;
import huynhlq.dev.udemy.firstproject.exceptions.ProjectIdExceptionResponse;
import huynhlq.dev.udemy.firstproject.repositories.ProjectRepository;
import huynhlq.dev.udemy.firstproject.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    /// PROPERTIES
    @Autowired
    private ProjectRepository projectRepository;

    /// PUBLIC METHOD
    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public Project createOrUpdate(Project project) {
        try {
            project.setIdentifier(project.getIdentifier().toLowerCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID: " + project.getIdentifier() + " already exists!");
        }
    }

    @Override
    public boolean delete(long projectId) {
        Project proNeed = projectRepository.findById(projectId).orElse(null);
        if(proNeed != null) {
            proNeed.setDeleted(true);
            projectRepository.save(proNeed);
            return true;
        } else {
            return false;
        }
    }

    public Project getById(String projectId) {
        Project project = projectRepository.getByIdentifier(projectId);
        if(project == null) {
            throw new ProjectIdException("Project does not exist!");
        }
        return project;
    }
}
