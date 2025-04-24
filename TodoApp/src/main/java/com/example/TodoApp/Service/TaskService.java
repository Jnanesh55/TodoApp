package com.example.TodoApp.Service;

import com.example.TodoApp.Model.Task;
import com.example.TodoApp.Repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  public List<Task> getUserTask(Long userId) {
        return taskRepository.findByUser_Id(userId);
    }

    public Task createTask(Task task) {
      return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
      taskRepository.deleteById(taskId);
    }
}
