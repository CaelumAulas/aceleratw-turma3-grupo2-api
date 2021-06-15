package com.alura.ProjetoAcelera.dto_form.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.alura.ProjetoAcelera.models.Vehicle;
import com.alura.ProjetoAcelera.repository.BrandRepository;
import com.alura.ProjetoAcelera.repository.VehicleRepository;

public class UpdateVehicleForm {

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

	public String getNameBrand() {
		return nameBrand;
	}

	public void setNameBrand(String nameBrand) {
		this.nameBrand = nameBrand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getYears() {
		return years;
	}

	public void setYears(Long years) {
		this.years = years;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Vehicle atualizar(Long id, VehicleRepository vehicleRepository) {
		Vehicle vehicle = vehicleRepository.getById(id);
		vehicle.setModel(this.model);
		vehicle.setYears(this.years);
		vehicle.setPrice(this.price);
		return vehicle;
	}

}
