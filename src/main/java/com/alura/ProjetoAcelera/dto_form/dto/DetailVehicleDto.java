package com.alura.ProjetoAcelera.dto_form.dto;

import org.springframework.data.domain.Page;

import com.alura.ProjetoAcelera.models.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailVehicleDto {

	private Long idVehicle;
	private String brand;
	private String model;
	private Double price;

	public DetailVehicleDto(Vehicle vehicle) {
		this.idVehicle = vehicle.getId();
		this.brand = vehicle.getBrand().getName();
		this.model = vehicle.getModel();
		this.price = vehicle.getPrice();

	}

	public static Page<DetailVehicleDto> converter(Page<Vehicle> vehicles) {
		return vehicles.map(DetailVehicleDto::new);
	}
}
