package com.example.tasks.Service;

import com.example.tasks.Model.Board;
import com.example.tasks.Model.TaskGroup;
import com.example.tasks.Repository.BoardRepository;
import com.example.tasks.Repository.TaskGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskGroupService {

    @Autowired
    private TaskGroupRepository taskGroupRepository;

    @Autowired
    private BoardRepository boardRepository;

    public TaskGroup criarTaskGroup(Long boardId, TaskGroup taskGroup) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board não encontrado"));
        taskGroup.setBoard(board);
        return taskGroupRepository.save(taskGroup);
    }

    public List<TaskGroup> listarTodos() {
        return taskGroupRepository.findAll();
    }

    public TaskGroup buscarPorId(Long id) {
        return taskGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TaskGroup não encontrado"));
    }

    public TaskGroup atualizar(Long id, TaskGroup novo) {
        TaskGroup existente = buscarPorId(id);
        existente.setName(novo.getName());
        return taskGroupRepository.save(existente);
    }

    public void deletar(Long id) {
        taskGroupRepository.deleteById(id);
    }
}
