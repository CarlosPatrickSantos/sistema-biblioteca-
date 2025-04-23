/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliotecaweb.sistema_biblioteca;

import com.bibliotecaweb.sistema_biblioteca.repository.ClienteRepository;
import com.bibliotecaweb.sistema_biblioteca.repository.EmprestimoRepository;
import com.bibliotecaweb.sistema_biblioteca.repository.LivroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ticks
 */
@RestController
@RequestMapping("/buscar")
public class BuscarController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @GetMapping
    public List<?> buscar(@RequestParam String tipo, @RequestParam String valor) {
        switch (tipo.toLowerCase()) {
            case "cliente":
                return clienteRepository.findByNomeContainingIgnoreCase(valor);
            case "autor":
                return livroRepository.findByAutorContainingIgnoreCase(valor);
            case "emprestimo":
                return emprestimoRepository.findByCliente_NomeContainingIgnoreCase(valor);
            default:
                return List.of();
        }
    }
}
