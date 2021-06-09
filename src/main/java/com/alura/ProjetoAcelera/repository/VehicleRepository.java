package com.alura.ProjetoAcelera.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.ProjetoAcelera.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	List<Vehicle> findByModel(String modelVehicle);

}
