package sirma_business.servicesImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import sirma_business.models.Project;
import sirma_business.repositories.ProjectRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {


    @Mock
    private ProjectRepository projectRepository;


    private ProjectServiceImpl projectService;


    @BeforeEach
    void setUp() {
        this.projectService = new ProjectServiceImpl(projectRepository);
    }


    @Test
    void createProject() {
        Project project = new Project();
        project.setName("A");
        project.setDescription("lorem");
        project.setStartDate(LocalDate.of(2023, 5, 25));

        // Mock the behavior of projectRepository.save(project) to return a new project with an ID
        Project savedProject = new Project();
        savedProject.setId(1L);
        savedProject.setName("A");
        savedProject.setDescription("lorem");
        savedProject.setStartDate(LocalDate.of(2023, 5, 25));
        when(projectRepository.save(project)).thenReturn(savedProject);

        // Call the service method to create the project
        Project result = projectService.createProject(project);

        // Verify that the projectRepository's save method was called once with the project object
        verify(projectRepository, times(1)).save(project);

        // Assert that the result project has the expected properties
        assertNotNull(result);
        assertEquals(savedProject.getId(), result.getId());
        assertEquals(savedProject.getName(), result.getName());
        assertEquals(savedProject.getDescription(), result.getDescription());
        assertEquals(savedProject.getStartDate(), result.getStartDate());
    }

    @Test
    void updateProject() {
        // Create a sample project object
        Project existingProject = new Project();
        existingProject.setId(1L);
        existingProject.setName("Existing Project");
        existingProject.setDescription("Existing Description");

        // Create an updated project object
        Project updatedProject = new Project();
        updatedProject.setId(1L);
        updatedProject.setName("Updated Project");
        updatedProject.setDescription("Updated Description");

        // Mock the behavior of projectRepository.findById(1L) to return the existingProject
        when(projectRepository.findById(1L)).thenReturn(Optional.of(existingProject));

        // Mock the behavior of projectRepository.save(updatedProject) to return the updatedProject
        when(projectRepository.save(updatedProject)).thenReturn(updatedProject);

        // Call the service method to update the project
        Project result = projectService.updateProject(1L, updatedProject);

        // Verify that the projectRepository's save method was called once with the updatedProject object
        verify(projectRepository, times(1)).save(updatedProject);

        // Assert that the result project has the expected properties
        assertNotNull(result);
        assertEquals(updatedProject.getId(), result.getId());
        assertEquals(updatedProject.getName(), result.getName());
        assertEquals(updatedProject.getDescription(), result.getDescription());
    }

    @Test
    void deleteProject() {
        // Mock the behavior of projectRepository.deleteById(1L)
        doNothing().when(projectRepository).deleteById(1L);

        // Call the service method to delete the project
        projectService.deleteProject(1L);

        // Verify that the projectRepository's deleteById method was called once with the correct ID
        verify(projectRepository, times(1)).deleteById(1L);
    }

    @Test
    void readAllProjects() {
        // Create a list of sample projects
        Project project = new Project();
        project.setId(1l);
        project.setName("B");
        project.setDescription("lorem5");
        project.setStartDate(LocalDate.of(2024, 2, 5));
        project.setEndDate(LocalDate.of(2024, 3, 10));

        Project project1 = new Project();
        project.setId(2l);
        project.setName("C");
        project.setDescription("lorem6");
        project.setStartDate(LocalDate.of(2024, 3, 5));
        project.setEndDate(LocalDate.of(2024, 4, 10));


        List<Project> projects = Arrays.asList(project1, project);

        // Mock the behavior of projectRepository.findAll() to return the list of projects
        when(projectRepository.findAll()).thenReturn(projects);

        // Call the service method to retrieve all projects
        List<Project> result = projectService.readAllProjects();

        // Verify that the result list is not null and has the expected size
        assertNotNull(result);
        assertEquals(projects.size(), result.size());

        // Verify that the result list contains the expected projects
        assertTrue(result.containsAll(projects));
    }

    @Test
    void getProjectById() {
        // Create a sample project object
        Project project = new Project();

        project.setId(1l);
        project.setName("B");
        project.setDescription("lorem5");
        project.setStartDate(LocalDate.of(2024, 2, 20));
        project.setEndDate(LocalDate.of(2024, 1, 12));

        // Mock the behavior of projectRepository.findById(1L) to return the project
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        // Call the service method to retrieve the project by ID
        Optional<Project> result = projectService.getProjectById(1L);

        // Verify that the result is not empty
        assertTrue(result.isPresent());

        // Assert that the result project has the expected properties
        assertEquals(project.getId(), result.get().getId());
        assertEquals(project.getName(), result.get().getName());
        assertEquals(project.getDescription(), result.get().getDescription());
        assertEquals(project.getStartDate(), result.get().getStartDate());
        assertEquals(project.getEndDate(), result.get().getEndDate());
    }
}