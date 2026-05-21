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

    @PostMapping
    public ClienteModel salvar(@RequestBody ClienteModel cliente) {
        return service.salvar(cliente);
    }

    @GetMapping
    public List<ClienteModel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ClienteModel buscarPorId(@PathVariable Long id) {

        return service.buscarPorId(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado"));
    }

    @PutMapping("/{id}")
    public ClienteModel atualizar(
            @PathVariable Long id,
            @RequestBody ClienteModel cliente) {

        return service.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
