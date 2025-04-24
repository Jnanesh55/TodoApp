package com.example.TodoApp.DTO;  //for returning task data

public class TaskResponseDTO {
    private Long id;
    private String discription;
    private Long userId;

    public TaskResponseDTO() {
    }

    public TaskResponseDTO(Long id, String discription, Long userId) {
        this.id = id;
        this.discription = discription;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}