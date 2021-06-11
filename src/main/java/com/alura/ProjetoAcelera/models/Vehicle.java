package com.alura.ProjetoAcelera.models;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.domain.Page;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@Data

@NoArgsConstructor
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Brand brand;
	/*@ManyToOne
	private User idUser;*/
	
	private String model;
	private Long years;
	private Double price;
	

	public Vehicle(Long id, Brand brand, String model, Long years, Double price) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.years = years;
		this.price = price;
	}


	public Vehicle(Long idVehicle2, Page<Brand> brand, String model2, Long years2, Double price2) {
		// TODO Auto-generated constructor stub
	}


	public Vehicle(Long idVehicle2, Optional<Brand> brand2, String model2, Long years2, Double price2) {
		// TODO Auto-generated constructor stub
	}
	
}
