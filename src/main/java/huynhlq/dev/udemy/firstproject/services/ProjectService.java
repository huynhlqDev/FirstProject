package huynhlq.dev.udemy.firstproject.services;

import huynhlq.dev.udemy.firstproject.entities.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();
    Project create(Project project);
    Project update(Project project);
    void delete(Project project);
    boolean existsById(Long id);
}
