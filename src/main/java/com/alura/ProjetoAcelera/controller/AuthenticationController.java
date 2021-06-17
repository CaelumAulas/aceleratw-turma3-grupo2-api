package com.alura.ProjetoAcelera.controller;

import com.alura.ProjetoAcelera.config.security.TokenService;
import com.alura.ProjetoAcelera.config.validation.ErrorMessageDto;
import com.alura.ProjetoAcelera.dto_form.dto.TokenDto;
import com.alura.ProjetoAcelera.dto_form.form.LoginForm;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/auth")
@Api(tags = "Authentication")
@Profile({"prod", "dev"})
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<?> authenticate(@RequestBody @Valid LoginForm form) {

		UsernamePasswordAuthenticationToken loginData = form.converter();
		try {
			Authentication authentication = authenticationManager.authenticate(loginData);
			String token = tokenService.generateToken(authentication);

			return ResponseEntity.ok(new TokenDto(token, "Bearer"));

		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageDto(404L, "User not found", new Date()));
		}
	}
}
