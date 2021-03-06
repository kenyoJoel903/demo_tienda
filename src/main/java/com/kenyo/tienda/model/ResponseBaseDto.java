package com.kenyo.tienda.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBaseDto {
	
	private Integer codigo;
	private String mensaje;
	
	public ResponseBaseDto() {}
	
	public ResponseBaseDto(Integer codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
