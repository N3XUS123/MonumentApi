package com.salesianostriana.monument.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.monument.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findFirstByUsernameAndPassword(String username, String password);
	User findFirstByUsername(String username);
	
	@Query("select u from User u JOIN FETCH u.authorities WHERE u.username = ?1")
	public User findUsuarioWithAuthorities(String username);
}
