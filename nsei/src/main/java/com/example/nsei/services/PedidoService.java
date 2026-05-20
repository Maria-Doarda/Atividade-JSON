package com.example.nsei.services;

import com.example.nsei.models.PedidoModel;
import com.example.nsei.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public PedidoModel salvar(PedidoModel pedido) {
        return repository.save(pedido);
    }

    public List<PedidoModel> listar() {
        return repository.findAll();
    }
}
