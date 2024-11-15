package com.pucgo.projetointegradorib.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenero;

    @Column(nullable = false)
    private String nomeGenero;
}
