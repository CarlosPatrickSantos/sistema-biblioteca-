package com.bibliotecaweb.sistema_biblioteca.repository;

import com.bibliotecaweb.sistema_biblioteca.model.Emprestimo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findByCliente_NomeContainingIgnoreCase(String nome);
}
