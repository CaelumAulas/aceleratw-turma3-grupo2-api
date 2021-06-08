package com.alura.ProjetoAcelera.repository;

import com.alura.ProjetoAcelera.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findByName(String name);
}