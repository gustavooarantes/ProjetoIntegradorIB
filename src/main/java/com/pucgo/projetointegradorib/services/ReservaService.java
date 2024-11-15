package com.pucgo.projetointegradorib.services;

import com.pucgo.projetointegradorib.models.Livro;
import com.pucgo.projetointegradorib.models.Reserva;
import com.pucgo.projetointegradorib.models.Usuario;
import com.pucgo.projetointegradorib.repositories.LivroRepository;
import com.pucgo.projetointegradorib.repositories.ReservaRepository;
import com.pucgo.projetointegradorib.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Lista todas as reservas cadastradas no sistema
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    // Busca reserva pelo seu ID
    public Reserva buscarPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprestimo não encontrado com ID: " + id));
    }

    // Cria uma nova reserva
    @Transactional
    public Reserva criarReserva(Long idLivro, Long idUsuario) {
        Optional<Livro> livroOptional = livroRepository.findById(idLivro);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);

        if (livroOptional.isEmpty() || usuarioOptional.isEmpty()) {
            throw new RuntimeException("Livro ou usuário não encontrado");
        }

        Livro livro = livroOptional.get();
        Usuario usuario = usuarioOptional.get();

        if (livro.estaEmprestadoLivro() || livro.estaReservadoLivro()) {
            throw new RuntimeException("Livro não está disponível para reserva");
        }

        // Atualiza o status de reserva do livro para "Reservado"
        livro.setReservadoLivro(true);
        livroRepository.save(livro);

        Reserva reserva = new Reserva();
        reserva.setLivroReserva(livro);
        reserva.setUsuarioReserva(usuario);
        reserva.setStatusReserva("Em andamento");
        reserva.setDataReserva(java.time.LocalDate.now());

        return reservaRepository.save(reserva);
    }

    // Finaliza uma reserva
    @Transactional
    public Reserva finalizarReserva(long idReserva) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(idReserva);

        if (reservaOptional.isEmpty()) {
            throw new RuntimeException("Reserva não encontrada");
        }

        Reserva reserva = reservaOptional.get();
        Livro livro = reserva.getLivroReserva();

        // Atualiza o status da reserva e do livro
        reserva.setStatusReserva("Finalizado");
        livro.setReservadoLivro(false);

        livroRepository.save(livro);
        return reservaRepository.save(reserva);
    }
}
