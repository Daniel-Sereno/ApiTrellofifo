package com.example.tasks.Controller;

import com.example.tasks.Model.Task;
import com.example.tasks.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Criar task vinculada a um task group
    @PostMapping("/taskgroup/{taskGroupId}")
    public ResponseEntity<Task> criar(@PathVariable Long taskGroupId, @RequestBody Task task) {
        Task criada = taskService.criarTask(taskGroupId, task);
        return ResponseEntity.ok(criada);
    }

    // Listar todas as tasks
    @GetMapping
    public ResponseEntity<List<Task>> listarTodos() {
        return ResponseEntity.ok(taskService.listarTodos());
    }

    // Buscar task por ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.buscarPorId(id));
    }

    // Atualizar task
    @PutMapping("/{id}")
    public ResponseEntity<Task> atualizar(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.atualizar(id, task));
    }

    // Deletar task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        taskService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
