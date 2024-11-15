package com.pucgo.projetointegradorib.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false)
    private String nomeUsuario;

    @Column(unique = true)
    private String emailUsuario;

    private String enderecoUsuario;

    private String telefoneUsuario;

    private LocalDate dataCadastroUsuario;
}
