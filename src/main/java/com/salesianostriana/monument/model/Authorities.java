package com.salesianostriana.monument.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class Authorities implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private @Id @GeneratedValue long id;
	private String authority;

	@ManyToOne
	@JoinColumn(name = "usuario")
	private User usuario;

	public Authorities(String authority, User usuario) {
		this.authority = authority;
		this.usuario = usuario;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}
}
