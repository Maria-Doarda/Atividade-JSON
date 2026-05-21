package com.example.nsei.controllers;


import com.example.nsei.models.ClienteModel;
import com.example.nsei.services.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    // Criar cliente
    @PostMapping
    public ClienteModel salvar(@RequestBody ClienteModel cliente) {
        return service.salvar(cliente);
    }

    // Listar todos clientes
    @GetMapping
    public List<ClienteModel> listarTodos() {
        return service.listarTodos();
    }

    // Buscar cliente por ID
    @GetMapping("/{id}")
    public ClienteModel buscarPorId(@PathVariable Long id) {

        return service.buscarPorId(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado"));
    }

    // Atualizar cliente
    @PutMapping("/{id}")
    public ClienteModel atualizar(
            @PathVariable Long id,
            @RequestBody ClienteModel cliente) {

        return service.atualizar(id, cliente);
    }

    // Deletar cliente
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
