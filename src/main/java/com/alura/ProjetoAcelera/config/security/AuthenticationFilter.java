package com.alura.ProjetoAcelera.config.security;

import com.alura.ProjetoAcelera.models.User;
import com.alura.ProjetoAcelera.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends OncePerRequestFilter {

	private TokenService tokenService;

	private UserRepository userRepository;

	public AuthenticationFilter(TokenService tokenService, UserRepository userRepository) {
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

		String token = retrieveToken(httpServletRequest);
		boolean valid = tokenService.isTokenValid(token);

		if (valid) {
			authenticateUser(token);
		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

	private void authenticateUser(String token) {
		Long userId = tokenService.getUserId(token);
		User user = userRepository.findById(userId).get();

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String retrieveToken(HttpServletRequest request) {

		String token = request.getHeader("Authorization");

		if (token == null || token.isEmpty() || !token.contains("Bearer ")) {
			return null;
		}

		return token.substring(7, token.length());
	}
}
