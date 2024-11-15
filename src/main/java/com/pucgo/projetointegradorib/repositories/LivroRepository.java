package com.pucgo.projetointegradorib.repositories;

import com.pucgo.projetointegradorib.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Livro l SET l.quantidadeDisponivelLivro = :quantidade WHERE l.idLivro = :id")
    void atualizarQuantidadeDisponivel(Long id, int quantidade);
}
