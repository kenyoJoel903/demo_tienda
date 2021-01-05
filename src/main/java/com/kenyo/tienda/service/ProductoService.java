package com.kenyo.tienda.service;

import java.util.List;

import com.kenyo.tienda.domain.Producto;

public interface ProductoService {
	
	Producto registro(Producto producto);
	
	Producto actualizacion(Producto producto);
	
	Producto buscarPorId(Long idProducto);
	
	List<Producto> listar();
	
	void eliminar (Long idProducto);

}
