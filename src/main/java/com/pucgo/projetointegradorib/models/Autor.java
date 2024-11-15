package com.pucgo.projetointegradorib.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    @Column(nullable = false)
    private String nomeAutor;

    private String nacionalidadeAutor;

    private LocalDate dataNascimentoAutor;
}
