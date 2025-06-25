package com.example.tasks.Service;

import com.example.tasks.Model.Board;
import com.example.tasks.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Board criarBoard(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> listarBoards() {
        return boardRepository.findAll();
    }

    public Board buscarPorId(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new RuntimeException("Board não encontrado"));
    }

    public Board atualizarBoard(Long id, Board novoBoard) {
        Board existente = buscarPorId(id);
        existente.setName(novoBoard.getName());
        existente.setDescription(novoBoard.getDescription());
        return boardRepository.save(existente);
    }

    public void deletarBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
