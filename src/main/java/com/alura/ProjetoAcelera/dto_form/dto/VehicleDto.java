package com.alura.ProjetoAcelera.dto_form.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.alura.ProjetoAcelera.models.Brand;
import com.alura.ProjetoAcelera.models.Vehicle;

import lombok.Data;

@Data
public class VehicleDto {
	
	private Long idVehicle;
	//private Brand idBrand;
	private String model;
	private Long years;
	private Double price;
	
	public VehicleDto (Vehicle vehicle) {
		this.idVehicle = vehicle.getIdVehicle();
	//	this.idBrand = vehicle.getNameBrand();
		this.model = vehicle.getModel();
		this.years = vehicle.getYears();
		this.price = vehicle.getPrice();
		
	}
	
	public static List<VehicleDto> converter(List<Vehicle> vehicles){
		return vehicles.stream().map(VehicleDto::new).collect(Collectors.toList());
	}

}
