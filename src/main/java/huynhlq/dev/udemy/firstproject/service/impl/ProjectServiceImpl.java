package huynhlq.dev.udemy.firstproject.service.impl;

import huynhlq.dev.udemy.firstproject.model.dto.ProjectDTO;
import huynhlq.dev.udemy.firstproject.model.dto.UserDTO;
import huynhlq.dev.udemy.firstproject.model.entity.Project;
import huynhlq.dev.udemy.firstproject.exception.CustomErrorException;
import huynhlq.dev.udemy.firstproject.model.entity.User;
import huynhlq.dev.udemy.firstproject.model.request.AddProjectRequest;
import huynhlq.dev.udemy.firstproject.repository.ProjectRepository;
import huynhlq.dev.udemy.firstproject.service.ProjectService;
import huynhlq.dev.udemy.firstproject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    /// PROPERTIES
    private final ProjectRepository projectRepository;
    private final UserService userService;

    public ProjectServiceImpl(ProjectRepository projectRepository, UserService userService) {
        this.projectRepository = projectRepository;
        this.userService = userService;
    }

    /// PUBLIC METHOD
    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public ProjectDTO createOrUpdate(AddProjectRequest request) {
        try {
            UserDTO userRequest = userService.findByUsername(request.getOwnerUsername());
            if (userRequest == null) {
                throw new CustomErrorException("User does not exist");
            }

            Project result = projectRepository.save(new Project(
                    request.getIdentifier(),
                    request.getName(),
                    request.getDescription(),
                    request.getStartDate(),
                    request.getEndDate()
            ));

            return new ProjectDTO(
                    result.getIdentifier(),
                    result.getName(),
                    result.getDescription(),
                    result.getStartDate().toString(),
                    result.getEndDate().toString(),
                    userRequest.getUsername()
            );
        } catch (CustomErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new CustomErrorException("Project ID: " + request.getIdentifier() + " already exists!");
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
