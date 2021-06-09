package com.alura.ProjetoAcelera.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "vehicle_id")
	private Long idVehicle;
	/*@ManyToOne
	private Brand nameBrand;
	@ManyToOne
	private User idUser;*/
	
	private String model;
	private Long years;
	private Double price;
	

	/*public Vehicle(Long idVehicle, Brand brand, String model, Long years, Double price) {
		this.idVehicle = idVehicle;
		//this.nameBrand = brand;
		this.model = model;
		this.years = years;
		this.price = price;
	}*/
	
}
