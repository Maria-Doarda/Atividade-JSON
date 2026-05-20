package com.example.nsei.services;

import com.example.nsei.models.ProdutoModel;
import com.example.nsei.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoModel salvar(ProdutoModel produto) {
        return repository.save(produto);
    }

    public List<ProdutoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<ProdutoModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoAtualizado) {

        ProdutoModel produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());

        return repository.save(produto);
    }

    public void deletar(Long id) {

        ProdutoModel produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        repository.delete(produto);
    }
}
