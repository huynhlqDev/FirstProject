package huynhlq.dev.udemy.firstproject.action;

import huynhlq.dev.udemy.firstproject.common.Logger;
import huynhlq.dev.udemy.firstproject.entities.Project;
import huynhlq.dev.udemy.firstproject.services.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectAction {

    @Autowired
    private ProjectServiceImpl projectService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody @Validated Project project, BindingResult result) {
        // Authentication

        // Request validation
        if (result.hasErrors()) {
            Logger.addErrorLog(result.getAllErrors());
            return new ResponseEntity<>(result.getAllErrors().get(0), HttpStatus.BAD_REQUEST);
        }

        // logic
        Logger.addActionLog("Creating project" + project.getName());
        Project createdProject = projectService.create(project);
        if (createdProject == null) {
            Logger.addErrorLog("Failed to create project" + project.getName());
            return new ResponseEntity<String>("Failed to create project", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @PostMapping("")
    public ResponseEntity<?> update(@RequestBody @Validated Project project, BindingResult result) {
        // Authentication

        // Request validation
        if (result.hasErrors()) {
            Logger.addErrorLog(result.getAllErrors());
            return new ResponseEntity<>(result.getAllErrors().get(0), HttpStatus.BAD_REQUEST);
        }

        // logic
        Logger.addActionLog("Updating project" + project.getName());
        Project updateProject = projectService.update(project);
        if (updateProject == null) {
            Logger.addErrorLog("Failed to updated project" + project.getName());
            return new ResponseEntity<String>("Failed to updated project", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(updateProject, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        Logger.addActionLog("Retrieving all projects");
        List<Project> projects = projectService.getAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}
