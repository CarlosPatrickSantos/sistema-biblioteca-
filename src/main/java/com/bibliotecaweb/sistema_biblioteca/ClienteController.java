package com.bibliotecaweb.sistema_biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bibliotecaweb.sistema_biblioteca.service.ClienteService;
import com.bibliotecaweb.sistema_biblioteca.model.Cliente;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.salvarCliente(cliente); // Persistência no banco
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }
}



