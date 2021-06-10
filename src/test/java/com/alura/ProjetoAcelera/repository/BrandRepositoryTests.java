package com.alura.ProjetoAcelera.repository;

import com.alura.ProjetoAcelera.models.Brand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class BrandRepositoryTests {
    @Autowired private BrandRepository brandRepository;
    @Autowired private TestEntityManager em;

    @Test
    public void findByNameTest(){
        String name = "marca 1";

        Brand brandTest = new Brand();
        brandTest.setName(name);
        em.persist(brandTest);

        Brand brand = brandRepository.findByName(name);
        Assert.assertNotNull(brand);
        Assert.assertEquals(name, brand.getName());
    }
}
