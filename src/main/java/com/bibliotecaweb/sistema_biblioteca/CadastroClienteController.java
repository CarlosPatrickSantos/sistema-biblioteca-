/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliotecaweb.sistema_biblioteca;

import com.bibliotecaweb.sistema_biblioteca.model.Cliente;
import com.bibliotecaweb.sistema_biblioteca.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/CadastroCliente")
public class CadastroClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public String cadastrarCliente(Cliente cliente) {
        try {
            clienteService.salvarCliente(cliente); // Salva o cliente no banco de dados
            return "redirect:/sucesso"; // Redireciona para uma página de sucesso
        } catch (Exception e) {
            return "redirect:/erro"; // Redireciona para uma página de erro
        }
    }
}