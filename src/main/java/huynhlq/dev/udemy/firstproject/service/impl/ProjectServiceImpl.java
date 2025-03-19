package huynhlq.dev.udemy.firstproject.service.impl;

import huynhlq.dev.udemy.firstproject.model.entity.Project;
import huynhlq.dev.udemy.firstproject.exception.CustomErrorException;
import huynhlq.dev.udemy.firstproject.repository.ProjectRepository;
import huynhlq.dev.udemy.firstproject.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    /// PROPERTIES
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

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
            throw new CustomErrorException("Project ID: " + project.getIdentifier() + " already exists!");
        }
    }

    @Override
    public boolean delete(long projectId) {
        Project proNeed = projectRepository.findById(projectId).orElse(null);
        if (proNeed != null) {
            proNeed.setDeleted(true);
            projectRepository.save(proNeed);
            return true;
        } else {
            return false;
        }
    }

    public Project getById(String projectId) {
        Project project = projectRepository.getByIdentifier(projectId);
        if (project == null) {
            throw new CustomErrorException("Project does not exist!");
        }
        return project;
    }
}
