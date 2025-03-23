package huynhlq.dev.udemy.firstproject.apiAction;

import huynhlq.dev.udemy.firstproject.common.Logger;
import huynhlq.dev.udemy.firstproject.common.RequestValidator;
import huynhlq.dev.udemy.firstproject.model.entity.Project;
import huynhlq.dev.udemy.firstproject.service.impl.ProjectServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/projects")
public class ProjectAction {

    private final ProjectServiceImpl projectService;
    private final RequestValidator requestValidator;

    public ProjectAction(ProjectServiceImpl projectService, RequestValidator requestValidator) {
        this.projectService = projectService;
        this.requestValidator = requestValidator;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        Logger.addActionLog("Retrieving all projects");
        List<Project> projects = projectService.getAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody @Valid Project project, BindingResult result) {
        // Authentication

        // Request validation
        ResponseEntity<?> responseEntity = requestValidator.validate(result);
        if (responseEntity != null) {
            Logger.addErrorLog("Failed to validation: " + responseEntity);
            return responseEntity;
        }

        Logger.addActionLog("Creating project " + project.getName());
        Project createdProject = projectService.createOrUpdate(project);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid Project project, BindingResult result) {
        // Authentication

        // Request validation
        ResponseEntity<?> responseEntity = requestValidator.validate(result);
        if (responseEntity != null) {
            Logger.addErrorLog("Failed to validation: " + responseEntity);
            return responseEntity;
        }

        Logger.addActionLog("Updating project" + project.getName());
        Project updateProject = projectService.createOrUpdate(project);
        return new ResponseEntity<>(updateProject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable @Min(value = 1, message = "ID must than 0!") long id) {
        // Authentication

        // logic
        Logger.addActionLog("Deleting project ID: " + id);
        boolean isDeleted = projectService.delete(id);
        if (isDeleted) {
            Logger.addActionLog("Deleted project ID: " + id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            Logger.addErrorLog("Failed to delete project ID: " + id);
            return new ResponseEntity<>("Failed to delete project ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> findById(@PathVariable String projectId) {
        return new ResponseEntity<>(projectService.getById(projectId), HttpStatus.OK);
    }
}