package com.grupointegrado.ecomercy.repository;

import com.grupointegrado.ecomercy.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
}
