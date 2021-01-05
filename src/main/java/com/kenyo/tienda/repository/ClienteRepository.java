package com.kenyo.tienda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenyo.tienda.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	boolean existsByDni(String dni);

}
