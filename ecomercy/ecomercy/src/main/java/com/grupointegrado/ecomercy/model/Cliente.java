package com.grupointegrado.ecomercy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    private String email;
    private String nome;
    private Integer idade;
    private String local;
    private String telefone;
    private String numero_ct;
    private String senha_ct;
    private String validade_ct;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha_ct() {
        return senha_ct;
    }

    public void setSenha_ct(String senha_ct) {
        this.senha_ct = senha_ct;
    }

    public String getNumero_ct() {
        return numero_ct;
    }

    public void setNumero_ct(String numero_ct) {
        this.numero_ct = numero_ct;
    }

    public String getValidade_ct() {
        return validade_ct;
    }

    public void setValidade_ct(String validade_ct) {
        this.validade_ct = validade_ct;
    }
// Getters e Setters
    // ...
}
