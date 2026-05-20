package com.example.nsei.models;

import com.example.nsei.models.PedidoModel;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class ClienteModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<PedidoModel> pedidos;

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

    public List<PedidoModel> getPedidos() {
        return pedidos;
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

    public void setPedidos(List<PedidoModel> pedidos) {
        this.pedidos = pedidos;
    }
}
