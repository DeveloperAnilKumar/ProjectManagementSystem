package sirma_business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sirma_business.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}