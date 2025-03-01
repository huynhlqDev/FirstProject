package huynhlq.dev.udemy.firstproject.repositories;

import huynhlq.dev.udemy.firstproject.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByDeletedContains(boolean deleted);
}
