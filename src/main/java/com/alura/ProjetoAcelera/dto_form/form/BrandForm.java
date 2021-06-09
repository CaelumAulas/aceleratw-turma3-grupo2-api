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

    public Brand convert(BrandRepository brandRepository){
        Brand brand = brandRepository.findByName(name);
        return new Brand(name);
    }
}
