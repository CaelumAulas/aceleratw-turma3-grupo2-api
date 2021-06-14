package com.alura.ProjetoAcelera.controller;

import com.alura.ProjetoAcelera.dto_form.dto.DetailVehicleDto;
import com.alura.ProjetoAcelera.dto_form.dto.VehicleDto;
import com.alura.ProjetoAcelera.dto_form.form.UpdateVehicleForm;
import com.alura.ProjetoAcelera.dto_form.form.VehicleForm;
import com.alura.ProjetoAcelera.models.Vehicle;
import com.alura.ProjetoAcelera.repository.BrandRepository;
import com.alura.ProjetoAcelera.repository.VehicleRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
@Api(tags = "Vehicles")
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
	public ResponseEntity<DetailVehicleDto> detalhar(@PathVariable Long id) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		if (vehicle.isPresent()) {
			return ResponseEntity.ok(new DetailVehicleDto(vehicle.get()));
		}
		return ResponseEntity.notFound().build();
	}


	@PostMapping
	@Transactional
	public ResponseEntity<VehicleDto> createVehicle(@RequestBody @Valid VehicleForm vehicleForm,
													UriComponentsBuilder uriComponentsBuilder) {
		Vehicle vehicle = vehicleForm.convert(brandRepository);
		vehicleRepository.save(vehicle);

		URI uri = uriComponentsBuilder.path("/vehicle/{id}").buildAndExpand(vehicle.getId()).toUri();

		return ResponseEntity.created(uri).body(new VehicleDto(vehicle));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VehicleDto> updateVehicle(@PathVariable Long id,
													@RequestBody @Valid UpdateVehicleForm updateVehicleForm) {
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
