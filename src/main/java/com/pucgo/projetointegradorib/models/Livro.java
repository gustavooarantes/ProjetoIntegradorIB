package com.pucgo.projetointegradorib.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @Column(nullable = false)
    private String tituloLivro;

    @ManyToOne
    @JoinColumn(name = "idGenero", nullable = false)
    private Genero generoLivro;

    @ManyToOne
    @JoinColumn(name = "idAutor", nullable = false)
    private Autor autorLivro;

    @ManyToOne
    @JoinColumn(name = "idEditora", nullable = false)
    private Editora editoraLivro;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacaoLivro;

    private boolean statusReservaLivro;

    private boolean statusEmprestimoLivro;

    private int quantidadeDisponivelLivro;

    public boolean estaEmprestadoLivro() {
        return statusEmprestimoLivro;
    }

    public void setEmprestadoLivro(boolean statusEmprestimoLivro) {
        this.statusEmprestimoLivro = statusEmprestimoLivro;
    }

    public boolean estaReservadoLivro() {
        return statusReservaLivro;
    }

    public void setReservadoLivro(boolean statusReservaLivro) {
        this.statusReservaLivro = statusReservaLivro;
    }

    public Autor getAutor() {
        return autorLivro;
    }

    public void setAutor(Autor autorLivro) {
        this.autorLivro = autorLivro;
    }

    public Editora getEditora() {
        return editoraLivro;
    }

    public void setEditora(Editora editoraLivro) {
        this.editoraLivro = editoraLivro;
    }

    public Genero getGenero() {
        return generoLivro;
    }

    public void setGenero(Genero generoLivro) {
        this.generoLivro = generoLivro;
    }
}
