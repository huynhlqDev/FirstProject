package huynhlq.dev.udemy.firstproject.service;

import huynhlq.dev.udemy.firstproject.model.dto.ProjectDTO;
import huynhlq.dev.udemy.firstproject.model.entity.Project;
import huynhlq.dev.udemy.firstproject.model.request.AddProjectRequest;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();
    ProjectDTO createOrUpdate(AddProjectRequest project);
    boolean delete(long projectId);
}