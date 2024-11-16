package com.pucgo.projetointegradorib.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    @Column(nullable = false)
    private String nomeAutor;

    private String nacionalidadeAutor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimentoAutor;
}
