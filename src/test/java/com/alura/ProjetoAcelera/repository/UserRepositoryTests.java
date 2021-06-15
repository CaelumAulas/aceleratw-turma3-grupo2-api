package com.alura.ProjetoAcelera.repository;

import com.alura.ProjetoAcelera.models.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TestEntityManager em;

	@Test
	public void findByNameTest() {
		String name = "luiza";

		User userTest = new User();
		userTest.setName(name);
		em.persist(userTest);

		Optional<User> optionalUser = userRepository.findByName(name);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			Assert.assertNotNull(user);
			Assert.assertEquals(name, user.getName());
		}
	}

    @Test
    public void doesntFindByNameTest(){
        String name = "user que nao existe";

        User user = userRepository.findByName(name);
        Assert.assertNull(user);
    }

    @Test
    public void findByIdTest(){
        String name = "luiza";

        User userTest = new User();
        userTest.setName(name);
        em.persist(userTest);

        Optional<User> user = userRepository.findById(userTest.getId());
        Assert.assertEquals(user.get(), userTest);
    }
}
