package com.example.tasks.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TaskGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "taskGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Task> tasks;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
