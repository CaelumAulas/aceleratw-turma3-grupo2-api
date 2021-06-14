package com.alura.ProjetoAcelera.controller;

import com.alura.ProjetoAcelera.config.security.TokenService;
import com.alura.ProjetoAcelera.dto_form.dto.TokenDto;
import com.alura.ProjetoAcelera.dto_form.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/auth")
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
			return ResponseEntity.badRequest().build();
		}
	}
}