package sirma_business.services;

import sirma_business.models.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectService {

    public abstract Project createProject(Project project);


    public abstract Project updateProject(Long id, Project project);


    public abstract void deleteProject(Long id);


    public abstract List<Project> readAllProjects();

    public abstract Optional<Project> getProjectById(Long id);


}
