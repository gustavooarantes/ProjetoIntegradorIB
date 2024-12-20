package com.pucgo.projetointegradorib.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Editoras")
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditora;

    @Column(nullable = false)
    private String nomeEditora;

    private String paisEditora;
}
