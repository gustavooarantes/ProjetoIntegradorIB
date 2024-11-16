package com.pucgo.projetointegradorib.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuarioReserva;

    @ManyToOne
    @JoinColumn(name = "idLivro", nullable = false)
    private Livro livroReserva;

    @Column(nullable = false)
    private String statusReserva; // iniciada, finalizada

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataReserva;
}
