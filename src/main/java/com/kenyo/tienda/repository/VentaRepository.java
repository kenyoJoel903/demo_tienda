package com.kenyo.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kenyo.tienda.domain.Venta;

public interface VentaRepository  extends JpaRepository<Venta, Long>{
	
	@Query("from Venta v where v.cliente.id = :cliente")
	List<Venta> buscarPorCliente(@Param("cliente") Long idCLiente);

}
