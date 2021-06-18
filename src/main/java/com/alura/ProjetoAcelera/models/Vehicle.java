package com.alura.ProjetoAcelera.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Brand brand;

	private String model;

	private Long years;

	private Double price;

	public Vehicle(Brand brand, String model, Long years, Double price) {
		this.brand = brand;
		this.model = model;
		this.years = years;
		this.price = price;

	}
}
