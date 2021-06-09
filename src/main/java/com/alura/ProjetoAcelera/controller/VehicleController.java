package com.alura.ProjetoAcelera.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.ProjetoAcelera.dto_form.VehicleForm;
import com.alura.ProjetoAcelera.dto_form.dto.VehicleDto;
import com.alura.ProjetoAcelera.models.Vehicle;
import com.alura.ProjetoAcelera.repository.BrandRepository;
import com.alura.ProjetoAcelera.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	BrandRepository brandRepository;

	@GetMapping
	public List<VehicleDto> listVehicle(String modelVehicle) {
		if (modelVehicle == null) {
			List<Vehicle> vehicles = vehicleRepository.findAll();
			return VehicleDto.converter(vehicles);
		} else {
			List<Vehicle> vehicles = vehicleRepository.findByModel(modelVehicle);
			return VehicleDto.converter(vehicles);
		}

	}

	@PostMapping
	public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleForm vehicleForm,
			UriComponentsBuilder uriComponentsBuilder) {
		Vehicle vehicle = vehicleForm.converter(brandRepository);
		vehicleRepository.save(vehicle);

		URI uri = uriComponentsBuilder.path("/vehicle/{id}").buildAndExpand(vehicle.getIdVehicle()).toUri();

		return ResponseEntity.created(uri).body(new VehicleDto(vehicle));
	}

}
