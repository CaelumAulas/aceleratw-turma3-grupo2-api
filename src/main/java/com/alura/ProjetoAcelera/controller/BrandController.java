package com.alura.ProjetoAcelera.controller;
import com.alura.ProjetoAcelera.dto_form.dto.BrandDto;
import com.alura.ProjetoAcelera.dto_form.form.BrandForm;
import com.alura.ProjetoAcelera.models.Brand;
import com.alura.ProjetoAcelera.repository.BrandRepository;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @GetMapping
    @Cacheable(value = "brandsList")
    public Page<BrandDto> getAllBrands(@RequestParam(required = false) String name,
                                 @PageableDefault(sort = "name",
                                         direction = Sort.Direction.ASC,
                                         page = 0, size = 10)
                                         Pageable pages) {

        if (name == null) {
            Page<Brand> brands = brandRepository.findAll(pages);
            return BrandDto.convert(brands);
        } else {
            Page<Brand> brands = brandRepository.findByName(name, pages);
            return BrandDto.convert(brands);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> getBrand(@PathVariable Integer id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isPresent()) {
            return ResponseEntity.ok(new BrandDto(brand.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "brandsList", allEntries = true)
    public ResponseEntity<BrandDto> registerBrand(@RequestBody BrandForm form,
                                              UriComponentsBuilder uriBuilder) {
        Brand brand = form.convert(brandRepository);
        brandRepository.save(brand);

        URI uri = uriBuilder.path("/brands/{id}").buildAndExpand(brand.getId()).toUri();
        return ResponseEntity.created(uri).body(new BrandDto(brand));
    }
}
