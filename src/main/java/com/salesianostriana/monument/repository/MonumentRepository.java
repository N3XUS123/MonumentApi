package com.salesianostriana.monument.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.monument.model.Monument;

public interface MonumentRepository extends JpaRepository<Monument, Long>{

}
