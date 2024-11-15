package com.pucgo.projetointegradorib.controllers;

import com.pucgo.projetointegradorib.models.Livro;
import com.pucgo.projetointegradorib.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros() {
        return ResponseEntity.ok(livroService.listarLivros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        try {
            Livro novoLivro = livroService.cadastrarLivro(livro);
            return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}/quantidade")
    public ResponseEntity<Void> atualizarQuantidadeDisponivel(@PathVariable Long id, @RequestParam int quantidade) {
        livroService.atualizarQuantidadeDisponivel(id, quantidade);
        return ResponseEntity.noContent().build();
    }
}