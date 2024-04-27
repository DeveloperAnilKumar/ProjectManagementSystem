package sirma_business.handlers;


import com.fasterxml.jackson.annotation.JsonInclude;
import sirma_business.models.Project;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectResponse {
    private List<String> error_messages;
    private String exception_message;
    private String statusCodeDescription;
    private LocalDateTime timestamp;
    private Project project;


    public List<String> getError_messages() {
        return error_messages;
    }

    public void setError_messages(List<String> error_messages) {
        this.error_messages = error_messages;
    }

    public String getException_message() {
        return exception_message;
    }

    public void setException_message(String exception_message) {
        this.exception_message = exception_message;
    }

    public String getStatusCodeDescription() {
        return statusCodeDescription;
    }

    public void setStatusCodeDescription(String statusCodeDescription) {
        this.statusCodeDescription = statusCodeDescription;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
