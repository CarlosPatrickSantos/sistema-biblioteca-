package com.bibliotecaweb.sistema_biblioteca.service;

import com.bibliotecaweb.sistema_biblioteca.model.Livro;
import com.bibliotecaweb.sistema_biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class LivroService {
private static final Logger logger = LoggerFactory.getLogger(LivroService.class);

    @Autowired
    private LivroRepository livroRepository;

    // Método para salvar um livro
    public Livro salvarLivro(Livro livro) {
     if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
        throw new RuntimeException("O título do livro é obrigatório.");
    }
    if (livro.getAutor() == null || livro.getAutor().isEmpty()) {
        throw new RuntimeException("O autor do livro é obrigatório.");
    }
    if (livro.getEdicao() == null || livro.getEdicao().isEmpty()) {
        throw new RuntimeException("A edição do livro é obrigatória.");
    }
    return livroRepository.save(livro); // Persistindo no banco

    }

    // Método para listar todos os livros
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    // Método para atualizar um livro existente
    public Livro atualizarLivro(Long id, Livro livroAtualizado) {
        Livro livroExistente = livroRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Livro com ID " + id + " não encontrado."));

    // Atualizar apenas se os dados forem válidos
    if (livroAtualizado.getTitulo() != null && !livroAtualizado.getTitulo().isEmpty()) {
        livroExistente.setTitulo(livroAtualizado.getTitulo());
    }
    if (livroAtualizado.getAutor() != null && !livroAtualizado.getAutor().isEmpty()) {
        livroExistente.setAutor(livroAtualizado.getAutor());
    }
    if (livroAtualizado.getEdicao() != null && !livroAtualizado.getEdicao().isEmpty()) {
        livroExistente.setEdicao(livroAtualizado.getEdicao());
    }

    return livroRepository.save(livroExistente);

    }

    // Método para deletar um livro pelo ID
    public void deletarLivro(Long id) {
        if (!livroRepository.existsById(id)) {
        throw new RuntimeException("Livro com ID " + id + " não encontrado para deletar.");
    }
    livroRepository.deleteById(id);

    }
}