package com.alura.ProjetoAcelera.dto_form.dto;

import com.alura.ProjetoAcelera.models.Brand;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class BrandDto {
    private Integer id;
    private String name;

    public BrandDto(Brand Brand){
        this.id = Brand.getId();
        this.name = Brand.getName();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Page<BrandDto> convert(Page<Brand> brands) {
        return brands.map(BrandDto::new);
    }
}
