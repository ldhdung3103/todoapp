package com.example.todoapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todoapp.entity.Task;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    List<Task> findByCompleted(boolean completed);
}
