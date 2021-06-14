package com.alura.ProjetoAcelera.dto_form.dto;

import org.springframework.data.domain.Page;

import com.alura.ProjetoAcelera.models.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

	private Long idVehicle;
	private String brand;
	private String model;
	private Long years;
	private Double price;

	public VehicleDto(Vehicle vehicle) {
		this.idVehicle = vehicle.getId();
		this.brand = vehicle.getBrand().getName();
		this.model = vehicle.getModel();
		this.years = vehicle.getYears();
		this.price = vehicle.getPrice();

	}

	public static Page<VehicleDto> converter(Page<Vehicle> vehicles) {
		return vehicles.map(VehicleDto::new);

	}

}
