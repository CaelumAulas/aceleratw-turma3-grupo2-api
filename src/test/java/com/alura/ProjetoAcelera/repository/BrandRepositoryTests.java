package com.alura.ProjetoAcelera.repository;

import com.alura.ProjetoAcelera.models.Brand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
public class BrandRepositoryTests {
    @Autowired private BrandRepository brandRepository;

    @Test
    public void findByNameTest(){
        String name = "marca 1";
        Brand brand = brandRepository.findByName(name);
        Assert.assertNotNull(brand);
        Assert.assertEquals(name, brand.getName());
    }
}
