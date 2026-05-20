package com.example.nsei.models;

public class ProdutoModel {

    private Long id;
    private String nome;
    private Double preco;

    public ProdutoModel() {
    }

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public Double getPreco() {
    return preco;
}

public void setPreco(Double preco) {
    this.preco = preco;
}
}
