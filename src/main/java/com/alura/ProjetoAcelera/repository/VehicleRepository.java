package com.alura.ProjetoAcelera.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.ProjetoAcelera.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	Page<Vehicle> findByModel(String modelVehicle, Pageable pages);

	List<Vehicle> findByBrandName(String brandNome);
	
	Vehicle findByModel(String modelVehicle);

}
