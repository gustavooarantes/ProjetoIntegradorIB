package com.pucgo.projetointegradorib.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuario usuarioReserva;

    @ManyToOne
    @JoinColumn(name = "ID_Livro", nullable = false)
    private Livro livroReserva;

    @Column(nullable = false)
    private String statusReserva; // iniciada, finalizada, expirada

    @Column(nullable = false)
    private LocalDate dataReserva;
}
