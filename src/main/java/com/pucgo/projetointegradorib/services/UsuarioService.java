package com.pucgo.projetointegradorib.services;

import com.pucgo.projetointegradorib.models.*;
import com.pucgo.projetointegradorib.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private ReservaService reservaService;

    // Lista todos os usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNomeUsuario(usuarioAtualizado.getNomeUsuario());
                    usuario.setEmailUsuario(usuarioAtualizado.getEmailUsuario());
                    usuario.setTelefoneUsuario(usuarioAtualizado.getTelefoneUsuario());
                    usuario.setEnderecoUsuario(usuarioAtualizado.getEnderecoUsuario());
                    return usuarioRepository.save(usuario);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @Transactional
    public Emprestimo realizarEmprestimo(Livro livro, Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getIdUsuario());

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        // Chama o EmprestimoService para criar o empréstimo
        return emprestimoService.criarEmprestimo(livro, usuario);
    }

    @Transactional
    public Reserva realizarReserva(Livro livro, Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getIdUsuario());

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        // Chama ReservaService para criar a reserva
        return reservaService.criarReserva(livro, usuario);
    }
}
