package com.proyin.entidades;

import com.proyin.adaptadores.IDTO;

public class Usuario implements IDTO{

	private String idUsuario;
	private String clave;
	private String estado;	
	// CLASES
	private Empleado objEmpleado;
	
	public Usuario(){
	}
	
	public Usuario(String idUsuario, String clave, String estado, Empleado objEmpleado){
		this.idUsuario = idUsuario;
		this.clave = clave;
		this.estado = estado;
		this.objEmpleado = objEmpleado;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Empleado getObjEmpleado() {
		return objEmpleado;
	}

	public void setObjEmpleado(Empleado objEmpleado) {
		this.objEmpleado = objEmpleado;
	}
}
