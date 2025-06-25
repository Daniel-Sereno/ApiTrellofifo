package com.example.tasks.Controller;

import com.example.tasks.Model.Board;
import com.example.tasks.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // Criar board
    @PostMapping
    public ResponseEntity<Board> criarBoard(@RequestBody Board board) {
        Board criado = boardService.criarBoard(board);
        return ResponseEntity.ok(criado);
    }

    // Listar todos os boards
    @GetMapping
    public ResponseEntity<List<Board>> listarBoards() {
        List<Board> boards = boardService.listarBoards();
        return ResponseEntity.ok(boards);
    }

    // Buscar board por ID
    @GetMapping("/{id}")
    public ResponseEntity<Board> buscarPorId(@PathVariable Long id) {
        Board board = boardService.buscarPorId(id);
        return ResponseEntity.ok(board);
    }

    // Atualizar board
    @PutMapping("/{id}")
    public ResponseEntity<Board> atualizarBoard(@PathVariable Long id, @RequestBody Board board) {
        Board atualizado = boardService.atualizarBoard(id, board);
        return ResponseEntity.ok(atualizado);
    }

    // Deletar board
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBoard(@PathVariable Long id) {
        boardService.deletarBoar
