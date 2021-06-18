package com.alura.ProjetoAcelera.services;

import com.alura.ProjetoAcelera.dto_form.dto.DashboardDto;
import com.alura.ProjetoAcelera.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<DashboardDto> getDashboardData() {

		List<DashboardDto> dashboardDtoList = vehicleRepository.findDashboardData();

		return dashboardDtoList;
	}
}
