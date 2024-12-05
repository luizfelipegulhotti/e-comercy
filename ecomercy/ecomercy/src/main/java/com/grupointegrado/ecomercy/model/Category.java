package com.grupointegrado.ecomercy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 200)
    private String nome;


    @OneToMany(mappedBy = "category")
    @JsonIgnoreProperties({"category",})
    private List<Ecomercy> ecomercy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ecomercy> getEcomercy() {
        return ecomercy;
    }

    public void setEcomercy(List<Ecomercy> ecomercy) {
        this.ecomercy = ecomercy;
    }
}
