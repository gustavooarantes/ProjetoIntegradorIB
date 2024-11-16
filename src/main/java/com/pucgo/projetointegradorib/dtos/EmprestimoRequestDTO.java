package com.pucgo.projetointegradorib.dtos;

import com.pucgo.projetointegradorib.models.Livro;
import com.pucgo.projetointegradorib.models.Usuario;

public class EmprestimoRequestDTO {
    private Livro livro;
    private Usuario usuario;

    // Getters e Setters
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
