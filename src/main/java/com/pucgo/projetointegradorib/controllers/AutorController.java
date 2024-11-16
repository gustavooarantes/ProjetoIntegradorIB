package com.pucgo.projetointegradorib.controllers;

import com.pucgo.projetointegradorib.models.Autor;
import com.pucgo.projetointegradorib.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores() {
        return ResponseEntity.ok(autorService.listarAutores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Autor> cadastrarAutor(@RequestBody Autor autor) {
        Autor novoAutor = autorService.cadastrarAutor(autor);
        return new ResponseEntity<>(novoAutor, HttpStatus.CREATED);
    }
}
