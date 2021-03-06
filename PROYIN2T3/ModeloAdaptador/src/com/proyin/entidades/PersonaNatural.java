package com.proyin.entidades;

import com.proyin.adaptadores.IDTO;

public class PersonaNatural extends Persona implements IDTO {

	private String apPaterno;
	private String apMaterno;
	private String nombres;
	private String sexo;
	private String tipoDocumento;
	private String nroDocumento;
	private String estadoCivil;
	private String gradoInstruccion;
	private String profesion;
	private String ocupacion;
	private Usuario objUsuario;
	private String fechaCreacion;
	private String horaCreacion;
	private String valido;
	private CIIU objCiiu;
	
	// referencia empleado
	private Empleado objEmpelado;

	public PersonaNatural() {
		
	}
	
	public Empleado getObjEmpelado() {
		return objEmpelado;
	}



	public void setObjEmpelado(Empleado objEmpelado) {
		this.objEmpelado = objEmpelado;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getGradoInstruccion() {
		return gradoInstruccion;
	}
	public void setGradoInstruccion(String gradoInstruccion) {
		this.gradoInstruccion = gradoInstruccion;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public Usuario getObjUsuario() {
		return objUsuario;
	}
	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getHoraCreacion() {
		return horaCreacion;
	}
	public void setHoraCreacion(String horaCreacion) {
		this.horaCreacion = horaCreacion;
	}
	public String getValido() {
		return valido;
	}
	public void setValido(String valido) {
		this.valido = valido;
	}
	public CIIU getObjCiiu() {
		return objCiiu;
	}
	public void setObjCiiu(CIIU objCiiu) {
		this.objCiiu = objCiiu;
	}
	
}
