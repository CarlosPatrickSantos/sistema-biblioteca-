package com.bibliotecaweb.sistema_biblioteca.repository;

import com.bibliotecaweb.sistema_biblioteca.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
}

