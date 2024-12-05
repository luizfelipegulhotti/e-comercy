package com.grupointegrado.ecomercy.repository;

import com.grupointegrado.ecomercy.model.Ecomercy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EcomercyRepository extends JpaRepository<Ecomercy, Integer> {
}
