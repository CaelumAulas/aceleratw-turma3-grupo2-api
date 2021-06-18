package com.alura.ProjetoAcelera.repository;

import com.alura.ProjetoAcelera.dto_form.dto.DashboardDto;
import com.alura.ProjetoAcelera.models.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	Page<Vehicle> findByModel(String modelVehicle, Pageable pages);

	List<Vehicle> findByBrandName(String brandNome);

	Vehicle findByModel(String modelVehicle);

	@Query("select new com.alura.ProjetoAcelera.dto_form.dto.DashboardDto(v.brand.name, v.model, count(v), sum(v.price)) from Vehicle v group by v.brand.id, v.brand.name, v.model, v.id")
	List<DashboardDto> findDashboardData();

}
