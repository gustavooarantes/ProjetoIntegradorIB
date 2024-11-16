package com.pucgo.projetointegradorib.controllers;

import com.pucgo.projetointegradorib.models.Editora;
import com.pucgo.projetointegradorib.services.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editoras")
public class EditoraController {
    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public ResponseEntity<List<Editora>> listarEditoras() {
        return ResponseEntity.ok(editoraService.listarEditoras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> buscarEditoraPorId(@PathVariable Long id) {
        return ResponseEntity.ok(editoraService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Editora> cadastrarEditora(@RequestBody Editora editora) {
        Editora novaEditora = editoraService.cadastrarEditora(editora);
        return new ResponseEntity<>(novaEditora, HttpStatus.CREATED);
    }
}
