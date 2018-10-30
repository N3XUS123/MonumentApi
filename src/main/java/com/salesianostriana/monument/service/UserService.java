package com.salesianostriana.monument.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianostriana.monument.model.Authorities;
import com.salesianostriana.monument.model.User;
import com.salesianostriana.monument.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = repo.findUsuarioWithAuthorities(username);
		if (userDetails == null) {
			throw new UsernameNotFoundException("User not found");

		}
		return userDetails;
	}
	
	public User save(User usuario) {
		usuario.addRole(new Authorities("ROLE_USER", usuario));
		return repo.save(usuario);
	}
	
	
}
