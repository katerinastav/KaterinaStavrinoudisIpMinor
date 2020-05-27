package be.ucll.IPminorPE.repository;

import be.ucll.IPminorPE.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{
    Task findById(long id);
}
