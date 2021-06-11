package com.alura.ProjetoAcelera.utils;

import com.alura.ProjetoAcelera.models.Brand;
import com.alura.ProjetoAcelera.models.User;
import com.alura.ProjetoAcelera.models.Vehicle;
import com.alura.ProjetoAcelera.repository.BrandRepository;
import com.alura.ProjetoAcelera.repository.UserRepository;
import com.alura.ProjetoAcelera.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SeedDb implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BrandRepository brandRepository;

	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public void run(String... args) throws Exception {
		loadUserData();
		loadBrandAndVehiclesData();
	}

	private void loadUserData() {
		if (userRepository.count() == 0) {
			String password = new BCryptPasswordEncoder().encode("123");
			User user1 = new User("bianca", password);
			User user2 = new User("ingrid", password);
			User user3 = new User("luiza", password);
			User user4 = new User("ronaldo", password);
			User user5 = new User("wendel", password);
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			userRepository.save(user4);
			userRepository.save(user5);
		}
		System.out.println("Users: " + userRepository.count());
	}

	private void loadBrandAndVehiclesData() {
		if (brandRepository.count() == 0 && vehicleRepository.count() == 0) {
			Brand brand1 = new Brand("Volkswagen");
			Brand brand2 = new Brand("Fiat");
			Brand brand3 = new Brand("Renault");

			brandRepository.save(brand1);
			brandRepository.save(brand2);
			brandRepository.save(brand3);

			Vehicle vehicle1 = new Vehicle(brand1, "Gol", 2010L, 1000.0);
			Vehicle vehicle2 = new Vehicle(brand2, "Palio", 2010L, 1000.0);
			Vehicle vehicle3 = new Vehicle(brand3, "Clio", 2010L, 1000.0);

			vehicleRepository.save(vehicle1);
			vehicleRepository.save(vehicle2);
			vehicleRepository.save(vehicle3);
		}
		System.out.println("Brands: " + brandRepository.count());
		System.out.println("Vehicles: " + vehicleRepository.count());
	}

}
