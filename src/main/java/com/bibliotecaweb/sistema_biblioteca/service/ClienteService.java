package com.bibliotecaweb.sistema_biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bibliotecaweb.sistema_biblioteca.repository.ClienteRepository;
import com.bibliotecaweb.sistema_biblioteca.model.Cliente;
import java.util.List;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

 public Cliente salvarCliente(Cliente cliente) {
    if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
        throw new IllegalArgumentException("O nome do cliente é obrigatório.");
    }
    // Outras validações podem ser adicionadas aqui
    try {
        return clienteRepository.save(cliente);
    } catch (Exception e) {
        throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage());
    }
}

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
    if (!clienteRepository.existsById(id)) {
        throw new IllegalArgumentException("O cliente com ID " + id + " não existe.");
    }
    clienteAtualizado.setId(id); // Garante que o ID seja o correto
    return clienteRepository.save(clienteAtualizado);
}


}