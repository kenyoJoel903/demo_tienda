package com.kenyo.tienda.service;

import com.kenyo.tienda.domain.Cliente;
import com.kenyo.tienda.model.ClienteRegistroDto;

public interface ClienteService {
	
	Cliente registro(ClienteRegistroDto clienteRegistro);
	
	Cliente buscarPorId(Long idCliente);

}
