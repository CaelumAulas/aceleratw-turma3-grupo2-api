package com.alura.ProjetoAcelera.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.alura.ProjetoAcelera.models.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UserRepositoryTests {
    @Autowired private UserRepository userRepository;
    @Autowired private TestEntityManager em;

    @Test
    public void findByNameTest(){
        String name = "luiza";

        User userTest = new User();
        userTest.setName(name);
        em.persist(userTest);

        User user = userRepository.findByName(name);
        Assert.assertNotNull(user);
        Assert.assertEquals(name, user.getName());
    }
}
