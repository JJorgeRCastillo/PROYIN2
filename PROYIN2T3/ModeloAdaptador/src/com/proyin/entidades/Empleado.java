package com.proyin.entidades;

import com.proyin.adaptadores.*;

public class Empleado extends Persona implements IDTO {

	private Puesto objPuesto;
	private Oficina objOficina;
	private Area objArea;
	private String fechaIngreso;
	private String fechaSalida;
	private int nroHijos;
	private Usuario objUsuario;
	private String fechaRegistro;
	private String horaRegistro;
	private PersonaNatural objPersonaNatural;	
	
	
	public Empleado() { }
	
	public Empleado(String idPersona, String tipoPersona,
			Urbanizacion objUrbanizacion, String tipoVivienda,
			String direccion, String fechaNacimiento, String telefono,
			Ubigeo objUbigeoDireccion, Ubigeo objUbigeoNacionalidad,
			float ingresoMensual, String correo, Usuario objUsuario,
			String fechaRegistro, String horaRegistro,
			String referenciaDireccion, String celular,
			String direccionNegocio, Puesto objPuesto, Oficina objOficina,
			Area objArea, String fechaIngreso, String fechaSalida,
			int nroHijos, Usuario objUsuario2, String fechaRegistro2,
			String horaRegistro2, PersonaNatural objPersonaNatural) {
		super(idPersona, tipoPersona, objUrbanizacion, tipoVivienda, direccion,
				fechaNacimiento, telefono, objUbigeoDireccion,
				objUbigeoNacionalidad, ingresoMensual, correo, objUsuario,
				fechaRegistro, horaRegistro, referenciaDireccion, celular,
				direccionNegocio);
		this.objPuesto = objPuesto;
		this.objOficina = objOficina;
		this.objArea = objArea;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.nroHijos = nroHijos;
		objUsuario = objUsuario2;
		fechaRegistro = fechaRegistro2;
		horaRegistro = horaRegistro2;
		this.objPersonaNatural = objPersonaNatural;
	}





	public Puesto getObjPuesto() {
		return objPuesto;
	}

	public void setObjPuesto(Puesto objPuesto) {
		this.objPuesto = objPuesto;
	}

	public Oficina getObjOficina() {
		return objOficina;
	}

	public void setObjOficina(Oficina objOficina) {
		this.objOficina = objOficina;
	}

	public Area getObjArea() {
		return objArea;
	}

	public void setObjArea(Area objArea) {
		this.objArea = objArea;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getNroHijos() {
		return nroHijos;
	}

	public void setNroHijos(int nroHijos) {
		this.nroHijos = nroHijos;
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

	public PersonaNatural getObjPersonaNatural() {
		return objPersonaNatural;
	}

	public void setObjPersonaNatural(PersonaNatural objPersonaNatural) {
		this.objPersonaNatural = objPersonaNatural;
	}
}
