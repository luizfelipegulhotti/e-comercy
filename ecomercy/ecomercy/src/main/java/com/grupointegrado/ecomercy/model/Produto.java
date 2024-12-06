package com.grupointegrado.ecomercy.model;

import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;

    private String nome;
    private Integer preco;

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public Set<Cliente> getClientesFavoritos() {
        return clientesFavoritos;
    }

    public void setClientesFavoritos(Set<Cliente> clientesFavoritos) {
        this.clientesFavoritos = clientesFavoritos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private Integer quantidade;
    private String descricao;

    @ManyToMany(mappedBy = "favoritos")
    private Set<Cliente> clientesFavoritos = new HashSet<>();

    // Getters e Setters
    // ...
}
