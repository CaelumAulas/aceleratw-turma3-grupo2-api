package com.alura.ProjetoAcelera.repository;

import com.alura.ProjetoAcelera.models.Brand;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Page<Brand> findByName(String name, Pageable pages);

	Brand findByName(String name);

	Optional<Brand> findById(Long id);
    
    
}