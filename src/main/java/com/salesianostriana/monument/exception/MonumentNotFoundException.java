package com.salesianostriana.monument.exception;

public class MonumentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MonumentNotFoundException(Long id) {
		super("Could not find monument " + id);
	}
}
