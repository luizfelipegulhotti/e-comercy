package com.grupointegrado.ecomercy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Ecomercy {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String nome;

    @Column
    private BigDecimal nota;

    @Column
    private String resumo;


    @ManyToOne

    @JoinColumn(name = "category_id", referencedColumnName = "id")

    @JsonIgnoreProperties("ecomercy")
    private Category category;



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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ecomercy ecomercy = (Ecomercy) o;
        return Objects.equals(id, ecomercy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
