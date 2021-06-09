package com.alura.ProjetoAcelera.repository;

import com.alura.ProjetoAcelera.models.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Page<Brand> findByName(String name, Pageable pages);
}