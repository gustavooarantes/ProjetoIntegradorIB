package com.pucgo.projetointegradorib.controllers;

import com.pucgo.projetointegradorib.models.Emprestimo;
import com.pucgo.projetointegradorib.models.Reserva;
import com.pucgo.projetointegradorib.models.Usuario;
import com.pucgo.projetointegradorib.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        try {
            Usuario usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{idUsuario}/emprestar/{idLivro}")
    public ResponseEntity<Emprestimo> realizarEmprestimo(@PathVariable Long idUsuario, @PathVariable Long idLivro) {
        try {
            Emprestimo emprestimo = usuarioService.realizarEmprestimo(idUsuario, idLivro);
            return new ResponseEntity<>(emprestimo, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{idUsuario}/reservar/{idLivro}")
    public ResponseEntity<Reserva> realizarReserva(@PathVariable Long idUsuario, @PathVariable Long idLivro) {
        try {
            Reserva reserva = usuarioService.realizarReserva(idUsuario, idLivro);
            return new ResponseEntity<>(reserva, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
