package sirma_business.handlers;

public class ProjectNotFoundException extends  RuntimeException {
    public ProjectNotFoundException(Long id ) {
        super("project with  id " + id + " is not found");
    }
}
