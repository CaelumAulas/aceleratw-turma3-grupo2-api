package com.alura.ProjetoAcelera.dto_form.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DashboardDto {

	private String brandName;

	private String vehicleModel;

	private Long quantity;

	private Double value;

}
