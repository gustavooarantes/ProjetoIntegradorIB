package com.pucgo.projetointegradorib.repositories;

import com.pucgo.projetointegradorib.models.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
}
