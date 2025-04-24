package com.bibliotecaweb.sistema_biblioteca.controller;

import com.bibliotecaweb.sistema_biblioteca.model.Emprestimo;
import com.bibliotecaweb.sistema_biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    // Endpoint para registrar um novo empréstimo
   @PostMapping
public ResponseEntity<Emprestimo> registrarEmprestimo(@RequestBody Emprestimo emprestimo) {
    Emprestimo novoEmprestimo = emprestimoService.salvarEmprestimo(emprestimo);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoEmprestimo);
}


    // Endpoint para listar todos os empréstimos
    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarEmprestimos() {
        List<Emprestimo> emprestimos = emprestimoService.listarTodosEmprestimos();
        return ResponseEntity.ok(emprestimos);
    }

    // Endpoint para atualizar um empréstimo
    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> atualizarEmprestimo(@PathVariable Long id, @RequestBody Emprestimo emprestimoAtualizado) {
        Emprestimo emprestimo = emprestimoService.atualizarEmprestimo(id, emprestimoAtualizado);
        return ResponseEntity.ok(emprestimo);
    }

    // Endpoint para deletar um empréstimo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmprestimo(@PathVariable Long id) {
        emprestimoService.deletarEmprestimo(id);
        return ResponseEntity.noContent().build();
    }
}
