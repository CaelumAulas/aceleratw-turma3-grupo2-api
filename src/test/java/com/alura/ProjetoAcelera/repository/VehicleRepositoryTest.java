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

import com.alura.ProjetoAcelera.models.Vehicle;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class VehicleRepositoryTest {

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	private TestEntityManager em;
	
	
	@Test
	public void findByNameVehicle() {
		String nameVehicle = "Palio";
		
		Vehicle vehicleTest = new Vehicle();
		vehicleTest.setModel(nameVehicle);
		em.persist(vehicleTest);
		
		Vehicle vehicle = vehicleRepository.findByModel(nameVehicle);
		Assert.assertNotNull(nameVehicle);
		Assert.assertEquals(nameVehicle, vehicle.getModel());
	}

}
