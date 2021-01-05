package com.kenyo.tienda.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenyo.tienda.domain.DetalleVenta;
import com.kenyo.tienda.domain.Venta;
import com.kenyo.tienda.exception.ModelNotFoundException;
import com.kenyo.tienda.repository.VentaRepository;
import com.kenyo.tienda.service.ClienteService;
import com.kenyo.tienda.service.ProductoService;
import com.kenyo.tienda.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService {
	
	@Autowired
	private VentaRepository ventaRepository;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ClienteService clienteService;

	@Override
	public Venta registro(Venta venta) {
		venta.setFecha(new Date());
		venta.setCliente(clienteService.buscarPorId(venta.getCliente().getId()));
		for (DetalleVenta detalle: venta.getDetalle()) {
			detalle.setProducto(productoService.buscarPorId(detalle.getProducto().getId()));
			detalle.setVenta(venta);
		}
		venta = ventaRepository.save(venta);
		return calcularVenta(venta);
	}

	@Override
	public Venta buscarPorId(Long idVenta) {
		Optional<Venta> opt = ventaRepository.findById(idVenta);
		if(!opt.isPresent())
			throw new ModelNotFoundException("No existe la venta con el id: " + idVenta);
		return calcularVenta(opt.get());
	}

	@Override
	public List<Venta> buscarPorCliente(Long idCliente) {
		return ventaRepository.buscarPorCliente(idCliente).stream()
				.map(v -> calcularVenta(v))
				.collect(Collectors.toList());
	}
	
	private Venta calcularVenta(Venta venta) {
		venta.getDetalle().forEach(d -> {
			d.setTotal(d.getCantidad() * d.getProducto().getPrecio());
		});
		Double total = venta.getDetalle().stream().map(d -> d.getTotal())
				.collect(Collectors.summingDouble(Double::doubleValue));
		venta.setTotal(total);
		return venta;
	}

	

}
