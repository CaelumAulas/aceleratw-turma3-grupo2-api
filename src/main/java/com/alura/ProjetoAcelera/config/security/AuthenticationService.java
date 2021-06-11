package com.alura.ProjetoAcelera.config.security;

import com.alura.ProjetoAcelera.models.User;
import com.alura.ProjetoAcelera.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByName(name);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		throw new UsernameNotFoundException("Dados inválidos");
	}
}
