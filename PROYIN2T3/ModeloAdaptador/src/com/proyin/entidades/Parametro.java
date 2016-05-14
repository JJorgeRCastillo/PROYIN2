package com.proyin.entidades;

import com.proyin.adaptadores.IDTO;

public class Parametro implements IDTO{

	private String idParametro;
	private String parametro;
	private Oficina objOficina;
	private String descripcion;
	private String valor;
	
	public Parametro(){}
	
	public Parametro(String idParametro, String parametro, Oficina objOficina,
			String descripcion, String valor) {
		this.idParametro = idParametro;
		this.parametro = parametro;
		this.objOficina = objOficina;
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public String getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(String idParametro) {
		this.idParametro = idParametro;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public Oficina getObjOficina() {
		return objOficina;
	}

	public void setObjOficina(Oficina objOficina) {
		this.objOficina = objOficina;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
