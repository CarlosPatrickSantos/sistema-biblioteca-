/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibliotecaweb.sistema_biblioteca;

/**
 *
 * @author ticks
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class WebController {
    
    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("Saying hello...");
                
        return "hello";
    }
     @RequestMapping("/Login")
    public String showLogin() {
        System.out.println("Showing login...");
        return "Login";
    }
   
    
    @RequestMapping("/Biblioteca")
    public String biblioteca() {
        System.out.println("Showing tela biblioteca...");
        return "Biblioteca"; // Retorna a página Biblioteca.html em templates/
    }
    
    @RequestMapping("/CadastroCliente")
    public String cadastrocliente () {
        System.out.println("Showing tela cadastro de cliente");
        return "CadastroCliente";
    }
    
    @RequestMapping("/CadastroLivros")
    public String cadastrarlivro () {
        System.out.println("Showing tela cadastro de livros");
        return "CadastroLivros"; // Retorna CadastroLivros.html
    }
    
    @RequestMapping("/Emprestimos")
    public String emprestimos() {
        System.out.println("Exibindo tela de emprestimos");
        return "Emprestimos"; // Retorna Emprestimos.html
    }
@RequestMapping("/Buscar")
    public String buscar() {
        System.out.println("Exibindo tela de busca");
        return "Buscar"; // Retorna o arquivo Buscar.html
    }
     @RequestMapping("/Configuracoes")
    public String configuracoes() {
        System.out.println("Exibindo tela de configurações");
        return "Configuracoes"; // Retorna o template Configuracoes.html
    }
}

