/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliotecaweb.sistema_biblioteca;

import com.bibliotecaweb.sistema_biblioteca.model.Livro;
import com.bibliotecaweb.sistema_biblioteca.service.LivroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ticks
 */
@RestController
@RequestMapping("/livros")

public class LivroController {
     @Autowired
    private LivroService livroService;

    // Endpoint para cadastrar um novo livro
    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.salvarLivro(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    // Endpoint para listar todos os livros
    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }

    // Endpoint para atualizar um livro existente
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        Livro livro = livroService.atualizarLivro(id, livroAtualizado);
        return ResponseEntity.ok(livro);
    }

    // Endpoint para deletar um livro pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

}
