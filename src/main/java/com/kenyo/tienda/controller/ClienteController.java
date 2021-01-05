package com.kenyo.tienda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenyo.tienda.exception.ResponseDto;
import com.kenyo.tienda.model.ClienteRegistroDto;
import com.kenyo.tienda.service.ClienteService;

@Controller
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping
	public ResponseEntity<ResponseDto> registar(@Valid @RequestBody  ClienteRegistroDto cliente) {
		ResponseDto response = new ResponseDto();
		response.setData(service.registro(cliente));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
