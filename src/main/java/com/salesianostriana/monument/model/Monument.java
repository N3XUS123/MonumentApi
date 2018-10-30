package com.salesianostriana.monument.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class Monument {

	private @Id @GeneratedValue long id;
	private String codigoPais;
	private String pais;
	private String ciudad;
	private String localizacion;
	private String nombre;
	private String descripcion;
	private String urlImagen;
	
	public Monument(String codigoPais, String pais, String ciudad, String localizacion, String nombre,
			String descripcion, String urlImagen) {
		this.codigoPais = codigoPais;
		this.pais = pais;
		this.ciudad = ciudad;
		this.localizacion = localizacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.urlImagen = urlImagen;
	}

	
	
}
