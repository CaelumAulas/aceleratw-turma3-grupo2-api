package com.alura.ProjetoAcelera.dto_form.form;


import com.alura.ProjetoAcelera.models.Brand;
import com.alura.ProjetoAcelera.repository.BrandRepository;
import com.sun.istack.NotNull;


public class BrandForm {
    @NotNull
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Brand convert(BrandRepository brandRepository) {
        return new Brand(name);
    }

    public Brand update(Long id, BrandRepository brandRepository) {
        Brand brand = brandRepository.getById(id);
        brand.setName(this.name);
        return brand;
    }
}
