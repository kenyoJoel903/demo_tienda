package com.kenyo.tienda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenyo.tienda.domain.Producto;
import com.kenyo.tienda.exception.ModelNotFoundException;
import com.kenyo.tienda.repository.ProductoRepository;
import com.kenyo.tienda.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Producto registro(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto actualizacion(Producto producto) {
		buscarPorId(producto.getId());
		return productoRepository.save(producto);
	}

	@Override
	public Producto buscarPorId(Long idProducto) {
		Optional<Producto> opt = productoRepository.findById(idProducto);
		if(!opt.isPresent())
			throw new ModelNotFoundException("No existe producto con id " + idProducto);
		return opt.get();
	}

	@Override
	public List<Producto> listar() {
		return productoRepository.findAll();
	}

	@Override
	public void eliminar(Long idProducto) {
		buscarPorId(idProducto);
		productoRepository.deleteById(idProducto);
	}

}
