package com.pucgo.projetointegradorib.services;

import com.pucgo.projetointegradorib.models.Emprestimo;
import com.pucgo.projetointegradorib.models.Livro;
import com.pucgo.projetointegradorib.models.Usuario;
import com.pucgo.projetointegradorib.repositories.EmprestimoRepository;
import com.pucgo.projetointegradorib.repositories.LivroRepository;
import com.pucgo.projetointegradorib.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Lista todos os empréstimos cadastrados no sistema
    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

    // Busca empréstimo pelo seu ID
    public Emprestimo buscarPorId(Long id) {
        return emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprestimo não encontrado com ID: " + id));
    }

    // Cria um novo empréstimo
    @Transactional
    public Emprestimo criarEmprestimo(Long idLivro, Long idUsuario) {
        Optional<Livro> livroOptional = livroRepository.findById(idLivro);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);

        if (livroOptional.isEmpty() || usuarioOptional.isEmpty()) {
            throw new RuntimeException("Livro ou usuário não encontrado");
        }

        Livro livro = livroOptional.get();
        Usuario usuario = usuarioOptional.get();

        if (livro.estaEmprestadoLivro() || livro.estaReservadoLivro()) {
            throw new RuntimeException("Livro não está disponível para empréstimo");
        }

        // Atualiza o status de empréstimo do livro para "Emprestado"
        livro.setEmprestadoLivro(true);
        livroRepository.save(livro);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivroEmprestimo(livro);
        emprestimo.setUsuarioEmprestimo(usuario);
        emprestimo.setStatusEmprestimo("Em andamento");
        emprestimo.setDataEmprestimo(java.time.LocalDate.now());

        return emprestimoRepository.save(emprestimo);
    }

    // Finaliza um empréstimo
    @Transactional
    public Emprestimo finalizarEmprestimo(Long idEmprestimo) {
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(idEmprestimo);

        if (emprestimoOptional.isEmpty()) {
            throw new RuntimeException("Empréstimo não encontrado");
        }

        Emprestimo emprestimo = emprestimoOptional.get();
        Livro livro = emprestimo.getLivroEmprestimo();

        // Atualiza o status do empréstimo e do livro
        emprestimo.setStatusEmprestimo("Finalizado");
        livro.setEmprestadoLivro(false);

        livroRepository.save(livro);
        return emprestimoRepository.save(emprestimo);
    }
}
