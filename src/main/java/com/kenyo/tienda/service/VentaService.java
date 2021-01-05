package com.kenyo.tienda.service;

import java.util.List;

import com.kenyo.tienda.domain.Venta;

public interface VentaService {
	
	Venta registro(Venta venta);
	
	Venta buscarPorId(Long idVenta);
	
	List<Venta> buscarPorCliente(Long idCliente);

}
