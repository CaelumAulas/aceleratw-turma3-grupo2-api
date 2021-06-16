package com.alura.ProjetoAcelera.dto_form.form;

import com.alura.ProjetoAcelera.models.User;
import com.alura.ProjetoAcelera.repository.UserRepository;
import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserForm {

	@NotNull
	private String name;

	@NotNull
	private String password;

	public UserForm(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.name = new BCryptPasswordEncoder().encode(password);
	}

	public User convert(UserRepository userRepository) {
		return new User(name, new BCryptPasswordEncoder().encode(password));
	}

	public User update(Long id, UserRepository userRepository) {
		User user = userRepository.getById(id);
		user.setName(this.name);
		user.setPassword(new BCryptPasswordEncoder().encode(this.password));
		return user;
	}
}
