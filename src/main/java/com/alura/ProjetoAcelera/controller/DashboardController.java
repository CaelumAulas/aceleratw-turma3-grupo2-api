package com.alura.ProjetoAcelera.controller;

import com.alura.ProjetoAcelera.dto_form.dto.DashboardDto;
import com.alura.ProjetoAcelera.services.DashboardService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@Api(tags = "Dashboard")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping
	public ResponseEntity<List<DashboardDto>> getDashboardInfo() {

		List<DashboardDto> dashboardDtoList = dashboardService.getDashboardData();

		return ResponseEntity.ok(dashboardDtoList);
	}
}
