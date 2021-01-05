package com.kenyo.tienda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenyo.tienda.domain.Venta;
import com.kenyo.tienda.exception.ResponseDto;
import com.kenyo.tienda.service.VentaService;

@Controller
@RestController
@RequestMapping("/api/ventas")
public class VentaController {
	
	@Autowired
	private VentaService ventaService;
	
	@PostMapping
	public ResponseEntity<ResponseDto> registro( @RequestBody Venta venta) {
		ResponseDto response = new ResponseDto();
		response.setData(ventaService.registro(venta));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseDto> buscarPorId(@PathVariable Long id) {
		ResponseDto response = new ResponseDto();
		response.setData(ventaService.buscarPorId(id));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/buscarPorCliente/{idCliente}")
	public ResponseEntity<ResponseDto> buscarPorIdCliente(@PathVariable Long idCliente) {
		ResponseDto response = new ResponseDto();
		response.setData(ventaService.buscarPorCliente(idCliente));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
