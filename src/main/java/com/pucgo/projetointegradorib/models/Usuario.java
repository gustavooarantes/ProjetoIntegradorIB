package com.pucgo.projetointegradorib.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Usuarios")
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

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastroUsuario;
}
