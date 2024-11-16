package com.pucgo.projetointegradorib.controllers;

import com.pucgo.projetointegradorib.dtos.EmprestimoRequestDTO;
import com.pucgo.projetointegradorib.models.Emprestimo;
import com.pucgo.projetointegradorib.models.Livro;
import com.pucgo.projetointegradorib.models.Usuario;
import com.pucgo.projetointegradorib.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/criar")
    public ResponseEntity<Emprestimo> criarEmprestimo(@RequestBody EmprestimoRequestDTO requestDTO) {
        try {
            Livro livro = requestDTO.getLivro();
            Usuario usuario = requestDTO.getUsuario();
            Emprestimo novoEmprestimo = emprestimoService.criarEmprestimo(livro, usuario);
            return new ResponseEntity<>(novoEmprestimo, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/finalizar/{idEmprestimo}")
    public ResponseEntity<Emprestimo> finalizarEmprestimo(@PathVariable Long idEmprestimo) {
        try {
            Emprestimo emprestimoFinalizado = emprestimoService.finalizarEmprestimo(idEmprestimo);
            return new ResponseEntity<>(emprestimoFinalizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
