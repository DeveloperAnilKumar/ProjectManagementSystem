package sirma_business.servicesImpl;

import org.springframework.stereotype.Service;
import sirma_business.handlers.ProjectNotFoundException;
import sirma_business.models.Project;
import sirma_business.repositories.ProjectRepository;
import sirma_business.services.IProjectService;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;


    //Contractor injection for projectRepository
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    //Method to create a new project
    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    //Method to updated and existing project
    @Override
    public Project updateProject(Long id, Project project) {
        Optional<Project> project1 = projectRepository.findById(id);
        if (project1.isPresent()) {
            project.setId(id);
            return projectRepository.save(project);
        } else {
            throw new ProjectNotFoundException(id);
        }

    }

    //Method to delete project by ID
    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }


    //Method to retrieve  all projects
    @Override
    public List<Project> readAllProjects() {
        return projectRepository.findAll();
    }

    //Method to retrieve a   project by ID
    @Override
    public Optional<Project> getProjectById(Long id) {
        //if project given id exits , return it , otherwise throw ProjectNotFoundException
        return Optional.ofNullable(projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id)));
    }


}
