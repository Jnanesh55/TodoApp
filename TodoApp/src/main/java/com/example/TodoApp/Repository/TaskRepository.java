package com.example.TodoApp.Repository;

import com.example.TodoApp.Model.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
   List<Task> findByUser_Id(Long userId);

}
