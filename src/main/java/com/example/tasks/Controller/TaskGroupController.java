package com.example.tasks.Controller;

import com.example.tasks.Model.TaskGroup;
import com.example.tasks.Service.TaskGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskgroups")
public class TaskGroupController {

    @Autowired
    private TaskGroupService taskGroupService;

    // Criar task group vinculado a um board
    @PostMapping("/board/{boardId}")
    public ResponseEntity<TaskGroup> criar(@PathVariable Long boardId, @RequestBody TaskGroup taskGroup) {
        TaskGroup criado = taskGroupService.criarTaskGroup(boardId, taskGroup);
        return ResponseEntity.ok(criado);
    }

    // Listar todos os task groups
    @GetMapping
    public ResponseEntity<List<TaskGroup>> listarTodos() {
        return ResponseEntity.ok(taskGroupService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskGroup> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(taskGroupService.buscarPorId(id));
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<TaskGroup> atualizar(@PathVariable Long id, @RequestBody TaskGroup taskGroup) {
        return ResponseEntity.ok(taskGroupService.atualizar(id, taskGroup));
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        taskGroupService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
