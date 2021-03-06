package com.proyin.entidades;

import com.proyin.adaptadores.IDTO;

public class Persona implements IDTO{

	private String idPersona;
	private String tipoPersona; // N o J
	private Urbanizacion objUrbanizacion;
	private String tipoVivienda;
	private String direccion;
	private String fechaNacimiento;
	private String telefono;
	private Ubigeo objUbigeoDireccion;
	private Ubigeo objUbigeoNacionalidad;
	private float ingresoMensual;
	private String correo;
	private Usuario objUsuario;
	private String fechaRegistro;
	private String horaRegistro;
	private String referenciaDireccion;
	private String celular;
	private String direccionNegocio;
	

	
	public Persona(){}
	
	public Persona(String idPersona, String tipoPersona,
			Urbanizacion objUrbanizacion, String tipoVivienda,
			String direccion, String fechaNacimiento, String telefono,
			Ubigeo objUbigeoDireccion, Ubigeo objUbigeoNacionalidad,
			float ingresoMensual, String correo, Usuario objUsuario,
			String fechaRegistro, String horaRegistro,
			String referenciaDireccion, String celular, String direccionNegocio) {
		this.idPersona = idPersona;
		this.tipoPersona = tipoPersona;
		this.objUrbanizacion = objUrbanizacion;
		this.tipoVivienda = tipoVivienda;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.objUbigeoDireccion = objUbigeoDireccion;
		this.objUbigeoNacionalidad = objUbigeoNacionalidad;
		this.ingresoMensual = ingresoMensual;
		this.correo = correo;
		this.objUsuario = objUsuario;
		this.fechaRegistro = fechaRegistro;
		this.horaRegistro = horaRegistro;
		this.referenciaDireccion = referenciaDireccion;
		this.celular = celular;
		this.direccionNegocio = direccionNegocio;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public Urbanizacion getObjUrbanizacion() {
		return objUrbanizacion;
	}

	public void setObjUrbanizacion(Urbanizacion objUrbanizacion) {
		this.objUrbanizacion = objUrbanizacion;
	}

	public String getTipoVivienda() {
		return tipoVivienda;
	}

	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Ubigeo getObjUbigeoDireccion() {
		return objUbigeoDireccion;
	}

	public void setObjUbigeoDireccion(Ubigeo objUbigeoDireccion) {
		this.objUbigeoDireccion = objUbigeoDireccion;
	}

	public Ubigeo getObjUbigeoNacionalidad() {
		return objUbigeoNacionalidad;
	}

	public void setObjUbigeoNacionalidad(Ubigeo objUbigeoNacionalidad) {
		this.objUbigeoNacionalidad = objUbigeoNacionalidad;
	}

	public float getIngresoMensual() {
		return ingresoMensual;
	}

	public void setIngresoMensual(float ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getHoraRegistro() {
		return horaRegistro;
	}

	public void setHoraRegistro(String horaRegistro) {
		this.horaRegistro = horaRegistro;
	}

	public String getReferenciaDireccion() {
		return referenciaDireccion;
	}

	public void setReferenciaDireccion(String referenciaDireccion) {
		this.referenciaDireccion = referenciaDireccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccionNegocio() {
		return direccionNegocio;
	}

	public void setDireccionNegocio(String direccionNegocio) {
		this.direccionNegocio = direccionNegocio;
	}	

}
