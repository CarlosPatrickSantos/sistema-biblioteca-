package com.bibliotecaweb.sistema_biblioteca.service;

import com.bibliotecaweb.sistema_biblioteca.model.Emprestimo;
import com.bibliotecaweb.sistema_biblioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    // Método para salvar um novo empréstimo
    public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    // Método para listar todos os empréstimos
    public List<Emprestimo> listarTodosEmprestimos() {
        return emprestimoRepository.findAll();
    }

    // Método para atualizar um empréstimo existente
    public Emprestimo atualizarEmprestimo(Long id, Emprestimo emprestimoAtualizado) {
        // Verifica se o empréstimo existe
        Emprestimo emprestimoExistente = emprestimoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Empréstimo com ID " + id + " não encontrado."));

        // Atualiza os dados
        emprestimoExistente.setCliente(emprestimoAtualizado.getCliente());
        emprestimoExistente.setLivro(emprestimoAtualizado.getLivro());
        emprestimoExistente.setDataEmprestimo(emprestimoAtualizado.getDataEmprestimo());
        emprestimoExistente.setDataDevolucao(emprestimoAtualizado.getDataDevolucao());

        // Salva as alterações
        return emprestimoRepository.save(emprestimoExistente);
    }

    // Método para deletar um empréstimo pelo ID
    public void deletarEmprestimo(Long id) {
        if (!emprestimoRepository.existsById(id)) {
            throw new RuntimeException("Empréstimo com ID " + id + " não encontrado para exclusão.");
        }
        emprestimoRepository.deleteById(id);
    }
}