package com.kenyo.tienda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenyo.tienda.domain.Producto;
import com.kenyo.tienda.exception.ResponseDto;
import com.kenyo.tienda.service.ProductoService;

@Controller
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	
	@PostMapping
	public ResponseEntity<ResponseDto> registro(@Valid @RequestBody Producto producto) {
		ResponseDto response = new ResponseDto();
		response.setData(productoService.registro(producto));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<ResponseDto> actualizacion(@Valid @RequestBody Producto producto) {
		ResponseDto response = new ResponseDto();
		response.setData(productoService.actualizacion(producto));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<ResponseDto> listar() {
		ResponseDto response = new ResponseDto();
		response.setData(productoService.listar());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseDto> obtenerPorId(@PathVariable Long id) {
		ResponseDto response = new ResponseDto();
		response.setData(productoService.buscarPorId(id));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		productoService.eliminar(id);
		return ResponseEntity.ok().build();
	}
	
	

}
