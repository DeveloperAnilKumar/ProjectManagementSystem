package sirma_business.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sirma_business.models.Project;
import sirma_business.services.IProjectService;


import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProjectController.class)
public class ProjectControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private IProjectService projectService;


    // Test for retrieving all projects
    @Test
    void testGetAllProjects() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/project/api/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    // Test for retrieving a project by ID
    @Test
    void testGetProjectById() throws Exception {
        // Mock project data
        Project project = new Project();
        project.setId(1L);
        project.setName("Test Project");
        project.setDescription("Test Description");
        project.setStartDate(LocalDate.of(2023, 5, 27));
        project.setEndDate(LocalDate.of(2024, 5, 27));

        // Mock the service behavior to return the project
        given(projectService.getProjectById(1L)).willReturn(Optional.of(project));

        // Perform GET request to retrieve project by ID
        mockMvc.perform(MockMvcRequestBuilders.get("/project/api/1")
                        .contentType(MediaType.APPLICATION_JSON))
                // Expect HTTP status code 200 OK
                .andExpect(status().isOk())
                // Expect content type to be JSON
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // Validate response body
                .andExpect(jsonPath("$.id").value(1)) // Check project ID
                .andExpect(jsonPath("$.name").value("Test Project")) // Check project name
                .andExpect(jsonPath("$.description").value("Test Description")) // Check project description
                .andExpect(jsonPath("$.startDate").value("2023-05-27")) // Check start date
                .andExpect(jsonPath("$.endDate").value("2024-05-27")); // Check end date
    }


    // Test for updating a project
    @Test
    void testUpdateProject() throws Exception {
        Long projectId = 1L;
        String projectJson = "{ \"name\": \"Updated Project Name\", \"description\": \"Updated Project Description\", \"startDate\": \"2023-05-27\", \"endDate\": \"2024-05-27\" }";
        mockMvc.perform(MockMvcRequestBuilders.put("/project/api/" + projectId)
                        .content(projectJson)
                        .contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    // Test for deleting a project
    @Test
    void testDeleteProject() throws Exception {
        Long projectId = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/project/api/" + projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


    // Test for creating a new project
    @Test
    void testCreateProject() throws Exception {
        // Create a JSON representation of the project object
        String projectJson = "{ \"name\": \"Test Project\", \"description\": \"Test Description\", \"startDate\": \"2023-05-27\", \"endDate\": \"2024-05-27\" }";
        mockMvc.perform(MockMvcRequestBuilders.post("/project/api/")
                        .content(projectJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
