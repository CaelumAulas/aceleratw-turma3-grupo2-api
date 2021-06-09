package com.alura.ProjetoAcelera.dto_form.dto;

import org.springframework.data.domain.Page;

import com.alura.ProjetoAcelera.models.Brand;

public class BrandDto {
    private Long id;
    private String name;

    public BrandDto(Brand brand){
        this.id = brand.getId();
        this.name = brand.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Page<BrandDto> convert(Page<Brand> brands) {
        return brands.map(BrandDto::new);
    }
}
