package sirma_business.controllers;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sirma_business.handlers.ProjectNotFoundException;
import sirma_business.models.Project;
import sirma_business.services.IProjectService;
import sirma_business.servicesImpl.ProjectServiceImpl;

import java.util.List;
import java.util.Optional;

//define the base URL for all endpoints in this controller
@RequestMapping("/project/api")
@RestController
public class ProjectController {

    private final IProjectService projectService;

    //Constructor injection for projectService
    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }


    //Endpoint to retrieve all projects
    @GetMapping("/")
    public ResponseEntity<List<Project>> getAllProjects() {
        return new ResponseEntity<>(projectService.readAllProjects(), HttpStatus.OK);
    }

    //Endpoint to retrieve a project by ID
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById( @PathVariable Long id) {
        Optional<Project> project = projectService.getProjectById(id);
        return project.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseThrow(()-> new ProjectNotFoundException(id));
    }


    //Endpoint to create a new project
    @PostMapping(value = "/" )
    public  ResponseEntity<Project>  createProject( @Valid @RequestBody Project project){
        return  new ResponseEntity<>(projectService.createProject(project), HttpStatus.CREATED);
    }


    //Endpoint  to update an existing project
    @PutMapping("/{id}")
    public  ResponseEntity<Project> updateProject( @PathVariable Long  id , @Valid @RequestBody Project project){
        return  new ResponseEntity<>(projectService.updateProject(id,project), HttpStatus.OK);

    }

    //Endpoint  to delete a project by ID
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteProject( @PathVariable Long id){
        projectService.deleteProject(id);
        return  new ResponseEntity<>("project deleted", HttpStatus.OK);
    }






}
