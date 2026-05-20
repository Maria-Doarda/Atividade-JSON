package com.example.nsei.services;


import com.example.nsei.models.ClienteModel;
import com.example.nsei.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public ClienteModel salvar(ClienteModel cliente) {
        return repository.save(cliente);
    }

    public List<ClienteModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<ClienteModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ClienteModel atualizar(Long id, ClienteModel clienteAtualizado) {

        ClienteModel cliente = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado"));

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(clienteAtualizado.getEmail());

        return repository.save(cliente);
    }

    public void deletar(Long id) {

        ClienteModel cliente = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado"));

        repository.delete(cliente);
    }
}
