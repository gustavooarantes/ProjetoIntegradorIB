package com.pucgo.projetointegradorib.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuario usuarioEmprestimo;

    @ManyToOne
    @JoinColumn(name = "ID_Livro", nullable = false)
    private Livro livroEmprestimo;

    @Column(nullable = false)
    private LocalDate dataEmprestimo;

    @Column(nullable = false)
    private String statusEmprestimo; // ativo, finalizado ou atrasado
}
