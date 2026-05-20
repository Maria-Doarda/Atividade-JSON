package com.example.nsei.controllers;


import com.example.nsei.models.ProdutoModel;
import com.example.nsei.services.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ProdutoModel salvar(@RequestBody ProdutoModel produto) {
        return service.salvar(produto);
    }

    @GetMapping
    public List<ProdutoModel> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ProdutoModel buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizar(
            @PathVariable Long id,
            @RequestBody ProdutoModel produto) {

        return service.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
