package com.example.TodoApp.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String discription;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference  // This side won't be serialized
    private User user;

    @JsonProperty("user_id")  // Explicitly include in JSON
    public Long getUserId() {
        return user != null ? user.getId() : null;
    }

    public Task(){

    }

    public Task(String discription, User user) {
        this.discription = discription;
        this.user = user;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
