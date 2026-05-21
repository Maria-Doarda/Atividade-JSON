package com.example.nsei.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ClienteModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ProdutoModel> produtoModels;

    public ClienteModel() {
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProdutoModel> getProdutoModels() {
        return produtoModels;
    }

    public void setProdutoModels(List<ProdutoModel> produtoModels) {
        this.produtoModels = produtoModels;
    }
}
