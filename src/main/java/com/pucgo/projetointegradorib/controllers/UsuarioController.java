package com.pucgo.projetointegradorib.controllers;

import com.pucgo.projetointegradorib.dtos.EmprestimoRequestDTO;
import com.pucgo.projetointegradorib.dtos.ReservaRequestDTO;
import com.pucgo.projetointegradorib.models.Emprestimo;
import com.pucgo.projetointegradorib.models.Livro;
import com.pucgo.projetointegradorib.models.Reserva;
import com.pucgo.projetointegradorib.models.Usuario;
import com.pucgo.projetointegradorib.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

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

    @PostMapping("/emprestar")
    public ResponseEntity<Emprestimo> realizarEmprestimo(@RequestBody EmprestimoRequestDTO requestDTO) {
        try {
            Livro livro = requestDTO.getLivro();
            Usuario usuario = requestDTO.getUsuario();
            Emprestimo emprestimo = usuarioService.realizarEmprestimo(livro, usuario);
            return new ResponseEntity<>(emprestimo, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/reservar")
    public ResponseEntity<Reserva> realizarReserva(@RequestBody ReservaRequestDTO requestDTO) {
        try {
            Livro livro = requestDTO.getLivro();
            Usuario usuario = requestDTO.getUsuario();
            Reserva reserva = usuarioService.realizarReserva(livro, usuario);
            return new ResponseEntity<>(reserva, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
