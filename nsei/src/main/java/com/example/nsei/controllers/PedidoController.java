package com.example.nsei.controllers;


import com.example.nsei.models.PedidoModel;
import com.example.nsei.services.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public PedidoModel salvar(@RequestBody PedidoModel pedido) {
        return service.salvar(pedido);
    }

    @GetMapping
    public List<PedidoModel> listar() {
        return service.listar();
    }
}