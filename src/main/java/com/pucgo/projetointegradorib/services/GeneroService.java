package com.pucgo.projetointegradorib.services;

import com.pucgo.projetointegradorib.models.Genero;
import com.pucgo.projetointegradorib.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepository;

    // Lista todos os gêneros
    public List<Genero> listarGeneros() {
        return generoRepository.findAll();
    }

    // Busca um gênero por seu id
    public Genero buscarPorId(Long id) {
        return generoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gênero não encontrado com ID: " + id));
    }

    // Cadastrar um gênero
    public Genero cadastrarGenero (Genero genero) {
        return generoRepository.save(genero);
    }
}
