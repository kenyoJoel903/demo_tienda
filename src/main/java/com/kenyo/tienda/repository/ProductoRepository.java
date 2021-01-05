package com.kenyo.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenyo.tienda.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
