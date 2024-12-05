package com.grupointegrado.ecomercy.repository;

import com.grupointegrado.ecomercy.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {
}
