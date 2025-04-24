package com.example.TodoApp.DTO;  //for creating new tasks

public class TaskRequestDTO {
    private String discription;
    private Long userId;

    public TaskRequestDTO() {
    }

    public TaskRequestDTO(String discription, Long userId) {
        this.discription = discription;
        this.userId = userId;
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