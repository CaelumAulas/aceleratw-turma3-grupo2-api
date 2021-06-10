package com.alura.ProjetoAcelera.repository;

import com.alura.ProjetoAcelera.models.User;
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
public class UserRepositoryTests {
    @Autowired private UserRepository userRepository;
    @Test
    public void findByNameTest(){
        String name = "luiza";
        User user = userRepository.findByName(name);
        Assert.assertNotNull(user);
        Assert.assertEquals(name, user.getName());
    }
}
