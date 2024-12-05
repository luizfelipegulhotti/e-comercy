package com.grupointegrado.ecomercy.repository;

import com.grupointegrado.ecomercy.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {
}
