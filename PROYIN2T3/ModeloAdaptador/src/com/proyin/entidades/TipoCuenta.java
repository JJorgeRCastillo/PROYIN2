package com.proyin.entidades;

public class TipoCuenta {
	
	private String idTipoCuenta;
	private String tipoMoneda;
	private Producto objProducto;
	private String descripcion;
	private float tasaVigente;
	private float montoMinimo;
	private int plazo;
	private float teaVigente;
	
	public TipoCuenta(){
		
	}

	public String getIdTipoCuenta() {
		return idTipoCuenta;
	}

	public void setIdTipoCuenta(String idTipoCuenta) {
		this.idTipoCuenta = idTipoCuenta;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public Producto getObjProducto() {
		return objProducto;
	}

	public void setObjProducto(Producto objProducto) {
		this.objProducto = objProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getTasaVigente() {
		return tasaVigente;
	}

	public void setTasaVigente(float tasaVigente) {
		this.tasaVigente = tasaVigente;
	}

	public float getMontoMinimo() {
		return montoMinimo;
	}

	public void setMontoMinimo(float montoMinimo) {
		this.montoMinimo = montoMinimo;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public float getTeaVigente() {
		return teaVigente;
	}

	public void setTeaVigente(float teaVigente) {
		this.teaVigente = teaVigente;
	}
	
}
