package huynhlq.dev.udemy.firstproject.repository;

import huynhlq.dev.udemy.firstproject.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "SELECT * FROM PROJECT WHERE DELETED = 0", nativeQuery = true)
    List<Project> getAll();

    @Query(value = "SELECT * FROM PROJECT WHERE IDENTIFIER =:id", nativeQuery = true)
    Project getByIdentifier(@Param("id") String id);
}
