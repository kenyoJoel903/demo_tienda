package com.kenyo.tienda.model;

import java.util.List;

import com.kenyo.tienda.domain.DetalleVenta;
import com.kenyo.tienda.domain.Venta;

public class VentaDto {
	
	private Venta venta;
	private List<DetalleVenta> detalle;
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public List<DetalleVenta> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<DetalleVenta> detalle) {
		this.detalle = detalle;
	}
	
	

}
