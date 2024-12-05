package com.grupointegrado.ecomercy.repository;

import com.grupointegrado.ecomercy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
