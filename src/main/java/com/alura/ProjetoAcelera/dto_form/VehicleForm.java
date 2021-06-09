package com.alura.ProjetoAcelera.dto_form;

import com.alura.ProjetoAcelera.models.Brand;
import com.alura.ProjetoAcelera.models.Vehicle;
import com.alura.ProjetoAcelera.repository.BrandRepository;

import lombok.Data;

@Data
public class VehicleForm {

	private Long idVehicle;
	private String nameBrand;
	private String model;
	private Long year;
	private Double price;

	public VehicleForm(Long idVehicle, String nameBrand, String model, Long year, Double price) {
		super();
		this.idVehicle = idVehicle;
		this.nameBrand = nameBrand;
		this.model = model;
		this.year = year;
		this.price = price;
	}

	public Vehicle converter(BrandRepository brandRepository) {
		//Brand brand = brandRepository.findByName(nameBrand);
		return new Vehicle(idVehicle,/* brand,*/ model, year, price);
	}

}
