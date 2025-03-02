package huynhlq.dev.udemy.firstproject.services.impl;

import huynhlq.dev.udemy.firstproject.entities.Project;
import huynhlq.dev.udemy.firstproject.repositories.ProjectRepository;
import huynhlq.dev.udemy.firstproject.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Project create(Project project) {
        if(existsById(project.getId())) {
            return null;
        }
        return projectRepository.save(project);
    }

    @Override
    public Project update(Project project) {
        if(existsById(project.getId())) {
            return projectRepository.save(project);
        }
        return null;
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

    @Override
    public boolean existsById(Long id) {
        return projectRepository.existsById(id);
    }
}
