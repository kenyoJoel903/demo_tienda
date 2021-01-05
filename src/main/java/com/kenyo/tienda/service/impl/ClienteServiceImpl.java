package com.kenyo.tienda.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kenyo.tienda.domain.Cliente;
import com.kenyo.tienda.exception.ModelNotFoundException;
import com.kenyo.tienda.exception.TiendaException;
import com.kenyo.tienda.model.ClienteRegistroDto;
import com.kenyo.tienda.repository.ClienteRepository;
import com.kenyo.tienda.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Cliente registro(ClienteRegistroDto clienteRegistro) {
		if(repository.existsByDni(clienteRegistro.getDni()))
			throw new TiendaException("Ya existe cliente registrado con el DNI: " + clienteRegistro.getDni());
		if(repository.existsByEmail(clienteRegistro.getEmail()))
			throw new TiendaException("Ya existe cliente registrado con el email: " + clienteRegistro.getEmail());
		
		Cliente cliente = new Cliente();
		cliente.setApellido(clienteRegistro.getApellido());
		cliente.setDni(clienteRegistro.getDni());
		cliente.setEmail(clienteRegistro.getEmail().toString());
		cliente.setNombre(clienteRegistro.getNombre());
		cliente.setPassword(encoder.encode(clienteRegistro.getPassword()));
		cliente.setTelefono(clienteRegistro.getTelefono());
		return repository.save(cliente);
	}

	@Override
	public Cliente buscarPorId(Long idCliente) {
		Optional<Cliente> opt = repository.findById(idCliente);
		if(!opt.isPresent())
			throw new ModelNotFoundException("No existe cliente con id " + idCliente);
		return opt.get();
	}

}
