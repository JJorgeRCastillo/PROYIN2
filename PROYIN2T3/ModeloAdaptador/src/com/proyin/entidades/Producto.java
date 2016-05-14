package com.proyin.entidades;

public class Producto {
	
	private String idProducto;
	private String descripcion;
	private String maxCuenta; // maximo de numero de cuentas por socio
	
	public Producto(){}
	
	public Producto(String idProducto, String descripcion, String maxCuenta) {
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.maxCuenta = maxCuenta;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMaxCuenta() {
		return maxCuenta;
	}

	public void setMaxCuenta(String maxCuenta) {
		this.maxCuenta = maxCuenta;
	}	
}
