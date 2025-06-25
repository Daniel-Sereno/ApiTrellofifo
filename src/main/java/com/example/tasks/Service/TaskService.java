package com.example.tasks.Service;

import com.example.tasks.Model.Task;
import com.example.tasks.Model.TaskGroup;
import com.example.tasks.Repository.TaskGroupRepository;
import com.example.tasks.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskGroupRepository taskGroupRepository;

    public Task criarTask(Long taskGroupId, Task task) {
        TaskGroup taskGroup = taskGroupRepository.findById(taskGroupId)
                .orElseThrow(() -> new RuntimeException("TaskGroup não encontrado"));
        task.setTaskGroup(taskGroup);
        return taskRepository.save(task);
    }

    public List<Task> listarTodos() {
        return taskRepository.findAll();
    }

    public Task buscarPorId(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));
    }

    public Task atualizar(Long id, Task novaTask) {
        Task existente = buscarPorId(id);
        existente.setTitle(novaTask.getTitle());
        existente.setDescription(novaTask.getDescription());
        existente.setStatus(novaTask.getStatus());
        return taskRepository.save(existente);
    }

    public void deletar(Long id) {
        taskRepository.deleteById(id);
    }
}
