package com.pucgo.projetointegradorib.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Emprestimos")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuarioEmprestimo;

    @ManyToOne
    @JoinColumn(name = "idLivro", nullable = false)
    private Livro livroEmprestimo;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEmprestimo;

    @Column(nullable = false)
    private String statusEmprestimo; // ativo, finalizado
}
