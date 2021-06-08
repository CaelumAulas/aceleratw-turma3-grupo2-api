package com.alura.ProjetoAcelera.dto_form.dto;

import com.alura.ProjetoAcelera.models.Brand;
import org.springframework.data.domain.Page;

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

    public static Page<BrandDto> convert(Page<Brand> topicos) {
        return topicos.map(BrandDto::new);
    }
}
