/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bibliotecaweb.sistema_biblioteca.repository;

import com.bibliotecaweb.sistema_biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ticks
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
