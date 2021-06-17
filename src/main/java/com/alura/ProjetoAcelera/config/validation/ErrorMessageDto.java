package com.alura.ProjetoAcelera.config.validation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ErrorMessageDto {

	private Long status;

	private String message;

	private Date timestamp;


}
