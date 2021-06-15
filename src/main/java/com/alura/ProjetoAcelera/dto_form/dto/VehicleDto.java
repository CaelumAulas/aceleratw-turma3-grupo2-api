package com.alura.ProjetoAcelera.dto_form.dto;

import com.alura.ProjetoAcelera.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

	private Long idVehicle;

	private String brand;

	private Long brandId;

	private String model;

	private Long years;

	private Double price;

	public VehicleDto(Vehicle vehicle) {
		this.idVehicle = vehicle.getId();
		this.brand = vehicle.getBrand().getName();
		this.brandId = vehicle.getBrand().getId();
		this.model = vehicle.getModel();
		this.years = vehicle.getYears();
		this.price = vehicle.getPrice();

	}

	public static Page<VehicleDto> converter(Page<Vehicle> vehicles) {
		return vehicles.map(VehicleDto::new);

	}

}
