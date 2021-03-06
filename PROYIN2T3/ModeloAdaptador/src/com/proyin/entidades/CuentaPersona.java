package com.proyin.entidades;

public class CuentaPersona {

	private Cuenta objCuenta;
	private Persona objPersona;
	private String titular; // nombre del titular
	
	// referencia de usuario que registra
	private Usuario objUsuario;

	public CuentaPersona(){}
	
	public CuentaPersona(Cuenta objCuenta, Persona objPersona, String titular,
			Usuario objUsuario) {
		this.objCuenta = objCuenta;
		this.objPersona = objPersona;
		this.titular = titular;
		this.objUsuario = objUsuario;
	}

	public Cuenta getObjCuenta() {
		return objCuenta;
	}

	public void setObjCuenta(Cuenta objCuenta) {
		this.objCuenta = objCuenta;
	}

	public Persona getObjPersona() {
		return objPersona;
	}

	public void setObjPersona(Persona objPersona) {
		this.objPersona = objPersona;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}
}
