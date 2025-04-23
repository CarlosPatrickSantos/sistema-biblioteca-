package com.bibliotecaweb.sistema_biblioteca.controller;

import com.bibliotecaweb.sistema_biblioteca.model.Livro;
import com.bibliotecaweb.sistema_biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin(origins = "*") // Permite chamadas de outros domínios, útil se usar JS
public class LivroRestController {

    @Autowired
    private LivroRepository livroRepository;

    // Buscar todos os livros
    @GetMapping
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    // Salvar novo livro
    @PostMapping
    public Livro salvarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    // Deletar livro por ID
    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
    }
}
