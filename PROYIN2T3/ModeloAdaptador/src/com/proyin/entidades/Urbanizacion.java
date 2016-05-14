package com.proyin.entidades;

import com.proyin.adaptadores.IDTO;

public class Urbanizacion implements IDTO {

	private String idUrbanizacion;
	private String nombre;
	
	public Urbanizacion(){}
	
	public Urbanizacion(String idUrbanizacion, String nombre) {
		super();
		this.idUrbanizacion = idUrbanizacion;
		this.nombre = nombre;
	}
	public String getIdUrbanizacion() {
		return idUrbanizacion;
	}
	public void setIdUrbanizacion(String idUrbanizacion) {
		this.idUrbanizacion = idUrbanizacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
