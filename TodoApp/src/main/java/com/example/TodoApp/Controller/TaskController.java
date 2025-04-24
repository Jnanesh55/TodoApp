package com.example.TodoApp.Controller;

import com.example.TodoApp.DTO.TaskRequestDTO;
import com.example.TodoApp.DTO.TaskResponseDTO;
import com.example.TodoApp.Model.Task;
import com.example.TodoApp.Model.User;
import com.example.TodoApp.Service.TaskService;
import com.example.TodoApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public List<TaskResponseDTO> getUserTask(@PathVariable Long userId){
        return taskService.getUserTask(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO taskRequest){
        System.out.println("recive"+taskRequest.getDiscription());
        User user = userService.findUserById(taskRequest.getUserId());
        if(user==null){
            throw new RuntimeException("User not found with id:"+taskRequest.getUserId());
        }
        Task task = new Task();
        task.setDiscription(taskRequest.getDiscription());
        task.setUser(user);

        Task createdTask = taskService.createTask(task);
        return convertToDTO(createdTask);
    }



    @DeleteMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }
    private TaskResponseDTO convertToDTO(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getDiscription(),
                task.getUser().getId()
        );
    }
}
