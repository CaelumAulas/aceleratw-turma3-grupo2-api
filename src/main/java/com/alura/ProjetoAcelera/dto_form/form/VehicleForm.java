package com.alura.ProjetoAcelera.dto_form.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.alura.ProjetoAcelera.models.Brand;
import com.alura.ProjetoAcelera.models.Vehicle;
import com.alura.ProjetoAcelera.repository.BrandRepository;

public class VehicleForm {

	private Long idVehicle;
	@NotNull
	@NotEmpty
	private String nameBrand;
	@NotNull
	@NotEmpty
	private String model;
	@NotNull
	private Long years;
	@NotNull
	private Double price;

	public VehicleForm(Long idVehicle, String nameBrand, String model, Long years, Double price) {

		this.idVehicle = idVehicle;
		this.nameBrand = nameBrand;
		this.model = model;
		this.years = years;
		this.price = price;
	}

	public Vehicle convert(BrandRepository brandRepository) {
		Brand brand = brandRepository.findByName(nameBrand);
		return new Vehicle(idVehicle, brand, model, years, price);
	}


}
