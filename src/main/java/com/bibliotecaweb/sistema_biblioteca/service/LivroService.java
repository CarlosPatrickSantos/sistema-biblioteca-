package com.bibliotecaweb.sistema_biblioteca.service;

import com.bibliotecaweb.sistema_biblioteca.model.Livro;
import com.bibliotecaweb.sistema_biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    // Método para salvar um livro
    public Livro salvarLivro(Livro livro) {
        // Opcional: Adicionar validações antes de salvar
        return livroRepository.save(livro);
    }

    // Método para listar todos os livros
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    // Método para atualizar um livro existente
    public Livro atualizarLivro(Long id, Livro livroAtualizado) {
        // Verificar se o livro existe antes de atualizar
        Livro livroExistente = livroRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Livro não encontrado."));
        livroAtualizado.setId(id);
        return livroRepository.save(livroAtualizado);
    }

    // Método para deletar um livro pelo ID
    public void deletarLivro(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new RuntimeException("Livro não encontrado para deletar.");
        }
        livroRepository.deleteById(id);
    }
}