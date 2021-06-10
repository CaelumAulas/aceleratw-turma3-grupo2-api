package com.alura.ProjetoAcelera.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.ProjetoAcelera.dto_form.dto.DetailVehicleDto;
import com.alura.ProjetoAcelera.dto_form.dto.VehicleDto;
import com.alura.ProjetoAcelera.dto_form.form.VehicleForm;
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
	public Page<VehicleDto> listVehicle(String modelVehicle, String brandNome,
			@PageableDefault(sort = "model", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable pages) {
		if (modelVehicle == null) {
			Page<Vehicle> vehicles = vehicleRepository.findAll(pages);
			return VehicleDto.converter(vehicles);

		} else {
			Page<Vehicle> vehicles = vehicleRepository.findByModel(modelVehicle, pages);
			return VehicleDto.converter(vehicles);
		}

	}

	@GetMapping("/{id}")
	public DetailVehicleDto detalhar(@PathVariable Long id) {
		Vehicle vehicle = vehicleRepository.getOne(id);
		return new DetailVehicleDto(vehicle);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<VehicleDto> createVehicle(@RequestBody @Valid VehicleForm vehicleForm,
			UriComponentsBuilder uriComponentsBuilder) {
		Vehicle vehicle = vehicleForm.convert(brandRepository);
		vehicleRepository.save(vehicle);

		URI uri = uriComponentsBuilder.path("/vehicle/{id}").buildAndExpand(vehicle.getIdVehicle()).toUri();

		return ResponseEntity.created(uri).body(new VehicleDto(vehicle));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VehicleDto> updateVehicle(@PathVariable Long id,
			@RequestBody @Valid com.alura.ProjetoAcelera.dto_form.form.UpdateVehicleForm updateVehicleForm) {
		Vehicle vehicle = updateVehicleForm.atualizar(id, vehicleRepository);
		return ResponseEntity.ok(new VehicleDto(vehicle));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
		vehicleRepository.deleteById(id);
		return ResponseEntity.ok().build();

	}

}
