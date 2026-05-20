package com.example.nsei.models;

import com.example.nsei.models.ProdutoModel;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProdutoModel> products;

    public PedidoModel() {
    }

    public Long getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public List<ProdutoModel> getProducts() {
        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setProducts(List<ProdutoModel> products) {
        this.products = products;
    }
}
