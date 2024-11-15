package com.pucgo.projetointegradorib.services;

import com.pucgo.projetointegradorib.models.Editora;
import com.pucgo.projetointegradorib.repositories.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {
    @Autowired
    private EditoraRepository editoraRepository;

    // Lista todas as editoras
    public List<Editora> listarEditoras() {
        return editoraRepository.findAll();
    }

    // Busca uma editora por seu id
    public Editora buscarPorId(Long id) {
        return editoraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editora não encontrada com ID: " + id));
    }
}
