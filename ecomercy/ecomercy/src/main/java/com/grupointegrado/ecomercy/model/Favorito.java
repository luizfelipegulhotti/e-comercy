package com.grupointegrado.ecomercy.model;

import com.grupointegrado.ecomercy.model.Cliente;
import jakarta.persistence.*;


@Entity
@Table(name = "favorito")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_favorito;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Integer getId_favorito() {
        return id_favorito;
    }

    public void setId_favorito(Integer id_favorito) {
        this.id_favorito = id_favorito;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
// Getters e Setters
    // ...
}
