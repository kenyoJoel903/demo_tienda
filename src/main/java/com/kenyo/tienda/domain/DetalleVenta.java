package com.kenyo.tienda.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(	name = "detalle_ventas")
public class DetalleVenta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetalleVenta")
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "idProducto")
	private Producto producto;
	
	@Column(nullable = false)
	private int cantidad;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(nullable = false, name = "idVenta")
	private Venta venta;
	
	@Transient
	private double total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "DetalleVenta [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", venta=" + venta
				+ ", total=" + total + "]";
	}
	
	
	
	
	
	
	
	

}
