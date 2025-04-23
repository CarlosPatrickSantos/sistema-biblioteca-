package com.bibliotecaweb.sistema_biblioteca.repository;

import com.bibliotecaweb.sistema_biblioteca.model.Livro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByAutorContainingIgnoreCase(String autor);
}

