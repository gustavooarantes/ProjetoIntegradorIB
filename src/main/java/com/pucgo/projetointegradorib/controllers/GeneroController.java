package com.pucgo.projetointegradorib.controllers;

import com.pucgo.projetointegradorib.models.Genero;
import com.pucgo.projetointegradorib.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {
    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<Genero>> listarGeneros() {
        return ResponseEntity.ok(generoService.listarGeneros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> buscarGeneroPeloId(@PathVariable Long id) {
        return ResponseEntity.ok(generoService.buscarPorId(id));
    }
}
