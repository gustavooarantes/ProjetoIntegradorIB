package com.pucgo.projetointegradorib.services;

import com.pucgo.projetointegradorib.models.Autor;
import com.pucgo.projetointegradorib.models.Livro;
import com.pucgo.projetointegradorib.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    // Lista todos os autores
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    // Cadastra um autor
    public Autor cadastrarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    // Busca um autor por seu id
    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com ID: " + id));
    }
}
