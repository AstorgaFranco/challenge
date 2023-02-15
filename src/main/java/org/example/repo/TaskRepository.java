package org.example.repo;

import org.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT id, description, priority " +
            "FROM  challenge.\"Task\" where id = 1 " ,nativeQuery = true)
    Optional<Task> findSorete(Long id);

}
