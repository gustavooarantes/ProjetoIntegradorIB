package com.pucgo.projetointegradorib.repositories;

import com.pucgo.projetointegradorib.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
