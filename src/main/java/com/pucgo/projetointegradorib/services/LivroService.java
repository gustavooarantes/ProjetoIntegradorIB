package com.pucgo.projetointegradorib.services;

import com.pucgo.projetointegradorib.models.Autor;
import com.pucgo.projetointegradorib.models.Editora;
import com.pucgo.projetointegradorib.models.Genero;
import com.pucgo.projetointegradorib.models.Livro;
import com.pucgo.projetointegradorib.repositories.AutorRepository;
import com.pucgo.projetointegradorib.repositories.EditoraRepository;
import com.pucgo.projetointegradorib.repositories.GeneroRepository;
import com.pucgo.projetointegradorib.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EditoraRepository editoraRepository;

    @Autowired
    private GeneroRepository generoRepository;

    // Lista todos os livros cadastrados no sistema
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    // Busca livro pelo seu ID
    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + id));
    }

    // Reliza o cadastro de um novo livro
    public Livro cadastrarLivro(Livro livro) {
        // Verificar e salvar o autor
        Autor autor = livro.getAutor();
        Optional<Autor> autorExistente = autorRepository.findById(autor.getIdAutor());
        if (autorExistente.isPresent()) {
            livro.setAutor(autorExistente.get());
        } else {
            autor = autorRepository.save(autor);
            livro.setAutor(autor);
        }

        // Verificar e salvar a editora
        Editora editora = livro.getEditora();
        Optional<Editora> editoraExistente = editoraRepository.findById(editora.getIdEditora());
        if (editoraExistente.isPresent()) {
            livro.setEditora(editoraExistente.get());
        } else {
            editora = editoraRepository.save(editora);
            livro.setEditora(editora);
        }

        // Verificar e salvar o gênero
        Genero genero = livro.getGenero();
        Optional<Genero> generoExistente = generoRepository.findById(genero.getIdGenero());
        if (generoExistente.isPresent()) {
            livro.setGenero(generoExistente.get());
        } else {
            genero = generoRepository.save(genero);
            livro.setGenero(genero);
        }

        // Salvar o livro
        return livroRepository.save(livro);
    }

    // Atualiza a quantidade disponível de um livro utilizando o ID do mesmo como referência
    public void atualizarQuantidadeDisponivel(Long id, int quantidade) {
        if (!livroRepository.existsById(id)) {
            throw new RuntimeException("Livro não encontrado com ID: " + id);
        }
        livroRepository.atualizarQuantidadeDisponivel(id, quantidade);
    }
}