package huynhlq.dev.udemy.firstproject.services;

import huynhlq.dev.udemy.firstproject.entities.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();
    Project createOrUpdate(Project project);
    boolean delete(long projectId);
    boolean existsById(Long id);
}