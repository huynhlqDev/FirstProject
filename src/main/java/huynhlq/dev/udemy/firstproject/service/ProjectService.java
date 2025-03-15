package huynhlq.dev.udemy.firstproject.service;

import huynhlq.dev.udemy.firstproject.model.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();
    Project createOrUpdate(Project project);
    boolean delete(long projectId);
}