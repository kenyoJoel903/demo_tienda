package com.kenyo.tienda.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kenyo.tienda.model.ResponseBaseDto;
import com.kenyo.tienda.util.Constant;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto extends ResponseBaseDto{
	
	private Object data;
	
	public ResponseDto() {}
	
	public ResponseDto(Integer codigo, String mensaje, Object data) {
		super(codigo, mensaje);
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		setCodigo(Constant.COD_OK);
		setMensaje(Constant.DATA_OK);
		this.data = data;
	}
	
	public void setEmptyData(Object data) {
		setCodigo(Constant.COD_EMPTY);
		setMensaje(Constant.DATA_EMPTY);
		this.data = data;
	}
	
	
	public void setError(Exception ex) {
		setCodigo(Constant.COD_ERR);
		setMensaje(ex.getMessage());
	}
	
	public void setError(String msgErr) {
		setCodigo(Constant.COD_ERR);
		setMensaje(msgErr);
	}
	

}
