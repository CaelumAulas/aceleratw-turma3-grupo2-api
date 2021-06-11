package com.alura.ProjetoAcelera.dto_form.form;

import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Setter
public class LoginForm {

	private String name;

	private String password;

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(name, password);
	}

}
