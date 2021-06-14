package com.alura.ProjetoAcelera.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alura.ProjetoAcelera.models.Brand;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehicleRepositoryTest {

	@Autowired
	BrandRepository brandRepository;
	
	@Test
	public void findByNameBrand() {
		String nameBrand = "marca 1";
		Brand brand = brandRepository.findByName(nameBrand);
		Assert.assertNotNull(brand);
		Assert.assertEquals(nameBrand, brand.getName());
	}

}
