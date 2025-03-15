package huynhlq.dev.udemy.firstproject.repository;

import huynhlq.dev.udemy.firstproject.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT * FROM TASK WHERE DELETED = 0", nativeQuery = true)
    List<Task> getAll();
}
